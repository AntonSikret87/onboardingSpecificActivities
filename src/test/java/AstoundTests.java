import java.util.List;

import net.demandware.astound20.core.TestBase;
import net.demandware.astound20.pages.astoundPages.PLPPage;
import net.demandware.astound20.pages.astoundPages.HomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AstoundTests extends TestBase {

	//Test scenario#1
	@Test(enabled = true)
	public void productFromWomanCategAddedToCart() {
		HomePage homePage = new HomePage(driver);
		homePage.hoverWomanCategory();
		homePage.navigateToDresses();
		PLPPage pagePLP = new PLPPage(driver);
		String actualNameProduct = pagePLP.clickItemAndGetNameProduct();
		pagePLP.clickAddToCart();
		pagePLP.hoverViewCartIcon();
		assertEquals(actualNameProduct, pagePLP.getActualTextFromViewCartDialog());
	}

	//Test scenario#2
	@Test(enabled = true)
	public void hoveringWomanCategOpensPopup() {
		HomePage homePage = new HomePage(driver);
		homePage.hoverWomanCategory();
		assertTrue(homePage.linksUnderWomanAreDisplayed());
	}

	//Test scenario#3
	@Test(enabled = true)
	public void changingAmountOfItemsOnPLP() {
		HomePage homePage = new HomePage(driver);
		homePage.hoverWomanCategory();
		homePage.navigateToDresses();
		PLPPage pagePLP = new PLPPage(driver);
		List<String> listDropDownPLP;
		listDropDownPLP = pagePLP.addStringFromDropDownPLP();
		assertEquals(Integer.parseInt(listDropDownPLP.get(0)), pagePLP.countItemsDisplayedOnPLP());
		pagePLP.changeValueInDropDown(listDropDownPLP.get(1));
		assertEquals(Integer.parseInt(listDropDownPLP.get(1)), pagePLP.countItemsDisplayedOnPLP());
		pagePLP.changeValueInDropDown(listDropDownPLP.get(2));
		assertEquals(Integer.parseInt(listDropDownPLP.get(2)), pagePLP.countItemsDisplayedOnPLP());
		pagePLP.changeValueInDropDown(listDropDownPLP.get(3).toString());
		int actualIntValueInDropDown = pagePLP.parseStringToInteger(listDropDownPLP.get(3));
		assertEquals(actualIntValueInDropDown, pagePLP.countItemsDisplayedOnPLP());
	}
}
