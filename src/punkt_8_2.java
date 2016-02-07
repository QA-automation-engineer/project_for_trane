import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Created by Vladimir on 31.01.2016.
 */
public class punkt_8_2 {
    public static void main(String[] args) throws InterruptedException {

        // знакомим chromedriver.exe с IntelliJ IDEA
        System.setProperty("webdriver.chrome.driver", "D:\\Trane\\external\\chromedriver\\chromedriver.exe");

        // запускаем chromedriver.exe
        WebDriver drv = new ChromeDriver();

        // заходим в гугл
        drv.get("https://www.google.com.ua");

        // ищем поисковое поле гугла и вводим для поиска "ткачёв"
        drv.findElement(By.id("lst-ib")).sendKeys("ткачёв");

        // ждем 1000 мс
        Thread.sleep(1000);

        // ищем кнопку поиск и жмем на нее
        drv.findElement(By.xpath("//body//button[@value=\"Поиск\"]")).click();

        // ждем 3000 мс
        Thread.sleep(1000);

        // определяем количество ссылок на странице с результатами поиска
        int urlsCount = drv.findElements(By.xpath("//*[@id=\"rso\"]/div/div/div/h3/a")).size();

        // формируем массив с результатами поиска
        List<WebElement> urls = drv.findElements(By.xpath("//*[@id=\"rso\"]/div/div/div/h3/a"));

        // ждем 1 с
        Thread.sleep(1000);

        // цикл на вывод ссылок
        for (int i=0; i<urlsCount; i++) {

            // пауза 300 мс перед выводом
            Thread.sleep(300);

            // вывод (i+1)-ой ссылки
            System.out.println((i+1) + "-я ссылка: " + urls.get(i).getAttribute("href"));
        }

        // закрываем chromedriver.exe
        drv.quit();
    }
}