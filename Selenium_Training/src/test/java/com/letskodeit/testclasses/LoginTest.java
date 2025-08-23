package com.letskodeit.testclasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
	
	WebDriver driver;

	@BeforeClass
	public void beForeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.letskodeit.com/");
	}

	@Test(priority=1)
	public void testLogin() {
		driver.findElement(By.xpath("//a[@href='/login']")).click();
		driver.findElement(By.xpath("//input[@name='email'][1]")).clear();
		driver.findElement(By.xpath("//input[@name='email'][1]")).sendKeys("test@email.com");
		WebElement passwordElement = driver.findElement(By.id("login-password"));
		passwordElement.clear();
		passwordElement.sendKeys("abcabc");
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement accountImage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("img-fluid")));

	    Assert.assertNotNull(accountImage, "Login failed: Account image not found!");

	}
	
	@Test(priority=2)
	public void testInvalidLogin() {
		driver.findElement(By.xpath("//a[@href='/login']")).click();
		driver.findElement(By.xpath("//input[@name='email'][1]")).clear();
		driver.findElement(By.xpath("//input[@name='email'][1]")).sendKeys("test01@email.com");
		WebElement passwordElement = driver.findElement(By.id("login-password"));
		passwordElement.clear();
		passwordElement.sendKeys("abcabc");
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement accountImage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("img-fluid")));

	    Assert.assertNotNull(accountImage, "Login failed: Account image not found!");
	}
}
