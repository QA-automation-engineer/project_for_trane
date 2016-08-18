package angel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Vladimir on 28.02.2016.
 */
public class AngelPO
{
    static String masterXpath = "//input[@name=\"master\"]";
    static String pushButton = "//input[@value=\"Generate\"]";
    static String passwordXpath = "//input[@name=\"password\"]";
    static String siteXpath = "//input[@name=\"site\"]";

    public static void open(WebDriver drv, int delay) {
        drv.get("http://angel.net/~nic/passwd.current.html");
        try {
            Thread.sleep(delay*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setMaster(WebDriver drv, String master) {
        drv.findElement(By.xpath(masterXpath)).sendKeys(master);
    }

    public static String getMaster(WebDriver drv) {
       return drv.findElement(By.xpath(masterXpath)).getAttribute("value");
    }

    public static void setSite(WebDriver drv, String site)
    {
        drv.findElement(By.xpath(siteXpath)).sendKeys(site);
    }

    public static String getSite(WebDriver drv)
    {
        return drv.findElement(By.xpath(siteXpath)).getAttribute("value");
    }

    public static String getPassword(WebDriver drv)
    {
        return drv.findElement(By.xpath(passwordXpath)).getAttribute("value");
    }

    public static void pushButton(WebDriver drv)
    {
        drv.findElement(By.xpath(pushButton)).click();
    }

    public static String myRandom(int length)
    {
        String candidate = "~`1234567890-=!@#$%^&*()_+qwertyuiop[]asdfghjkl;'zxcvbnm,./QWERTYUIOP{}|ASDFGHJKL:ZXCVBNM<>?";
        StringBuilder out = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < length; i++)
        {
            // append - добавляет к тому, что есть то, что дает candidate.charAt, выбирая случайные символы из candidate
            out.append(candidate.charAt(random.nextInt(candidate.length())));
        }
        return out.toString();
    }

    public static String myInputPass(WebDriver drv, Integer i, Integer k)
    {
        String RandomMaster = AngelPO.myRandom(i);
        String RandomSite = AngelPO.myRandom(k);
        AngelPO.setMaster(drv, RandomMaster);
        AngelPO.setSite(drv, RandomSite);
        AngelPO.pushButton(drv);
        drv.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        return AngelPO.getPassword(drv);
    }
}
