package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionSignature {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		BrowserUtil brutil = new BrowserUtil();

		WebDriver driver = brutil.launchBrowser("chrome");
		ElementUtil eleutil = new ElementUtil(driver);

		driver.manage().window().maximize();
		brutil.launchURL("https://signature-generator.com/draw-signature/");
		
		WebElement search = eleutil.getElement(By.id("signature-pad"));
		
		Thread.sleep(3000);
		Actions act = new Actions(driver); 	
		
	Action	action=act.click(search)
		.moveToElement(search, 100, 100)
		.clickAndHold(search)
		.moveToElement(search, 13, -17)
		.moveByOffset(10, 70)
		.release(search)
		.build();
	action.perform();
	

	}

}
