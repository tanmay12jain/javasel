package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectDropDown {
	public static void main(String args[]) throws InterruptedException {
		By dropdownelement = By.xpath("//select[@multiple]");

		BrowserUtil brutil = new BrowserUtil();
		WebDriver driver = brutil.launchBrowser("chrome");

		ElementUtil eleutil = new ElementUtil(driver);
		driver.manage().window().maximize();

		brutil.launchURL("https://html.com/attributes/select-multiple/");

		Select select = new Select(eleutil.getElement(dropdownelement));
		System.out.println(select.isMultiple());
		if (select.isMultiple()) {
			System.out.println("Multiselect is possible");
			select.selectByVisibleText("American flamingo");
			select.selectByVisibleText("Chilean flamingo");
			select.selectByVisibleText("James's flamingo");

		}
		Thread.sleep(3000);
		
		select.deselectByVisibleText("Chilean flamingo");
		Thread.sleep(3000);
		select.deselectAll();
		
		driver.close();

	}

}
