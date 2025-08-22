package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebShopLogin {
	WebDriver driver;
	
	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
	}
	
	@When("User click on Login")
		public void user_click_on_Login(){
			driver.findElement(By.xpath("//a[@href='/login']")).click();
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
	    driver.findElement(By.id("Email")).sendKeys(email);
	    driver.findElement(By.id("Password")).sendKeys(password);
	}

	@When("Click on login")
	public void click_on_login() {
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
	    Assert.assertEquals(driver.getTitle(), expectedTitle);
	}

	@When("User click on Logout")
	public void user_click_on_logout() {
		driver.findElement(By.linkText("Log out")).click();
	}

	@Then("close browser")
	public void close_browser() {
	    driver.close();
	}
}
