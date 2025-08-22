package Day_27;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DatePicker_Practice {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void LaunchBrowser() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));   // handling the page loading time
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
	}
	@Test
	public void DatePickerTest() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@id='dob']")).click();  // Click on the DOB text box

//		=========MONTH AND YEAR SELECTION============
//		Importing the Select Class to get the month and year from the drop-down
		Select month = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		month.selectByVisibleText("Nov");
		Thread.sleep(2000);
		
		Select year = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		year.selectByVisibleText("2002");
		Thread.sleep(2000);
		
//		=========DATE SELECTION==========
//		Picking the Date 
		String date = "11";
		
//		Storing all the dates into a List  ---- use of findElements
		List<WebElement> alldates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td//a"));
		
//		Picking Each Date and Matching with our Expected Date
		for(WebElement ele: alldates) 
		{
			String dt = ele.getText();
			
//			Matching selected date and expected date
			if(dt.equals(date)) {
				ele.click();
				break;
			}
		}
	}
	
	/*
	@AfterMethod
	public void tearDown() {
		if(driver != null)
			driver.quit();
	}
	*/
	
}

