package e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriver webDriver;
    private final WebDriverWait waiter;

    private static final By FIELD_USERNAME  = By.id("login-username");
    private static final By FIELD_PASSWORD  = By.id("login-password");
    private static final By BUTTON_LOGIN    = By.id("login-submit");

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.waiter = new WebDriverWait(webDriver, Duration.ofSeconds(5));
    }

    public void fillUsername(String username) {
        WebElement field = waiter.until(ExpectedConditions.visibilityOfElementLocated(FIELD_USERNAME));
        field.sendKeys(username);
    }

    public void fillPassword(String password) {
        webDriver.findElement(FIELD_PASSWORD).sendKeys(password);
    }

    public void clickLogin() {
        webDriver.findElement(BUTTON_LOGIN).click();
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }
}