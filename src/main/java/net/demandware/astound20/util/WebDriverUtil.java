package net.demandware.astound20.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtil {
	private WebDriver webDriver;
	private WebDriverWait webDriverWait;
	private Actions actions;
	private JavascriptExecutor JSexecutor;


	public WebDriverUtil(WebDriver webDriver) {
		this.webDriver = webDriver;
		webDriverWait = new WebDriverWait(webDriver, 25);
		actions = new Actions(webDriver);
	}

	public WebElement waitForExpectedCondition(ExpectedCondition expectedCondition) {
		return (WebElement)webDriverWait.until(expectedCondition);
	}

	public void jsClickByElement(WebElement element) {
		JSexecutor = (JavascriptExecutor)webDriver;
		JSexecutor.executeScript("arguments[0].click();", element);
	}

	public void jsClickByIdOrName(String locator, String type) {
		JSexecutor = (JavascriptExecutor)webDriver;
		switch (type) {
		case "id": {
			JSexecutor.executeScript("document.getElementById(\"" + locator + "\").click()");
			break;
		}
		case "name": {
			JSexecutor.executeScript("document.getElementsByName(\"" + locator + "\")[0].click()");
			break;
		}
		}
	}
}
