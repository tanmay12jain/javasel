package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Windowsize {

	public static void main(String[] args) throws InterruptedException {

		BrowserUtil brutil = new BrowserUtil();

		WebDriver driver = brutil.launchBrowser("chrome");
		ElementUtil eleutil = new ElementUtil(driver);

		driver.manage().window().maximize();
		brutil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		WebElement search = eleutil.getElement(By.name("firstname"));

		Thread.sleep(3000);

		int ht = search.getSize().getHeight();

	}

	
}
