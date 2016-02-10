import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Vladimir on 31.01.2016.
 */
public class punkt_8_2_old {
    public static void main(String[] args) throws InterruptedException {

        // знакомии chromedriver.exe � IntelliJ IDEA
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

        // ждем 1000 мс
        Thread.sleep(1000);

        // объявляем стринговый массив для ссылок
        String[] res;
        res = new String[10];

	    // грабим и выводим ссылки
        for (int i=0; i<10; i++) {
            res[i] = drv.findElement(By.xpath("//*[@id=\"rso\"]/div/div[" + (i+1) + "]/div/h3/a")).getAttribute("href");
            Thread.sleep(300);
            System.out.println((i+1) + "-я ссылка: " + res[i]);
        }
        if (!res[9].isEmpty()) {
            System.out.println("тест успешный");     // если +, то выводим "тест успешный"
        } else {                                     // закрываем иф и делаем элс
            System.out.println("тест неуспешный");   // если 0, то выводим "тест неуспешный"
        }
        // закрываем chromedriver.exe
        drv.quit();
    }
}