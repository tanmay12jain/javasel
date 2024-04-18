package assingments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seleniumsessions.BrowserUtil;
import seleniumsessions.ElementUtil;

public class RegPageLinkstext {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//By getlinksLists = By.xpath("//a[@class = 'list-group-item']");
		By getlinksLists = By.xpath("//a");
		BrowserUtil brutil = new BrowserUtil();
		WebDriver driver = brutil.launchBrowser("chrome");
		
		brutil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		Thread.sleep(3000);
		
		ElementUtil eleutil = new ElementUtil(driver);
//		 List<WebElement> allinks = eleutil.getElements(getlinksLists);
//		 for(WebElement e : allinks) {
//			 String linksText = e.getText();
//			 if (linksText.length()!=0) {
//				 System.out.println(linksText);
//			}
//			 
//		 }
		
		eleutil.doGetElementsText(getlinksLists);
		 
		
		
	}
	

}
