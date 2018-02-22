import net.demandware.astound20.core.TestBase;
import net.demandware.astound20.pages.gmailPages.GmailLoginPage;
import net.demandware.astound20.pages.gmailPages.GmailPage;
import net.demandware.astound20.util.PropertiesCache;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class GmailSuccessLoginTest extends TestBase {

	private String subjectName = PropertiesCache.getProperty("subjectName.text");

	@Test(enabled = true, groups = "positive")
	public void gmailTestLoginSuccess() {
		GmailPage gmailPage = new GmailPage(driver);
		gmailPage.login(PropertiesCache.getProperty("user.nameValid"),
		                PropertiesCache.getProperty("user.passwordValid"));
		GmailLoginPage gmailLoginPage = new GmailLoginPage(driver);
		assertTrue(gmailLoginPage.checkIncomingLinkIsDisplayed());
		assertTrue(gmailLoginPage.getTitleIcon().contains(PropertiesCache.getProperty("user.nameValid")));
		gmailLoginPage.findAndOpenEmailBySubject(subjectName);
		assertTrue(gmailLoginPage.showDetailsBtnIsDisplayedInEmail());
		gmailLoginPage.logout();
	}
}
