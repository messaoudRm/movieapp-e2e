package e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SideNavPage extends BasePage{

    private static final By NAV_HOME = By.id("nav-home");
    private static final By NAV_WATCHED = By.id("nav-watched");
    private static final By NAV_WATCH_LATER = By.id("nav-watch-later");
    private static final By NAV_FAVORITES = By.id("nav-favorites");
    private static final By NAV_COMMENTS = By.id("nav-comments");
    private static final By NAV_ME = By.id("nav-me");
    private static final By NAV_MANAGE_MOVIE = By.id("nav-manageMovies");
    private static final By NAV_USERS = By.id("nav-users");
    private static final By NAV_LOGOUT = By.id("nav-auth");

    public SideNavPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void goToHome() {
        click(NAV_HOME);
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

    public void goToComments() {
        click(NAV_COMMENTS);
    }

    public void goToManageMovies() {
        click(NAV_MANAGE_MOVIE);
    }
    public void goToMe() {
        click(NAV_ME);
    }
    public void goToUsers() {
        click(NAV_USERS);
    }
    public void Logout() {
        click(NAV_LOGOUT);
    }
}
