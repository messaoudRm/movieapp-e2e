package e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommentsPage extends BasePage{

    public CommentsPage(WebDriver webDriver){
        super(webDriver);
    }

    public void clickDeleteComment(int id) {
        click(By.id("btn-delete-" + id));
    }
}
