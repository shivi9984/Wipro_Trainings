package com.letskodeit.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class SearchBarPage extends BasePage {
	
	public SearchBarPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public WebDriver driver;
	private final String SEARCH_COURSE_FIELD = "//input[@class='form-control find-input dynamic-text']";
	private String SEARCH_COURSE_BUTTON = "//button[@class='find-course search-course']";
	
	
	public ResultPage searchCourse(String courseName) {
		WebElement searchField = driver.findElement(By.xpath(SEARCH_COURSE_FIELD));
		searchField.clear();
		searchField.sendKeys(courseName);
		
		WebElement searchButton = driver.findElement(By.xpath(SEARCH_COURSE_BUTTON));
		searchButton.click();
		
		
		return new ResultPage(driver);
	}
}
