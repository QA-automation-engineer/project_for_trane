import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Vladimir on 31.01.2016.
 */
public class punkt_8_1 {
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

        // получаем ссылку и текст из второго результата поиска по запросу "ткачёв"
        String res1 = drv.findElement(By.xpath("//*[@id=\"rso\"]/div/div[2]/div/h3/a")).getAttribute("href");
        String res2 = drv.findElement(By.xpath("//*[@id=\"rso\"]/div/div[2]/div/h3/a")).getText();

            if (res2.length() >= 9) {                                                                   // проверка, что символов >= 9
                String subres2 = res2.substring(0, 9);                                                  // выделение первых 9-ти символов
                if (subres2.equals("Проповеди") && res1.equals("http://www.andreytkachev.com/")) {      // проверка есть ли вначале "Проповеди"
                    System.out.println("Тест успешный");                                                // если +, то вернуть "Тест успешный"
                }                                                                                       // закрываем вложеный иф
            } else {                                                                                    // закрываем внешний иф и делаем элс
                System.out.println("Тест неуспешный");                                                  // если +, то вернуть "Тест неуспешный"
            }

        // закрываем chromedriver.exe
        drv.quit();
    }
}