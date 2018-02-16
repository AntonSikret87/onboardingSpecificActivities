package net.demandware.astound20.pages;

import net.demandware.astound20.util.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
	protected WebDriver driver;
	protected WebDriverUtil webDriverUtil;
	protected Actions action;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		webDriverUtil=new WebDriverUtil(driver);
		action =new Actions(driver);
	}

	public void open(String url) {
		driver.get(url);
	}
}
