package Day_29;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Alert_Boxes_Practice {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://demoqa.com/alerts");
    }

    public void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void allAlerts() {
        // Simple Alert
        driver.findElement(By.id("alertButton")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert a = driver.switchTo().alert();
        pause(1500); 
        a.accept();

        // Timed Alert
        driver.findElement(By.id("timerAlertButton")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert x = driver.switchTo().alert();
        pause(1500);
        x.accept();

        // Confirm Alert
        driver.findElement(By.id("confirmButton")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert c = driver.switchTo().alert();
        pause(1500);
        c.dismiss();

        // Prompt Alert
        driver.findElement(By.id("promtButton")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert p = driver.switchTo().alert();
        pause(1500);
        p.sendKeys("Shivam");
        pause(1000);
        p.accept();
    }
}

