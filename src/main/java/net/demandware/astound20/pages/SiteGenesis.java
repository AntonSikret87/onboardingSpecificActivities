package net.demandware.astound20.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SiteGenesis extends BasePage {
	By womansItemLocator = By.cssSelector("li:nth-child(1) > a.has-sub-menu");
	private WebElement lnkWoman;

	By itemDressesLocator = By.xpath(".//li/a[contains(., 'Dresses')]");
	private WebElement lnkDresses;

	By firstItemInDressesLocator = By.xpath(".//div[@class='product-tile' and @data-itemid='25696638']");
	private WebElement lnkFirstItemInDresses;

	By addToCartLocator = By.xpath(".//button[@id='add-to-cart']");
	private WebElement btnAddToCart;

	By viewCartLocator = By.xpath(".//i[@class='minicart-icon fa fa-shopping-cart']");
	private WebElement btnViewCart;

	By productInCartLocator =
			By.xpath(".//div[@class='mini-cart-name']//a[@title='Go to Product: Cap Sleeve Wrap Dress.']");
	private WebElement lnkProductInCart;

	By womanCategLocator = By.xpath(".//ul[@class='menu-horizontal']//a");
	private WebElement lnkWomanCategory;

	By firstListLocator = By.xpath(".//a[@class='name-link']");
	List <WebElement> lstDressesPLP;

	By paginationSelectLocator = By.id("grid-paging-footer");
	private WebElement lstSelectPagination;


	public SiteGenesis(WebDriver driver) {
		super(driver);
	}

	public void hoverWomanCategory() {
		lnkWoman = webDriverUtil.waitForExpectedCondition(
				ExpectedConditions.visibilityOfElementLocated(womansItemLocator));
		action.moveToElement(lnkWoman).build().perform();
	}

	public void navigateToDresses() {
		lnkDresses = webDriverUtil.waitForExpectedCondition(
				ExpectedConditions.elementToBeClickable(itemDressesLocator));
		action.click(lnkDresses).click().build().perform();
	}

	public void clickFirstItemOutfit() {
		lnkFirstItemInDresses = webDriverUtil.waitForExpectedCondition(
				ExpectedConditions.elementToBeClickable(firstItemInDressesLocator));
		lnkFirstItemInDresses.click();
	}

	public void clickAddToCart() {
		btnAddToCart = webDriverUtil.waitForExpectedCondition(
				ExpectedConditions.elementToBeClickable(addToCartLocator));
		btnAddToCart.click();
	}

	public void hoverViewCart() {
		btnViewCart = webDriverUtil.waitForExpectedCondition(
				ExpectedConditions.visibilityOfElementLocated(viewCartLocator));
		action.moveToElement(btnViewCart).build().perform();
	}

	public String getActualText() {
		lnkProductInCart = webDriverUtil.waitForExpectedCondition(
				ExpectedConditions.visibilityOfElementLocated(productInCartLocator));
		String actualText = lnkProductInCart.getText();
		return actualText;
	}

	public boolean womanCategoriesLinksAreDisplayed() {
		lnkWomanCategory = driver.findElement(womanCategLocator);
		return lnkWomanCategory.isDisplayed();
	}

	public CharSequence countListPLP() {
		lstDressesPLP = driver.findElements(firstListLocator);
		int allLinksAmountFirst = lstDressesPLP.size() - 1;
		return (String.valueOf(allLinksAmountFirst));
	}

	public void chengeListViewPagination(String pageAmount){
		lstSelectPagination=driver.findElement(paginationSelectLocator);
		lstSelectPagination.click();
		lstSelectPagination.sendKeys(pageAmount);
		lstSelectPagination.click();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
