package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage extends BasePage {

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(id = "search")
    private WebElement results;

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://www.google.com");
    }

    public void searchFor(String query) {
        waitUntilVisible(searchBox).sendKeys(query + Keys.RETURN);
    }

    public boolean isResultsDisplayed() {
        return waitUntilVisible(results).isDisplayed();
    }
}