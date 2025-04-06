package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    private final int TIMEOUT = 10;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement waitUntilVisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
            .until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    protected WebElement waitUntilClickable(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
            .until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    protected WebElement waitUntilPresent(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
            .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}