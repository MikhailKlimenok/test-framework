package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import utils.DriverFactory;

public class SampleTest extends BaseTest {

    @Test
    public void openGoogle() {
        DriverFactory.getDriver().get("https://google.com");
        getTest().pass("Google opened successfully.");
    }
}