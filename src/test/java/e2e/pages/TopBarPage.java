package e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopBarPage extends BasePage{

    private static final By THEME_TOGGLE = By.id("theme-toggle");
    private static final By MENU_TOGGLE = By.id("menu-toggle");
    private static final By SEARCH_INPUT = By.id("search-input");

    public TopBarPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void toggleTheme() {
        click(THEME_TOGGLE);
    }

    public void openCloseMenu() {
        click(MENU_TOGGLE);
    }

    public void searchMovie(String name) {
        type(SEARCH_INPUT, name);
    }

    public void clickFirstSearchResult() {
        click(By.cssSelector("mat-option.movie-option"));
    }

}
