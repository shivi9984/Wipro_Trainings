package page;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RequiredCellphonePage {
	WebDriver driver;
	WebDriverWait wait;
	
	By samsungPhoneDescription = By.xpath("//div[@class='short-description']");
	By samsungPhonePrice = By.xpath("//div[@class='product-price']/span");
	By phoneImage = By.id("main-product-img-22");
	By setQuantity = By.id("product_enteredQuantity_22");
	By addToCartButton = By.xpath("//button[text()='Add to cart']");
	By addCartSuccessMessage = By.cssSelector("div.bar-notification.success");
	
	@FindBy(xpath = "//a[@href='#estimate-shipping-popup-22']")
	WebElement setAddress;
	
	@FindBy(id = "CountryId")
	WebElement countryDropdown;
	
	@FindBy(id = "StateProvinceId")
	WebElement stateDropdown;
	
	@FindBy(id = "ZipPostalCode")
	WebElement zipPostalCode;
	
	@FindBy(xpath = "//div/button[text()='Apply']")
	WebElement addressSubmitButton;
	
	
	public RequiredCellphonePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	
	public Boolean verifySamsungDescription(Map<String, String> nopCommerceData) {
	    try {
	        String expectedDesc = nopCommerceData.get("specificationsOfCellPhone");

	        WebElement productImage = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneImage));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", productImage);

	        WebElement descriptionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(samsungPhoneDescription));
	        String actualDesc = descriptionElement.getText().trim();

	        System.out.println("Actual Description: " + actualDesc);

	        return actualDesc.contains(expectedDesc);
	    } 
	    catch (Exception e) {
	        System.out.println("Error while verifying description: " + e.getMessage());
	        return false;
	    }
	}
	
	public void getSamsungPhonePrice() {
		String price = "";
		try {
            WebElement priceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(samsungPhonePrice));
            price = priceElement.getText().trim();
            System.out.println("Phone Price: " + price);
        } 
		catch (Exception e) {
            System.out.println("Price not found!");
        }
    }
	
	public Boolean setShippingAddress(Map<String, String> nopCommerceData) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(setAddress)).click();
			Select selectCountry = new Select(countryDropdown);
			selectCountry.selectByVisibleText(nopCommerceData.get("setShippingAddCountry"));
			Thread.sleep(500);
			
			Select selectState = new Select(stateDropdown);
			selectState.selectByVisibleText(nopCommerceData.get("setShippingAddState"));
			Thread.sleep(500);
			
			zipPostalCode.sendKeys(nopCommerceData.get("setZipPostalCode"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Ground')]")));
			addressSubmitButton.click();
			Thread.sleep(2000);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Boolean setQuantityAndAddToCart(String quantity) {
		try {
	        WebElement qtyBox = wait.until(ExpectedConditions.visibilityOfElementLocated(setQuantity));
	        qtyBox.clear();
	        qtyBox.sendKeys(quantity);

	        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
	        addToCartBtn.click();

	        WebElement successMsgAddCart = wait.until(ExpectedConditions.visibilityOfElementLocated(addCartSuccessMessage));

	        System.out.println("Cart Message: " + successMsgAddCart.getText());

	        return successMsgAddCart.getText().contains("The product has been added");
	    } 
		catch (Exception e) {
	        System.out.println("Failed to add product to cart: " + e.getMessage());
	        return false;
	    }
	}
}
