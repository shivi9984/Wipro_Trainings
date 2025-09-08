package page;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonEvents;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath = "//a[@href='/login?returnUrl=%2F']")
	WebElement loginElement;
	
	@FindBy(id = "Email")
	WebElement emailField;
	
	@FindBy(id = "Password")
	WebElement passwordField;
	
	@FindBy(xpath = "//button[text()='Log in']")
	WebElement loginButton;
	
	@FindBy(xpath = "//a[@href='/customer/info']")
	WebElement accountElement;
	
	@FindBy(id = "Email-error")
	WebElement emailErrorElement;
	
	@FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
	WebElement invalidCredentialMessage;
	
	@FindBy(xpath = "//div[@class='header-links']/ul/li/a[@href='/customer/info']")
	WebElement myAccountElement;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public String loginWithEpmtyFields() throws InterruptedException {
		CommonEvents commonEvents = new CommonEvents(driver);
		commonEvents.click(wait.until(ExpectedConditions.visibilityOf(loginElement)));
		commonEvents.click(loginButton);
		wait.until(ExpectedConditions.visibilityOf(emailErrorElement));
		commonEvents.highlightRed(emailErrorElement);
		Thread.sleep(500);
		String errorMessage = commonEvents.getText(emailErrorElement);
		System.out.println("Login Email Error Debug: "+errorMessage);
		return errorMessage;
	}
	
	public String loginWithInvalidCredentials(Map<String, String> nopCommerceData) throws InterruptedException {
		CommonEvents commmonEvents = new CommonEvents(driver);
		wait.until(ExpectedConditions.elementToBeClickable(loginElement)).click();
		emailField.sendKeys(nopCommerceData.get("Invalid Email"));
		passwordField.sendKeys(nopCommerceData.get("Invalid Password"));
		loginButton.click();
		wait.until(ExpectedConditions.visibilityOf(invalidCredentialMessage));
		commmonEvents.highlightRed(invalidCredentialMessage);
		Thread.sleep(500);
		String errorMessageCredential = invalidCredentialMessage.getText();
		System.out.println("Login Email Error Debug: "+errorMessageCredential);
		return errorMessageCredential;
	}
	
	public Boolean userLoginWithValidCredentials(Map<String, String> nopCommerceData) {
		boolean isAccountDisplayed = false;
		wait.until(ExpectedConditions.elementToBeClickable(loginElement)).click();
		emailField.sendKeys(nopCommerceData.get("Email"));
		passwordField.sendKeys(nopCommerceData.get("Password"));
		loginButton.click();
		isAccountDisplayed = true;
		return isAccountDisplayed;
	}
	
	public String isMyAccountDiaplayed() throws InterruptedException {
		CommonEvents commonEvent = new CommonEvents(driver);
		wait.until(ExpectedConditions.visibilityOf(myAccountElement));
		String myAccountTextString = myAccountElement.getText();
		commonEvent.highlightGreen(myAccountElement);
		Thread.sleep(500);
		return myAccountTextString;
	}
}
