package e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MovieListPage extends BasePage {

    public MovieListPage(WebDriver driver) {
        super(driver);
    }

    public void clickMovieById(int id) {
        click(By.id("movie-" + id));
    }
}

