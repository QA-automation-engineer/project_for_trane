import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Vladimir on 10.02.2016.
 */
public class dz3_p_7_1 {
    public static void main(String[] args) throws InterruptedException {

        // знакомим chromedriver.exe с IntelliJ IDEA
        System.setProperty("webdriver.chrome.driver", "D:\\Trane\\external\\chromedriver\\chromedriver.exe");

        // запускаем chromedriver.exe
        WebDriver drv = new ChromeDriver();

        // заходим на нужный сайт
        drv.get("http://angel.net/~nic/passwd.current.html");

        // создаем стринговый массив урлами сайтов
        String[] urls;
        urls = new String[5];
        urls[0] = "https://mail.ru/";
        urls[1] = "http://codingbat.com/";
        urls[2] = "http://toolsqa.com/";
        urls[3] = "https://github.com/";
        urls[4] = "https://bitbucket.org/";

        // создаем стринговый массив с паролями
        String[] pass;
        pass = new String[5];
        pass[0] = "Smith19880425";
        pass[1] = "Cvbn19880425";
        pass[2] = "Cvbn19880425";
        pass[3] = "Cvbn19880425";
        pass[4] = "Yferfevttnvyjujubnbr1986";

        // объявляем стринговый массив с зашифрованными паролями
        String[] res;
        res = new String[5];

        //
        for (int i=0; i<5; i++) {
            // ищем поля и вводим в них нужный текст
            drv.findElement(By.name("master")).sendKeys(pass[i]);
            drv.findElement(By.name("site")).sendKeys(urls[i]);

            // ищем кнопку Generate и жмем на нее
            drv.findElement(By.xpath("//*[@value=\"Generate\"]")).click();

            // ждем 500 мс
            Thread.sleep(500);

            // ищем поле с новым паролем и получаем из него результат !!! заметим себе, что getText тут не работал((((
            res[i] = drv.findElement(By.name("password")).getAttribute("value");

            // ждем 500 мс
            Thread.sleep(500);

            // чистим первые два поля
            drv.findElement(By.name("master")).clear();
            drv.findElement(By.name("site")).clear();
            drv.findElement(By.name("password")).clear();

            System.out.println("Название " + (i+1) + "-го сайта: " + urls[i]);
            System.out.println("Зашифрованный пароль: " + res[i]);

            // ждем 500 мс
            Thread.sleep(500);

        }
        // закрываем chromedriver.exe
        drv.quit();
    }
}
