import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends Base {
    public static By selector_search = By.cssSelector("input[class='search-catalog__input j-search-input']");
    public static By search_button = By.cssSelector("button[class='search-catalog__btn search-catalog__btn--search j-btn-search']");
    public static String search_text = "venus";

    public static void searchProduct() {
        SearchPage.goToSearch();
        SearchPage.sendSearchProduct();
        SearchPage.pressSearch();
    }

    public static void goToSearch() {
        click(SearchPage.selector_search);
    }
    public static void sendSearchProduct() {
        sendKeys(SearchPage.selector_search, SearchPage.search_text);
    }
    public static void pressSearch() {
        click(SearchPage.search_button);
    }

}
