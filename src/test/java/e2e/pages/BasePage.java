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
        waits();
        waiter.until(
                ExpectedConditions.elementToBeClickable(locator)
        ).click();
    }

    protected void type(By locator, String text) {
        waits();
        WebElement element = waiter.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
        element.clear();
        element.sendKeys(text);
    }

    protected void waits() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


}