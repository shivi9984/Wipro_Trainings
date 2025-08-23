package com.letskodeit.pageclasses;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPage {
	
	public NavigationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver driver;
	private final String URL = "https://www.letskodeit.com/";
	private String ALL_COURSES_LINK = "//li[@data-id='41189']/a[@href='/courses']"; 
	
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
	
	public boolean isOpen() {
		return URL.equalsIgnoreCase(driver.getCurrentUrl());
	}
}
