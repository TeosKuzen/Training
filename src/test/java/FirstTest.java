import Base.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class FirstTest extends Base {

    @Before
    public void startTest () {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Василий\\IdeaProjects\\Training\\chromedriver.exe");
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://www.wildberries.ru");
    }

    @Test
    public void firstTest () {

        SearchPage.searchProduct();
        ProductPage.chooseAndputProduct();
        BasketPage.checkBasket();
        System.out.println("Test passed successfully");
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
    }













}

