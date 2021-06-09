import Base.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.swing.*;

public class BasketPage extends Base {
    public static void assertAddBasketProduct (By selector, String expectedAddProductTitle) {
        WebElement addProduct = wait.until(ExpectedConditions.elementToBeClickable(selector));
        String actualAddProductTitle = addProduct.getText();
        Assert.assertEquals(expectedAddProductTitle, actualAddProductTitle);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void assertDeleteBasketProduct (By selector, By selector_delete,String expectedDeleteProductTitle) {
        WebElement deleteProduct = chromeDriver.findElement(selector);
        WebElement deleteButton = wait.until(ExpectedConditions.presenceOfElementLocated(selector_delete));
        Actions actions = new Actions(chromeDriver);
        actions.moveToElement(deleteButton).build().perform();

        if (deleteProduct.isDisplayed()) {
            String actualDeleteProductTitle = deleteProduct.getText();
            Assert.assertEquals(expectedDeleteProductTitle, actualDeleteProductTitle);
            click(selector_delete);
        }
        if (wait.until(ExpectedConditions.stalenessOf(deleteProduct))) {
            System.out.println("Продукт успешно удален!");
        }
    }
}
