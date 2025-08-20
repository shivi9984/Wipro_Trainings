package Day_23_PracticeGroup;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
//import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(Day_25.MyListener_Report.class)

public class DemoShop_Group {
	
	WebDriver driver;
	
	@Parameters({"browserName", "url"})
	
	@BeforeClass(alwaysRun=true)
	public void launchWebShop(String browserName, String url) {
		System.out.println("Launching Demo Web Shop.");
//		driver = new ChromeDriver();
		
		switch (browserName) {
			case "Chrome" :
				driver = new ChromeDriver();
				break;
			case "Firefox" :
				driver = new FirefoxDriver();
				break;
			case "Edge" :
				driver = new EdgeDriver();
				break;
			default : 
				System.out.println("Browsers Invalid");
				break;
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	
	//@Ignore
	@Test(priority=1, groups = {"smoke", "regression"})
	public void logIn() {
		System.out.println("Testing LogIn.");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/login']"))).click();
		driver.findElement(By.id("Email")).sendKeys("marvel01@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("IronMan");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Log in']"))).click();
		
	}
	
	@Test(priority=2, groups = {"smoke", "regression"})
	public void clickBook() {
		System.out.println("Now testing Books button.");
		driver.findElement(By.xpath("//a[@href='/books']")).click();
	}
	
	
	@Test(priority=3, groups = {"smoke"})
	public void selectBooks() {
	    System.out.println("Book selection testing");
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement book = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/computing-and-internet']")));
	    
	    // Scroll into view
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", book);
	    
	    // Click using JavaScript (forces click)
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", book);
	}

	
	@Test(priority=4, groups = {"cart"})
	public void settingQuantity() {
		System.out.println("Giving quantity of books.");
		driver.findElement(By.id("addtocart_13_EnteredQuantity")).clear();
		driver.findElement(By.id("addtocart_13_EnteredQuantity")).sendKeys("5");
	}
	
	@Test(priority=5, groups = {"cart"})
	public void addToCart() {
		System.out.println("Now adding to cart.");
		driver.findElement(By.id("add-to-cart-button-13")).click();

	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Closing the browser.");
		if(driver != null) {
			driver.quit();
		}
	}
}
