package angel;

import org.junit.*;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Vladimir on 02.03.2016.
 */

@RunWith(JUnit4.class)

//@RunWith(Suite.class)
//@Suite.SuiteClasses({TestPravoslavie1.class, TestPravoslavie2.class, TestPravoslavie3.class})

public class AngelTesting {

    static ChromeDriver drv;

    @BeforeClass
    public static void setUp()
    {
        // знакомим chromedriver.exe с IntelliJ IDEA
        System.setProperty("webdriver.chrome.driver", "D:\\Trane\\external\\chromedriver\\chromedriver.exe");
        // запускаем chromedriver.exe
        drv = new ChromeDriver();
    }

    @AfterClass
    public static void tearDown()
    {
        // закрываем chromedriver.exe
        drv.quit();
        // очищаем инициализацию chromedriver.exe
        drv = null;
    }

    @Test
    public void Test1()
    {
        AngelPO.open(drv, 1);
        AngelPO.setMaster(drv,"");
        AngelPO.setSite(drv,"angel.net");
        AngelPO.pushButton(drv);
        Assert.assertEquals("Тест-a завален!", "Is2nfhWTJLvq0@1a", AngelPO.getPassword(drv));
        System.out.println("Тест-а успешный!");
    }

    @Test
    public void Test2()
    {
        AngelPO.open(drv, 1);
        AngelPO.setMaster(drv,"asdasd");
        AngelPO.setSite(drv,"angel.net");
        AngelPO.pushButton(drv);
        Assert.assertEquals("Тест-б завален!", "B9ya7yayeK/Zn@1a", AngelPO.getPassword(drv));
        System.out.println("Тест-б успешный!");
    }

    @Test
    public void Test3()
    {
        AngelPO.open(drv, 1);
        String pass1 = AngelPO.myInputPass(drv, 10, 10);
        String pass2 = AngelPO.myInputPass(drv, 10, 10);
        Assert.assertNotEquals("Тест-в завален: пароли одинаковые!", pass1, pass2);
        System.out.println("Тест-в успешный!");
    }

    @Test
    public void Test4()
    {
        AngelPO.open(drv, 1);
        AngelPO.myInputPass(drv, 10, 10);
        String pass = AngelPO.getPassword(drv);
        Assert.assertNotNull("Тест-г завален: поле Password пустое!", pass);
        String master = AngelPO.getMaster(drv);
        Assert.assertNotNull("Тест-г завален: поле Master password пустое!", master);
        String site = AngelPO.getSite(drv);
        Assert.assertNotNull("Тест-г завален: поле Site пустое!", site);
        System.out.println("Тест-г успешный!");
    }
}
