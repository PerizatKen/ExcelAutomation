package homework;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GooglePage;

public class GoogleSearch {
	static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Perizat/Documents/Libraries/drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
	}

	@Test
	public void search() throws InterruptedException {
		GooglePage google = new GooglePage(driver);
		google.searchBox.sendKeys("calculator");
		Thread.sleep(2000);
		google.searchBox.sendKeys(Keys.ENTER);
		// google.searchBtn.click();=> sometimes this not working

		google.calTable.isDisplayed();
		Thread.sleep(5000);

		// google.calInput.sendKeys("11");
		// google.calInput.sendKeys("+");
		// google.calInput.sendKeys("15");
		// google.calInput.sendKeys(Keys.ENTER);

	}
}
