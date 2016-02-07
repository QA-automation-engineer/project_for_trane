import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Vladimir on 31.01.2016.
 */
public class dz2 {
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
/**
        // получаем ссылку и текст из второго результата поиска по запросу "ткачёв"
        String res1 = drv.findElement(By.xpath("//*[@id=\"rso\"]/div/div[2]/div/h3/a")).getAttribute("href");
        String res2 = drv.findElement(By.xpath("//*[@id=\"rso\"]/div/div[2]/div/h3/a")).getText();

        int dem=res2.length();                                                                          // определение количества символов
            if (dem>=9) {                                                                               // проверка, что символов >= 9
                String subres2 = res2.substring(0, 9);                                                  // выделение первых 9-ти символов
                if (subres2.equals("Проповеди") && res1.equals("http://www.andreytkachev.com/")) {      // проверка есть ли вначале "Проповеди"
                    System.out.println("Тест успешеный");                                               // если +, то вернуть "Тест успешеный"
                }                                                                                       // закрываем вложеный иф
            } else {                                                                                    // закрываем внешний иф и делаем элс
                System.out.println("Тест неуспешный");                                                  // если +, то вернуть "Тест неуспешный"
            }

**/     /**
        String[] res;
        res = new String[10];
        for (int i=0; i<10; i++) {
            res[i] = drv.findElement(By.xpath("//*[@id=\"rso\"]/div/div[" + (i+1) + "]/div/h3/a")).getAttribute("href");
            Thread.sleep(100);
            System.out.println(res[i]);
        }**/
/**
        String res1 = drv.findElement(By.xpath("//*[@id=\"rso\"]/div/div[1]/div/h3/a")).getAttribute("href");
        String res2 = drv.findElement(By.xpath("//*[@id=\"rso\"]/div/div[2]/div/h3/a")).getAttribute("href");
        String res3 = drv.findElement(By.xpath("//*[@id=\"rso\"]/div/div[3]/div/h3/a")).getAttribute("href");
        String res4 = drv.findElement(By.xpath("//*[@id=\"rso\"]/div/div[4]/div/h3/a")).getAttribute("href");
        String res5 = drv.findElement(By.xpath("//*[@id=\"rso\"]/div/div[5]/div/h3/a")).getAttribute("href");
        String res6 = drv.findElement(By.xpath("//*[@id=\"rso\"]/div/div[6]/div/h3/a")).getAttribute("href");
        String res7 = drv.findElement(By.xpath("//*[@id=\"rso\"]/div/div[7]/div/h3/a")).getAttribute("href");
        String res8 = drv.findElement(By.xpath("//*[@id=\"rso\"]/div/div[8]/div/h3/a")).getAttribute("href");
        String res9 = drv.findElement(By.xpath("//*[@id=\"rso\"]/div/div[9]/div/h3/a")).getAttribute("href");
        String res10 = drv.findElement(By.xpath("//*[@id=\"rso\"]/div/div[10]/div/h3/a")).getAttribute("href");
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
        System.out.println(res5);
        System.out.println(res6);
        System.out.println(res7);
        System.out.println(res8);
        System.out.println(res9);
        System.out.println(res10);
**/
        // закрываем chromedriver.exe
        drv.quit();
    }
}
// (//h3[@class='r']/a)[2]
//<a href="http://www.andreytkachev.com/" onmousedown="return rwt(this,'','','','2','AFQjCNEgpqWhO0iR1G1kSjQo6YN2atfFww','WxZ6vNFzvS1TQtC46UlMlg','0ahUKEwihwabc_dTKAhUI_HIKHdxOADQQFgggMAE','','',event)">Проповеди протоиерея Андрея Ткачёва</a>