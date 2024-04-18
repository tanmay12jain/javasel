package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.List;

import org.openqa.selenium.By;;
public class RelativeLocators {

	public static void main(String[] args) throws InterruptedException {
		BrowserUtil brUtil = new BrowserUtil();

		WebDriver driver = brUtil.launchBrowser("chrome");
		driver.manage().window().maximize();

		brUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		Thread.sleep(3000);
		
		  WebElement baseEle = driver.findElement(By.id("input-email"));
		  
		  WebElement tagetEle = driver.findElement(By.cssSelector("label[for='input-email']"));
		  
		  WebElement header=driver.findElement(By.xpath("//h2[text()='New Customer']"));
		  
		  WebElement abovElement = driver.findElement(By.linkText("Continue"));
		  
		  List<WebElement> eleselection = driver.findElements(with(By.tagName("p")).below(header).above(abovElement));
		  System.out.println(eleselection.size());;
		  for (WebElement webElement : eleselection) {
			  System.out.println(webElement.getText());
			
		}
//		  String above_email = driver.findElement(with(By.cssSelector("label[for='input-email']")).above(baseEle)).getText();
//		  
//		  System.out.println(above_email);
		  
		  driver.close();
//		  
		  

	}

}
