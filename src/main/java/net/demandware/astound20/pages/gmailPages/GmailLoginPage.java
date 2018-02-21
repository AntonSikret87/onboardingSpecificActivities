package net.demandware.astound20.pages.gmailPages;

import net.demandware.astound20.pages.BasePage;
import net.demandware.astound20.util.PropertiesCache;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GmailLoginPage extends BasePage {

	By myIconLocator = By.xpath(PropertiesCache.getProperty("myIcon.xpath"));
	private WebElement myNameOnThePage;

	By incomingMailsLocator = By.xpath(PropertiesCache.getProperty("incoming.xpath"));
	private WebElement incomingLink;

	public GmailLoginPage(WebDriver driver) {
		super(driver);
	}

	public String getTitleIcon() {
        myNameOnThePage = webDriverUtil.waitForExpectedCondition(
		        ExpectedConditions.elementToBeClickable(myIconLocator));
		String myNameActual = myNameOnThePage.getAttribute("title");
		return myNameActual;
	}

	public boolean checkIncomingLinkIsDisplayed() {
		incomingLink = driver.findElement(incomingMailsLocator);
		return incomingLink.isDisplayed();
	}
}

