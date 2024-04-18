package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ImplicitlyWaitsconcept {

	public static void main(String[] args) {

		BrowserUtil brutil = new BrowserUtil();
		WebDriver driver = brutil.launchBrowser("chrome");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		brutil.launchURL("https://www.orangehrm.com/en/30-day-free-trial");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		By uname = By.id("Form_getForm_subdomaind");
		
		eleUtil.getElement(uname).sendKeys("test");
		
		driver.close();
		
		
	}

}
