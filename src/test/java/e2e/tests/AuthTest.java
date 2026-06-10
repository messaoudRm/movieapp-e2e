package e2e.tests;

import e2e.pages.LoginPage;
import e2e.pages.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthTest {

    private static final String BASE_URL  = "http://localhost:4200/auth";
    private static final String HOME_URL  = "http://localhost:4200/home";

    private static final String USERNAME  = "selenium";
    private static final String PASSWORD  = "selenium";
    private static final String EMAIL     = "selenium@selenium.com";

    private WebDriver webDriver;

    @BeforeAll
    public static void setUpChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.get(BASE_URL);
    }

    @AfterEach
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

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