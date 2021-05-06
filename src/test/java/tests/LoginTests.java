package tests;

import io.qameta.allure.Description;
import listener.CustomListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Dashboard;
import pages.Main;

import static configs.PropertyReader.getPassword;
import static configs.PropertyReader.getUsername;

@Listeners(CustomListener.class)
public class LoginTests extends BaseTest {

    private Main main;
    private Dashboard dashboard;
    private WebDriver webDriver;

    @BeforeMethod
    public void init() {
        webDriver = getWebDriver();
        main = new Main(webDriver);
        dashboard = new Dashboard(webDriver);
    }

    @Test
    @Description(value = "")
    public void test1() {
        main.fillInLogin(getUsername())
                .fillInPassword(getPassword())
                .loginButtonClick();
        System.out.println();
        dashboard.isLoaded();
    }
}
