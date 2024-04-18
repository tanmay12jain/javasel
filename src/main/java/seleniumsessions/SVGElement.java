package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SVGElement {

	public static void main(String[] args) throws InterruptedException {
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://www.flipkart.com/");
	Thread.sleep(3000);
	
	//driver.findElement(By.cssSelector("._30XB9F")).click();
	
	driver.findElement(By.name("q")).sendKeys("MacBook");
	
	driver.findElement(By.xpath("//button/*[local-name()='svg']")).click();
	
	Thread.sleep(6000);
	
	driver.close();

	}

}
