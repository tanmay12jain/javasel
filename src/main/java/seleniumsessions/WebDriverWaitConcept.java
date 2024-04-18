package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitConcept {

	public static void main(String[] args) {

		BrowserUtil brutil = new BrowserUtil();
		WebDriver driver = brutil.launchBrowser("chrome");
		driver.manage().window().maximize();		
		brutil.launchURL("https://www.orangehrm.com/en/30-day-free-trial");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		By fullName = By.id("Form_getForm_subdomain");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement fname = wait.until(ExpectedConditions.presenceOfElementLocated(fullName));
		fname.sendKeys("Nicor");
	}

}
