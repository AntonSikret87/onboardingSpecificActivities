package net.demandware.astound20.core;

import java.util.concurrent.TimeUnit;

import net.demandware.astound20.util.PropertiesCache;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestBase {
	protected WebDriver driver;
	private String baseUrl = PropertiesCache.getProperty("base.URL");/**/
	private long implicitWait = Long.parseLong(PropertiesCache.getProperty("wait.implicit"));
	private long loadingPageTime = Long.parseLong(PropertiesCache.getProperty("wait.loadingPage"));
	private long scriptSetTime = Long.parseLong(PropertiesCache.getProperty("wait.scriptSetTime"));

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		String pathToFileWindows = ".\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", pathToFileWindows);
		driver = new ChromeDriver();
		setWebDriverSettings();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}

	private void setWebDriverSettings() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(loadingPageTime, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(scriptSetTime, TimeUnit.SECONDS);
	}
	@BeforeMethod
	public void goTo(){
		driver.get(baseUrl);
	}
}
