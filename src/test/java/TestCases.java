import net.demandware.astound20.core.TestBase;
import net.demandware.astound20.pages.SiteGenesis;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class TestCases extends TestBase {
	private String baseUrl =
			"http://astound20.alliance-prtnr-eu01.dw.demandware.net/on/demandware.store/Sites-SiteGenesis-Site";
	private String expectedFirstDressText = "Cap Sleeve Wrap Dress.";
	private String expectedAmountOnFirstPLP = "12";
	private String expectedAmountOnSecondPLP = "24";
	private String expectedAmountOnThirdPLP = "36";
	private String selectViewAll = "View All (46)";
	private String expectedAmountOnFourthPLP = "46";

	//Test scenario#1
	@Test
	public void productFromWomanCategAddedToCart() {
		SiteGenesis siteGenesis = new SiteGenesis(driver);
		siteGenesis.open(baseUrl);
		siteGenesis.hoverWomanCategory();
		siteGenesis.navigateToDresses();
		siteGenesis.clickFirstItemOutfit();
		siteGenesis.clickAddToCart();
		siteGenesis.hoverViewCart();
		assertEquals(expectedFirstDressText, siteGenesis.getActualText());
	}

	//Test scenario#2
	@Test
	public void hoveringWomanCategOpensPopup() {
		SiteGenesis siteGenesis = new SiteGenesis(driver);
		siteGenesis.open(baseUrl);
		siteGenesis.hoverWomanCategory();
		assertTrue(siteGenesis.womanCategoriesLinksAreDisplayed());
	}

	//Test scenario#3
	@Test
	public void changingAmountOfItemsOnPLP() {
		SiteGenesis siteGenesis = new SiteGenesis(driver);
		siteGenesis.open(baseUrl);
		siteGenesis.hoverWomanCategory();
		siteGenesis.navigateToDresses();
		assertEquals(expectedAmountOnFirstPLP, siteGenesis.countListPLP());
		siteGenesis.chengeListViewPagination(expectedAmountOnSecondPLP);
		assertEquals(expectedAmountOnSecondPLP, siteGenesis.countListPLP());
		siteGenesis.chengeListViewPagination(expectedAmountOnThirdPLP);
		assertEquals(expectedAmountOnThirdPLP, siteGenesis.countListPLP());
		siteGenesis.chengeListViewPagination(selectViewAll);
		assertEquals(expectedAmountOnFourthPLP, siteGenesis.countListPLP());
	}
}
