package base;

import org.openqa.selenium.WebDriver;

public class BasePage extends CustomDriver{
	
	WebDriver driver;
	
	public BasePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean verifyTitle(String expectedTitle) {
		return driver.getTitle().equalsIgnoreCase(expectedTitle);
	}
	
}
