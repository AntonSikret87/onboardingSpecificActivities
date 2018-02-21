package net.demandware.astound20.pages;

import net.demandware.astound20.util.PropertiesCache;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
	By womansItemLocator = By.cssSelector(PropertiesCache.getProperty("womanItem.css"));
	private WebElement lnkWoman;

	By itemDressesLocator = By.xpath(PropertiesCache.getProperty("itemDresses.xpath"));
	private WebElement lnkDresses;

	By itemsUnderWomanCategLocator = By.xpath(PropertiesCache.getProperty("linksUnderWomanCateg.xpath"));
	private WebElement lnksUnderWomanCategory;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public HomePage hoverWomanCategory() {
		lnkWoman = webDriverUtil.waitForExpectedCondition(
				ExpectedConditions.visibilityOfElementLocated(womansItemLocator));
		action.moveToElement(lnkWoman).build().perform();
		return this;
	}

	public void navigateToDresses() {
		lnkDresses = webDriverUtil.waitForExpectedCondition(
				ExpectedConditions.elementToBeClickable(itemDressesLocator));
		lnkDresses.click();
	}

	public boolean linksUnderWomanAreDisplayed() {
		lnksUnderWomanCategory = driver.findElement(itemsUnderWomanCategLocator);
		return lnksUnderWomanCategory.isDisplayed();
	}
}
