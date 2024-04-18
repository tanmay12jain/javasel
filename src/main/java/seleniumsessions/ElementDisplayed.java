package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementDisplayed {
	public static void main(String args[]) throws InterruptedException {
		By logo = By.className("img-responsive");
		BrowserUtil brutil = new BrowserUtil();
		WebDriver driver = brutil.launchBrowser("chrome");
		driver.manage().window().maximize();
		brutil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		
	//	Thread.sleep(3000);
		
		ElementUtil eleutil = new ElementUtil(driver);
		List<WebElement> locatelogo = eleutil.getElements(logo);
		System.out.println(locatelogo);
		if (locatelogo.size()==1) {
			System.out.println("logo is present on the page");
		}
		else {
			System.out.println("Logi is missing on the page");
		}
		
//		List<WebElement> logo = driver.findElements(By.className("img-responsive"));
//		
//		if(logo.size()==1) {
//			System.out.println("logo is displayed");
//		}
//		else {
//			System.out.println("logo is not displayed");
//		}
	}
	
}
