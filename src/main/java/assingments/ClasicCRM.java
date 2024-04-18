package assingments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import seleniumsessions.BrowserUtil;
import seleniumsessions.ElementUtil;

public class ClasicCRM {

	public static void main(String[] args) throws InterruptedException {
		BrowserUtil brutil = new BrowserUtil();
		WebDriver driver = brutil.launchBrowser("chrome");
		
		driver.manage().window().maximize();
		
		ElementUtil eleUtil = new ElementUtil(driver); 	
		brutil.launchURL("https://classic.crmpro.com/");
		
		eleUtil.doSendKeys(By.name("username"), "apiautomation");
		eleUtil.doSendKeys(By.name("password"), "Selenium@12345");
		
		eleUtil.doClick(By.xpath("//input[@value='Login']"));
		
		driver.switchTo().frame("mainpanel");
		
		eleUtil.doClick(By.linkText("CONTACTS"));
		
		eleUtil.doGetElementsText(By.xpath("(//a[text()='Josh Buttler'])[1]/parent::td/following-sibling::td[not(.//i[contains(@class, 'fa')])]"));
		
		eleUtil.doClick(By.name("do_action"));
		
		Thread.sleep(2000);
		
		eleUtil.selectByVisibleText(By.name("do_action"), "Delete Checked");
		
		Thread.sleep(2000);
		
		eleUtil.doClick(By.xpath("//input[@value='DO']"));
		
		Alert alert = driver.switchTo().alert();
		
		Thread.sleep(2000);
		
		String altext = alert.getText();
		
		System.out.println(altext);
		
		String exp = "Are you sure you want to delete all selected contacts?";
		
		if (altext.contains(exp)) {
			
			System.out.println("Alert is matched");
		}
		else {
			System.out.println("des not matched");
		}
		Thread.sleep(2000);
		
		alert.accept();
		
		driver.close();
		

	}

}
