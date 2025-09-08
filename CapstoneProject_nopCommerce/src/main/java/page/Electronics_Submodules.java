package page;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonEvents;

public class Electronics_Submodules {
	WebDriver driver;
	WebDriverWait wait;
	
	By electronicsElement = By.xpath("//ul[@class='top-menu notmobile']/li/a[@href='/electronics']");
	
	@FindBy(xpath = "//ul[@class='sublist first-level']/li/a[@href='/camera-photo']")
	WebElement cameraPhotoElement;
	
	@FindBy(xpath = "//ul[@class='sublist first-level']/li/a[@href='/cell-phones']")
	WebElement cellPhonesElement;
	
	@FindBy(xpath = "//ul[@class='sublist first-level']/li/a[@href='/others']")
	WebElement othersElement;
	
	
	public Electronics_Submodules(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public Boolean clickOnElectronicsIfDisplayed() {
		CommonEvents commonEvent = new CommonEvents(driver);
		WebElement elec = driver.findElement(electronicsElement);
		commonEvent.highlight(elec);
		return elec.isDisplayed();
	}
	
	public Boolean electronicsSubmodulesPresent() throws InterruptedException {
		boolean isDispSubElement = false;
		try {
			CommonEvents commonEvent = new CommonEvents(driver);
			Actions action = new Actions(driver);
			WebElement elec = driver.findElement(electronicsElement);
			action.moveToElement(elec).perform();
			Thread.sleep(2000);
			
			List<WebElement> subElementsList = new ArrayList<>();
			subElementsList.add(cameraPhotoElement);
			subElementsList.add(cellPhonesElement);
			subElementsList.add(othersElement);
			
			for(WebElement hoverSubElement : subElementsList) {
				isDispSubElement = hoverSubElement.isDisplayed();
				commonEvent.highlight(hoverSubElement);
				action.sendKeys(Keys.ARROW_DOWN);
				Thread.sleep(300);
			}
		} catch(Exception e) {
			throw e;
		}
		
		return isDispSubElement;
	}
}
