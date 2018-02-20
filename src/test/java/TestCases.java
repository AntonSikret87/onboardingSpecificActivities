import net.demandware.astound20.core.TestBase;
import net.demandware.astound20.pages.DressesPage;
import net.demandware.astound20.pages.HomePage;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class TestCases extends TestBase {

	private String expectedFirstDressText = "Cap Sleeve Wrap Dress.";
	private int expectedAmountOnFirstPLP = 12;
	private String expectedAmountOnSecondPLP = "24";
	private String expectedAmountOnThirdPLP = "36";
	private String selectViewAll = "View All (46)";
	private String expectedAmountOnFourthPLP = "46";


	//Test scenario#1
	@Test
	public void productFromWomanCategAddedToCart() {
		HomePage homePage = new HomePage(driver);
		homePage.hoverWomanCategory();
		homePage.navigateToDresses();
		DressesPage dressesPage = new DressesPage(driver);
		//String actualNameProduct =
				dressesPage.clickItemAndGetNameProduct();
		dressesPage.clickAddToCart();
		dressesPage.hoverViewCartIcon();
		//assertEquals(actualNameProduct, dressesPage.getActualTextFromViewCartDialog());
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
		int actualFirstValueInDropDown = homePage.selectAndGetValueFromDropDownPLP(0);
		assertEquals(actualFirstValueInDropDown, homePage.countItemsDisplayedOnPLP());
		int actualSecondValueInDropDown = homePage.selectAndGetValueFromDropDownPLP(1);
		assertEquals(actualSecondValueInDropDown, homePage.countItemsDisplayedOnPLP());

	}

}
