package assingments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import seleniumsessions.BrowserUtil;

public class CheckBoxNButton {

	public static void main(String[] args) throws InterruptedException {
		BrowserUtil brUtil = new BrowserUtil();

		WebDriver driver = brUtil.launchBrowser("chrome");
		driver.manage().window().maximize();

		brUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		Thread.sleep(3000);
		
		  WebElement baseEle = driver.findElement(By.cssSelector(".btn.btn-primary"));
		  
		   WebElement checkbox = driver.findElement(with(By.cssSelector("input[name='agree']")).toLeftOf(baseEle));
		   
		  
		  if (checkbox.isDisplayed()&& !checkbox.isSelected()) {
			System.out.println("checkbox is peresent on the left side of the continue button and not selected rightnow");
		}
		  else {
			System.out.println("checkbox is not present");
		}
		  
		  
		  String privicy = driver.findElement(with(By.linkText("Privacy Policy")).toLeftOf(checkbox)).getText();
		  System.out.println("Privacy policy link is present nearby of check box: "+privicy);
		
		  driver.close();
	}

}
