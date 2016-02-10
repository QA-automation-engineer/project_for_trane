import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by Vladimir on 10.02.2016.
 */
public class dz3_p_1_2 {
    public static void main(String[] args) throws InterruptedException {

        // знакомим chromedriver.exe с IntelliJ IDEA
        System.setProperty("webdriver.chrome.driver", "D:\\Trane\\external\\chromedriver\\chromedriver.exe");

        // запускаем chromedriver.exe
        WebDriver drv = new ChromeDriver();

        // заходим на сайт с исследуемой формой
        drv.get("http://toolsqa.com/automation%20practice-form/");

        // ждем 0,5 с
        Thread.sleep(500);

        // выбираем в поле "Continents" континент "Africa"
        new Select(drv.findElement(By.id("continents"))).selectByVisibleText("Africa");

        // ждем 3 с
        Thread.sleep(3000);

        // закрываем chromedriver.exe
        drv.quit();
    }
}
