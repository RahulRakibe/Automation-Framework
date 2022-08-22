package com.qa.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Action.Action;
import com.qa.Base.TestBase;

public class CheckoutAndPaymentsPage extends TestBase {
	Action act = new Action();

	public CheckoutAndPaymentsPage() {
		PageFactory.initElements(driver, this);
	}

	// Account holder name displayed under under Login
	@FindBy(xpath = "//span[@class='npYOZI']")
	WebElement Account_Holder_Name;

	// Delivery Address is Displayed
	@FindBy(xpath = "//span[@class='rPNEXT Br27Zz']")
	WebElement Delivery_Address;

	// Select Delivery Address
	@FindBy(xpath = "//input[@class='_3DAmyP']")
	WebElement Select_Delivery_Address;

	// Delivere Here Button
	@FindBy(xpath = "//button[@class='_2KpZ6l RLM7ES _3AWRsL']")
	WebElement Delivere_Here_Button;

	// all product names products in Order Summary
	@FindAll(value = { @FindBy(xpath = "//span[text()='Order Summary']//following::div[@class='_2Kn22P']") })
	List<WebElement> All_product_Names_In_Orser_Summary;

	// CONTINUE Button
	@FindBy(xpath = "//button[@class='_2KpZ6l _1seccl _3AWRsL']")
	WebElement Continue_Button;

//====================================================================
	// Get Title of Page
	public String getTitle() {
	
		String Title = driver.getTitle();
		return Title;
	}

	// get Account Holder name displayed under Login
	public String account_Holder_Name() {
		String account_holder_name = Account_Holder_Name.getText();
		return account_holder_name;
	}

	public boolean delivery_Address_isDisplayed() {
		boolean displayed = Delivery_Address.isDisplayed();
		if (displayed) {
			act.click(driver, Select_Delivery_Address);
			act.click(driver, Delivere_Here_Button);
			return displayed;
		} else {
			System.out.println("Address is Not Available please add New Delivery Addres");
		}
		return displayed;
	}

	public List<WebElement> get_All_product_Names_In_Orser_Summary() {
		return All_product_Names_In_Orser_Summary;
	}

	public void click_On_Continue_Button() {
		act.click(driver, Continue_Button);
	}
}
