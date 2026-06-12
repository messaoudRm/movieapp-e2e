package e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MovieDetailCommentsPage extends BasePage{

    private static final By TAB_COMMENTS   = By.id("tab-comments");
    private static final By COMMENT_INPUT  = By.id("comment-input");
    private static final By COMMENT_SUBMIT = By.id("comment-submit");

    public MovieDetailCommentsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openCommentsTab() {
        click(TAB_COMMENTS);
    }

    public void fillCommet(String comment) {
        type(COMMENT_INPUT, comment);
    }

    public void clickSend() {
        click(COMMENT_SUBMIT);
    }
}
