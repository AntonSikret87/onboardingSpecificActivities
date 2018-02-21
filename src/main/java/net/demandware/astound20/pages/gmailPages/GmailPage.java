package net.demandware.astound20.pages.gmailPages;

import net.demandware.astound20.pages.BasePage;
import net.demandware.astound20.util.PropertiesCache;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GmailPage extends BasePage {

	By emailFieldLocator = By.id(PropertiesCache.getProperty("emailField.id"));
	private WebElement emailField;

	By nextBtnEmailLocator = By.id(PropertiesCache.getProperty("nextBtn.id"));
	private WebElement nextButtonEmail;

	By passFieldLocator = By.name(PropertiesCache.getProperty("passField.name"));
	private WebElement passwordField;

	By nextBtnPassLocator = By.id(PropertiesCache.getProperty("nextBtnPass.id"));
	private WebElement nextButtonPassword;

	By errorMessageLocator = By.xpath(PropertiesCache.getProperty("errorMessage.xpath"));
	private WebElement errorMessage;

	public GmailPage(WebDriver driver) {
		super(driver);
	}

	public void login(String email, String pass) {
		emailField = driver.findElement(emailFieldLocator);
		emailField.sendKeys(email);
		nextButtonEmail = driver.findElement(nextBtnEmailLocator);
		nextButtonEmail.click();
		passwordField = webDriverUtil.waitForExpectedCondition(
				ExpectedConditions.elementToBeClickable(passFieldLocator));
		passwordField.sendKeys(pass);
		nextButtonPassword = webDriverUtil.waitForExpectedCondition(
				ExpectedConditions.elementToBeClickable(nextBtnPassLocator));
		nextButtonPassword.click();
	}

	public boolean errorMessageIsDisplayed(){
		errorMessage = webDriverUtil.waitForExpectedCondition(
				ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
		return errorMessage.isDisplayed();
	}

	public String getErrorText() {
		errorMessage = webDriverUtil.waitForExpectedCondition(
				ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
		return errorMessage.getText();
	}
}
