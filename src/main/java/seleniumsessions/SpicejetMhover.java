package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SpicejetMhover {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.spicejet.com/");
		
		WebElement tarele = driver.findElement(By.xpath("//div[text()='Add-ons']"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(tarele).perform();
		Thread.sleep(3000);

		act.click(driver.findElement(By.xpath("//div[text()='SpiceMax']"))).perform();
		
		Thread.sleep(3000);
		
		driver.quit();
		
	}

}
