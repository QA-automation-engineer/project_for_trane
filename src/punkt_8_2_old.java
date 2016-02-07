import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Vladimir on 31.01.2016.
 */
public class punkt_8_2_old {
    public static void main(String[] args) throws InterruptedException {

        // �������� chromedriver.exe � IntelliJ IDEA
        System.setProperty("webdriver.chrome.driver", "D:\\Trane\\external\\chromedriver\\chromedriver.exe");

        // ��������� chromedriver.exe
        WebDriver drv = new ChromeDriver();

        // ������� � ����
        drv.get("https://www.google.com.ua");

        // ���� ��������� ���� ����� � ������ ��� ������ "������"
        drv.findElement(By.id("lst-ib")).sendKeys("������");

        // ���� 1000 ��
        Thread.sleep(1000);

        // ���� ������ ����� � ���� �� ���
        drv.findElement(By.xpath("//body//button[@value=\"�����\"]")).click();

        // ���� 3000 ��
        Thread.sleep(1000);

        String[] res;
        res = new String[10];

	// 
        for (int i=0; i<10; i++) {
            res[i] = drv.findElement(By.xpath("//*[@id=\"rso\"]/div/div[" + (i+1) + "]/div/h3/a")).getAttribute("href");
            Thread.sleep(300);
            System.out.println((i+1) + "-� ������: " + res[i]);
        }
        if (!res[9].isEmpty()) {
            System.out.println("���� ��������");     // ���� +, �� ������� "���� ��������"
        } else {                                     // ��������� �� � ������ ���
            System.out.println("���� ����������");   // ���� -, �� ������� "���� ����������"
        }
        // ��������� chromedriver.exe
        drv.quit();
    }
}