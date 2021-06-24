import Base.Base;
import org.openqa.selenium.By;

public class ProductPage extends Base {
    public static By product_icon = By.xpath("//div[@id='c2833869']");
    public static By product_into_to_basket = By.xpath("//div[@class='cart-btn-wrap']/button[@class='c-btn-main-lg-v1']");
    public static By go_to_basket = By.xpath("//div[@class='cart-btn-wrap']/a[@class='c-btn-base-lg-v1 j-go-to-basket']");

    public static void chooseAndputProduct() {
        choose_a_product();
        sendProductToCart();
        goToCart();
    }

    public static void choose_a_product() {
        click(ProductPage.product_icon);
    }
    public static void sendProductToCart() {
        click(ProductPage.product_into_to_basket);
    }
    public static void goToCart() {
        click(ProductPage.go_to_basket);
    }

}
