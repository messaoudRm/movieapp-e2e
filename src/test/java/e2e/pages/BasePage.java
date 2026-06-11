package e2e.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected final WebDriver webDriver;
    protected final WebDriverWait waiter;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.waiter = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    protected void click(By locator) {
        waiter.until(
                ExpectedConditions.elementToBeClickable(locator)
        ).click();
    }

    protected void type(By locator, String text) {
        WebElement element = waiter.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
        element.sendKeys(text);
    }
}