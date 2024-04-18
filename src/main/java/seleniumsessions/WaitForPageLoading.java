package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForPageLoading {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.speedtest.net/");
		System.out.println(driver.manage().timeouts().getPageLoadTimeout().getSeconds());
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String jsreturn = wait.until(ExpectedConditions.jsReturnsValue("return document.readyState ==='complete'")).toString();
		
		boolean flag = Boolean.parseBoolean(jsreturn);
		if(!flag) {
			throw new MyElementException("Page is not loaded");
		}
		
		System.out.println(driver.manage().timeouts().getPageLoadTimeout().getSeconds());
	}
}
