package e2e.tests;

import e2e.pages.LoginPage;
import e2e.pages.RegisterPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static e2e.config.TestConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AuthTest extends BaseTest {

    @Test
    public void shouldRegisterThenLogin() {
        // GIVEN : inscription (register)
        RegisterPage registerPage = new RegisterPage(webDriver);
        registerPage.openRegisterTab();
        registerPage.fillUsername(USERNAME);
        registerPage.fillPassword(PASSWORD);
        registerPage.fillEmail(EMAIL);
        registerPage.clickRegister();

        // WHEN : connexion sur login
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.fillUsername(USERNAME);
        loginPage.fillPassword(PASSWORD);
        loginPage.clickLogin();

        // THEN : redirect to /home
        WebDriverWait waiter = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        waiter.until(ExpectedConditions.urlToBe(HOME_URL));

        assertThat(webDriver.getCurrentUrl()).isEqualTo(HOME_URL);
    }
}