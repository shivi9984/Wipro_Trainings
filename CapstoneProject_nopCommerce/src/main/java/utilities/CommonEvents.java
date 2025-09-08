package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonEvents {
	WebDriver driver;
	static WebDriverWait wait;
	
	public CommonEvents(WebDriver driver) {
		this.driver = driver;
	}
	
	// Common Methods
	
	public WebElement waitUntilVisibilityOf(WebElement element) {
		
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public void click(Object object) {
		((WebElement) object).click();
	}
	
	public String getText(WebElement element) {
		
		return element.getText();
	}
	
	
	public void highlight(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// Add Blue the highlight
		jse.executeScript("arguments[0].setAttribute('style', 'border: solid 5px blue');", element);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Remove the highlight
		jse.executeScript("arguments[0].setAttribute('style', '');", element);
	}
	
	public void highlightGreen(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// Add the Green highlight
		jse.executeScript("arguments[0].setAttribute('style', 'border: solid 5px green');", element);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Remove the highlight
		jse.executeScript("arguments[0].setAttribute('style', '');", element);
	}
	
	public void highlightRed(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// Add Red the highlight
		jse.executeScript("arguments[0].setAttribute('style', 'border: solid 5px red');", element);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Remove the highlight
		jse.executeScript("arguments[0].setAttribute('style', '');", element);
	}
}
