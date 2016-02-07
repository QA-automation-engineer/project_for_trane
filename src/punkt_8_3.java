import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Vladimir on 02.02.2016.
 */
public class punkt_8_3 {
    public static void main(String[] args) throws InterruptedException {

        // знакомим chromedriver.exe с IntelliJ IDEA
        System.setProperty("webdriver.chrome.driver", "D:\\Trane\\external\\chromedriver\\chromedriver.exe");

        // запускаем chromedriver.exe
        WebDriver drv = new ChromeDriver();

        // заходим в гугл
        drv.get("https://translate.google.com/#ru/en");

        // создаем стринговый массив переводимых слов
        String[] text;
        text = new String[3];
        text[0] = "товарищ";
        text[1] = "привет";
        text[2] = "пока";

        // создаем стринговый массив с эталонными результатами перевода
        String[] rese;
        rese = new String[3];
        rese[0] = "comrade";
        rese[1] = "Hi";
        rese[2] = "till";

        // объявляем стринговый массив для результатов перевода
        String[] res;
        res = new String[3];

        //
        for (int i=0; i<3; i++) {
            // ищем поисковое поле гугл-переводчика и вводим текст для перевода
            drv.findElement(By.id("source")).sendKeys(text[i]);

            // ждем 1000 мс
            Thread.sleep(1000);

            // ищем поле с переводом и получаем оттуда результат перевода
            res[i] = drv.findElement(By.id("result_box")).getText();

            // ждем 1000 мс
            Thread.sleep(1000);

            // ищем поисковое поле гугл-переводчика чистим его
            drv.findElement(By.id("source")).clear();

            System.out.println("ER: " + rese[i]);
            System.out.println("AR: " + res[i]);

            if (rese[i].equals(res[i])) {
                System.out.println("Тест " + (i+1) + "-й успешный");     // если +, то вернуть "Тест (i+1) успешный"
            } else {                                                     // закрываем иф и делаем элс
                System.out.println("Тест " + (i+1) + "-й неуспешный");   // если -, то вернуть "Тест (i+1) неуспешный"
            }
        }
        // закрываем chromedriver.exe
        drv.quit();
    }
}
