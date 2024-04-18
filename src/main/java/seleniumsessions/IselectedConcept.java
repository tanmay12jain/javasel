package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IselectedConcept {

	public static void main(String[] args) throws InterruptedException {
		By sub_button=By.id("submitButton");
		By tearms = By.name("agreeTerms");
		BrowserUtil brutil = new BrowserUtil();
		WebDriver driver = brutil.launchBrowser("chrome");
		
		ElementUtil eleutil = new ElementUtil(driver);
		driver.manage().window().maximize();
		
		//brutil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		brutil.launchURL("https://classic.freecrm.com/register/");
		boolean eledis = eleutil.getElement(sub_button).isDisplayed();
		System.out.println("submit button is displayed?: " +eledis);
		
		boolean tearmsDisplay = eleutil.getElement(tearms).isDisplayed();
		System.out.println("tearms is displayed?: "+tearmsDisplay);
		
		boolean subEnable = eleutil.getElement(sub_button).isEnabled();
		System.out.println("submit button is enabled?: "+subEnable);
		
		boolean teramselect = eleutil.getElement(tearms).isSelected();
		System.out.println("tearms is selected?: " + teramselect);
		
		eleutil.getElement(tearms).click();
		
		 teramselect = eleutil.getElement(tearms).isSelected();
		System.out.println("tearms is selected?: " + teramselect);
		
		subEnable = eleutil.getElement(sub_button).isEnabled();
		System.out.println("submit button is enabled?: "+subEnable);
		
		
//		Thread.sleep(2000);
//		By email = By.name("email");	
//		eleutil.doSendKeys(email,"test@gmail.com");
//		String attri = eleutil.getElement(email).getAttribute("value");
//		System.out.println(attri);
//		Thread.sleep(2000);
		driver.close();
		
	
		
	
	}

}
