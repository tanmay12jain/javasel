package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionScrolling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		BrowserUtil brutil = new BrowserUtil();

		WebDriver driver = brutil.launchBrowser("chrome");
		ElementUtil eleutil = new ElementUtil(driver);

		driver.manage().window().maximize();
		brutil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		Thread.sleep(3000);
		Actions act = new Actions(driver);
//		act.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(2000);
//		act.sendKeys(Keys.PAGE_UP).perform();
//		Thread.sleep(2000);
//		act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).build().perform();
//		Thread.sleep(2000);
//		act.sendKeys(Keys.CONTROL).sendKeys(Keys.HOME).perform();
//		Thread.sleep(2000);
		//eleutil.getElement(By.xpath("//a[text() = 'Delivery Information']")).click();
		act.scrollToElement(eleutil.getElement(By.xpath("//a[text() = 'Delivery Information']")))
		.click(eleutil.getElement(By.xpath("//a[text() = 'Delivery Information']"))).build().perform();
		Thread.sleep(2000);
		//driver.close();
	
	}
}
