package base;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Util;

public class CustomDriver {
	public WebDriver driver;
	private JavascriptExecutor js;
	
	public CustomDriver() {
		
	}
	
	public CustomDriver(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}

	public void refresh() {
		driver.navigate().refresh();
		System.out.println("The current browser location was refreshed");
	}

	public String getTitle() {
		String title = driver.getTitle();
		System.out.println("Title of the page is : " + title);
		return title;
	}

	public String getURL() {
		String url = driver.getCurrentUrl();
		System.out.println("Current URL is: " + url);
		return url;
	}

	public void navigateBrowserBack() {
		driver.navigate().back();
		System.out.println("Navigate back");
	}

	public void navigateBrowserForward() {
		driver.navigate().back();
		System.out.println("Navigate back");
	}

	public By getByType(String locator) {
		By by = null;
		String locatorType = locator.split("=>")[0];
		locator = locator.split("=>")[1];
		try {
			if (locatorType.contains("id")) {
				by = By.id(locator);
			} else if (locatorType.contains("name")) {
				by = By.name(locator);
			} else if (locatorType.contains("xpath")) {
				by = By.xpath(locator);
			} else if (locatorType.contains("css")) {
				by = By.cssSelector(locator);
			} else if (locatorType.contains("class")) {
				by = By.className(locator);
			} else if (locatorType.contains("tag")) {
				by = By.tagName(locator);
			} else if (locatorType.contains("link")) {
				by = By.linkText(locator);
			} else if (locatorType.contains("partialLink")) {
				by = By.partialLinkText(locator);
			} else {
				System.out.println("Locator type not supported");
			}
		} catch (Exception e) {
			System.out.println("By type not found with : " + locatorType);
		}

		return by;
	}

	public WebElement getElement(String locator, String info) {
		WebElement element = null;
		By byType = getByType(locator);
		try {
			element = driver.findElement(byType);
			System.out.println("Element " + info + " found with locator : " + locator);
		} catch (Exception e) {
			System.out.println("Element not found with : " + locator);
			e.printStackTrace();
		}
		return element;
	}

	public List<WebElement> getElementList(String locator, String info) {
		List<WebElement> elementList = new ArrayList<>();
		By byType = getByType(locator);
		try {
			elementList = driver.findElements(byType);
			System.out.println("Element List found with : " + locator);
		} catch (Exception e) {
			System.out.println("Element List not found with : " + locator);
			e.printStackTrace();
		}
		return elementList;
	}

	public boolean isElementPresent(String locator, String info) {
		List<WebElement> elementList = getElementList(locator, info);
		int size = elementList.size();
		if (size > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void elementClick(WebElement element, String info, long timeToWait) {
		try {
			element.click();
			if (timeToWait == 0) {
				System.out.println("Clicked On : " + info);
			} else {
				Util.sleep(timeToWait, "Clicked on :" + info);
			}
		} catch (Exception e) {
			System.out.println("Cannot click on : " + info);
			takeScreenshot("Click ERROR", "");
		}
	}

	public void elementClick(WebElement element, String info) {
		elementClick(element, info, 0);
	}

	public void elementClick(String locator, String info, long timeToWait) {
		WebElement element = this.getElement(locator, info);
		elementClick(element, info, timeToWait);
	}

	public void elementClick(String locator, String info) {
		WebElement element = this.getElement(locator, info);
		elementClick(element, info, 0);
	}

	public void javascriptClick(String locator, String info) {
		WebElement element = getElement(locator, info);
		try {
			js.executeScript("arguments[0].click();", element);
			System.out.println("Clicked on : " + info);
		} catch (Exception e) {
			System.out.println("Cannot click on : " + info);
		}
	}

	public void clickWhenReady(By locator, int timeout) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
			WebElement element = null;
			System.out.println("Waiting for max : " + timeout + " seconds for element to be clickable");

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.click();
			System.out.println("Element clicked on the web page");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		} catch (Exception e) {
			System.out.println("Element not appeared on the web page");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		}
	}

	public void sendData(WebElement element, String data, String info, Boolean clear) {
		try {
			if (clear) {
				element.clear();
			}
			// Util.sleep(1000, "Waiting Before Entering Data");
			element.sendKeys(data);
			System.out.println("Send Keys on element : " + info + " with data : " + data);
		} catch (Exception e) {
			System.out.println("Cannot send keys on element : " + info + " with data : " + data);
		}
	}

	public void sendData(String locator, String data, String info, Boolean clear) {
		WebElement element = this.getElement(locator, info);
		sendData(element, data, info, clear);
	}

	public void sendData(WebElement element, String data, String info) {
		sendData(element, data, info, true);
	}

	public void sendData(String locator, String data, String info) {
		WebElement element = this.getElement(locator, info);
		sendData(element, data, info, true);
	}

	public String getText(WebElement element, String info) {
		System.out.println("Getting Text on element : " + info);
		String text = null;
		text = element.getText();
		if (text.length() == 0) {
			text = element.getAttribute("innerText");
		}
		if (!text.isEmpty()) {
			System.out.println("The text is : " + text);
		} else {
			text = "NOT_FOUND";
		}
		return text.trim();
	}

	public String getText(String locator, String info) {
		WebElement element = this.getElement(locator, info);
		return this.getText(element, info);
	}

	public Boolean isEnabled(WebElement element, String info) {
		Boolean enabled = false;
		if (element != null) {
			enabled = element.isEnabled();
			if (enabled) {
				System.out.println("Element : " + info + " is Enabled");
			} else {
				System.out.println("Element : " + info + " is Disabled");
			}
		}
		return enabled;
	}

	public Boolean isEnabled(String locator, String info) {
		WebElement element = getElement(locator, info);
		return this.isEnabled(element, info);
	}

	public Boolean isDisplayed(WebElement element, String info) {
		Boolean displayed = false;
		if (element != null) {
			displayed = element.isDisplayed();
			if (displayed) {
				System.out.println("Element : " + info + " is displayed");
			} else {
				System.out.println("Element : " + info + " is NOT displayed");
			}
		}
		return displayed;
	}

	public Boolean isDisplayed(String locator, String info) {
		WebElement element = getElement(locator, info);
		return this.isDisplayed(element, info);
	}

	public Boolean isSelected(WebElement element, String info) {
		Boolean selected = false;
		if (element != null) {
			selected = element.isSelected();
			if (selected) {
				System.out.println("Element : " + info + " is selected");
			} else {
				System.out.println("Element : " + info + " is already selected");
			}
		}
		return selected;
	}

	public Boolean isSelected(String locator, String info) {
		WebElement element = getElement(locator, info);
		return this.isSelected(element, info);
	}

	public void Check(WebElement element, String info) {
		if (!isSelected(element, info)) {
			elementClick(element, info);
			System.out.println("Element : " + info + " is checked");
		} else {
			System.out.println("Element : " + info + " is already checked");
		}
	}

	public void Check(String locator, String info) {
		WebElement element = getElement(locator, info);
		Check(element, info);
	}

	public void UnCheck(WebElement element, String info) {
		if (isSelected(element, info)) {
			elementClick(element, info);
			System.out.println("Element : " + info + " is unchecked");
		} else {
			System.out.println("Element : " + info + " is already unchecked");
		}
	}

	public void UnCheck(String locator, String info) {
		WebElement element = getElement(locator, info);
		UnCheck(element, info);
	}

	public Boolean Submit(WebElement element, String info) {
		if (element != null) {
			element.submit();
			System.out.println("Element :" + info + "is submitted");
			return true;
		} else {
			return false;
		}
	}

	public String getElementAttributeValue(String locator, String attribute) {
		WebElement element = getElement(locator, "info");
		return element.getAttribute(attribute);
	}

	public String getElementAttributeValue(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	public WebElement waitForElement(String locator, int timeout) {
		By byType = getByType(locator);
		WebElement element = null;
		try {
			System.out.println("Waiting for max : " + timeout + " seconds for element to be available");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(byType));
			System.out.println("Element appeared on the web page");
		} catch (Exception e) {
			System.out.println("Element not appeared on the web page");
		}
		return element;
	}

	public boolean waitForLoading(String locator, long timeout) {
	    By byType = getByType(locator);
	    boolean elementInvisible = false;
	    try {
	        System.out.println("Waiting for max: " + timeout + " seconds for element to disappear");
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	        elementInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(byType));
	        System.out.println("Element disappeared from the web page");
	    } catch (Exception e) {
	        System.out.println("Element did not disappear within the given time");
	    }
	    return elementInvisible;
	}


	public void mouseHover(String locator, String info) {
		WebElement element = getElement(locator, info);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		// Util.sleep(5000);
	}

	public void selectOption(WebElement element, String optionToSelect) {
		Select sel = new Select(element);
		sel.selectByVisibleText(optionToSelect);
		System.out.println("Selected option : " + optionToSelect);
	}

	public void selectOption(String locator, String optionToSelect, String info) {
		WebElement element = getElement(locator, info);
		this.selectOption(element, optionToSelect);
	}

	public String getSelectDropDownValue(WebElement element) {
		Select sel = new Select(element);
		return sel.getFirstSelectedOption().getText();
	}

	public boolean isOptionExists(WebElement element, String optionToVerify) {
		Select sel = new Select(element);
		boolean exists = false;
		List<WebElement> optList = sel.getOptions();
		for (int i = 0; i < optList.size(); i++) {
			String text = getText(optList.get(i), "Option Text");
			if (text.matches(optionToVerify)) {
				exists = true;
				break;
			}
		}
		if (exists) {
			System.out.println("Selected Option : " + optionToVerify + " exist");
		} else {
			System.out.println("Selected Option:" + optionToVerify + " does not exist");
		}
		return exists;
	}

	public String takeScreenshot(String methodName, String browserName) {
		String fileName = Util.getScreenshotName(methodName, browserName);
		String screenshotDir = System.getProperty("user.dir") + "/screenshots/";
		new File(screenshotDir).mkdirs();
		String path = screenshotDir + fileName;
		try {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(path));
			System.out.println("Screen Shot Was Stored at : " + path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}

	public void DoubleClick(WebElement element, String info) {
		Actions action = new Actions(driver);
		action.doubleClick(element);
		System.out.println("Double Clicked on : " + info);
		action.perform();
	}

	public void rightClick(String locator, String info) {
		WebElement element = getElement(locator, info);
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
		System.out.println("Double Clicked on : " + info);
	}

	public void selectItemRightClick(String elementLocator, String itemLocator) {
		WebElement element = getElement(elementLocator, "info");
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
		WebElement itemElement = getElement(itemLocator, "info");
		elementClick(itemElement, "Selected Item");
	}

	public void keyPress(Keys key, String info) {
		Actions action = new Actions(driver);
		action.keyDown(key).build().perform();
		System.out.println("Key Pressed : " + info);
	}

}
