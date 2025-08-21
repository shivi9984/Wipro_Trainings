package Day_26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelTestDemo1 {
	WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser() {
		System.out.println("Launching Chrome Browser...");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
	}
	
	@Test
	public void verifyTitle() throws InterruptedException {
		System.out.println("Verifying Title..");
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop");
		Thread.sleep(2000);
	}
	
	@Test
	public void verifyLogo() throws InterruptedException {
		System.out.println("Verifying Logo..");
		WebElement logo = driver.findElement(By.xpath("//div[@class='header-logo']"));
		Assert.assertTrue(logo.isDisplayed());
		Thread.sleep(2000);
	}
}
