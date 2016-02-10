import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Created by Vladimir on 10.02.2016.
 */
public class dz3_p_1_1 {
    public static void main(String[] args) throws InterruptedException {

        // знакомим chromedriver.exe с IntelliJ IDEA
        System.setProperty("webdriver.chrome.driver", "D:\\Trane\\external\\chromedriver\\chromedriver.exe");

        // запускаем chromedriver.exe
        WebDriver drv = new ChromeDriver();

        // заходим на сайт с исследуемой формой
        drv.get("http://toolsqa.com/automation%20practice-form/");

        // определяем количество линков в форме
        int urlsCount = drv.findElements(By.xpath("//body//fieldset//a")).size();

        // формируем массив с результатами поиска
        List<WebElement> urls = drv.findElements(By.xpath("//body//fieldset//a"));

        // ждем 0,5 с
        Thread.sleep(500);

        // цикл на вывод линков
        for (int i=0; i<urlsCount; i++) {

            // пауза 300 мс перед выводом
            Thread.sleep(300);

            // вывод (i+1)-ого линкка
            System.out.println((i+1) + "-й линк: " + urls.get(i).getText());
        }

        // закрываем chromedriver.exe
        drv.quit();
    }
}
