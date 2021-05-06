package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static configs.PropertyReader.getURL;

public class Main extends BasePage {
    private final WebDriver webDriver;
    private final String ENDPOINT = "/admin/login";

    @FindBy(id = "UserLogin_username")
    private WebElement username;
    @FindBy(id = "UserLogin_password")
    private WebElement password;
    @FindBy(name = "yt0")
    private WebElement submitButton;

    public Main(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public Main fillInLogin(final String login) {
        utils.writeText(username, login);
        return this;
    }

    public Main fillInPassword(final String password) {
        utils.writeText(this.password, password);
        return this;
    }

    public Main loginButtonClick() {
        utils.click(submitButton);
        return this;
    }

    @Override
    public void load() {
        webDriver.get(getURL() + ENDPOINT);
    }

    @Override
    public void isLoaded() throws Error {
        Assert.assertEquals(webDriver.getCurrentUrl(), getURL() + ENDPOINT);
    }
}
