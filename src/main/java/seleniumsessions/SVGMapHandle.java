package seleniumsessions;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SVGMapHandle {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://petdiseasealerts.org/forecast-map#/");
		
		Thread.sleep(6000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'map-instance')]")));
		
		String xpath = "//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @class='region']";
		List<WebElement> mapGraps = driver.findElements(By.xpath(xpath));
		
		System.out.println(mapGraps.size());
		
		Actions act = new Actions(driver);
		for(WebElement e:mapGraps){
			act.moveToElement(e).perform();
			System.out.println(e.getAttribute("id"));
			Thread.sleep(500);
			
		}
		
		driver.close();
		
	}

}
