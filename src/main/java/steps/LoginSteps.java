package steps;

import org.openqa.selenium.WebDriver;
import pages.Main;

public class LoginSteps {
    private Main main;

    public LoginSteps(WebDriver driver) {
        main = new Main(driver);
    }

    public void loginStep(final String username, final String password) {
        main.fillInLogin(username)
                .fillInPassword(password)
                .loginButtonClick();
    }

}
