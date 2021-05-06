package tests;

import io.qameta.allure.Description;
import listener.CustomListener;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Dashboard;
import pages.PlayersPage;
import steps.LoginSteps;

import static configs.PropertyReader.getPassword;
import static configs.PropertyReader.getUsername;

@Listeners(CustomListener.class)
public class PlayersTests extends BaseTest {

    private Dashboard dashboard;
    private WebDriver webDriver;
    private LoginSteps loginSteps;
    private PlayersPage playersPage;

    @BeforeMethod
    public void init() {
        webDriver = getWebDriver();
        dashboard = new Dashboard(webDriver);
        loginSteps = new LoginSteps(webDriver);
        playersPage = new PlayersPage(webDriver);
        loginSteps.loginStep(getUsername(), getPassword());
        dashboard.isLoaded();
    }

    @Test
    @Description(value = "")
    public void test1() {
        dashboard.chooseNavigationItemFromTheListByTitle("Users")
                .chooseUsersItemFromTheListByTitle("Players");

        playersPage.isLoaded();
    }

    @Test
    @Description(value = "")
    public void test2() {
        playersPage.load();
        playersPage.sortByUsername();
        Assert.assertTrue(playersPage.isTableSortedByUsername(), "The table isn't sorted correct");
    }

}
