package com.letskodeit.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	WebDriver driver;
	private String LOGIN_LINK = "//a[@href='/login']";
	private String EMAIL_FIELD = "//input[@name='email'][1]";
	private String PASSWORD_FIELD = "login-password";
	private String LOG_IN_BUTTON = "login"; 
	
	public void open() {
		driver.findElement(By.xpath(LOGIN_LINK)).click();
	}
	
	public NavigationPage signInWith(String email, String password) {
		WebElement emailField = driver.findElement(By.xpath(EMAIL_FIELD));
		emailField.clear();
		emailField.sendKeys(email);
		
		WebElement passwordField = driver.findElement(By.id(PASSWORD_FIELD));
		passwordField.clear();
		passwordField.sendKeys(password);
		
		WebElement loginButton = driver.findElement(By.id(LOG_IN_BUTTON));
		loginButton.click();
		
		
		return new NavigationPage(driver);
	}
}
