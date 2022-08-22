package com.qa.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Action.Action;
import com.qa.Base.TestBase;

public class HomePage extends TestBase {
	Action act = new Action();

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
//===============================================================

	// Locate Elements On HomePage

	// 1.Enter Email/Mobile number Input Box
	@FindBy(xpath = "//input[@class='_2IX_2- VJZDxU']")
	WebElement Enter_Email_Mobile_number_InputBox;

	// 2.Enter Password Text Box
	@FindBy(xpath = "//input[@class='_2IX_2- _3mctLh VJZDxU']")
	WebElement Enter_Password_InputBox;

	// 3.Login button
	@FindBy(xpath = "//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	WebElement Login_Button;

	// 4.Account holder name
	@FindBy(xpath = "(//div[@class='exehdJ'])[1]")
	WebElement Account_Holder_Name;

	// 5.HomePage Logo
	@FindBy(xpath = "//img[@class='_2xm1JU']")
	WebElement HomePage_Logo;

	// 6.Serch Tab
	@FindBy(xpath = "//input[@class='_3704LK']")
	WebElement Search_Tab;

	// 6.Serch button
	@FindBy(xpath = "//button[@class='L0Z3Pu']")
	WebElement Search_Button;

	// Random product displayed on homepage
	@FindBy(xpath = "(//a[@class='s1Q9rs'])[1]")
	WebElement Product_Displayed_On_HomePage;

//===============================================================
	// Perform Action on WebElements

	// Enter_Email_Mobile_number_TextBox
	public void enter_Email_Mobile_number_TextBox(String username) {
		act.text(Enter_Email_Mobile_number_InputBox, username);
	}

	// Enter Password Text Box
	public void enter_Password_Text_Box(String pass) {
		act.text(Enter_Password_InputBox, pass);
	}

	// Login button
	public void click_on_Login_Button() {
		act.click(driver, Login_Button);
	}

	// get Account holder name from Account section
	public String get_Account_Holder_Name() throws InterruptedException {
		Thread.sleep(1000);
		String name = Account_Holder_Name.getText();
		return name;
	}

	// Get Title of HomePage
	public String getTitle_Of_HomePage() throws Exception {
		String actual_HomePage_Title = driver.getTitle();
		return actual_HomePage_Title;
	}

	// Logo is displayed
	public boolean homePage_Logo_isDesplyed() throws InterruptedException {
		Thread.sleep(1000);
		boolean logo = HomePage_Logo.isDisplayed();
		return logo;
	}

	// Serch product
	public SearchResultPage search_Product(String productname) throws Exception {
		Thread.sleep(1000);
		act.text(Search_Tab, productname);
		act.click(driver, Search_Button);
		return new SearchResultPage();
	}

	public String get_Text_From_Product() throws Exception {
		Thread.sleep(1000);
		act.scrollPage(driver, "window.scrollBy(0,366)");
		String productDescription = Product_Displayed_On_HomePage.getText();
		return productDescription;
	}
}