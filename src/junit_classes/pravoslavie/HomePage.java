package junit_classes.pravoslavie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Vladimir on 19.02.2016.
 */
public class HomePage
{

    private WebDriver drv;

    public HomePage(ChromeDriver drv)
    {
        this.drv = drv;
    }

    public ResultPage search(String request)
    {
        // ищем поисковое поле и вводим в него "request"
        drv.findElement(By.id("searchFormInput")).sendKeys(request);

        // ищем кнопку поиска и жмем на нее
        drv.findElement(By.className("block-search__submit")).click();
        return new ResultPage(drv);
    }
}
