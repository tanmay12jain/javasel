package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserMultipleWindowHandling {

	public static void main(String[] args) throws InterruptedException {
		BrowserUtil brUtils = new BrowserUtil();
		WebDriver driver = brUtils.launchBrowser("chrome");
		
		driver.manage().window().maximize();
		String pWID = driver.getWindowHandle();
		ElementUtil eleutil = new ElementUtil(driver);
		
		brUtils.launchURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		
		eleutil.doClick(By.xpath("//a[contains(@href,'linkedin')]"));
		eleutil.doClick(By.xpath("//a[contains(@href,'facebook')]"));
		eleutil.doClick(By.xpath("//a[contains(@href,'twitter')]"));
		eleutil.doClick(By.xpath("//a[contains(@href,'youtube')]"));
		Thread.sleep(3000);
		
		Set<String> handle = driver.getWindowHandles();
		Iterator<String> it = handle.iterator();
		
		while (it.hasNext()) {
			String windowId = it.next();
			System.out.println("window id: "+windowId);
			driver.switchTo().window(windowId);
			System.out.println(driver.getCurrentUrl());
			if (!pWID.equals(windowId)) {
				driver.close();
			}
			
		}
		driver.switchTo().window(pWID);
		System.out.println(driver.getCurrentUrl());
		

	}

}
