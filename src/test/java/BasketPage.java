import Base.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.swing.*;
import java.util.Properties;

public class BasketPage extends Base {
   public static By product_in_basket = By.xpath("//span[@class='good-info__good-name']");
   public static By brand_selector = By.xpath("//span[@class='good-info__good-brand']");
   public static String brand_text = "VENUS";
   public static By deleteProductSelector = By.xpath("//div[@class='btn__del j-basket-item-del']");
   public static WebElement addProduct;
   public static String addProductBrand;

    public static void checkBasket() {
        checkTheProductInCart();
        checkTheDeletedProduct();
    }

    public static void assertAddBasketProduct (By selector, By selector_brand, String expectedAddProductBrand) {
        addProduct = wait.until(ExpectedConditions.elementToBeClickable(selector));
        if (chromeDriver.findElement(selector).isDisplayed()) {
            addProductBrand = chromeDriver.findElement(selector_brand).getText();
            Assert.assertEquals(expectedAddProductBrand, addProductBrand);
        }
    }

    public static void assertDeleteBasketProduct (By selector_delete) {
        WebElement deleteButton = wait.until(ExpectedConditions.presenceOfElementLocated(selector_delete));
        Actions actions = new Actions(chromeDriver);
        actions.moveToElement(deleteButton).build().perform();
        click(selector_delete);

        if (wait.until(ExpectedConditions.stalenessOf(addProduct))) {
            System.out.println("The product was successfully deleted");
        }
    }

    public static void checkTheProductInCart() {
        BasketPage.assertAddBasketProduct(BasketPage.product_in_basket, BasketPage.brand_selector, BasketPage.brand_text);
    }
    public static void checkTheDeletedProduct() {
        BasketPage.assertDeleteBasketProduct(BasketPage.deleteProductSelector);
    }
}
