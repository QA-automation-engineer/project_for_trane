package junit_classes.pravoslavie;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Vladimir on 14.02.2016.
 */
public class PageResults {
    @FindBy(xpath = "//body//ul[@class=\"block-publications__items\"]//li")
    WebElement results;
}
