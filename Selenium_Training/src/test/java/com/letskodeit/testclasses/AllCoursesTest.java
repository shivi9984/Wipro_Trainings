package com.letskodeit.testclasses;

import org.testng.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.letskodeit.pageclasses.CategoryFilterPage;
import com.letskodeit.pageclasses.SearchBarPage;

import base.BaseSetUp;
import base.CheckPoint;
import utilities.Constants;
import utilities.ExcelUtility;

		
public class AllCoursesTest extends BaseSetUp {
	
	@DataProvider(name= "searchCourseData")
	public Object[][] getSearchCourseData(){
		Object[][] testData = ExcelUtility.getTestData("verify_search_course");
		return testData;
	}
	
	@BeforeClass
	public void setUp() {
		nav = login.signInWith(Constants.DEFAULT_USERNAME, Constants.DEFAULT_PASSWORD);
		ExcelUtility.setExcelFile(Constants.EXCEL_FILE, "AllCoursesTests");
	}
	
	@Test(dataProvider = "searchCourseData")
	public void searchCourse(String courseName) {
//      NavigationPage nav = new NavigationPage(driver)
		nav.allCourses();
		search = new SearchBarPage(driver);
		result = search.searchCourse(courseName);
//		ResultPage result = new ResultPage(driver);
		boolean searchResult = result.verifySearchResult();
//		Assert.assertTrue(searchResult);
		CheckPoint.markFinal("test-02", searchResult, "search course verification");
	}
	
	@Test(enabled = false)
	public void filterByCategory() {
		nav.allCourses();
		category = new CategoryFilterPage(driver);
		result = category.select("Selenium WebDriver");
		boolean filterResult = result.verifyFilterCourse();
		Assert.assertTrue(filterResult);
		
	}
	
	
}
