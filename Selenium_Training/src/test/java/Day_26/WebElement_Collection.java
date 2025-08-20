package Day_26;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebElement_Collection {
	
	WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
	}
	@Test
	public void getWebElement() {
		List<WebElement> links =driver.findElements(By.cssSelector("a"));   // By changing css value(selector) we can find another types of list of elements.
		for(WebElement link : links ) {
			String text = link.getText();
			if(!text.trim().isEmpty()) {
				System.out.println(link.getText());
				//System.out.println(link.getAttribute("class"));
				System.out.println("------------------");
			}
		}
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
	
	
}
