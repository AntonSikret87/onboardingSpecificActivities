package net.demandware.astound20.core;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
	protected WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		String pathToFileWindows = ".\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", pathToFileWindows);
		driver = new ChromeDriver();
		setWebDriverSettings();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

	private void setWebDriverSettings() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
	}
}
