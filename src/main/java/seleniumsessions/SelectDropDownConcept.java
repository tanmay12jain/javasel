package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownConcept {

	public static void main(String[] args) throws InterruptedException {
		
		By countryDrop = By.id("Form_getForm_Country");
		BrowserUtil brutil = new BrowserUtil();
		WebDriver driver = brutil.launchBrowser("chrome");
		
		ElementUtil eleutil = new ElementUtil(driver);
		driver.manage().window().maximize();
		
		brutil.launchURL("https://www.orangehrm.com/en/30-day-free-trial");
		
		//WebElement countryEle = eleutil.getElement(countryDrop);
		
//		Select select = new Select(countryEle);
//		select.selectByIndex(2);
//		Thread.sleep(1000);
//		select.selectByValue("Anguilla");
//		Thread.sleep(2000);
//		select.selectByVisibleText("India");
//		Thread.sleep(2000);
		
		
	     eleutil.printSelectDropdownValues(countryDrop);
		
		
		driver.close();
	}

}
