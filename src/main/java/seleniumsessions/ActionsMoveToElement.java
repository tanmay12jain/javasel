package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsMoveToElement {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		BrowserUtil brutil = new BrowserUtil();
		
		WebDriver driver = brutil.launchBrowser("chrome");
		ElementUtil eleutil = new ElementUtil(driver);

		driver.manage().window().maximize();
		brutil.launchURL("http://mrbool.com/search/?txtsearch=how-to-create-menu-with-submenu-using-css-html");
		Thread.sleep(3000);
		
		By mainmenu = By.className("menulink");
		By submenu = By.linkText("ARTICLES");

		
		
		Actions action = new Actions(driver);
		action.moveToElement(eleutil.getElement(mainmenu)).perform();
		Thread.sleep(1500);
		eleutil.getElement(submenu).click();
		
		Thread.sleep(3000);
		
		driver.close();
	
	}
}