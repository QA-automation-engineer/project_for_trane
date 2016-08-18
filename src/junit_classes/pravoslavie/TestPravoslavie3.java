package junit_classes.pravoslavie;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Vladimir on 19.02.2016.
 */
public class TestPravoslavie3 {

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

    @Before
    public void beforeEachTests()
    {
        // заходим на pravoslavie.ru
        drv.get("http://www.pravoslavie.ru/");
        // ждем 5 с
        drv.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void TestRuSearch()
    {
        HomePage home = new HomePage(drv);
        ResultPage result = (home.search("Ткачев"));

        WebDriverWait wait = new WebDriverWait(drv,30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchResults")));

        Assert.assertTrue("Не перешли на страницу с результатом поиска", drv.findElement(By.tagName("body")).getText().contains("Поиск по сайту"));

        // определяем количество статей, для которых указан автор
        int resultCount = result.getAllLinksbyAuthor().size();

        // формируем массив из статей, для которых указан автор
        List<WebElement> res = result.getAllLinksbyAuthor();

        // объявляем переменную для количества статей, у которых автор Ткачев
        int k = 0;

        // цикл проверки статей на авторство Ткачева
        for (int i=0; i<resultCount; i++)
        {
            // считаем количество результатов поиска с автором "Протоиерей Андрей Ткачев" или "Протојереј Андреј Ткачев"
            if (res.get(i).getText().equals("Протоиерей Андрей Ткачев") || res.get(i).getText().equals("Протојереј Андреј Ткачев"))
            {
                k++;
            }
        }

        // проверяем, что все авторские статьи принадлежат Ткачеву
        Assert.assertEquals("Количество статей, принадлежащих Ткачеву, и всего статей с автором - разное", resultCount, k);
        System.out.println("Expected (всего статей с автором): " + resultCount);
        System.out.println("Actual (статей, принадлежащих Ткачеву): " + k);
        System.out.println("Тест Ткачев-1 успешный!");
        System.out.println("");
    }

    @Test
    public void TestEnSearch()
    {
        HomePage home = new HomePage(drv);
        ResultPage result = home.search("Nrfxtd");
        Assert.assertTrue("Не перешли на страницу с результатом поиска", drv.findElement(By.tagName("body")).getText().contains("Поиск по сайту"));

        Assert.assertTrue("На поисковой запрос Nrfxtd есть результат", result.getAllLinksbyAuthor() == null);
        System.out.println("Expected: Ничего не нашлось :(");
        System.out.println("Actual: Ничего не нашлось :(");
        System.out.println("Тест Ткачев-2 успешный!");
        System.out.println("");
    }

    @Test
    public void TestPaperSearch()
    {
        HomePage home = new HomePage(drv);
        ResultPage result = home.search("НАЧИНКА И ОБОЛОЧКА");
        Assert.assertTrue("Не перешли на страницу с результатом поиска", drv.findElement(By.tagName("body")).getText().contains("Поиск по сайту"));

        Assert.assertEquals("Первый результат не НАЧИНКА И ОБОЛОЧКА", "НАЧИНКА И ОБОЛОЧКА", result.getAllLinksbyTitle().get(0).getText());
        System.out.println("Expected: Первый результат - НАЧИНКА И ОБОЛОЧКА");
        System.out.println("Actual: Первый результат - НАЧИНКА И ОБОЛОЧКА");
        System.out.println("Тест Ткачев-3 успешный!");
        System.out.println("");
    }
}
