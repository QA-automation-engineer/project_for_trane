import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Vladimir on 10.02.2016.
 */
public class dz3_p_7_2 {
    public static void main(String[] args) throws InterruptedException {

        // знакомим chromedriver.exe с IntelliJ IDEA
        System.setProperty("webdriver.chrome.driver", "D:\\Trane\\external\\chromedriver\\chromedriver.exe");

        // запускаем chromedriver.exe
        WebDriver drv = new ChromeDriver();

        // заходим на нужный сайт
        drv.get("http://angel.net/~nic/passwd.current.html");

        // создаем стринг урла сайта
        String url = "https://bitbucket.org/";

        // создаем стринг с паролем
        String pass = "Yferfevttnvyjujubnbr1986";

        // количество проверок
        int n = 100;

        // количество успешных проверок
        int k = 0;

        // объявляем стринг с зашифрованным паролем
        String[] res;
        res = new String[2];

        // первый прогон нужен для определения пароля, остальные - для проверки
        for (int i=0; i<=n; i++) {
            // ищем поля и вводим в них нужный текст
            drv.findElement(By.name("master")).sendKeys(pass);
            drv.findElement(By.name("site")).sendKeys(url);

            // ищем кнопку Generate и жмем на нее
            drv.findElement(By.xpath("//*[@value=\"Generate\"]")).click();

            // ждем 50 мс
            Thread.sleep(50);

            // ищем поле с новым паролем и получаем из него результат !!! заметим себе, что getText тут не работал((((
            res[1] = drv.findElement(By.name("password")).getAttribute("value");

            // забиваем первый результат как эталонный
            if (i==0) res[0]=res[1];

            // ждем 50 мс
            Thread.sleep(50);

            // чистим первые два поля
            drv.findElement(By.name("master")).clear();
            drv.findElement(By.name("site")).clear();
            drv.findElement(By.name("password")).clear();

            if (i>0  && res[1].equals(res[0])) {
                k++;
            }

        }

        // проверяем, что количество проверок и успешных тестов одинаковое
        if (k==n) {
            System.out.println("Сайт крутой, ибо не поломал");  // если +, то выводим "тест успешный"
        } else {                                                // закрываем иф и делаем элс
            System.out.println("Сайт - фуфло, ибо поломал");    // если 0, то выводим "тест неуспешный"
        }

        // закрываем chromedriver.exe
        drv.quit();
    }
}
