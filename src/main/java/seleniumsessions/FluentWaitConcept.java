package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitConcept {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		By image=By.cssSelector("div#imageTemplateContainer imgs");

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
//				.ignoring(TimeoutException.class)
//				.ignoring(NoSuchElementException.class)
				.withMessage("your element is not found");

		 WebElement imclick = wait.until(ExpectedConditions.visibilityOfElementLocated(image));
		 imclick.click();
		
//		WebDriver driver = new ChromeDriver();//browser - chrome
//
//		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");//page
//		
//		By image = By.cssSelector("div#imageTemplateContainer imgs");
//		
//		
//		//FW:
//		
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//									.withTimeout(Duration.ofSeconds(10))
//									.pollingEvery(Duration.ofSeconds(2))
//									.ignoring(NoSuchElementException.class)
//									.ignoring(TimeoutException.class)
//									.ignoring(ElementNotInteractableException.class)
//									.withMessage("time out...element is not present...");
//		
//		WebElement image_ele = 
//						wait.until(ExpectedConditions.visibilityOfElementLocated(image));
//		
//		image_ele.click();

	}

}
