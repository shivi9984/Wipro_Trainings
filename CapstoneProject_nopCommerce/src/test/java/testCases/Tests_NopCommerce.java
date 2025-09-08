package testCases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ExcelPathProvider;
import utilities.Excel_Integration;
import page.CheckoutPage;
import page.ElectronicsCellPhonePage;
import page.Electronics_Submodules;
import page.LoginPage;
import page.NopCommerce_SubmodulesPage;
import page.RegisterPage;
import page.RequiredCellphonePage;
import page.ShoppingCartPage;

@Listeners(testUtilities.MyListener_Report_Capstone.class)

public class Tests_NopCommerce extends BaseTest{
	
	String nopCommerceExcelPath = ExcelPathProvider.getExcelPath("NopCommerceExpectedData.xlsx");
    
	@Test(priority=1)
	public void registerTest() throws Exception{
		Map<String, String> nopCommerce = new Excel_Integration().readExcelPOI(nopCommerceExcelPath, "Registration");
		RegisterPage regPage = new RegisterPage(driver);
		System.out.println("User Registration Test Starts...");
		regPage.startRegister(nopCommerce);
		System.out.println("Registration Test Successful...");	
	}
	
	@Test(priority=2)
	public void logInTest() throws Exception {
		Map<String, String> nopCommerce = new Excel_Integration().readExcelPOI(nopCommerceExcelPath, "Credentials");
		Map<String, String> nopCommerceExpected = new Excel_Integration().readExcelPOI(nopCommerceExcelPath, "Data");
		
		LoginPage logPage = new LoginPage(driver);
		System.out.println("User Login Test Starts...");
		// Edge Case - Login while having empty fields.
		String actualErrorString = logPage.loginWithEpmtyFields();
		Assert.assertTrue(actualErrorString.contains(nopCommerceExpected.get("emptyLoginErrorMessage")));
		// Invalid Credentials Case
		String actualErrorMessage = logPage.loginWithInvalidCredentials(nopCommerce);
		Assert.assertTrue(actualErrorMessage.contains(nopCommerceExpected.get("invalidCredentialsErrorMessage")));
		// Valid Case
		Assert.assertTrue(logPage.userLoginWithValidCredentials(nopCommerce));
		System.out.println("Valid Credentials Test Successful...");
		
		// Check Is Login Successful
		Assert.assertEquals(logPage.isMyAccountDiaplayed(), "My account");
		System.out.println("Login Successful!!!  Now In Home Page Of Nop Commerce.");
		
	}
	
	@Test(priority=3)
	public void nopCommerceSubmodules() {
		NopCommerce_SubmodulesPage nopComSub = new NopCommerce_SubmodulesPage(driver);
		System.out.println("Nop Commerce Submodules Verification starts...");
		
		Assert.assertTrue(nopComSub.verifyNopCommerceSubmodules(), "Failed!!!...Nop-Commerce Submodule Verification.");
		System.out.println("Submodule Verification Successful...");
		
	}
	
	@Test(priority=4)
	public void checkSubmodulesOfElectronicsAreVisible() throws InterruptedException {
		 Electronics_Submodules electronics = new Electronics_Submodules(driver);
		 System.out.println("Electronics Submodule Test Started...");
		 Assert.assertTrue(electronics.clickOnElectronicsIfDisplayed(), "Error!!! Electronics Button Is Not Displayed.");
		 System.out.println("Electronics Button Displayed.");
		 Assert.assertTrue(electronics.electronicsSubmodulesPresent(), "False!!! Sub-Elements Of Electronics Not Displayed.");
	 }
	
	@Test(priority=5)
	public void verifyCellPhoneAndSelectPhone() throws InterruptedException {
		Map<String, String> nopCommerceExpected = new Excel_Integration().readExcelPOI(nopCommerceExcelPath, "Data");
		
		ElectronicsCellPhonePage cellPhone = new ElectronicsCellPhonePage(driver);
		System.out.println("Cell Phone Test Started...");
		Assert.assertEquals(cellPhone.clickOnElectronics(), nopCommerceExpected.get("expectedElectronicsPageURL"));
		Assert.assertEquals(cellPhone.clickOnCellPhonesImageAndCheckTheCurrentPageTitleURl(), nopCommerceExpected.get("cellPhonePageURL"));
		Assert.assertTrue(cellPhone.checkIfCellPhonesArePresent(), "No Cell Are Present.");
		Assert.assertTrue(cellPhone.selectRequiredCellPhoneForBuying(nopCommerceExpected), "Requied Cell Phone Not Found!!!");
		System.out.println("Pass..Cell Phone Found And Selected Successfully.");
	}
	
	@Test(priority=6)
	public void checkDescriptionSetQuantityAndAddressAddTocart() {
		Map<String, String> nopCommerceExpected = new Excel_Integration().readExcelPOI(nopCommerceExcelPath, "Data");
		
		RequiredCellphonePage samsungPhone = new RequiredCellphonePage(driver);
		System.out.println("Add To Cart Test Started...");
		Assert.assertTrue(samsungPhone.verifySamsungDescription(nopCommerceExpected));
		samsungPhone.getSamsungPhonePrice();
		Assert.assertTrue(samsungPhone.setShippingAddress(nopCommerceExpected), "Error!!!  Failed To Set Shipping Address.");
		Assert.assertTrue(samsungPhone.setQuantityAndAddToCart(nopCommerceExpected.get("quantityOfCellPhoneToOrder")));
		System.out.println("Test Successful... Phone Added To Cart");
	}
	
	@Test(priority=7)
	public void verifyShOppingCartTestCase() throws InterruptedException {
		ShoppingCartPage shoppingCart_Page = new ShoppingCartPage(driver);
		System.out.println("Verify Shopping Cart Test Case Started...");
		shoppingCart_Page.hoverOnShoppingCart();
		System.out.println("Verify Shopping Cart Test Case Completed Successfully...");
		
		
	}
	@Test(priority=8)
	public void verifyCheckoutProcessTestCase() throws InterruptedException {
		Map<String, String> checkoutDataMap = new Excel_Integration().readExcelPOI(nopCommerceExcelPath, "CheckoutData");
		CheckoutPage checkout_Page = new CheckoutPage(driver);
		System.out.println("Verify CheckOut Process Test Case Started...");
		checkout_Page.checkoutValidation();
		checkout_Page.billingAddresValidation(checkoutDataMap);
		System.out.println("Verify CheckOut Process Test Case Completed Successfully...");	
	}
	
}
