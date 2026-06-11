package e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MovieDetailPage extends BasePage {

    private static final By BTN_LIKE = By.id("btn-like");
    private static final By BTN_WATCH_LATER = By.id("btn-watch-later");
    private static final By BTN_WATCHED = By.id("btn-watched");

    public MovieDetailPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickLike() {
        click(BTN_LIKE);
    }

    public void clickWatchLater() {
        click(BTN_WATCH_LATER);
    }

    public void clickWatched() {
        click(BTN_WATCHED);
    }

    public void goBack() {
        webDriver.navigate().back();
    }
}
