import net.demandware.astound20.core.TestBase;
import net.demandware.astound20.pages.gmailPages.GmailLoginPage;
import net.demandware.astound20.pages.gmailPages.GmailPage;
import net.demandware.astound20.util.PropertiesCache;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class GmailSuccessLoginTest extends TestBase {

	private String subjectName = PropertiesCache.getProperty("subjectName.text");

	@Test(enabled = true, groups = "positive", dataProvider = "Success_Login_Credentials")
	public void gmailTestLoginSuccess(String sUsername, String sPassword) {
		GmailPage gmailPage = new GmailPage(driver);
		gmailPage.login(sUsername, sPassword);
		GmailLoginPage gmailLoginPage = new GmailLoginPage(driver);
		assertTrue(gmailLoginPage.checkIncomingLinkIsDisplayed());
		assertTrue(gmailLoginPage.getTitleIcon().contains(sUsername));
		gmailLoginPage.findAndOpenEmailBySubject(subjectName);
		assertTrue(gmailLoginPage.showDetailsBtnIsDisplayedInEmail());
		gmailLoginPage.logout();
	}

	@DataProvider(name = "Success_Login_Credentials")
	public Object[][] getDataForSuccessLoginGmail() {
		return new Object[][]{
				{PropertiesCache.getProperty("user1.nameValid"), PropertiesCache.getProperty("user1.passwordValid")},
				{PropertiesCache.getProperty("user2.nameValid"), PropertiesCache.getProperty("user2.passwordValid")}};
	}
}
