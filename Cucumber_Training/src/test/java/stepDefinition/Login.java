package stepDefinition;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Login {
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("I open the browser and launch the login page")
	public void I_open_the_browser_and_launch_the_login_page() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/login");
	}
	
	
	@When("I login with username {string} and password {string}")
	public void I_login_with_username_and_password(String username , String password){
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='ico-login']"))).click();
		
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
		
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}
	
	
	@Then("I should see the home page")
	public void  I_should_see_the_home_page() {
		if(driver != null)
			driver.quit();
	}

}

