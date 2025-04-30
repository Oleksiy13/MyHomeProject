package pages;

import context.TestContext;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ConfigurationReader;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage(TestContext context) {
        super(context);
    }

    @FindBy(css = "#accept-btn")
    public WebElement acceptCookieButton;

    @FindBy(css = "div.header a[href*='/customer/account/login']")
    public WebElement signInButton;

    @FindBy(css = "//header//a[text()='Create an Account']")
    public WebElement createAccountButton;


    @FindBy(css = "a.action.showcart")
    public WebElement cartButton;

    @FindBy(css = "#ui-id-8")
    public WebElement saleButton;

    @FindBy(xpath = "(//span[@class='logged-in'])[1]")
    public WebElement welcomeMessage;

    @FindBy(css = "#search")
    public WebElement searchField;

    @FindBy(css = ".product-item")
    public List<WebElement> searchResults;

    @FindBy(css = ".page-title-wrapper")
    public WebElement searchMessage;

    @FindBy(xpath = "//div[@class='message notice']//div[contains(text(), 'Your search returned no results')]")
    public WebElement wrongSearchMessage;

    @FindBy(css = "#ui-id-5")
    public WebElement menButton;


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

    public HomePage search(String searchText){
        searchField.click();
        searchField.sendKeys(searchText);
        searchField.sendKeys(Keys.ENTER);
        context.wait.until(ExpectedConditions.visibilityOfAllElements(searchMessage));
        return this;
    }

    public WebElement getFirstSearchResult(){
        new Actions(context.driver).scrollToElement(searchResults.get(0)).perform();
        context.wait.until(ExpectedConditions.visibilityOfAllElements(searchResults));
        return searchResults.get(0);
    }

    public JacketPage goToJacketPage(){
        context.driver.get(ConfigurationReader.get("productUrl"));
        return new JacketPage(context);
    }
}
