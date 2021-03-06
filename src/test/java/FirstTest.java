import Base.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class FirstTest extends Base {

    @Before
    public void startTest () {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Василий\\IdeaProjects\\Training\\chromedriver.exe");
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://www.wildberries.ru");
    }

    @Test
    public void firstTest () {

        click(By.cssSelector("input[class='search-catalog__input j-search-input']"));
        sendKeys(By.cssSelector("input[class='search-catalog__input j-search-input']"),  "venus");
        click(By.cssSelector("button[class='search-catalog__btn search-catalog__btn--search j-btn-search']"));
        click(By.cssSelector("img[src='//images.wbstatic.net/c252x336/new/2830000/2833869-1.jpg']"));
        click(By.xpath("//div[@class='cart-btn-wrap']/button[@class='c-btn-main-lg-v1']"));
        click(By.xpath("//div[@class='cart-btn-wrap']/a[@class='c-btn-base-lg-v1 j-go-to-basket']"));
        BasketPage.assertAddBasketProduct(By.xpath("//span[@class='good-info__good-name']"),By.xpath("//span[@class='good-info__good-brand']"), "VENUS");
        BasketPage.assertDeleteBasketProduct(By.xpath("//span[@class='good-info__good-name']"),By.xpath("//span[@class='good-info__good-brand']"), By.xpath("//div[@class='btn__del j-basket-item-del']"), "VENUS");
    }

    @After
    public void quit () {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.quit();
        chromeDriver = null;
        System.out.println("Test passed successfully");
    }













}

