package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HdfcBank {

	public static void main(String[] args) throws InterruptedException {

		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.launchBrowser("chrome");
		ElementUtil eleutil = new ElementUtil(driver);
		driver.manage().window().maximize();

		brUtil.launchURL("https://www.hdfcbank.com/");

		Thread.sleep(5000);

		By dropdownclick = By.xpath("//span[text()='Loans']");
		By dpListby = By.cssSelector("ul.dropdown1 > li");

		eleutil.getElement(dropdownclick).click();

		List<WebElement> optionsList = eleutil.getElements(dpListby);
		System.out.println(optionsList.size());
		for (WebElement element : optionsList) {
			String text = element.getText();
			System.out.println(text);
		}

		eleutil.doSelectvalueFromDropDown(dpListby, "Cards");

		driver.close();

	}

}
