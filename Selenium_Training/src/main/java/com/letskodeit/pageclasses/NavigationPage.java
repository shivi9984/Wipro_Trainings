package com.letskodeit.pageclasses;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;
import utilities.Util;

public class NavigationPage extends BasePage {
	
	public NavigationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public WebDriver driver;
	private final String URL = "https://www.letskodeit.com/";
	private String ALL_COURSES_LINK = "//li[@data-id='41189']/a[@href='/courses']"; 
	private String ACCOUNT_ICON = "dropdownMenu1";
	private String LOGIN_LINK = "//a[@href='/login']";
	private String LOGOUT_LINK = "//a[normalize-space()='Logout']";
	
	public void allCourses() {
//		WebElement allCourses = driver.findElement(By.xpath(ALL_COURSES_LINK));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", allCourses);
		
		try {
			Thread.sleep(2000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath(ALL_COURSES_LINK)).click();
//		Alert a = driver.switchTo().alert();
//		a.accept();

	}
	
	public boolean isUserLogIn() {
		try{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ACCOUNT_ICON)));
			return true;
		}
	    catch(Exception e) {
//	    	e.printStackTrace();  
	    	return false; 
	    }		   
	}
	
	public boolean verifyHeader() {
		WebElement link = driver.findElement(By.xpath(ALL_COURSES_LINK));
		String text = link.getText();
		return Util.verifyTextContains(text, "ALL COURSESSS");
	}
	
	public LoginPage login() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LOGIN_LINK))).click();
		return new LoginPage(driver);
		
	}
	
	public void logout() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.id(ACCOUNT_ICON))).click();
		WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LOGOUT_LINK)));
		logoutLink.click();
		
//		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		 WebElement profileDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id(ACCOUNT_ICON)));
//
//		 // Select option using visible text
//		 Select select = new Select(profileDropdown);
//		 select.selectByVisibleText("Logout");
	
	}
	
	public boolean isOpen() {
		return URL.equalsIgnoreCase(driver.getCurrentUrl());
	}
}
