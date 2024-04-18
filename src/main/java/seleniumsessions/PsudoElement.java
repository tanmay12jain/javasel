package seleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class PsudoElement {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		Thread.sleep(4000);

		String script = "return window.getComputedStyle(document.querySelector('label[for=\"input-firstname\"]'),'::before').getPropertyValue('content')";
		

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String psu = js.executeScript(script).toString();
		System.out.println(psu);
		if (psu.contains("*")) {
			System.out.println("FN is th emandaroty field");
		}
		driver.close();
	}

}
