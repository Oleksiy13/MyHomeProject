package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.HomePage;
import pages.SignInPage;
import utils.ConfigurationReader;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AllTests extends BaseTest{

    @Test
    public void loginTest(){
        context.driver.get(ConfigurationReader.get("url"));

        HomePage homePage = new HomePage(context);
        homePage.acceptCookie();

        SignInPage signInPage = homePage.goToSignInPage();
        signInPage.login();

        boolean isSignedIn = homePage.isUserSignedIn();

        assertTrue(isSignedIn, "Пользователь не залогинен");
    }
}
