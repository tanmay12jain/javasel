package seleniumsessions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyntraSearch {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.myntra.com/");
		
		driver.findElement(By.cssSelector(".desktop-searchBar")).sendKeys("dress");
		
		List<WebElement> alloption = driver.findElements(By.cssSelector(".desktop-suggestion.null"));
		
		for(WebElement element : alloption) {
			String eletext = element.getText();
			System.out.println(eletext);
			if(eletext.equals("Dress Kurtis")) {
				element.click();
				break;
			}
			
		}
		Thread.sleep(2000);
		driver.close();
	}

}
