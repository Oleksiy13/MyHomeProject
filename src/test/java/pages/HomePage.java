package pages;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(TestContext context) {
        super(context);
    }

    @FindBy(css = "div.header a[href*='/customer/account/login']")
    public WebElement signInButton;

    @FindBy(css = "#search")
    public WebElement searchInput;

    @FindBy(css = "a.action.showcart")
    public WebElement cartButton;

    @FindBy(css = "#ui-id-8")
    public WebElement saleButton;

    @FindBy(css = "#accept-btn")
    public WebElement acceptCookieButton;

    @FindBy(xpath = "(//span[@class='logged-in'])[1]")
    public WebElement welcomeMessage;

    public void acceptCookie() {
        try {
            context.wait.until(ExpectedConditions.elementToBeClickable(acceptCookieButton));
            acceptCookieButton.click();
        } catch (Exception e) {
            System.out.println("Окно куки не появилось");
        }
    }

    public SignInPage goToSignInPage(){
        signInButton.click();
        return new SignInPage(context);
    }

    public boolean isUserSignedIn(){
        try {
            context.wait.until(ExpectedConditions.visibilityOf(welcomeMessage));
            return welcomeMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
