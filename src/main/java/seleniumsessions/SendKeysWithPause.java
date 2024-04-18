package seleniumsessions;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SendKeysWithPause {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		BrowserUtil brutil = new BrowserUtil();

		WebDriver driver = brutil.launchBrowser("chrome");
		ElementUtil eleutil = new ElementUtil(driver);

		driver.manage().window().maximize();
		brutil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		Thread.sleep(3000);
		Actions act = new Actions(driver);

		WebElement search = eleutil.getElement(By.name("search"));

		String value = "MacBook";
		char val[] = value.toCharArray();
		
		for (char c : val) {
			act.sendKeys(search,String.valueOf(c)).pause(200).build().perform();
		}

	}

}
