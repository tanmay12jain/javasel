package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDomWithIframe {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
		
		Thread.sleep(4000);
		
		String shd = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#pact1\")";
		JavascriptExecutor js = (JavascriptExecutor)driver;
		 WebElement shadowelement = (WebElement)js.executeScript(shd);
		 
		 driver.switchTo().frame(shadowelement);
		 
		 driver.findElement(By.id("glaf")).sendKeys("Test pizza");
		

	}

}
