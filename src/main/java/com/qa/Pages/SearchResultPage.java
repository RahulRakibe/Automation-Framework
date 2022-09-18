package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Action.Action;
import com.qa.Base.TestBase;

public class SearchResultPage extends TestBase {
	Action act = new Action();

	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}

	// search result Text
	@FindBy(xpath = "//span[@class='_10Ermr']/span")
	private WebElement Search_Product_Result_Text;

	// Filters option
	@FindBy(xpath = "//span[text()='Filters']")
	private WebElement Filter;

	// Filters
	// Genter
	@FindBy(xpath = "//div[text()='Gender']")
	private WebElement Gender;

	// Men
	@FindBy(xpath = "//div[text()='Men' and @class='_3879cV']")
	private WebElement Men;

	// Select Min price
	@FindBy(xpath = "(//select[@class='_2YxCDZ'])[1]")
	private WebElement Min_Price;

	// Select Max price
	@FindBy(xpath = "(//select[@class='_2YxCDZ'])[2]")
	private WebElement Max_Price;

	// Select CUSTOMER RATINGS button
	@FindBy(xpath = "//div[text()='Customer Ratings']")
	private WebElement Customer_Ratings;

	// Max CUSTOMER RATING
	@FindBy(xpath = "//div[text()='4★ & above' and @class='_3879cV']")
	private WebElement Max_Rating;

	// First Product price
	@FindBy(xpath = "(//div[@class='_30jeq3 _1_WHN1'])[1]")
	private WebElement First_Product_Price;

	// First product rating
	@FindBy(xpath = "(//div[@class='_3LWZlK'])[1]")
	private WebElement First_Product_Rating;

	// Random product displayed on Serch Result Page
	@FindBy(xpath = "((//div[@class='_13oc-S'])[1]//following::div)[1]")
	WebElement Product_Displayed;

	// ==========================================================================

	// product search result Text
	public String product_Result_Text() throws InterruptedException {
		Thread.sleep(1000);
		String Text = Search_Product_Result_Text.getText();
		return Text;
	}

	// Get Text From Filter Option
	public String filters() {
		String text = Filter.getText();
		return text;
	}

	// Select Gende for apply filter
	public void select_gender() {
		act.click(driver, Gender);
		act.click(driver, Men);
	}

	// select max rating
	public void select_Rating() throws InterruptedException {
		Thread.sleep(1000);
		act.scrollUpToElement(driver, Max_Rating);
		act.click(driver, Max_Rating);
	}

	// Select price
	public void select_Price() throws InterruptedException {
		Thread.sleep(1000);
		act.selectByIndex(Min_Price, 1);
		act.selectByIndex(Max_Price, 6);
	}

	// click on Random product displayed on Serch result page
	public ProductSpecificationPage click_ON_Product_Displayed() {
		act.click(driver, Product_Displayed);
		return new ProductSpecificationPage();
	}

}
