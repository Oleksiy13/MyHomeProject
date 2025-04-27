package pages;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ConfigurationReader;

public class SignInPage extends BasePage{
    public SignInPage(TestContext context) {
        super(context);
    }

    @FindBy(css = "#email")
    public WebElement email;

    @FindBy(css = "input[name='login[password]']")
    public WebElement password;

    @FindBy(css = "button.action.login.primary")  // Кнопка Sign In
    public WebElement signInButton;

    public HomePage login(){

        email.sendKeys(ConfigurationReader.get("userName"));
        password.sendKeys(ConfigurationReader.get("userPassword"));
        signInButton.click();
        return new HomePage(context);
    }
}
