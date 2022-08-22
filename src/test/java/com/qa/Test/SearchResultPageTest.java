package com.qa.Test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.Base.TestBase;
import com.qa.DataProvider.DataProviders;
import com.qa.Pages.HomePage;
import com.qa.Pages.ProductSpecificationPage;
import com.qa.Pages.SearchResultPage;
import com.qa.Utility.RetryAnalyzer;

public class SearchResultPageTest extends TestBase {

	DataProviders dp = new DataProviders();
	String username = dp.getusername();
	String pass = dp.getPassword();
	String Account_Holder_Name = dp.getAccount_Holder_Name();
	String product_Name = dp.product_Name_For_Search();
	HomePage homepage;
	SearchResultPage searchResultPage;
	ProductSpecificationPage productSpecificationPage;

	// TC005::Verify that Filters options should be present on search results page.
	@Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
	public void verify_That_Filters_Options_Should_Be_Present_On_Search_Results_Page() throws Exception {
		SoftAssert sassert = new SoftAssert();
		homepage = new HomePage();
		searchResultPage = new SearchResultPage();
		// Enter email/mobile number
		homepage.enter_Email_Mobile_number_TextBox(username);
		// Enter password
		homepage.enter_Password_Text_Box(pass);
		// Click on Login
		homepage.click_on_Login_Button();
		homepage.search_Product(product_Name);

		String ActualText = searchResultPage.filters();
		String expectedText = "Filters";
		sassert.assertEquals(ActualText, expectedText);
		sassert.assertAll();
	}

	// TC006::Verify that user able to apply Filters on serch product
	@Test(priority = 2)
	public void TC00_verify_That_User_Able_to_Apply_Filters_on_Serch_Product() throws Exception {
		SoftAssert sassert = new SoftAssert();
		homepage = new HomePage();
		searchResultPage = new SearchResultPage();
		// Enter email/mobile number
		homepage.enter_Email_Mobile_number_TextBox(username);
		// Enter password
		homepage.enter_Password_Text_Box(pass);
		// Click on Login
		homepage.click_on_Login_Button();
		homepage.search_Product(product_Name);
		searchResultPage.select_Rating();
		searchResultPage.select_Price();

	}

	// TC009::Verify that when user clicks on any product, user should be redirected
	// to product specification page.
	@Test(priority = 03, retryAnalyzer = RetryAnalyzer.class)
	public void TC009_verify_That_When_User_Clicks_On_Any_Product_User_Should_Be_Redirected_To_Product_Specification_Page()
			throws Exception {
		SoftAssert sassert = new SoftAssert();
		homepage = new HomePage();
		searchResultPage = new SearchResultPage();
		productSpecificationPage = new ProductSpecificationPage();
		homepage.enter_Email_Mobile_number_TextBox(username);
		homepage.enter_Password_Text_Box(pass);
		homepage.click_on_Login_Button();
		homepage.search_Product(product_Name);
		searchResultPage.click_ON_Product_Displayed();
		boolean result = productSpecificationPage.specification();
		sassert.assertTrue(result);
		sassert.assertAll();
	}
}
