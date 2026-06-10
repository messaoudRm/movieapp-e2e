package e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    private final WebDriver webDriver;
    private final WebDriverWait waiter;

    private static final By TAB_REGISTER    = By.id("tab-register");
    private static final By FIELD_USERNAME  = By.id("register-username");
    private static final By FIELD_PASSWORD  = By.id("register-password");
    private static final By FIELD_EMAIL     = By.id("register-email");
    private static final By BUTTON_REGISTER = By.id("register-submit");

    public RegisterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.waiter = new WebDriverWait(webDriver, Duration.ofSeconds(5));
    }

    public void openRegisterTab() {
        WebElement tab = waiter.until(ExpectedConditions.elementToBeClickable(TAB_REGISTER));
        tab.click();
    }

    public void fillUsername(String username) {
        WebElement field = waiter.until(
                ExpectedConditions.visibilityOfElementLocated(FIELD_USERNAME)
        );
        field.sendKeys(username);
    }

    public void fillPassword(String password) {
        WebElement field = waiter.until(
                ExpectedConditions.visibilityOfElementLocated(FIELD_PASSWORD)
        );
        field.sendKeys(password);
    }

    public void fillEmail(String email) {
        WebElement field = waiter.until(
                ExpectedConditions.visibilityOfElementLocated(FIELD_EMAIL)
        );
        field.sendKeys(email);
    }

    public void clickRegister() {
        WebElement button = waiter.until(
                ExpectedConditions.elementToBeClickable(BUTTON_REGISTER)
        );
        button.click();
    }
}