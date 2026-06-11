package e2e.tests;

import e2e.pages.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static e2e.config.TestConstants.*;

public class HomeTest extends BaseTest {

    @Test
    public void shouldLoginThenNavigateAndInteractWithMovies() {

        // GIVEN : connexion sur login
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.fillUsername(USERNAME);
        loginPage.fillPassword(PASSWORD);
        loginPage.clickLogin();

        // WHEN : url = /home interaction avec les films
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(HOME_URL));

        TopBarPage topBar = new TopBarPage(webDriver);
        PaginatorPage paginator = new PaginatorPage(webDriver);
        MovieListPage movieList = new MovieListPage(webDriver);
        MovieDetailPage detail = new MovieDetailPage(webDriver);
        SideNavPage sideNav = new SideNavPage(webDriver);

        // Changer le thème
        topBar.toggleTheme();

        // Changer la taille de la liste
        paginator.setPageSize("5");
        paginator.setPageSize("40");
        paginator.setPageSize("20");

        // Pagination
        paginator.goToNextPage();
        paginator.goToLastPage();
        paginator.goToPreviousPage();
        paginator.goToFirstPage();

        // Movie id 1
        movieList.clickMovieById(1);
        detail.clickLike();
        detail.clickWatchLater();
        detail.goBack();

        // Movie id 5
        movieList.clickMovieById(5);
        detail.clickWatched();
        detail.goBack();

        // Search
        topBar.searchMovie("john wick");
        topBar.clickFirstSearchResult();

        detail.clickWatched();
        detail.clickWatchLater();
        detail.clickLike();

        // Navigation menu
        topBar.openMenu();

        sideNav.goToWatchLater();
        sideNav.goToWatched();
        sideNav.goToFavorites();
    }
}