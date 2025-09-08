package page;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath = "//a[@href='/register?returnUrl=%2F']")
	WebElement registerElement;
	
	@FindBy(id = "gender-male")
	WebElement genderMale;

	@FindBy(id = "FirstName")
	WebElement firstName;
	
	@FindBy(id = "LastName")
	WebElement lastName;
	
	@FindBy(id = "Email")
	WebElement email;
	
	@FindBy(id = "Password")
	WebElement password;
	
	@FindBy(id = "ConfirmPassword")
	WebElement confirmPassword;
	
	@FindBy(id = "register-button")
	WebElement registerButton;
	
	@FindBy(xpath =  "//a[@href='/logout']")
	WebElement logoutElement;
	
	By registrationCompletedText = By.xpath("//div[text()='Your registration completed']");
	By alreadyRegisteredElement = By.xpath("//li[text()='The specified email already exists']");
	
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	}

	public void startRegister(Map<String, String> nopCommerceData) {
		wait.until(ExpectedConditions.elementToBeClickable(registerElement)).click();
		genderMale.click();
		firstName.sendKeys(nopCommerceData.get("FirstName"));
		lastName.sendKeys(nopCommerceData.get("LastName"));
		email.sendKeys(nopCommerceData.get("Email"));
		password.sendKeys(nopCommerceData.get("Password"));
		confirmPassword.sendKeys(nopCommerceData.get("Confirm Password"));
		registerButton.click();	
		
		try {
			// Check for registration success
			WebElement successMessage = wait.until(ExpectedConditions.presenceOfElementLocated(registrationCompletedText));
			if (successMessage.isDisplayed()) {
				System.out.println("Registration successful.");
				WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(logoutElement));
				logoutBtn.click();
			}
		} catch (Exception ignored) {
			// Do nothing; try checking if email is already registered
		}

		try {
			// Check if email already exists
			WebElement emailExistsMessage = wait.until(ExpectedConditions.presenceOfElementLocated(alreadyRegisteredElement));
			if (emailExistsMessage.isDisplayed()) {
				System.out.println("Email already exists.");

			}
		} catch (Exception ignored) {
			System.out.println("Neither success nor email-exists message appeared.");
		}

	}
	
	
}
