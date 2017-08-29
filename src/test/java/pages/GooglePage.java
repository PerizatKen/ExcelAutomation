package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {
	private WebElement driver;

	public GooglePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "q")
	public WebElement searchBox;

	@FindBy(xpath = "//input[@type='submit'][1]")
	public WebElement searchBtn;

	@FindBy(xpath = "//*[@id='cwmcwd']")
	public WebElement calTable;

	@FindBy(xpath = "//*[@id='cwtltblr']/div[2]")
	public WebElement calInput;

}
