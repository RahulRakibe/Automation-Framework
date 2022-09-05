#**Automation Framework**
**_____________________________________________________________________**
##Introduction
###A sample framework based on Page Object Model, Selenium, TestNG using Java Programming language . This framework is based in Page Object Model design pattern (POM).
I have use the Flipkart website for the sample test scripts.

##The framework uses:
Java 
Selenium 
TestNG
Maven  
Page Factory
ChromeDriver
EdgeDriver
Extent Report
Log4j

##Structure of the framework
### Packages
1. Action: contains all common action like JS actions, waits, handles windows, handles popup, mouse and keyboard Actions, handle dropdown, handle Alerts screenshot etc.
2. Base: This is the base class that performs set-up and tear-down operations like – browser configurations, implicit waits handling, cookies deletion, etc. Each test class extend this class.
3. DataProvider: having Data Provider class to read configure file and provide data like username password at run time 
4. Utility: having listener class which is responsible to generate log, Extent reports after execution of script. Also having RetryAnalyzer class for run failed test case automatically.
5. Pages: The pages package contains all the page classes. Each page class contains the web elements and actions that can be performed on those classes. 
6. Test: The test package contains all the test classes. Each test class extends the Base class and contains the test cases.
 

###Folders
1. Configuration: All Static Data like URL, Login credential placed in config.properties file.
2. Drivers: chromedriver, geckodriver, edgedriver.
3. Screenshots: The framework have the capability to capture screenshots in case of failed tests. All failed test cases screenshot save under     Screenshots folder.
4. ExtentReport: The framework produce html report. After test script execution HTML report generate with failed test cases screenshot’s and save under the ExtentReport folder.
5. TestCases:  Having all sample test cases in the Excel sheet. Yellow highlighted mark test cases are automated.  


##POM.xml: The pom.xml contains all the dependencies used in the project. It Contains selenium webdrier, TestNg, chromedriver, webdrivermanager, extent manager, log4j.
##testng.xml: TestNG.xml file contains all the Test configuration and this XML file can be used to run and organize our test. 
