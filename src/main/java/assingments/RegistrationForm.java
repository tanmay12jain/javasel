package assingments;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import seleniumsessions.BrowserUtil;
import seleniumsessions.ElementUtil;

public class RegistrationForm {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		By fName = By.id("input-firstname");
		By lName = By.id("input-lastname");
		By email = By.id("input-email");
		By telephone = By.id("input-telephone");
		By pass = By.name("password");
		By confirmPass = By.name("confirm");
		By sub = By.name("newsletter");
		By privicy = By.xpath("//input[@name='agree']");
		By continueButton = By.xpath("//input[@value='Continue']");
		
		BrowserUtil brutil = new BrowserUtil();
		WebDriver driver = brutil.launchBrowser("chrome");
		
		brutil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		Thread.sleep(3000);
		 String title = brutil.getPageTitle();
		 if (title.equals("Register Account")) {
			 System.out.println("tytle is correct: " +title);
		}
		 else {
			 System.out.println("Title is not matched:"+title);
		 }
		 
		 ElementUtil eleutil = new ElementUtil(driver);
		 eleutil.doSendKeys(fName,"T_automation");
		 eleutil.doSendKeys(lName, "J_java");
		 eleutil.doSendKeys(email, "testautomation@gmail.com");
		 eleutil.doSendKeys(telephone, "12345687891");
		 eleutil.doSendKeys(pass,"12345@Qa");
		 eleutil.doSendKeys(confirmPass, "12345@Qa");
		 
		
		
		
		
		
		
	}

}
