package page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonEvents;

public class NopCommerce_SubmodulesPage {
	WebDriver driver;
	WebDriverWait wait;
	
	By nopSubModuleListElement = By.xpath("//ul[@class='top-menu notmobile']/li");
	
	public NopCommerce_SubmodulesPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public Boolean verifyNopCommerceSubmodules() {
		CommonEvents commonEvent = new CommonEvents(driver);
		List<WebElement> subModulesElements = driver.findElements(nopSubModuleListElement);
		System.out.println("Total Number of NopCommerce SubModules: "+subModulesElements.size());
		for(WebElement subModuleElement: subModulesElements) {
			commonEvent.highlight(subModuleElement);
		}
		if(subModulesElements.isEmpty()) {
			return false;
		}
		return true;
	}
}
