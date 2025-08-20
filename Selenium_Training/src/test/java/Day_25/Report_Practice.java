package Day_25;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Report_Practice {

    WebDriver driver;

    @Test(priority=1)
    public void setup() {
        driver = new ChromeDriver(); 
        driver.manage().window().maximize();
        Reporter.log("Driver setup and browser maximized.", true);
    }

    @Test(priority=2)
    public void verifyHomePageTitle() {
        driver.get("https://demowebshop.tricentis.com/");
        Reporter.log("Navigated to Demo Web Shop home page.", true);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Demo Web Shop";  // correct title
        Assert.assertEquals(actualTitle, expectedTitle, "Home page title mismatch!");
        Reporter.log("Verified home page title successfully.", true);
    }

    @Test(priority=3)
    public void logIn() {
    	driver.get("https://demowebshop.tricentis.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/login']"))).click();
		driver.findElement(By.id("Email")).sendKeys("marvel01@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("IronMan");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Log in']"))).click();
        Reporter.log("Verified login page and now it's logging in.", true);
    }

}
