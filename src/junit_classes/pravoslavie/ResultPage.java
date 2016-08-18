package junit_classes.pravoslavie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Created by Vladimir on 19.02.2016.
 */
public class ResultPage {

    private WebDriver drv;

    public ResultPage(WebDriver drv)
    {
        this.drv = drv;
    }

    public List<WebElement> getAllLinksbyAuthor()
    {
        ResultPage.waitForSomeTime(5000);
        if (!drv.findElement(By.id("searchResults")).getText().contains("Ничего не нашлось :("))
        {
            return drv.findElements(By.className("block-publications__author"));
        }
        return null;
    }

    public List<WebElement> getAllLinksbyTitle()
    {
        //ResultPage.waitForSomeTime(5000);
        if (!drv.findElement(By.id("searchResults")).getText().contains("Ничего не нашлось :("))
        {
            return drv.findElements(By.className("block-publications__title"));
        }
        return null;
    }

    public static void waitForSomeTime(int delay)
    {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
