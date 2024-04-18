package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		BrowserUtil brutil = new BrowserUtil();

		WebDriver driver = brutil.launchBrowser("chrome");
		ElementUtil eleutil = new ElementUtil(driver);

		driver.manage().window().maximize();
		brutil.launchURL("https://jqueryui.com/resources/demos/droppable/default.html");
		Thread.sleep(3000);

		By elesrc = By.xpath("//p[text()='Drag me to my target']");
		By eledest = By.xpath("//p[text()='Drop here']");

		Actions actions = new Actions(driver);
		actions.clickAndHold(eleutil.getElement(elesrc)).moveToElement(eleutil.getElement(eledest)).release().build()
				.perform();
		driver.navigate().refresh();
		Thread.sleep(1500);
		driver.close();
		

	}

}
