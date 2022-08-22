package com.qa.Test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.Base.TestBase;
import com.qa.DataProvider.DataProviders;
import com.qa.Pages.HomePage;
import com.qa.Pages.ProductSpecificationPage;
import com.qa.Pages.SearchResultPage;
import com.qa.Utility.RetryAnalyzer;

public class HomePageTest extends TestBase {

	DataProviders dp = new DataProviders();
	String username = dp.getusername();
	String pass = dp.getPassword();
	String Account_Holder_Name = dp.getAccount_Holder_Name();
	String product_Name = dp.product_Name_For_Search();
	HomePage homepage;
	SearchResultPage searchResultPage;
	ProductSpecificationPage productSpecificationPage;

	// TC001::Verify that user should login with correct user name and password
	@Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
	public void TC001_verify_That_User_Should_Login_With_Correct_User_Name_and_Password() throws InterruptedException {
		SoftAssert sassert = new SoftAssert();
		homepage = new HomePage();
		// Enter email/mobile number
		homepage.enter_Email_Mobile_number_TextBox(username);
		// Enter password
		homepage.enter_Password_Text_Box(pass);
		// Click on Login
		homepage.click_on_Login_Button();
		// verify Account holder name
		String name = homepage.get_Account_Holder_Name();
		boolean result = Account_Holder_Name.contains(name);
		sassert.assertTrue(result);
		sassert.assertAll();

	}

	// TC002::Verify that home page is displayed after Sign-In or not.
	@Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
	public void TC002_Verify_That_Home_Page_Is_Displayed_After_LogIn() throws Exception {
		SoftAssert sassert = new SoftAssert();
		homepage = new HomePage();
		// Enter email/mobile number
		homepage.enter_Email_Mobile_number_TextBox(username);
		// Enter password
		homepage.enter_Password_Text_Box(pass);
		// Click on Login
		homepage.click_on_Login_Button();
		// User should be able to click on login button and home page should displayed
		String actual_HomePage_Title = homepage.getTitle_Of_HomePage();
		String expected_Homepage_title = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		sassert.assertEquals(actual_HomePage_Title, expected_Homepage_title);
		sassert.assertAll();

	}

	// TC003::Verify that logo is displayed on home page or not
	@Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
	public void TC003_verify_That_Logo_is_Displayed() throws InterruptedException {
		SoftAssert sassert = new SoftAssert();
		homepage = new HomePage();
		homepage.enter_Email_Mobile_number_TextBox(username);
		homepage.enter_Password_Text_Box(pass);
		homepage.click_on_Login_Button();
		boolean result = homepage.homePage_Logo_isDesplyed();
		sassert.assertTrue(result);
		sassert.assertAll();
	}

	// TC005::Verify that user able to serch product
	@Test(priority = 04, retryAnalyzer = RetryAnalyzer.class)
	public void TC005_verify_That_User_Able_To_Serch_product() throws Exception {
		SoftAssert sassert = new SoftAssert();
		homepage = new HomePage();
		homepage.enter_Email_Mobile_number_TextBox(username);
		homepage.enter_Password_Text_Box(pass);
		homepage.click_on_Login_Button();

		searchResultPage = homepage.search_Product(product_Name);

		String ActualText = searchResultPage.product_Result_Text();
		sassert.assertEquals(ActualText, product_Name);
		sassert.assertAll();
	}

}
