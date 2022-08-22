package com.qa.Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.Action.Action;


public class Listnerclass  implements  ITestListener {
	public static ExtentSparkReporter  htmlReporter;
	public static ExtentReports reports;
	public static ExtentTest test;	
	Action act=new Action();
	
	public static void setExtent() throws IOException {
		
		
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "MY Automation Report " + timestamp + ".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//ExtentReport//" + reportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//add system information/environment info to reports
		reports.setSystemInfo("Machine:", "MyTest");
		reports.setSystemInfo("OS", "windows 10");
		reports.setSystemInfo("browser:", "Edge");
		reports.setSystemInfo("user name:", "Rahul");
		
		//configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("Extent Report");
		htmlReporter.config().setReportName("Chrome Browser Report");
		htmlReporter.config().setTheme(Theme.DARK);	
}

//OnStart method is called when any Test starts
public void onStart(ITestContext Result)					
{		
	try {
		setExtent();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("On Start method invoked....");  		
}	

//onFinish method is called after all Tests are executed
public void onFinish(ITestContext Result) 					
{		
	System.out.println("On Finished method invoked....");  	
	reports.flush();
}		
	
//When Test case get failed, this method is called.		

	public void onTestFailure(ITestResult Result) 					
	{		
		act.screenShot(Result.getName());
		System.out.println("Name of test method failed:" + Result.getName() );  		
		test = reports.createTest(Result.getName());//create entry in html report
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName() ,ExtentColor.RED));
	
	String screenShotPath = System.getProperty("user.dir") + "\\ScreenShots\\" + Result.getName() + ".png";
	
	File screenShotFile = new File(screenShotPath);
	
	if(screenShotFile.exists())
	{
		test.fail("Captured Screenshot is below:" + test.addScreenCaptureFromPath(screenShotPath));
		
	}
	}
	// When Test case get Skipped, this method is called.		

		public void onTestSkipped(ITestResult Result)					
		{		
			System.out.println("Name of test method skipped:" + Result.getName() );  		

			test = reports.createTest(Result.getName());
			test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test case is: " + Result.getName() ,ExtentColor.YELLOW));
		}			

		// When Test case get Started, this method is called.		

		public void onTestStart(ITestResult Result)					
		{		
			System.out.println("Name of test method started:" + Result.getName() );  		

		}		

		// When Test case get passed, this method is called.		

		public void onTestSuccess(ITestResult Result)					
		{		
			System.out.println("Name of test method sucessfully executed:" + Result.getName() );  		

			test = reports.createTest(Result.getName());
			test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is: " + Result.getName() ,ExtentColor.GREEN));
		}				
	}		

