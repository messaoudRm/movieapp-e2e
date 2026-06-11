package e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaginatorPage extends BasePage{

    private static final By PAGE_SIZE_SELECT = By.cssSelector("#movie-paginator .mat-mdc-paginator-page-size-select");
    private static final By BTN_NEXT = By.cssSelector("#movie-paginator button[aria-label='Next page']");
    private static final By BTN_PREVIOUS = By.cssSelector("#movie-paginator button[aria-label='Previous page']");
    private static final By BTN_LAST = By.cssSelector("#movie-paginator button[aria-label='Last page']");
    private static final By BTN_FIRST = By.cssSelector("#movie-paginator button[aria-label='First page']");

    public PaginatorPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void setPageSize(String size) {

        click(PAGE_SIZE_SELECT);

        for (WebElement option :
                waiter.until(
                        ExpectedConditions.
                        visibilityOfAllElementsLocatedBy(
                                By.cssSelector("mat-option span")
                ))) {

            if (option.getText().trim().equals(size)) {
                option.click();
                return;
            }
        }
    }

    public void goToNextPage() {
        click(BTN_NEXT);
    }

    public void goToPreviousPage() {
        click(BTN_PREVIOUS);
    }

    public void goToLastPage() {
        click(BTN_LAST);
    }

    public void goToFirstPage() {
        click(BTN_FIRST);
    }

}
