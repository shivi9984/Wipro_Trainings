package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class nopCommerceEcommerce {
    WebDriver driver;

    @Given("I open the browser")
    public void i_open_the_browser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("I navigate to {string}")
    public void i_navigate_to(String url) {
        driver.get(url);
    }

    @When("I click on the login link")
    public void i_click_on_the_login_link() {
        driver.findElement(By.className("ico-login")).click();
    }

    @When("I enter valid username {string} and password {string}")
    public void i_enter_valid_credentials(String username, String password) {
        driver.findElement(By.id("Email")).sendKeys(username);
        driver.findElement(By.id("Password")).sendKeys(password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    @Then("I should see my account page")
    public void i_should_see_my_account_page() {
        driver.findElement(By.className("ico-account")).isDisplayed();
    }

    @When("I navigate to {string} category")
    public void i_navigate_to_category(String category) {
        driver.findElement(By.linkText(category)).click();
    }

    @When("I select {string} subcategory")
    public void i_select_subcategory(String subcategory) {
        driver.findElement(By.linkText(subcategory)).click();
    }

    @When("I choose a product")
    public void i_choose_a_product() {
        driver.findElement(By.xpath("//div[@data-productid='21']")).click();
    }

    @When("I add the product to the shopping cart")
    public void i_add_the_product_to_the_shopping_cart() {
        // Works for any product on detail page
        driver.findElement(By.cssSelector("button[id^='add-to-cart-button']")).click();
    }

    @Then("The product should be displayed in the shopping cart")
    public void the_product_should_be_displayed_in_the_shopping_cart() {
        driver.findElement(By.className("cart-label")).click();
        driver.findElement(By.cssSelector(".product-name")).isDisplayed();
    }

    @When("I go to the shopping cart page")
    public void i_go_to_the_shopping_cart_page() {
        driver.findElement(By.className("cart-label")).click();
    }
    
    @When("Click on Term Check Box")
    public void click_on_term_check_box() {
    	driver.findElement(By.id("termsofservice")).click();
    }

    @When("I click on checkout")
    public void i_click_on_checkout() {
        driver.findElement(By.id("checkout")).click();
    }

    @When("I enter billing details")
    public void i_enter_billing_details() {
//        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Tony");
//        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Stark");
//        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("test@demo.com");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("New York");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("123 Main Street");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("10001");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("1234567890");
        driver.findElement(By.cssSelector("button[name='save']")).click();
    }

    @When("I select shipping method")
    public void i_select_shipping_method() {
        driver.findElement(By.name("shippingoption")).click();
        driver.findElement(By.cssSelector("button[name='save']")).click();
    }

    @When("I select payment method")
    public void i_select_payment_method() {
        driver.findElement(By.name("paymentmethod")).click();
        driver.findElement(By.cssSelector("button[name='save']")).click();
    }

    @When("I confirm the order")
    public void i_confirm_the_order() {
        driver.findElement(By.xpath("//button[text()='Confirm']")).click();
    }

    @Then("I should see the order confirmation message")
    public void i_should_see_the_order_confirmation_message() {
        driver.findElement(By.xpath("//strong[contains(text(),'successfully processed')]")).isDisplayed();
        driver.quit();
    }
}

