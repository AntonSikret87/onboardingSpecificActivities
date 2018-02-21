package net.demandware.astound20.pages;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

	By dropDownValuesLocator = By.xpath(PropertiesCache.getProperty("dropDownListValues.xpath"));
	List<WebElement> lstDropDownPLP;

	By productsOnPLPLocator = By.xpath(PropertiesCache.getProperty("lstProductsOnPLP.xpath"));
	List<WebElement> productsOnPLP;

	By paginationSelecPLPtLocator = By.id("grid-paging-footer");
	private WebElement lstSelectPaginationPLP;

	By addToCartLocator = By.id(PropertiesCache.getProperty("addToCartBtn.id"));
	private WebElement btnAddToCart;

	By viewCartLocator = By.xpath(PropertiesCache.getProperty("viewCartIcon.xpath"));
	private WebElement btnViewCart;

	By productInCartLocator =
			By.xpath(".//div[@class='mini-cart-name']/a");
	private WebElement lnkProductInCart;

	By listDressesLocator = By.xpath(".//a[@class='name-link']");
	List<WebElement> lstDressesPLP;

	By firstProductLocator =
			By.xpath(PropertiesCache.getProperty("firstItem.xpath"));
	private WebElement firstProductLink;

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

	public List<String> addStringFromDropDownPLP() {
		List<String> listDropDownFromCycle = new ArrayList<>();
		lstDropDownPLP = driver.findElements(dropDownValuesLocator);
		for (WebElement elVal : lstDropDownPLP) {
			String elValStr = elVal.getText();
			listDropDownFromCycle.add(elValStr);
		}
		//System.out.println("Numbers added to list after: " + listDropDownFromCycle);
		return listDropDownFromCycle;
	}

	public int countItemsDisplayedOnPLP() {
		productsOnPLP = driver.findElements(productsOnPLPLocator);
		int amountOfLinksThatDisplayed = productsOnPLP.size();
		//System.out.println("Actual Links onPLP: " + amountOfLinksThatDisplayed);
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return amountOfLinksThatDisplayed;
	}

	public void changeValueInDropDown(String pageAmountIndexToBeDisplayed) {
		lstSelectPaginationPLP = driver.findElement(paginationSelecPLPtLocator);
		lstSelectPaginationPLP.click();
		lstSelectPaginationPLP.sendKeys(pageAmountIndexToBeDisplayed);
		lstSelectPaginationPLP.click();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int parseStringToInteger(String stringWithInteger) {
		String getString = stringWithInteger.replaceAll("[^\\d]", "");
		int IntFromStr = Integer.parseInt(getString);
		//System.out.println("Result int from str : " + IntFromStr);
		return IntFromStr;
	}


	public void clickAddToCart() {
		btnAddToCart = webDriverUtil.waitForExpectedCondition(
				ExpectedConditions.elementToBeClickable(addToCartLocator));
		btnAddToCart.click();
	}

	public void hoverViewCartIcon() {
		btnViewCart = webDriverUtil.waitForExpectedCondition(
				ExpectedConditions.visibilityOfElementLocated(viewCartLocator));
		action.moveToElement(btnViewCart).build().perform();
	}

	public String getActualTextFromViewCartDialog() {
		lnkProductInCart = webDriverUtil.waitForExpectedCondition(
				ExpectedConditions.visibilityOfElementLocated(productInCartLocator));
		String actualText = lnkProductInCart.getText();
		return actualText;
	}

	public String clickItemAndGetNameProduct() {
		firstProductLink = webDriverUtil.waitForExpectedCondition(
				ExpectedConditions.visibilityOfElementLocated(firstProductLocator));
		String actualName = firstProductLink.getText();
		firstProductLink.click();
		return actualName;
	}
}
