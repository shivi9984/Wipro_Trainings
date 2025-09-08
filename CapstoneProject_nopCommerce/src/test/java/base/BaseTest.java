package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utilities.Constants;

public class BaseTest {
	public WebDriver driver;
	String baseURL;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		baseURL = Constants.BASE_URL;
		driver.get(baseURL);
	}
	
	
	@AfterClass
	public void tearDown() {
		if (driver != null) {
            driver.quit();
        }
	}
}
