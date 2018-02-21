import java.util.ArrayList;
import java.util.List;

import net.demandware.astound20.core.TestBase;
import net.demandware.astound20.pages.HomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class TestCases extends TestBase {

	//Test scenario#1
	@Test
	public void productFromWomanCategAddedToCart() {
		HomePage homePage = new HomePage(driver);
		homePage.hoverWomanCategory();
		homePage.navigateToDresses();
		//DressesPage dressesPage = new DressesPage(driver);
		String actualNameProduct = homePage.clickItemAndGetNameProduct();
		homePage.clickAddToCart();
		homePage.hoverViewCartIcon();
		assertEquals(actualNameProduct, homePage.getActualTextFromViewCartDialog());
	}

	//Test scenario#2
	@Test
	public void hoveringWomanCategOpensPopup() {
		HomePage homePage = new HomePage(driver);
		homePage.hoverWomanCategory();
		assertTrue(homePage.linksUnderWomanAreDisplayed());
	}

	//Test scenario#3
	@Test
	public void changingAmountOfItemsOnPLP() {
		HomePage homePage = new HomePage(driver);
		homePage.hoverWomanCategory();
		homePage.navigateToDresses();
		List<String> listDropDownPLP;
		listDropDownPLP = homePage.addStringFromDropDownPLP();
		assertEquals(Integer.parseInt(listDropDownPLP.get(0)), homePage.countItemsDisplayedOnPLP());
		homePage.changeValueInDropDown(listDropDownPLP.get(1));
		assertEquals(Integer.parseInt(listDropDownPLP.get(1)), homePage.countItemsDisplayedOnPLP());
		homePage.changeValueInDropDown(listDropDownPLP.get(2));
		assertEquals(Integer.parseInt(listDropDownPLP.get(2)), homePage.countItemsDisplayedOnPLP());
		homePage.changeValueInDropDown(listDropDownPLP.get(3).toString());
		int actualIntValueInDropDown = homePage.parseStringToInteger(listDropDownPLP.get(3));
		assertEquals(actualIntValueInDropDown, homePage.countItemsDisplayedOnPLP());
	}
}
