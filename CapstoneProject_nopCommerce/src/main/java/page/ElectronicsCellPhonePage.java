package page;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonEvents;

public class ElectronicsCellPhonePage {
	WebDriver driver;
	WebDriverWait wait;
	
	By electronicsElement = By.xpath("//ul[@class='top-menu notmobile']/li/a[@href='/electronics']");
	
	@FindBy(xpath = "//div[@class='picture']/a[@href='/cell-phones']")
	WebElement cellPhoneImage;
	
	@FindBy(xpath = "//div[@data-productid='22']")
	WebElement samsungPhoneWithImage;
	
	By allCellPhones = By.xpath("//div[@class='product-item']");
	By samsungPhoneLocator = By.xpath("//h2[@class='product-title']/a[contains(text(),'Samsung Galaxy S24')]");
	
	public ElectronicsCellPhonePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public String clickOnElectronics() {
		WebElement electronics = wait.until(ExpectedConditions.elementToBeClickable(electronicsElement));
		electronics.click();
		wait.until(ExpectedConditions.urlContains("/electronics"));
		return driver.getCurrentUrl();
	}
	
	public String clickOnCellPhonesImageAndCheckTheCurrentPageTitleURl() {
		wait.until(ExpectedConditions.elementToBeClickable(cellPhoneImage));
		cellPhoneImage.click();
		String currentPageTitle = "nopCommerce demo store. Cell phones";
		wait.until(ExpectedConditions.titleIs(currentPageTitle));
		System.out.println(currentPageTitle);
		return driver.getCurrentUrl();
	}
	
	public Boolean checkIfCellPhonesArePresent() {
		List<WebElement> subModulesElements = driver.findElements(allCellPhones);
		int noOfPhones = subModulesElements.size();
		if(!(noOfPhones > 0)) {
			return false;
		}
		System.out.println("Total Number Of Cell Phones: " +noOfPhones);
		return true;
	}
	
	public Boolean selectRequiredCellPhoneForBuying(Map<String, String> nopCommerceData) throws InterruptedException {
		try {
			CommonEvents commmonEvents = new CommonEvents(driver);
	        WebElement samsungPhone = driver.findElement(samsungPhoneLocator);

	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", samsungPhone);
	        Thread.sleep(2000);

	        String phoneName = samsungPhone.getText();
	        if (phoneName.equals(nopCommerceData.get("requiredCellPhone"))) {
	            System.out.println("Phone found: " + phoneName);
	            commmonEvents.highlightGreen(samsungPhoneWithImage);
	            Thread.sleep(500);
	            samsungPhone.click();
	            return true;
	        } else {
	            System.out.println("Phone not found!");
	            return false;
	        }
		}
		catch(Exception e) {
			throw e;
		}
		
	}
	
	
}
