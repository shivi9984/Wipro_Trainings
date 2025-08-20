package Day_24;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderNew{
    
    WebDriver driver;
    WebDriverWait wait;
    
    @BeforeClass
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    @Test(dataProvider="logInTestData")
    public void logIn(String userName, String password) {
    	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        wait.until(ExpectedConditions.elementToBeClickable(By.name("username"))).clear();
        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        
        if (password.equals("admin123")) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@class='oxd-userdropdown-name']"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Logout']"))).click();
        }
        
//        driver.navigate().back();
    }
    
    @DataProvider(name="logInTestData")
    public Object[][] logInData() {
        return new Object[][] {
            {"Admin", "admin1234"},
            {"Admin", "admin123"}
        };
    }
    
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

