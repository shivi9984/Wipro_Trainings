package com.letskodeit.testclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.letskodeit.pageclasses.NavigationPage;
import com.letskodeit.pageclasses.CategoryFilterPage;
import com.letskodeit.pageclasses.LoginPage;
import com.letskodeit.pageclasses.ResultPage;
import com.letskodeit.pageclasses.SearchBarPage;

		
public class AllCoursesTest {
	WebDriver driver;
	LoginPage login;
	NavigationPage nav;
	SearchBarPage search;
	ResultPage result;
	CategoryFilterPage category;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.letskodeit.com/");
		login = new LoginPage(driver);
		login.open();
		nav = login.signInWith("test@email.com", "abcabc");
	}
	
	@Test
	public void searchCourse() {
	
//      NavigationPage nav = new NavigationPage(driver);
		nav.allCourses();
		
		search = new SearchBarPage(driver);
		result = search.searchCourse("rest api");
//		ResultPage result = new ResultPage(driver);
		boolean searchResult = result.verifySearchResult();
		Assert.assertTrue(searchResult);
	}
	
	@Test(dependsOnMethods = "searchCourse")
	public void filterByCategory() {
		nav.allCourses();
		category = new CategoryFilterPage(driver);
		result = category.select("Selenium WebDriver");
		boolean filterResult = result.verifyFilterCourse();
		Assert.assertTrue(filterResult);
		
	}
	
	@AfterClass
	public void tearDown() {
//		driver.quit();
	}
	
}
