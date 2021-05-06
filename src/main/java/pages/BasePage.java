package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import utils.Utils;

public abstract class BasePage extends LoadableComponent {
    protected Utils utils;

    public BasePage(WebDriver webDriver) {
        utils = new Utils(webDriver);
    }
}