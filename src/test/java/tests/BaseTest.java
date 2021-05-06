package tests;

import configs.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.Main;

public class BaseTest extends DriverFactory {
    private Main main;
    private WebDriver webDriver;

    @BeforeTest
    public void inits() {
        PropertyReader.load();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        start();
        webDriver = getWebDriver();
        main = new Main(webDriver);
        main.load();
        main.isLoaded();
    }

    @AfterMethod(alwaysRun = true)
    public void quit() {
        finish();
    }
}
