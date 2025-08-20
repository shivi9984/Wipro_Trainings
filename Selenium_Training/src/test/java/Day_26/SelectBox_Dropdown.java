package Day_26;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectBox_Dropdown {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void launchBrowser() {
		System.out.println("Launching Chrome Browser...");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
	}
	
	@Test(priority=1)
	public void logIn() {
		System.out.println("Logging In Demo Web Shop.");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/login']"))).click();
		driver.findElement(By.id("Email")).sendKeys("marvel01@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("IronMan");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
	}
	
	@Test(priority=2)
	public void clickShoppingCart() {
		driver.findElement(By.id("topcartlink")).click();
	}
	
	@Test(priority=3)
	public void countryDropDown() {
//		String a = driver.findElement(By.id("CountryId")).getAttribute("value");
//		String b = driver.findElement(By.id("StateProvinceId")).getAttribute("value");
//		
//		System.out.println(a);
//		System.out.println(b);
		WebElement dropdown = driver.findElement(By.id("CountryId"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("India");
		
		System.out.println("Selected value: " + select.getFirstSelectedOption().getText());

	}
	
	
}
