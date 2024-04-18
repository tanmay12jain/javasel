package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.openqa.selenium.support.locators.RelativeLocator.with;;

public class RelativeLocatorConcept {

	public static void main(String[] args) throws InterruptedException {
		
		BrowserUtil brUtil = new BrowserUtil();
		
		WebDriver driver = brUtil.launchBrowser("chrome");
		driver.manage().window().maximize();
		
		brUtil.launchURL("https://www.aqi.in/dashboard/canada");
		Thread.sleep(3000);
		
		WebElement ele = driver.findElement(By.linkText("Toronto, Canada"));
		String left = driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText();
		System.out.println(left);
		
		String right = driver.findElement(with(By.tagName("p")).toRightOf(ele)).getText();
		System.out.println(right);
		
		String above = driver.findElement(with(By.tagName("p")).above(ele)).getText();
		System.out.println(above);
		
		String below = driver.findElement(with(By.tagName("p")).below(ele)).getText();
		System.out.println(below);
		
		String near = driver.findElement(with(By.tagName("p")).near(ele)).getText();
		System.out.println(near);
		
		driver.close();

		
	}

}
