package seleniumsessions;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForFrame {

	public static void main (String args[]) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		driver.findElement( By.cssSelector("div.details__form-image > img")).click();
		By fname = By.id("RESULT_TextField-8");
		By fraame = By.xpath("//iframe[contains(@id,'frame-one')]");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(fraame));
		
		driver.findElement(fname).sendKeys("testuser");
		
		driver.switchTo().defaultContent();
	
		String text=driver.findElement(By.cssSelector("h3.details__form-preview-title")).getText();
		
		System.out.println(text);
		
		driver.close();
		
	}
}
