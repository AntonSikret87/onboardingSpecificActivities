package net.demandware.astound20.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DressesPage extends BasePage {

	By firstItemInDressesLocator = By.xpath(".//div[@class='product-name' and @xpath='1']");
	private WebElement lnkFirstItemInDresses;

	By addToCartLocator = By.id("add-to-cart");
	private WebElement btnAddToCart;

	By viewCartLocator = By.xpath(".//i[@class='minicart-icon fa fa-shopping-cart']");
	private WebElement btnViewCart;

	By productInCartLocator =
			By.xpath(".//div[@class='mini-cart-name']/a");
	private WebElement lnkProductInCart;

	By listDressesLocator = By.xpath(".//a[@class='name-link']");
	List<WebElement> lstDressesPLP;

	By paginationSelecPLPtLocator = By.id("grid-paging-footer");
	private WebElement lstSelectPaginationPLP;




	public DressesPage(WebDriver driver) {
		super(driver);
	}

	public void clickItemAndGetNameProduct() {
//		String actualName = driver.findElement(By.xpath("//h1[@class='product-name']")).getText();
//		System.out.println(actualName);
		lnkFirstItemInDresses = webDriverUtil.waitForExpectedCondition(
				ExpectedConditions.elementToBeClickable(firstItemInDressesLocator));
		lnkFirstItemInDresses.click();
		//return actualName;
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

	public CharSequence countItemsDisplayedOnPLP() {
		lstDressesPLP = driver.findElements(listDressesLocator);
		int amountOfLinksThatDisplayed = lstDressesPLP.size() - 1;
		return (String.valueOf(amountOfLinksThatDisplayed));
	}

	public void changeListViewPagination(String pageAmountToBeDisplayed) {
		lstSelectPaginationPLP = driver.findElement(paginationSelecPLPtLocator);
		lstSelectPaginationPLP.click();
		lstSelectPaginationPLP.sendKeys(pageAmountToBeDisplayed);
		lstSelectPaginationPLP.click();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	}


