package Base;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Base {
    public static ChromeDriver chromeDriver = new ChromeDriver();
    public static long waiting_time = 10;
    public static WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(waiting_time));

    public static void click(By selector) {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(selector));
        button.click();
    }

    public static void sendKeys (By selector, String text) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(selector));
        input.sendKeys(text);

    }













}
