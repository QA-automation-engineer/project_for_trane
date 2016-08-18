package junit_classes.pravoslavie;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Vladimir on 14.02.2016.
 */
public class PageSearch {

    @FindBy(id = "searchFormInput")
    static WebElement searchField;

    @FindBy(xpath = "//input[@value=\"Найти\"]")
    static WebElement searchButton;

    public static void sendKeysValuesToSearchField(String values) {
        searchField.sendKeys(values);
    }

    public static void clickSearchButton() {
        searchButton.click();
    }
}
