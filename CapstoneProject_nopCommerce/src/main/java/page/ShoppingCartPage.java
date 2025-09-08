package page;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonEvents;

public class ShoppingCartPage {
	WebDriver driver;
	WebDriverWait wait;
	CommonEvents commonEvents;
	
	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		commonEvents = new CommonEvents(driver);
	}
	
	@FindBy(xpath = "//span[text()='Shopping cart']")
	WebElement shoppingCartElement;
	
	@FindBy(xpath = "//button[text()='Go to cart']")
	WebElement goToShoppingCartElement;
	
	@FindBy(xpath = "//span[@title='Close']")
	WebElement closePopUpElement;
	
	
	
	public void hoverOnShoppingCart() throws InterruptedException {
		Actions actions = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(closePopUpElement)).click();		
		Thread.sleep(2000); 
		
//		actions.scrollToElement(shoppingCartElement);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", shoppingCartElement);
		actions.moveToElement(shoppingCartElement).perform();
		wait.until(ExpectedConditions.elementToBeClickable(goToShoppingCartElement)).click();
		
	}
	
	
}
