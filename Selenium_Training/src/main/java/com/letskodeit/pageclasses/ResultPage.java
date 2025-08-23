package com.letskodeit.pageclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPage {
	
	public ResultPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver driver;
	private final String URL = "courses";
	private String URL_CATEGORY = "selenium-webdriver";
	private String COURSES_LIST = "//div[@class='col-lg-4 col-md-4 col-sm-6 col-xs-12']";
	
	
	public boolean isOpen() {
		return driver.getCurrentUrl().contains(URL);
	}
	
	public int coursesCount() {
		List<WebElement> coursesList = driver.findElements(By.xpath(COURSES_LIST));
		return coursesList.size();
	}
	
	public boolean verifySearchResult() {
		boolean result = false;
		if(coursesCount() > 0) {
			result = true;
		}
		result = isOpen() && result;
		return result;
	}
	
	public boolean verifyFilterCourse() {
		return driver.getCurrentUrl().contains(URL_CATEGORY);
	}
}
