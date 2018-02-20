package net.demandware.astound20.pages;


import java.util.List;
import java.util.concurrent.TimeUnit;

import net.demandware.astound20.util.PropertiesCache;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {
	By womansItemLocator = By.cssSelector(PropertiesCache.getProperty("womanItem.css"));
	private WebElement lnkWoman;

	By itemDressesLocator = By.xpath("(.//ul[@class='level-3']/descendant::li[position()=3]/a)[1]");
	private WebElement lnkDresses;

	By itemsUnderWomanCategLocator = By.xpath(".//ul[@class='menu-horizontal']//a");
	private WebElement lnksUnderWomanCategory;



	By dropDownValuesLocator = By.xpath(".//select[@id='grid-paging-header']/option");
	List<WebElement> lstDropDownPLP;

	By productsOnPLPLocator = By.xpath(".//ul[@id='search-result-items']/li");
	List<WebElement> productsOnPLP;

	By paginationSelecPLPtLocator = By.id("grid-paging-footer");
	private WebElement lstSelectPaginationPLP;

	public HomePage(WebDriver driver) {
		super(driver);

	}

	public HomePage hoverWomanCategory() {
		lnkWoman = webDriverUtil.waitForExpectedCondition(
				ExpectedConditions.visibilityOfElementLocated(womansItemLocator));
		action.moveToElement(lnkWoman).build().perform();
		return this;
	}

	public DressesPage navigateToDresses() {
		lnkDresses = webDriverUtil.waitForExpectedCondition(
				ExpectedConditions.elementToBeClickable(itemDressesLocator));
		action.click(lnkDresses).click().build().perform();
		return new DressesPage(driver);
	}

	public boolean linksUnderWomanAreDisplayed() {
		lnksUnderWomanCategory = driver.findElement(itemsUnderWomanCategLocator);
		return lnksUnderWomanCategory.isDisplayed();
	}



	public int selectAndGetValueFromDropDownPLP(int indexOfValue){
		//List<Integer> listDropDownFromCycle = new ArrayList<>();
		lstDropDownPLP =driver.findElements(dropDownValuesLocator);
		String actualValInDrop = lstDropDownPLP.get(indexOfValue).getText();
		System.out.println("From liat first el: " + lstDropDownPLP.get(indexOfValue).getText() );
		new Select(driver.findElement(paginationSelecPLPtLocator)).selectByIndex(indexOfValue);

//		lstSelectPaginationPLP =driver.findElement(paginationSelecPLPtLocator);
//		lstSelectPaginationPLP.click();
//		lstSelectPaginationPLP.sendKeys(pageAmountToBeDisplayed);
//		lstSelectPaginationPLP.click();
		return Integer.parseInt(actualValInDrop);

		//parse string value from drop down
//		int number=0;
//		for(WebElement val : lstDropDownPLP){
//			String elVal = val.getText();
//			//System.out.println("Values cycle " + val.getText());
//			//int valueOnList = Integer.parseInt(val.getText());
//			String mystr = elVal.replaceAll( "[^\\d]", "" );
//			number= Integer.parseInt(mystr);
//			System.out.println(number);
//			listDropDownFromCycle.add(number);
//		}
//		System.out.println(listDropDownFromCycle);
//		return number;

	}

	public int countItemsDisplayedOnPLP() {
		productsOnPLP = driver.findElements(productsOnPLPLocator);
		int amountOfLinksThatDisplayed = productsOnPLP.size();
		System.out.println("Actual Links onPLP: " + amountOfLinksThatDisplayed);
		lstSelectPaginationPLP =driver.findElement(paginationSelecPLPtLocator);

		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return amountOfLinksThatDisplayed;

	}
}
