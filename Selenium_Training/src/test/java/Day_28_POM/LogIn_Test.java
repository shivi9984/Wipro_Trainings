package Day_28_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogIn_Test {
	
	WebDriver driver;
//	LoginPage log;
	LoginPage2 log;
	
	@BeforeClass
	public void launchBrowser() {
		System.out.println("Launching Chrome Browser...");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//		log = new LoginPage(driver);
		log = new LoginPage2(driver);
	}
	
	@Test
	public void logIn() {
		driver.get("https://demowebshop.tricentis.com/");
		log.signInButton();
		log.enterEmail("marvel01@gmail.com");
		log.enterPassword("IronMan");
		log.clickLogin();
		
	}
}
