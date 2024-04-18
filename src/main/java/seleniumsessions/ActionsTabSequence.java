package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsTabSequence {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		BrowserUtil brutil = new BrowserUtil();

		WebDriver driver = brutil.launchBrowser("chrome");
		ElementUtil eleutil = new ElementUtil(driver);

		driver.manage().window().maximize();
		brutil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		WebElement search = eleutil.getElement(By.name("firstname"));
		
		Thread.sleep(3000);
		Actions act = new Actions(driver); 	
		act.sendKeys(search, "Tanmay")
		.sendKeys(Keys.TAB)
		.pause(200)
		.sendKeys("automation")
		.sendKeys(Keys.TAB)
		.pause(200)
		.sendKeys("Test@gmail.com")
		.sendKeys(Keys.TAB)
		.pause(200)
		.sendKeys("234234324324")
		.sendKeys(Keys.TAB)
		.pause(200)
		.sendKeys("12345@Qa")
		.sendKeys(Keys.TAB)
		.pause(200)
		.sendKeys("12345@Qa")
		.sendKeys(Keys.TAB)
		.build().perform();
	}

}
