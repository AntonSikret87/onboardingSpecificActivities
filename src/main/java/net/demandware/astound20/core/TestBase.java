package net.demandware.astound20.core;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import net.demandware.astound20.util.PropertiesCache;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestBase {
	protected WebDriver driver;
	private String browser = System.getProperty("browser");

	private String baseUrl = PropertiesCache.getProperty("base.URL.gmail");//base.URL.AstoundAdress
	private long implicitWait = Long.parseLong(PropertiesCache.getProperty("wait.implicit"));
	private long loadingPageTime = Long.parseLong(PropertiesCache.getProperty("wait.loadingPage"));
	private long scriptSetTime = Long.parseLong(PropertiesCache.getProperty("wait.scriptSetTime"));

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		//use lib
//		ChromeDriverManager.getInstance().setup();
//      driver = new ChromeDriver();
		//use mvn (run: -Dbrowser={$browser})
		setBrowser();
		setWebDriverSettings();
	}

	public void setBrowser() {
		BrowserEnum runBrowser = browser == null ? BrowserEnum.CHROME : BrowserEnum.valueOf(browser);
		switch (runBrowser) {
		case CHROME:
			ChromeDriverManager.getInstance().setup();
			driver = new ChromeDriver();
			break;
		case FF:
			FirefoxDriverManager.getInstance().setup();
			driver = new FirefoxDriver();
			break;
		}
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}

	private void setWebDriverSettings() {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(loadingPageTime, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(scriptSetTime, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void goTo() {
		driver.get(baseUrl);
	}
}
