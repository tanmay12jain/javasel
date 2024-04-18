package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserWindowHandling {

	public static void main(String[] args) throws InterruptedException {
		
		BrowserUtil brUtils = new BrowserUtil();
		WebDriver driver = brUtils.launchBrowser("chrome");
		
		driver.manage().window().maximize();
		
		ElementUtil eleutil = new ElementUtil(driver);
		
		brUtils.launchURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		
		eleutil.doClick(By.xpath("//a[contains(@href,'linkedin')]"));
		
		Thread.sleep(3000);
		
		Set<String> handle = driver.getWindowHandles();
		Iterator<String> it = handle.iterator();
		
		String parentWindowId = it.next();
	    System.out.println("Parent Window id: "+parentWindowId);
	    
	    String childWindowId = it.next();
	    System.out.println("child Window id: "+childWindowId);
	    
		driver.switchTo().window(childWindowId);
		
		System.out.println(driver.getCurrentUrl());
		
		driver.close();
		
		driver.switchTo().window(parentWindowId);
		
		System.out.println(driver.getCurrentUrl());
		
		driver.close();
		
		
		

	}

}
