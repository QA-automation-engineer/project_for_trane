package junit_classes.pravoslavie;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Created by Vladimir on 14.02.2016.
 */
public class TestPravoslavie {

    // создаем статическую переменную класса WebDriver
    static WebDriver drv;

    // перед началом всех тестов инициализируем chromedriver.exe и заходим на pravoslavie.ru
    @BeforeClass
    public static void setUp()
    {
        // знакомим chromedriver.exe с IntelliJ IDEA
        System.setProperty("webdriver.chrome.driver", "D:\\Trane\\external\\chromedriver\\chromedriver.exe");

        // запускаем chromedriver.exe
        drv = new ChromeDriver();

        // заходим на pravoslavie.ru
        drv.get("http://www.pravoslavie.ru/");
    }

    // после всех тестов закрываем chromedriver.exe и очищаем его инициализацию
    @AfterClass
    public static void afterAllTests()
    {
        // закрываем chromedriver.exe
        drv.quit();

        // очищаем инициализацию chromedriver.exe
        drv = null;
    }

    // после каждого теста чистим поисковое поле
    @After
    public void afterEachTests()
    {
        // ищем поисковое поле и чистим его
        drv.findElement(By.id("searchFormInput")).clear();
    }

    // тест ищет результаты по запросу "Ткачев" и проверяет, что все статьи с авторами принадлежат Ткачеву
    //@Ignore
    @Test
    public void TestRuSearch() throws InterruptedException
    {
        // ищем поисковое поле и вводим в него "Ткачев"
        drv.findElement(By.id("searchFormInput")).sendKeys("Ткачев");

        // ищем кнопку поиска и жмем на нее
        drv.findElement(By.xpath("//input[@value=\"Найти\"]")).click();

        // проверяем, что произошел переход на страницу с результатом поиска
        Assert.assertEquals("Не произошел переход на страницу с результатом поиска", "Поиск по сайту", drv.findElement(By.xpath("//body//h1")).getText());

        // сообщаем, что произошел переход на страницу с результатом поиска
        System.out.println("Произошел переход на страницу с результатом поиска");

        Thread.sleep(1000);

        // определяем количество статей, для которых указан автор
        int resultCount = drv.findElements(By.xpath("//body//ul//li//span[@class=\"block-publications__author\"]")).size();

        // формируем массив из статей, для которых указан автор
        List<WebElement> res = drv.findElements(By.xpath("//body//ul//li//span[@class=\"block-publications__author\"]"));

        // количество результатов, удовлетворяющих критерию(-ям)
        int k = 0;

        // цикл на проверку соответствия каждого результата критерию(-ям)
        for (int i=0; i<resultCount; i++)
        {
            // считаем количество результатов поиска с автором "Протоиерей Андрей Ткачев" или "Протојереј Андреј Ткачев"
            if (res.get(i).getText().equals("Протоиерей Андрей Ткачев") || res.get(i).getText().equals("Протојереј Андреј Ткачев"))
            {
                k++;
            }
        }

        // проверяем, что все авторские статьи принадлежат искомому автору
        Assert.assertEquals("Количество статей, принадлежащих Ткачеву, и всего статей с автором - разное", resultCount, k);
        System.out.println("Expected (всего статей с автором): " + resultCount);
        System.out.println("Actual (статей, принадлежащих Ткачеву): " + k);
        System.out.println("Тест Ткачев-1 успешный!");
        System.out.println("");
    }

    // Тест проверяет, что по запросу "Nrfxtd" (Ткачев) нет результатов поиска
    //@Ignore
    @Test
    public void TestEnSearch() throws InterruptedException
    {
        // ищем поисковое поле и вводим в него "Nrfxtd"
        drv.findElement(By.id("searchFormInput")).sendKeys("Nrfxtd");

        // ищем кнопку поиска и жмем на нее
        drv.findElement(By.xpath("//input[@value=\"Найти\"]")).click();

        // проверяем, что произошел переход на страницу с результатом поиска
        Assert.assertEquals("Не произошел переход на страницу с результатом поиска", "Поиск по сайту", drv.findElement(By.xpath("//body//h1")).getText());

        // сообщаем, что произошел переход на страницу с результатом поиска
        System.out.println("Произошел переход на страницу с результатом поиска");

        Thread.sleep(1000);

        // проверяем, что по запросу "Nrfxtd" ничего не найдено
        Assert.assertEquals("На поисковой запрос Nrfxtd есть результат", "Ничего не нашлось :(", drv.findElement(By.className("block-publications__nofind")).getText());
        System.out.println("Expected: Ничего не нашлось :(");
        System.out.println("Actual: Ничего не нашлось :(");
        System.out.println("Тест Ткачев-2 успешный!");
        System.out.println("");
    }

    // тест проверяет, что по запросу "НАЧИНКА И ОБОЛОЧКА" сайт первым результатом выдает искомую статью
    //@Ignore
    @Test
    public void TestPaperSearch() throws InterruptedException
    {
        // ищем поисковое поле и вводим в него "НАЧИНКА И ОБОЛОЧКА"
        drv.findElement(By.id("searchFormInput")).sendKeys("НАЧИНКА И ОБОЛОЧКА");

        // ищем кнопку поиска и жмем на нее
        drv.findElement(By.xpath("//input[@value=\"Найти\"]")).click();

        // проверяем, что произошел переход на страницу с результатом поиска
        Assert.assertEquals("Не произошел переход на страницу с результатом поиска", "Поиск по сайту", drv.findElement(By.xpath("//body//h1")).getText());

        // сообщаем, что произошел переход на страницу с результатом поиска
        System.out.println("Произошел переход на страницу с результатом поиска");

        Thread.sleep(1000);

        // проверяем, что по запросу "НАЧИНКА И ОБОЛОЧКА" первый результат поиска одноименный
        Assert.assertEquals("По поисковому запросу НАЧИНКА И ОБОЛОЧКА первый результат не одноименный", "НАЧИНКА И ОБОЛОЧКА", drv.findElement(By.className("block-publications__title")).getText());
        System.out.println("Expected: Первый результат - НАЧИНКА И ОБОЛОЧКА");
        System.out.println("Actual: Первый результат - НАЧИНКА И ОБОЛОЧКА");
        System.out.println("Тест Ткачев-3 успешный!");
        System.out.println("");
    }
}
