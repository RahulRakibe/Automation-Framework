package com.qa.Test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.Base.TestBase;
import com.qa.DataProvider.DataProviders;
import com.qa.Pages.CartPage;
import com.qa.Pages.CheckoutAndPaymentsPage;
import com.qa.Pages.HomePage;
import com.qa.Pages.ProductSpecificationPage;
import com.qa.Pages.SearchResultPage;
import com.qa.Utility.RetryAnalyzer;

public class ProductSpecificationPageTest extends TestBase {

	DataProviders dp = new DataProviders();
	String username = dp.getusername();
	String pass = dp.getPassword();
	String Account_Holder_Name = dp.getAccount_Holder_Name();
	String product_Name = dp.product_Name_For_Search();
	HomePage homepage;
	SearchResultPage searchResultPage;
	ProductSpecificationPage productSpecificationPage;
	CartPage cartPage;

	// TC001::Verify that images of product are displayed correctly.
	@Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
	public void TC001_verify_That_Images_Of_Product_Are_Displayed_Correctly() throws Exception {
		SoftAssert sassert = new SoftAssert();
		homepage = new HomePage();
		searchResultPage = new SearchResultPage();
		productSpecificationPage = new ProductSpecificationPage();
		homepage.enter_Email_Mobile_number_TextBox(username);
		homepage.enter_Password_Text_Box(pass);
		homepage.click_on_Login_Button();
		homepage.search_Product(product_Name);
		searchResultPage.click_ON_Product_Displayed();
		boolean result = productSpecificationPage.Product_Image_IsDisplayaed();
		sassert.assertTrue(result);
		sassert.assertAll();
	}

	// TC007::Verify that when user clicks on add to cart, the product should be
	// added to cart
	@SuppressWarnings("unlikely-arg-type")
	@Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
	public void TC007_Verify_That_When_User_Clicks_On_Go_To_Cart_The_Product_Should_Be_Add_Into_Cart()
			throws Exception {
		SoftAssert sassert = new SoftAssert();
		homepage = new HomePage();
		searchResultPage = new SearchResultPage();
		cartPage = new CartPage();
		productSpecificationPage = new ProductSpecificationPage();
		homepage.enter_Email_Mobile_number_TextBox(username);
		homepage.enter_Password_Text_Box(pass);
		homepage.click_on_Login_Button();
		homepage.search_Product(product_Name);
		searchResultPage.click_ON_Product_Displayed();
		String first_product_name = productSpecificationPage.get_First_Product_Name();
		productSpecificationPage.click_On_Go_To_Cart_Button();

		List<WebElement> All_cart_product_names_name = cartPage.cart_Products_Name();
		for (WebElement name : All_cart_product_names_name) {
			String product_name = name.getText();
			if (product_name.equals(first_product_name)) {
				sassert.assertTrue(true);
			}
		}
		sassert.assertAll();
	}

	// TC008::Verify that when user clicks on Buy Now button user should land on
	// Check and Payments Page.
	@Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
	public void TC008_verify_That_When_User_Clicks_On_Buy_Now_button_Then_User_Land_On_Checkout_And_Payments_Page()
			throws Exception {
		SoftAssert sassert = new SoftAssert();
		homepage = new HomePage();
		searchResultPage = new SearchResultPage();
		cartPage = new CartPage();
		productSpecificationPage = new ProductSpecificationPage();
		CheckoutAndPaymentsPage checkoutAndPaymentsPage = new CheckoutAndPaymentsPage();
		homepage.enter_Email_Mobile_number_TextBox(username);
		homepage.enter_Password_Text_Box(pass);
		homepage.click_on_Login_Button();
		homepage.search_Product(product_Name);
		searchResultPage.click_ON_Product_Displayed();
		productSpecificationPage.Buy_Now();

		String Title = checkoutAndPaymentsPage.getTitle();
		String expected_page_title = "Flipkart.com: Secure Payment: Login > Select Shipping Address > Review Order > Place Order";
		sassert.assertEquals(Title, expected_page_title);
		sassert.assertAll();
	}
}
