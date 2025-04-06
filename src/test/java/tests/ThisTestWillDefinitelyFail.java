package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.DriverFactory;

public class ThisTestWillDefinitelyFail extends BaseTest {

    @Test
    public void elementShouldBePresentButIsNot() {
        DriverFactory.getDriver().get("https://google.com");
        DriverFactory.getDriver().findElement(By.id("nonexistent-element")); // элемент точно не существует
        getTest().pass("Somehow passed... but shouldn't.");
    }
}