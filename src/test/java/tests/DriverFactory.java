package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static configs.PropertyReader.getBrowser;


public class DriverFactory {

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public void start() {
        if (getWebDriver() == null) {
            switch (System.getProperty("browser", getBrowser())) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    drivers.set(new ChromeDriver(new ChromeOptions().addArguments("kiosk")));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    drivers.set(new FirefoxDriver((new FirefoxOptions().addArguments("--start-maximized"))));
                    System.out.println();
                    break;
            }
        }
    }

    public static WebDriver getWebDriver() {
        return drivers.get();
    }

    public void finish() {
        getWebDriver().quit();
        drivers.remove();
    }

}
