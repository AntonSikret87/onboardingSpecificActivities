package net.demandware.astound20.pages.gmailPages;

import java.util.List;

import net.demandware.astound20.pages.astoundPages.BasePage;
import net.demandware.astound20.util.PropertiesCache;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GmailLoginPage extends BasePage {

	By myIconLocator = By.xpath(PropertiesCache.getProperty("myIcon.xpath"));
	private WebElement btnMyIcon;

	By incomingMailsLocator = By.xpath(PropertiesCache.getProperty("incoming.xpath"));
	private WebElement incomingLink;

	By subjectsListLoctor = By.xpath(PropertiesCache.getProperty("lstSubjectEmails.xpath"));
	private List<WebElement> lstEmailsSubject;

	By showDetailsBtnInEmailLocator = By.xpath(PropertiesCache.getProperty("showDetailsBtnInEmail.xpath"));
	private WebElement btnShowDetailsEmail;

	By signOutLocator = By.id(PropertiesCache.getProperty("signOutBtn.id"));
	private WebElement btnSignOut;

	public GmailLoginPage(WebDriver driver) {
		super(driver);
	}

	public String getTitleIcon() {
		btnMyIcon = webDriverUtil.waitForExpectedCondition(
				ExpectedConditions.elementToBeClickable(myIconLocator));
		String myNameActual = btnMyIcon.getAttribute("title");
		return myNameActual;
	}

	public boolean checkIncomingLinkIsDisplayed() {
		incomingLink = driver.findElement(incomingMailsLocator);
		return incomingLink.isDisplayed();
	}

	public void findAndOpenEmailBySubject(String sSubject) {
		lstEmailsSubject = driver.findElements(subjectsListLoctor);
		for (WebElement link : lstEmailsSubject) {
			if (link.getText().contains(sSubject)) {
				//System.out.println("My link seacrhed " + link.getText());
				link.click();
				return;
			}
		}
		System.out.println("Email with this subject was not found");
	}

	public boolean showDetailsBtnIsDisplayedInEmail() {
		btnShowDetailsEmail = driver.findElement(showDetailsBtnInEmailLocator);
		return btnShowDetailsEmail.isDisplayed();
	}

	public void logout() {
		btnMyIcon = webDriverUtil.waitForExpectedCondition(
				ExpectedConditions.elementToBeClickable(myIconLocator));
		btnMyIcon.click();
		btnSignOut = webDriverUtil.waitForExpectedCondition(
				ExpectedConditions.visibilityOfElementLocated(signOutLocator));
		btnSignOut.click();
		driver.manage().deleteAllCookies();
	}
}
