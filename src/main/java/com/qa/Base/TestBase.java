package com.qa.Base;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.qa.DataProvider.DataProviders;

public class TestBase
{
	//public static ThreadLocal<RemoteWebDriver> driver1 = new ThreadLocal<>();
	public static  WebDriver driver;
	
	DataProviders dp=new DataProviders();
	//Launch Browser
	@SuppressWarnings("deprecation")
	


	//@Parameters("browser")
	@BeforeMethod	
	public void setUp()
	  {
		   String url=dp.getUrl();
		   
       //  if(browser.equalsIgnoreCase("chrome"))
         System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\eclipse-workspace\\AutomationFramework\\Chromedriver\\chromedriver.exe");
	      driver=new ChromeDriver();		  
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		  driver.get(url);
		  
		  
		   
		//if (browser.equalsIgnoreCase("edge"))
	    // {				
		/*  System.setProperty("webdriver.edge.driver","C:\\Users\\User\\eclipse-workspace\\AutomationFramework\\Chromedriver\\msedgedriver.exe");
		  
			driver=new EdgeDriver();
		    driver.manage().window().maximize();
		    driver.manage().deleteAllCookies();
		   // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  
		    driver.get(url);*/
          // }
		
	/*if(browser.equalsIgnoreCase("firefox"))
	     {				
		    System.setProperty("webdriver.gecko.driver","C:\Users\User\eclipse-workspace\AutomationFramework\Chromedriver\geckodriver.exe");		  
			driver=new FirefoxDriver();
		    driver.manage().window().maximize();
		    driver.manage().deleteAllCookies();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  
		    driver.get(url);
          }*/
		 		
	  }
	//tear down Browser
	@AfterMethod
	  public void close()
	  {
		 //driver.close();
		 driver.quit();
	  }

}
