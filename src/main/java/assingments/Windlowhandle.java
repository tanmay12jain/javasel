package assingments;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seleniumsessions.BrowserUtil;
import seleniumsessions.ElementUtil;

public class Windlowhandle {

	public static void main(String[] args) throws InterruptedException {
		BrowserUtil brUtils = new BrowserUtil();
		WebDriver driver = brUtils.launchBrowser("chrome");

		driver.manage().window().maximize();
		ElementUtil eleutil = new ElementUtil(driver);

		brUtils.launchURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);

		WebElement linkedin = eleutil.getElement(By.xpath("//a[contains(@href,'linkedin')]"));
		WebElement facebook = eleutil.getElement(By.xpath("//a[contains(@href,'facebook')]"));
		WebElement twitter = eleutil.getElement(By.xpath("//a[contains(@href,'twitter')]"));
		WebElement youtube = eleutil.getElement(By.xpath("//a[contains(@href,'youtube')]"));

		List<WebElement> newWindowOptions = new ArrayList<WebElement>();
		newWindowOptions.add(facebook);
		newWindowOptions.add(twitter);
		newWindowOptions.add(youtube);
		newWindowOptions.add(linkedin);

		for (int i = 0; i < newWindowOptions.size(); i++) {
			newWindowOptions.get(i).click();
			Thread.sleep(5000);
			Set<String> handle = driver.getWindowHandles();
			Iterator<String> it = handle.iterator();
			while (it.hasNext()) {
				String pWId = it.next();
				String cWId = it.next();
				driver.switchTo().window(cWId);
				System.out.println(driver.getCurrentUrl());
				System.out.println(driver.getTitle());

				driver.close();
				driver.switchTo().window(pWId);
				Thread.sleep(1000);//just for visibility
			}

		}
		driver.close();
	}

}
