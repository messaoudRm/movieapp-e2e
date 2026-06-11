package e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SideNavPage extends BasePage{

    private static final By NAV_WATCHED = By.id("nav-watched");
    private static final By NAV_WATCH_LATER = By.id("nav-watch-later");
    private static final By NAV_FAVORITES = By.id("nav-favorites");

    public SideNavPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void goToWatched() {
        click(NAV_WATCHED);
    }

    public void goToWatchLater() {
        click(NAV_WATCH_LATER);
    }

    public void goToFavorites() {
        click(NAV_FAVORITES);
    }
}
