package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "Email")
	WebElement email;
	
	@FindBy(id = "Password")
	WebElement password;
	
	@FindBy(xpath = "//button[@class='button-1 login-button']")
	WebElement loginButton;
	
	@FindBy(linkText = "Logout")
	WebElement logoutButton;
	
	
	public void enterEmail(String emailAdd) {
		email.clear();
		email.sendKeys(emailAdd);
	}
	
	public void enterPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickLogin() {
		loginButton.click();
	}
	
	public void clickLogout() {
		logoutButton.click();
	}
	
}
