package com.qa.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Action.Action;
import com.qa.Base.TestBase;

public class CartPage extends TestBase {
	Action act = new Action();

	public CartPage() {
		PageFactory.initElements(driver, this);
	}

	// cart product name
	@FindAll(value = { @FindBy(xpath = "//a[@class='_2Kn22P gBNbID']") })
	List<WebElement> Cart_Products_Names;

	// cart producct quantity
	@FindAll(value = { @FindBy(xpath = "(//input[@class='_253qQJ'])[1]") })
	WebElement Cart_Products_Quantity;

	// increase(+) Quantity button
	@FindBy(xpath = "(//button[@class='_23FHuj' and text()='+'])[1]")
	WebElement increase_Quantity_Button;

	// individual price of all cart products
	@FindAll(value = { @FindBy(xpath = "//span[@class='_2-ut7f _1WpvJ7']") })
	List<WebElement> Price_of_cart_products;

	// Delivery Charges
	@FindBy(xpath = "//div[@class='_2npqm0' and text()='Delivery Charges']/following::span")
	WebElement Delivery_Charges;

	// Secured Packaging Fee
	@FindBy(xpath = "//div[@class='_2npqm0' and text()='Secured Packaging Fee']/following::span")
	WebElement Secured_Packaging_Fee;

	// Total Amount of
	@FindBy(xpath = "//div[@class='_2npqm0' and text()='Total Amount']/following::span")
	WebElement Total_Amount;

	// Remove Button
	@FindBy(xpath = "(//div[text()='Remove'])[1]")
	WebElement Remove_Button;

	// confirm Remove Button
	@FindBy(xpath = "//div[@class='_3dsJAO _24d-qY FhkMJZ' and text()='Remove']")
	WebElement Confirm_Remove_Button;

	// your cart is empty msg
	@FindBy(xpath = "//div[@class='_1LCJ1U']")
	WebElement Your_Cart_Is_Empty;

	// Successfull product is removed
	@FindBy(xpath = "//div[@class='_2sKwjB']")
	WebElement Successfully_Product_Remove_Message;

	// Place order button
	@FindBy(xpath = "//button[@class='_2KpZ6l _2ObVJD _3AWRsL']")
	WebElement Place_Order_Button;

//=====================================================================================

	// all cart product name
	public List<WebElement> cart_Products_Name() {
		return Cart_Products_Names;
	}

	// get product quantity
	public String product_Quantity() throws InterruptedException {
		String product_quantity = Cart_Products_Quantity.getAttribute("value");
		return product_quantity;
	}

	// click on increase Quantity button
	public void increase_Quantity() throws InterruptedException {
		act.jsClick(driver, increase_Quantity_Button);
		Thread.sleep(1000);
	}

	// get price of all cart product
	public int price_of_All_cart_Product() {
		int num = 0;
		for (int i = 0; i < Price_of_cart_products.size(); i++) {
			String sprice = Price_of_cart_products.get(i).getText().replaceAll("₹", "").replaceAll(",", "");
			Integer price = Integer.valueOf(sprice);
			num = num + price;
		}
		return num;
	}

	// Delivery Charges
	public int get_Delivery_Charges() {
		int intdelivery_charges = 0;

		if (!Delivery_Charges.getText().equalsIgnoreCase("Free")) {
			String deliverycharges = Delivery_Charges.getText().replaceAll("₹", "").replaceAll(",", "");
			intdelivery_charges = Integer.valueOf(deliverycharges);

		} else {

		}
		return intdelivery_charges;

	}

	// Secured Packaging Fees
	public int secured_Packaging_Fee() {
		int SecuredPackagingFee = 0;
		try {
			if (Secured_Packaging_Fee.isDisplayed()) {
				String secured_Packaging_Fee = Secured_Packaging_Fee.getText().replaceAll("₹", "").replaceAll(",", "");
				SecuredPackagingFee = Integer.valueOf(secured_Packaging_Fee);
			}
		} catch (Exception e) {

		}

		return SecuredPackagingFee;
	}

	// Total amount
	public int get_Total_Amount() {
		String total_amount = Total_Amount.getText().replaceAll("₹", "").replaceAll(",", "");
		int Totalamount = Integer.valueOf(total_amount);
		return Totalamount;
	}

	// remove product from cart
	public void remove_Product_From_Cart() throws InterruptedException {

		act.jsClick(driver, Remove_Button);
		act.jsClick(driver, Confirm_Remove_Button);
	}

	// successfully_Product_remove_Message
	public boolean successfully_Product_remove_Message() throws InterruptedException {
		Thread.sleep(1000);
		boolean Successfully_Product_Remove_Message_isDisplayed = Successfully_Product_Remove_Message.isDisplayed();
		return Successfully_Product_Remove_Message_isDisplayed;
	}

	public CheckoutAndPaymentsPage click_On_Place_Order_Button() {
		act.scrollUpToElement(driver, Place_Order_Button);
		act.click(driver, Place_Order_Button);
		return new CheckoutAndPaymentsPage();
	}

}
