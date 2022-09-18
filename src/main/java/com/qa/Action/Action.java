package com.qa.Action;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Base.TestBase;

public class Action extends TestBase {
	
	// click on element by move to element method
	public void click(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).click().build().perform();
	}
	
	// click by java script
		public void jsClick(WebDriver driver, WebElement element) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		}
		
	// to scroll upto element
	public void scrollUpToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	//Scroll web Page
		public void scrollPage(WebDriver driver, String function) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(function);
		}

	// send text by send keys method
	public void text(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	// select vlaue from dropdown by
	// 1.By index

	public void selectByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	// 2.ByValue
	public void selectByValue(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	// 3.ByVisibleText
	public void selectByVisibleText(WebElement element, String visibletext) {
		Select s = new Select(element);
		s.selectByVisibleText(visibletext);
	}

	// Frame: Switch to frame
	// 1.By index
	@SuppressWarnings("deprecation")
	public void switchToFrameByIndex(WebDriver driver, int index) {
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
		driver.switchTo().frame(index);
	}

	// 2.By ID Value
	@SuppressWarnings("deprecation")
	public void switchToFrameByIdValue(WebDriver driver, String idValue) {
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
		driver.switchTo().frame(idValue);
	}

	// 3.By Name
	@SuppressWarnings("deprecation")
	public void switchToFrameByName(WebDriver driver, String name) {
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
		driver.switchTo().frame(name);
	}

	// switch to DefaultFrame /parent window
	public void switchToDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	// switch back letest parent frame
	public void switchToParentFraem(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	//Move to element
	public void moveToElement(WebDriver driver, WebElement target) {
		Actions clicke = new Actions(driver);
		clicke.moveToElement(target).build().perform();
	}

	// Drag and Drop
	public void draganddrop(WebDriver driver, WebElement source, WebElement target) {
		new Actions(driver).dragAndDrop(source, target).build().perform();
	}

	// Rightclick on element
	public void rightclick(WebDriver driver, WebElement element) {
		Actions clicke = new Actions(driver);
		clicke.contextClick(element).build().perform();
	}

	// switch to new window
	public void switchToWindow(WebDriver driver) {
		String parent_window = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> it = allwindows.iterator();

		while (it.hasNext()) {
			String child_window = it.next();
			if (!parent_window.equalsIgnoreCase(child_window)) {
				driver.switchTo().window(child_window);
			}
		}
	}

//Alerts
	// Accept alert
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	// Dismiss
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	// send text to alert
	public void sendTestToAlert(WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);

	}

	// Get Text From Alert
	public void getTextFromAlert(WebDriver driver) {
		driver.switchTo().alert().getText();

	}

	// Waits
	// implicitWait
	@SuppressWarnings("deprecation")
	public void implicitWait(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// ExplicitWait
	public void explicitWait(WebDriver driver, WebElement element) {
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfAllElements(element));
	}

	// To take Screenshot
	public void screenShot(String testName) {
		try {
			TakesScreenshot Take = ((TakesScreenshot) driver);

			File src = Take.getScreenshotAs(OutputType.FILE);

			File Dest = new File(System.getProperty("user.dir") + "\\ScreenShots\\" + testName + ".png");

			FileHandler.copy(src, Dest);

		} catch (IOException e) {
			System.out.println("Show Exception");
		}
	}
	
	

}
