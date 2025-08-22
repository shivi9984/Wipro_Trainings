package Day_27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IFrame_Practice {
	
	WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void serachInFrame1() throws InterruptedException {
		driver.get("https://practice-automation.com/iframes/");
		
		// Switching to frame
		driver.switchTo().frame("iframe-1");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Search (Ctrl+K)']"))).click();
		Thread.sleep(2000);
		driver.findElement(By.className("DocSearch-Input")).sendKeys("Hello");
	}
}
