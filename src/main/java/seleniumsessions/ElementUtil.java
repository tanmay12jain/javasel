package seleniumsessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.AddHasCasting;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	private WebDriver driver;
	private final String DEFAULT_ELEMENT_TIMEOUT_MESSAGE = "TimeOut....Element is not found";
	private final String DEFAULT_ALERT_TIMEOUT_MESSAGE = "TimeOut....Alert is not found";

	private void nullBlankCheck(String value) {
		if (value == null || value.length() == 0) {
			throw new MyElementException(value + "-- value text can not be null or blank");
		}
	}

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public By getBy(String loctorType, String locatorValue) {
		By locator = null;
		switch (loctorType) {
		case "id":
			locator = By.id(locatorValue);
			break;

		case "name":
			locator = By.name(locatorValue);
			break;

		case "xpath":
			locator = By.xpath(locatorValue);
			break;

		case "cssSelector":
			locator = By.cssSelector(locatorValue);
			break;

		case "className":
			locator = By.className(locatorValue);
			break;

		case "tagName":
			locator = By.tagName(locatorValue);
			break;

		case "linkText":
			locator = By.linkText(locatorValue);
			break;

		case "parcialLinkText":
			locator = By.partialLinkText(locatorValue);
			break;

		default:
			System.out.println(loctorType + " is a invalid, please pass the right locator");
			break;
		}
		return locator;

	}

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		} catch (NoSuchElementException e) {
			System.out.println("Element is not present on the page");
			e.printStackTrace();
		}
		return element;
	}

	public WebElement getElemnet(String loctorType, String locatorValue) {
		return driver.findElement(getBy(loctorType, locatorValue));
	}

	public void doSendKeys(By locator, String value) {
		driver.findElement(locator).sendKeys(value);
	}

	public void doSendKeys(By locator, String value, int timeOut) {
		nullBlankCheck(value);
		waitForElementvisibility(locator, timeOut).sendKeys(value);
	}

	public void doSendkeys(String loctorType, String locatorValue, String value) {
		driver.findElement(getBy(loctorType, loca torValue)).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public void doClick(By locator, int timeOut) {
		waitForElementvisibility(locator, timeOut).click();
	}

	public String doGetElementText(By locator) {
		return getElement(locator).getText();
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public String doElementGetAttribute(By locator, String name) {
		return getElement(locator).getAttribute(name);
	}

	public ArrayList<String> doGetElementsText(By locator) {
		ArrayList<String> alltext = new ArrayList<String>();
		List<WebElement> allinks = getElements(locator);
		for (WebElement e : allinks) {
			String linksText = e.getText();
			if (linksText.length() != 0) {
				alltext.add(linksText);
				System.out.println(linksText);
			}
		}
		return alltext;
	}

	public ArrayList<String> getElementAttributeList(By locator, String attrName) {
		List<WebElement> eleList = getElements(locator);
		ArrayList<String> eleAttrList = new ArrayList<String>();// pc=0

		for (WebElement e : eleList) {
			String attrValue = e.getAttribute(attrName);
			if (attrValue.length() != 0) {
				eleAttrList.add(attrValue);
			}
		}

		return eleAttrList;

	}

	public boolean isElementDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public boolean isElementExist(By locator) {
		if (getElements(locator).size() == 1) {
			return true;
		}
		return false;
	}

	// ****************Select class *************

	public void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);

	}

	public void selectByVisibleText(By locator, String visibleText) {
		nullBlankCheck(visibleText);
		Select select = new Select(getElement(locator));
		try {
			select.selectByVisibleText(visibleText);
		} catch (NoSuchElementException e) {
			System.out.println("visible text is not present in the dropdown");
			e.printStackTrace();
			throw new MyElementException("Text is not present");
		}
	}

	public void selectByValue(By locator, String value) {
		nullBlankCheck(value);
		Select select = new Select(getElement(locator));
		try {
			select.selectByVisibleText(value);
		} catch (NoSuchElementException e) {
			System.out.println("visible text is not present in the dropdown");
			e.printStackTrace();
			throw new MyElementException("Text is not present");
		}
	}

	public List<WebElement> getDropDownOptionsList(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions();
	}

	public int getDropdownValueCount(By locator) {
		return getDropDownOptionsList(locator).size();
	}

	public void printSelectDropdownValues(By locator) {
		List<WebElement> optionsList = getDropDownOptionsList(locator);

		for (WebElement element : optionsList) {
			String text = element.getText();
			System.out.println(text);
		}
	}

	// get the list of dropdownvalues in the form of string list

	public List<WebElement> getDropdownList(By locator) {
		List<WebElement> optionsList = getDropDownOptionsList(locator);
		List<String> optionsTextList = new ArrayList<String>();

		for (WebElement element : optionsList) {
			String text = element.getText();
			optionsTextList.add(text);
		}
		return optionsList;

	}

// without select class select drop down value
	public void doSelectvalueFromDropDown(By locator, String value) {
		nullBlankCheck(value);
		List<WebElement> optionsList = getElements(locator);
		System.out.println(optionsList.size());
		for (WebElement element : optionsList) {
			String text = element.getText();
			if (text.equals(value)) {
				element.click();
				break;
			}
		}

	}

	// **************Actions classes

	public void handleMenuSubMenuLevel2(By parentMenuLocator, By submenuLocator) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenuLocator)).perform();
		Thread.sleep(1500);
		doClick(submenuLocator);
	}

	public void handleMenuSublevel4(By level1Menu, By level2Menu, By level3Menu, By level4Menu)
			throws InterruptedException {
		Actions act = new Actions(driver);
		doClick(level1Menu);
		act.moveToElement(getElement(level2Menu)).perform();
		Thread.sleep(1500);
		act.moveToElement(getElement(level3Menu)).perform();
		Thread.sleep(1500);
		doClick(level4Menu);
	}

	public void handleMenuSublevel4MouseHover(By level1Menu, By level2Menu, By level3Menu, By level4Menu)
			throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(level1Menu)).perform();
		;
		Thread.sleep(1500);

		act.moveToElement(getElement(level2Menu)).perform();
		Thread.sleep(1500);
		act.moveToElement(getElement(level3Menu)).perform();
		Thread.sleep(1500);
		act.moveToElement(getElement(level4Menu)).perform();
	}

	public void doActionClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}

	public void doActionsendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value);
	}

	public void getRightClickMenu(By rightClickTarget, By rightClickOptions, String value) {
		Actions act = new Actions(driver);
		act.contextClick(getElement(rightClickOptions));
		List<WebElement> itemsList = getElements(rightClickOptions);
		System.out.println(itemsList.size());
		for (WebElement e : itemsList) {
			String txt = e.getText();
			System.out.println(txt);
			if (txt.equals(value)) {
				e.click();
				break;
			}
		}
	}

	// ******************waits****************8

	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does notnecessarily mean that the element is visible
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitForElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public List<WebElement> waitForElementsPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page
	 * and visible. Visibility means that the element is not only displayed but also
	 * has a height and width that isgreater than 0.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitForElementvisibility(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public List<WebElement> waitForElementsVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public String waitforTitleContains(String titleFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		try {
			if (wait.until(ExpectedConditions.titleContains(titleFraction))) {
				return driver.getTitle();
			}
		} catch (Exception e) {
			System.out.println("title is not find with in " + timeOut);
		}
		return null;
	}

	public String waitforTitleIs(String titleFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		try {
			if (wait.until(ExpectedConditions.titleIs(titleFraction))) {
				return driver.getTitle();
			}
		} catch (Exception e) {
			System.out.println("title is not find with in " + timeOut);
		}
		return null;
	}

	public String waitForUrlContains(String urlFreaction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		try {
			if (wait.until(ExpectedConditions.urlContains(urlFreaction))) {
				return driver.getCurrentUrl();
			}
		} catch (Exception e) {
			System.out.println("url is not find with in " + timeOut);
		}
		return null;
	}

	public String waitForUrlIs(String urlFreaction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		try {
			if (wait.until(ExpectedConditions.urlToBe(urlFreaction))) {
				return driver.getCurrentUrl();
			}
		} catch (Exception e) {
			System.out.println("url is not find with in " + timeOut);
		}
		return null;
	}

	public Alert waitForJSAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public String getAlertText(int timeOut) {
		return waitForJSAlert(timeOut).getText();
	}

	public void acceptAlert(int timeOut) {
		waitForJSAlert(timeOut).accept();
	}

	public void dismissAlert(int timeOut) {
		waitForJSAlert(timeOut).dismiss();
	}

	public Boolean waitForWindow(int totalNumberOfWindowsToBe, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.numberOfWindowsToBe(totalNumberOfWindowsToBe));
	}

	public void clickWhenReady(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	public WebElement waitForElementVisible(By locator, int timeOut, int interwalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(interwalTime));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitForFrameAndSwichToIT(By frameLocator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}

	public void waitForFrameAndSwichToIT(int frameIndex, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}

	public void waitForFrameAndSwichToIT(WebElement frameElement, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}

	public List<WebElement> waitForElementPresenceWithFluentWait(By locator, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class)
				.withMessage(DEFAULT_ELEMENT_TIMEOUT_MESSAGE);
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

	}

	public Alert waitForAlertPresenceWithFluentWait(By locator, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class)
				.withMessage(DEFAULT_ELEMENT_TIMEOUT_MESSAGE);
		return wait.until(ExpectedConditions.alertIsPresent());

	}

	public WebElement retryingElement(By locator, int timeOut) {
		WebElement element = null;
		int attempts = 0;
		while (attempts < timeOut) {
			try {
				element = getElement(locator);
				System.out.println("Element is found..." + locator + "in attempts" + attempts);
			} catch (NoSuchElementException e) {
				System.out.println("Element is found...in attempts" + attempts);
				TimeUtil.defaultTime();
			}
			attempts++;
		}
		if(element==null) {
			System.out.println("Element is not found....tried for" +timeOut+"times"+" with the interval of "+500+"millisecond");
			 throw new MyElementException("No such element");
		}
		return null;
	}
	
	public WebElement retryingElement(By locator, int timeOut, int intervalTime) {
		WebElement element = null;
		int attempts = 0;
		while (attempts < timeOut) {
			try {
				element = getElement(locator);
				System.out.println("Element is found..." + locator + "in attempts" + attempts);
			} catch (NoSuchElementException e) {
				System.out.println("Element is found...in attempts" + attempts);
				TimeUtil.applyWait(intervalTime);
			}
			attempts++;
		}
		if(element==null) {
			System.out.println("Element is not found....tried for" +timeOut+"times"+" with the interval of "+500+"millisecond");
			 throw new MyElementException("No such element");
		}
		return null;
	}

}
