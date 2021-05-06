package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Utils extends Waits {

    public Utils(WebDriver webDriver) {
        super(webDriver);
    }

    public static boolean isSorted(final List<WebElement> listOfStrings) {
        List<String> items = new LinkedList<>();
        for (WebElement item : listOfStrings) {
            items.add(item.getText());
        }
        Iterator<String> iter = items.iterator();
        String current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next();
            if (previous.compareTo(current) > 0) {
                return false;
            }
            previous = current;
        }
        return true;
    }

    public void click(final WebElement elementBy) {
        waitVisibility(elementBy);
        elementBy.click();
    }

    public void clickItemByTitle(final List<WebElement> elements, final String title) {
        waitVisibility(elements);
        for (WebElement element : elements) {
            if (element.getText().equals(title)) {
                element.click();
                break;
            }
        }
    }

    //Is Element located By  Displayed
    public void isElementDisplayed(final WebElement elementBy) {
        waitVisibility(elementBy);
        Assert.assertTrue(elementBy.isDisplayed());
    }


    //Write Text in field located By
    public void writeText(final WebElement elementBy, final String text) {
        waitVisibility(elementBy);
        elementBy.clear();
        elementBy.sendKeys(text);
    }
}
