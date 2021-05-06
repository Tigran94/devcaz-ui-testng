package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Waits {
    public WebDriverWait wait;

    public Waits(WebDriver webDriver) {
        wait = new WebDriverWait(webDriver, 30);
    }

    public void waitVisibility(final WebElement elementBy) {
        wait.until(ExpectedConditions.visibilityOf(elementBy));
    }

    public void waitVisibility(final List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void writeText(final WebElement elementBy, final String text) {
        waitVisibility(elementBy);
        elementBy.clear();
        elementBy.sendKeys(text);
    }

    public void waitForJQueryToLoad() {
        ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
        wait.until(jQueryLoad);
    }

}
