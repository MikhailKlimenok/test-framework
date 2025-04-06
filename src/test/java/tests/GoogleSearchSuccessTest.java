package tests;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;
import utils.DriverFactory;

public class GoogleSearchSuccessTest extends BaseTest {

    @DataProvider(name = "searchQueries")
    public Object[][] searchQueries() {
        return new Object[][]{
            {"apple"},
            {"banana"},
            {"orange"}
        };
    }

    @Test(dataProvider = "searchQueries")
    public void searchInGoogle(String query) {
        GoogleSearchPage google = new GoogleSearchPage(DriverFactory.getDriver());

        google.open();
        google.searchFor(query);

        if (google.isResultsDisplayed()) {
            getTest().pass("Search for '" + query + "' returned results.");
        } else {
            getTest().fail("Search for '" + query + "' returned no results.");
        }
    }
}