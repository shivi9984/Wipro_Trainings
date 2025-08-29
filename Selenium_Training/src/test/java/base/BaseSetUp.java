package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.letskodeit.pageclasses.CategoryFilterPage;
import com.letskodeit.pageclasses.LoginPage;
import com.letskodeit.pageclasses.NavigationPage;
import com.letskodeit.pageclasses.ResultPage;
import com.letskodeit.pageclasses.SearchBarPage;

import utilities.Constants;

public class BaseSetUp {
	public WebDriver driver;
	protected String baseURL;
	protected LoginPage login;
	protected NavigationPage nav;
	protected SearchBarPage search;
	protected ResultPage result;
	protected CategoryFilterPage category;
	
	@BeforeClass
	@Parameters({"browser"})
	public void commonSetUp(String browser) {
		driver = WebDriverFactory.getInstance().getDriver(browser);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		baseURL = Constants.BASE_URL;
		driver.get(baseURL);
		nav = new NavigationPage(driver);
		login = nav.login();
	}
	
	@BeforeMethod
	public void methodSetUp() {
		CheckPoint.clearHashMap();
	}
	
	@AfterClass
	public void commonTearDown() {
//		driver.quit();
		WebDriverFactory.getInstance().quitDriver();
	}
}
