import net.demandware.astound20.core.TestBase;
import net.demandware.astound20.pages.gmailPages.GmailPage;
import net.demandware.astound20.util.PropertiesCache;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GmailFailedLoginTest extends TestBase {

	private String expectedErrorMessage = PropertiesCache.getProperty("errorMessage.text");

	@Test(enabled = true, groups = "negative")
	public void gmailTestLoginFailed() {
		GmailPage gmailPage = new GmailPage(driver);
		gmailPage.login(PropertiesCache.getProperty("user1.nameValid"),
		                PropertiesCache.getProperty("user.passwordInvalid"));
		assertTrue(gmailPage.errorMessageIsDisplayed());
		assertEquals(expectedErrorMessage, gmailPage.getErrorText());
	}
}


