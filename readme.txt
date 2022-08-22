Qa Automation Framework:
A sample framework based on Page Object Model, Selenium, TestNG using Java.

This framework is based in Page Object Model (POM).

The framework uses:
Java
Selenium
TestNG
chromedriver
Eclipse IDE
Extent Report
Log4j

Contains:
$ Packages
1.Action : contains All common action like js actions, keyboard actions, waits, handles windows etc
2.TestBase: This class is responsible forInitializing the WebDriver
3.Utility: having listener class f
4.Pages: having HomePage class contains Webelement related to home page(Follow POM desigen pattern)

$Folders
1.Screenshots:screenshots of failed test cases
2.ChromeDriver: chromedriver ,edgedriver



$ POM.xml: contains selenium webdrier, TestNg, chromedriver,webdrivermanager, extent manager,log4j
$testng.xml : use this file for run Test Suite