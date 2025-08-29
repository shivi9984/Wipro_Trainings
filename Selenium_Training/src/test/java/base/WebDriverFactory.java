package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;

public class WebDriverFactory {
	
	//Singleton Pattern Method
	//Only one instance of the class can exist at a time.
	private static final WebDriverFactory instance = new WebDriverFactory();
	
	private WebDriverFactory() {
		
	}
	
	// Return the instance of this WebDriverFactory class.
	public static WebDriverFactory getInstance() {
		return instance;
	}
	
	private static ThreadLocal<WebDriver> threadedDriver = new ThreadLocal<WebDriver>();
	private static ThreadLocal<String> threadedBrowser = new ThreadLocal<String>();
	
	public WebDriver getDriver(String browser) {
		WebDriver driver = null;
		threadedBrowser.set(browser);
		if(threadedDriver.get() == null) {
			try {
				if(browser.equalsIgnoreCase("firefox")) {
					FirefoxOptions ffOptions = setFFOptions();
					driver = new FirefoxDriver(ffOptions);
					threadedDriver.set(driver);
				}
				if(browser.equalsIgnoreCase("chrome")) {
					ChromeOptions chromeOptions = setChromeOptions();
					driver = new ChromeDriver(chromeOptions);
					threadedDriver.set(driver);
				}
				if(browser.equalsIgnoreCase("edge")) {
					EdgeOptions edgeOptions = setEdgeOptions();
					driver = new EdgeDriver(edgeOptions);
					threadedDriver.set(driver);
				}
				if(browser.equalsIgnoreCase("iexplorer")) {
					InternetExplorerOptions ieOptions = setIEOptions();
					driver = new InternetExplorerDriver(ieOptions);
					threadedDriver.set(driver);
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			threadedDriver.get().manage().window().maximize();
			threadedDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		}
		
		return threadedDriver.get();
	}
	
	public String getBrowser() {
		return threadedBrowser.get();
	}
	
	public void quitDriver() {
		threadedDriver.get().quit();
		threadedDriver.set(null);
	}
	
	public ChromeOptions setChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable=infobars");
		return options;
	}
	
	public FirefoxOptions setFFOptions() {
		FirefoxOptions options = new FirefoxOptions();
		options.setCapability(CapabilityType.BROWSER_NAME, false);
		return options;
	}
	
	public EdgeOptions setEdgeOptions() {
		EdgeOptions options = new EdgeOptions();
		options.addArguments("disable=infobars");
		return options;
	}
	
	public InternetExplorerOptions setIEOptions() {
		InternetExplorerOptions options = new InternetExplorerOptions();
		options.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
		options.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		options.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
		options.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		
		return options;
	}
}
