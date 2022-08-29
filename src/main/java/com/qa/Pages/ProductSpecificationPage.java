package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Action.Action;
import com.qa.Base.TestBase;

public class ProductSpecificationPage extends TestBase
{
    Action act=new Action();
	
	public ProductSpecificationPage()
	{
		PageFactory.initElements(driver,this);
		act.switchToWindow(driver);
	}
	
	//Product Image
	@FindBy(xpath="((//div[@class='_1YokD2 _2GoDe3'])[1]//div[@class='_3kidJX']//img)[1]")
	WebElement Product_Image;

	//Specification Text  or Product Details
	@FindBy(xpath="//div[@class='_1AtVbE col-12-12']//div[text()='Specifications' or text()='Product Details']")
	WebElement Specifications;
	
	// First product name 
	@FindBy(xpath="//span[@class='B_NuCI']")
	public WebElement First_Product_Name;
	
	//go to cart buutton
	@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	WebElement Go_TO_Cart_Button;
	
	//Buy Now
	@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA ihZ75k _3AWRsL']")
	WebElement Buy_Now;
	
	//Product is now out of stock massage
	@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	WebElement Product_Is_Out_Of_Stock_Msg;
	
	
	//cart button
	@FindBy(xpath="//span[text()='Cart']")
	WebElement cart_Button;
	
	//Size of product
	@FindBy(xpath="//span[@id='Size']")	
	WebElement Size_Of_Product;
	
	//Select Size
	@FindBy(xpath="//span[@id='Size']/following::li[3]")
	WebElement Select_Size;
		

//===============================================================
	
	//Get Title of ProductSpecificationPage
	public String getTitle_Of_ProductSpecificationPage() 
	   {	
		   
		   String ProductSpecificationPag_Title=driver.getTitle();
		   return ProductSpecificationPag_Title;
	   }
	//get text from Sprcification on Product Specification Page or Product Details
	public boolean specification()
	{

		boolean result=Specifications.isDisplayed();	
		return result;		
	}
	public String get_First_Product_Name()
	{
		act.switchToWindow(driver);
		String first_product_name=First_Product_Name.getText();
		return first_product_name;
	}
	//product image is displayaed
	public boolean Product_Image_IsDisplayaed()
	{
	
		boolean result=Product_Image.isDisplayed();
		return result;
	}
	
	//Similar products of product
	public CartPage click_On_Go_To_Cart_Button() 
	{	
		try
		{
		if(Size_Of_Product.isDisplayed())
		{			
			Select_Size.click();		 		   
	        act.scrollUpToElement(driver, Go_TO_Cart_Button);
	        Go_TO_Cart_Button.click();	 
		}
		}
		
		catch(Exception e)
		{	
		        act.scrollUpToElement(driver, Go_TO_Cart_Button);
				act.click(driver, Go_TO_Cart_Button);
		}		
		return new CartPage();
	}
	
	//Buy Now
	public CheckoutAndPaymentsPage Buy_Now() 
	{	
		try
		{
		if(Size_Of_Product.isDisplayed())
		{		
			
			Select_Size.click();
			Thread.sleep(2000);
	        act.scrollUpToElement(driver, Buy_Now);
	        Buy_Now.click();	 
		}
		}
		
		catch(Exception e)
		{	
		        act.scrollUpToElement(driver, Buy_Now);
				act.click(driver, Buy_Now);
		}
		
		return new CheckoutAndPaymentsPage();
	}
		
	
	//product is out of stock msg
	public boolean product_Is_Out_Of_Stock_Msg()
	{
		boolean result = Product_Is_Out_Of_Stock_Msg.isDisplayed();
		return result;
	}
	
	//click on cart button
	
	public CartPage click_On_cart_Button()
	{
		try{
			act.click(driver, cart_Button);
			}
		catch(Exception e)
		{
		}
		return new CartPage(); 	
	}
	
	
	
	
	
}
