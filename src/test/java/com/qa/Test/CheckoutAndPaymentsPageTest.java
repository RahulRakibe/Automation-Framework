package com.qa.Test;

import java.util.ArrayList;
import java.util.LinkedList;
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

public class CheckoutAndPaymentsPageTest extends TestBase {
	DataProviders dp = new DataProviders();
	String username = dp.getusername();
	String pass = dp.getPassword();
	String Account_Holder_Name = dp.getAccount_Holder_Name();
	String product_Name = dp.product_Name_For_Search();

	// TC001::Verify that Valid account holder name should displyed under login
	@Test
	public void TC001_verify_That_Valid_Account_Holder_Name_Displyed_Under_Login() throws Exception {
		SoftAssert sassert = new SoftAssert();
		HomePage homepage = new HomePage();
		SearchResultPage searchResultPage = new SearchResultPage();
		ProductSpecificationPage productSpecificationPage = new ProductSpecificationPage();
		CartPage cartPage = new CartPage();
		CheckoutAndPaymentsPage checkoutAndPaymentsPage = new CheckoutAndPaymentsPage();
		homepage.enter_Email_Mobile_number_TextBox(username);
		homepage.enter_Password_Text_Box(pass);
		homepage.click_on_Login_Button();
		homepage.search_Product(product_Name);
		searchResultPage.click_ON_Product_Displayed();
		productSpecificationPage.click_On_Go_To_Cart_Button();
		productSpecificationPage.click_On_cart_Button();
		cartPage.click_On_Place_Order_Button();
		String actual_account_Holder_Name = checkoutAndPaymentsPage.account_Holder_Name();

		sassert.assertEquals(actual_account_Holder_Name, Account_Holder_Name);
		sassert.assertAll();
	}

	// TC002::Verify that delivery address details should be displayed at checkout
	// and user able to select one delivery address\
	@Test
	public void TC002_verify_That_Delivery_Address_Details_Should_Be_Displayed_And_User_Able_To_Select_One_Delivery_Address()
			throws Exception {
		SoftAssert sassert = new SoftAssert();
		HomePage homepage = new HomePage();
		SearchResultPage searchResultPage = new SearchResultPage();
		ProductSpecificationPage productSpecificationPage = new ProductSpecificationPage();
		CartPage cartPage = new CartPage();
		CheckoutAndPaymentsPage checkoutAndPaymentsPage = new CheckoutAndPaymentsPage();
		homepage.enter_Email_Mobile_number_TextBox(username);
		homepage.enter_Password_Text_Box(pass);
		homepage.click_on_Login_Button();
		homepage.search_Product(product_Name);
		searchResultPage.click_ON_Product_Displayed();
		productSpecificationPage.click_On_Go_To_Cart_Button();
		productSpecificationPage.click_On_cart_Button();
		cartPage.click_On_Place_Order_Button();
		boolean result = checkoutAndPaymentsPage.delivery_Address_isDisplayed();
		sassert.assertTrue(result);
		sassert.assertAll();

	}

	// TC003::Verify that order summary having same product wich available in cart
	// page
	@Test
	public void TC003_Verify_That_Order_Summary_Having_Same_Product_Wich_Available_In_Cart_Page() throws Exception {
		SoftAssert sassert = new SoftAssert();
		HomePage homepage = new HomePage();
		SearchResultPage searchResultPage = new SearchResultPage();
		ProductSpecificationPage productSpecificationPage = new ProductSpecificationPage();
		CartPage cartPage = new CartPage();
		CheckoutAndPaymentsPage checkoutAndPaymentsPage = new CheckoutAndPaymentsPage();
		homepage.enter_Email_Mobile_number_TextBox(username);
		homepage.enter_Password_Text_Box(pass);
		homepage.click_on_Login_Button();
		homepage.search_Product(product_Name);
		searchResultPage.click_ON_Product_Displayed();
		productSpecificationPage.click_On_Go_To_Cart_Button();
		productSpecificationPage.click_On_cart_Button();

		List<WebElement> All_cart_product_names_name = cartPage.cart_Products_Name();
		LinkedList<String> list1 = new LinkedList<>();
		for (WebElement cart_Product_name : All_cart_product_names_name) {
			String cpname = cart_Product_name.getText();
			list1.add(cpname);
		}
		System.out.println(list1);

		cartPage.click_On_Place_Order_Button();
		checkoutAndPaymentsPage.delivery_Address_isDisplayed();
		List<WebElement> All_product_Names_In_Orser_Summary = checkoutAndPaymentsPage
				.get_All_product_Names_In_Orser_Summary();

		for (WebElement name : All_product_Names_In_Orser_Summary) {
			String pname = name.getText();
			sassert.assertTrue(list1.contains(pname));
		}
		checkoutAndPaymentsPage.click_On_Continue_Button();
		sassert.assertAll();
	}
}
