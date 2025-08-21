package Day_28_POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Without Page Factory

public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	By signIn = By.xpath("//a[@href='/login']");
	By email = By.id("Email");
	By password = By.id("Password");
	By loginButton = By.xpath("//input[@value='Log in']");
	
	public void signInButton() {
		
		wait.until(ExpectedConditions.elementToBeClickable(signIn)).click();
	}
	
	public void enterEmail(String mail) {
		driver.findElement(email).sendKeys(mail);
	}
	
	public void enterPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	
	public void clickLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
	}
}
