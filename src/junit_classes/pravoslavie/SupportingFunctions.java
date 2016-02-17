package junit_classes.pravoslavie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Vladimir on 17.02.2016.
 */
public class SupportingFunctions {
    WebDriver drv;

    public SupportingFunctions(WebDriver drv)
    {
        this.drv = drv;
    }

    public void search(String request)
    {
        // ищем поисковое поле и вводим в него "request"
        drv.findElement(By.id("searchFormInput")).sendKeys(request);

        // ищем кнопку поиска и жмем на нее
        drv.findElement(By.xpath("//input[@value=\"Найти\"]")).click();
    }

    public void waitForSomeTime(int delay)
    {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
