package simple_ddt;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExcelUtils;

public class AmazonSearchDDT {
	String excelFilePath = "./src/test/resources/TestData/AmazonSearchData.xlsx";
	static WebDriver driver;
	WebElement search;
	WebElement results;

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Perizat/Documents/Libraries/drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
	}

	@Test
	public void searchTest() throws Exception {

		ExcelUtils.openExcelFile(excelFilePath, "TestData");
		int rowsCount = ExcelUtils.getUsedRowsCount();

		for (int rownum = 1; rownum < rowsCount; rownum++) {
			String item = ExcelUtils.getCellData(rownum, 1);
			searchFor(item);
			String resultText = getSearchResults();
			int resultCount = cleanUpResultsCount(resultText);
			System.out.println(resultCount);
			ExcelUtils.setCellData(String.valueOf(resultCount), rownum, 2);

			if (resultCount > 0) {
				System.out.println("Pass");
				ExcelUtils.setCellData("Pass", rownum, 3);
			} else {
				System.out.println("Fail");
				ExcelUtils.setCellData("Fail", rownum, 3);
			}
			// write current time to excel
			String now = LocalDateTime.now().toString();
			ExcelUtils.setCellData(now, rownum, 4);
		}
	}

	public String getSearchResults() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("s-result-count")));
		try {
			results = driver.findElement(By.id("s-result-count"));
		} catch (NoSuchElementException noElem) {
			return "0 results";
		}
		return results.getText();
	}

	public int cleanUpResultsCount(String resultText) {

		String[] arrResult = resultText.split(" ");
		int resultsCount;
		if (resultText.contains(" of ")) {
			resultsCount = Integer.parseInt(arrResult[2].replace(",", ""));
		} else {
			resultsCount = Integer.parseInt(arrResult[0]);
		}

		return resultsCount;
	}

	public void searchFor(String item) {

		search = driver.findElement(By.id("twotabsearchtextbox"));
		search.clear();
		search.sendKeys(item + Keys.ENTER);
	}

	// String excelPath = "C:\\Users\\Perizat\\Desktop\\EmpData.xlsx";
	// FileInputStream in = new FileInputStream(excelPath);
	// XSSFWorkbook workbook = new XSSFWorkbook(in);
	// XSSFSheet worksheet = workbook.getSheet("SearchData");
}
