package e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    private static final By TAB_REGISTER    = By.id("tab-register");
    private static final By FIELD_USERNAME  = By.id("register-username");
    private static final By FIELD_PASSWORD  = By.id("register-password");
    private static final By FIELD_EMAIL     = By.id("register-email");
    private static final By BUTTON_REGISTER = By.id("register-submit");

    public RegisterPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openRegisterTab() {
        click(TAB_REGISTER);
    }

    public void fillUsername(String username) {
        type(FIELD_USERNAME, username);
    }

    public void fillPassword(String password) {
        type(FIELD_PASSWORD, password);
    }

    public void fillEmail(String email) {
        type(FIELD_EMAIL, email);
    }

    public void clickRegister() {
        click(BUTTON_REGISTER);
    }
}