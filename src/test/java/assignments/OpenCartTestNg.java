package assignments;

import java.security.PublicKey;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import javax.sound.midi.VoiceStatus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenCartTestNg {
	
	WebDriver driver;
	
	//@BeforeTest
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}
	
	@Test
	public void logocheck() {
		driver.findElement(By.xpath("//img[@alt='naveenopencart']")).isDisplayed();
	}
	
	@Test
	public void search() {
		WebElement search = driver.findElement(By.name("search"));
		Actions act = new Actions(driver);
		String entering = "macbook";
		char [] ent = entering.toCharArray();
		for(char c : ent) {
			act.sendKeys(search, String.valueOf(c)).pause(500).build().perform();
		}
		
		System.out.println("Search is successful");
	}
	
	@Test
	public void checklist() {
		List<WebElement> lists = driver.findElements(By.cssSelector(".list-group>a"));
		for (WebElement webElement : lists) {
			if (webElement.getText().equals("Login")) {
				System.out.println("Login is present on the page");
				break;
			}
			else {
				System.out.println("login is not present on the page");
			}
		}
		

	}
	@Test
	public void login() {
		driver.findElement(By.name("email")).sendKeys("testnkl489@gmail.com");
		driver.findElement(By.name("password")).sendKeys("12345@Qa");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	//@AfterTest
	@AfterMethod
	public void close() {
		driver.close();
	}
}
