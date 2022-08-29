package com.qa.Test;

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

public class CartPageTest extends TestBase {
	DataProviders dp = new DataProviders();
	String username = dp.getusername();
	String pass = dp.getPassword();
	String Account_Holder_Name = dp.getAccount_Holder_Name();
	String product_Name = dp.product_Name_For_Search();
	HomePage homepage;
	SearchResultPage searchResultPage;
	ProductSpecificationPage productSpecificationPage;
	CartPage cartPage;
	CheckoutAndPaymentsPage checkoutAndPaymentsPage;

	// TC001::Verify that item quantity should be increased if user click on
	// increase button(+)
	@Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
	public void TC001_verify_That_Item_Quantity_Should_Be_Increased_If_user_click_On_Increase_Button()
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
		productSpecificationPage.click_On_cart_Button();
		String product_quantity = cartPage.product_Quantity();
		Integer current_product_quantity = Integer.valueOf(product_quantity);
		Integer Expected_product_quantity = current_product_quantity + 1;
		cartPage.increase_Quantity();
		String product_quantity_after_increased = cartPage.product_Quantity();
		Integer actual_Product_Quantity_after_increased = Integer.valueOf(product_quantity_after_increased);
		sassert.assertEquals(actual_Product_Quantity_after_increased, Expected_product_quantity);
		sassert.assertAll();
	}

	// TC002::Verify that total amount of all items should be displayed to user.
	@Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
	public void TC002_verify_That_Total_Amount_Of_All_Items_Should_Be_displayed_to_user() throws Exception {
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
		productSpecificationPage.click_On_Go_To_Cart_Button();
		// productSpecificationPage.click_On_cart_Button();
		int Totalprice = cartPage.price_of_All_cart_Product();
		int deliverycharges = cartPage.get_Delivery_Charges();
		int SecuredPackagingFee = cartPage.secured_Packaging_Fee();
		int Expected_Tota_Amount = Totalprice + deliverycharges + SecuredPackagingFee;
		int Actual_Total_Amount = cartPage.get_Total_Amount();
		sassert.assertEquals(Actual_Total_Amount, Expected_Tota_Amount);
	}

	// TC005::Verify that when user clicks on remove button the item should be
	// removed from cart
	@Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
	public void TC005_verify_That_When_User_Clicks_On_Remove_Button_The_Item_Should_Be_Removed_From_Cart()
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

		productSpecificationPage.click_On_Go_To_Cart_Button();
		productSpecificationPage.click_On_cart_Button();

		cartPage.remove_Product_From_Cart();
		boolean Successfully_Product_Remove_Message_isDisplayed = cartPage.successfully_Product_remove_Message();

		sassert.assertTrue(Successfully_Product_Remove_Message_isDisplayed);
		sassert.assertAll();
	}

	// TC007::Verify that user should able to ckick on Place Order button and
	// redirect on Checkout&Payments Page
	@Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
	public void TC007_verify_That_User_Should_Able_To_Ckick_On_Place_Order_Button_And_Redirect_On_Checkout_And_Payments_Page()
			throws Exception {
		SoftAssert sassert = new SoftAssert();
		homepage = new HomePage();
		searchResultPage = new SearchResultPage();
		cartPage = new CartPage();
		productSpecificationPage = new ProductSpecificationPage();
		checkoutAndPaymentsPage = new CheckoutAndPaymentsPage();
		homepage.enter_Email_Mobile_number_TextBox(username);
		homepage.enter_Password_Text_Box(pass);
		homepage.click_on_Login_Button();
		homepage.search_Product(product_Name);
		searchResultPage.click_ON_Product_Displayed();

		productSpecificationPage.click_On_Go_To_Cart_Button();
		productSpecificationPage.click_On_cart_Button();

		cartPage.click_On_Place_Order_Button();
		String actual_page_title = checkoutAndPaymentsPage.getTitle();
		String expected_page_title = "Flipkart.com: Secure Payment: Login > Select Shipping Address > Review Order > Place Order";
		sassert.assertEquals(actual_page_title, expected_page_title);
		sassert.assertAll();

	}

}
