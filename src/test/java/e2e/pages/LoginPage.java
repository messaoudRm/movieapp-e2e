package e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private static final By FIELD_USERNAME  = By.id("login-username");
    private static final By FIELD_PASSWORD  = By.id("login-password");
    private static final By BUTTON_LOGIN    = By.id("login-submit");

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void fillUsername(String username) {
        type(FIELD_USERNAME, username);
    }

    public void fillPassword(String password) {
        type(FIELD_PASSWORD, password);
    }

    public void clickLogin() {
        click(BUTTON_LOGIN);
    }

}