package e2e.tests;

import e2e.pages.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static e2e.config.TestConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AppFlowTest extends BaseTest {

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
        MovieDetailCommentsPage detailComments = new MovieDetailCommentsPage(webDriver);
        CommentsPage commentsPage = new CommentsPage(webDriver);

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
        movieList.clickMovieById(MOVIE_ID);
        detail.clickLike();
        detail.clickWatchLater();
        detail.goBack();

        // Movie id 5
        movieList.clickMovieById(ANOTHER_MOVIE_ID);
        detail.clickWatched();
        detail.goBack();

        // Search
        topBar.searchMovie(MOVIE_NAME);
        topBar.clickFirstSearchResult();

        detail.clickWatched();
        detail.clickWatchLater();
        detail.clickLike();

        // Navigation menu
        topBar.openCloseMenu();

        sideNav.goToWatchLater();
        sideNav.goToFavorites();
        sideNav.goToWatched();

        // Back to /home
        sideNav.goToHome();

        // Close menu
        topBar.openCloseMenu();

        // Select movie
        movieList.clickMovieById(10);
        detailComments.openCommentsTab();


        detailComments.fillCommet(POSITIVE_REVIEW);
        detailComments.clickSend();

        detailComments.fillCommet(NEGATIVE_REVIEW);
        detailComments.clickSend();

        topBar.openCloseMenu();
        sideNav.goToComments();
        topBar.openCloseMenu();

        commentsPage.clickDeleteComment(COMMENT_ID);
        commentsPage.clickDeleteComment(ANOTHER_COMMENT_ID);


        topBar.openCloseMenu();
        sideNav.goToManageMovies();
        sideNav.goToMe();
        sideNav.goToUsers();
        sideNav.Logout();

        // THEN : redirect to /auth
        WebDriverWait waiter = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        waiter.until(ExpectedConditions.urlToBe(AUTH_URL));

        assertThat(webDriver.getCurrentUrl()).isEqualTo(AUTH_URL);


    }
}