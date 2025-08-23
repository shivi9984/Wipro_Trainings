package com.letskodeit.pageclasses;

import java.time.Duration;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryFilterPage {

	public CategoryFilterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver driver;
	private String CATEGORY_DROPDOWN = "//select[@name='categories']";
	

	public ResultPage select(String categoryName) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement categoryDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CATEGORY_DROPDOWN)));

	    // Select option using visible text
	    Select select = new Select(categoryDropdown);
	    select.selectByVisibleText(categoryName);

	    // Wait for URL to change
	    wait.until(ExpectedConditions.urlContains("selenium-webdriver"));

	    return new ResultPage(driver);
	}
	

}
