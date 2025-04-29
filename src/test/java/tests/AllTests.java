package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.HomePage;
import pages.SignInPage;
import utils.ConfigurationReader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AllTests extends BaseTest{

    @Test
    public void loginTest(){

        HomePage homePage = new HomePage(context);
        homePage.acceptCookie();


        SignInPage signInPage = homePage.goToSignInPage();
        signInPage.login();

        boolean isSignedIn = homePage.isUserSignedIn();

        assertTrue(isSignedIn, "Пользователь не залогинен");
    }

    @Test
    public void wrongLoginTest() {

        HomePage homePage = new HomePage(context);
        homePage.acceptCookie();


        SignInPage signInPage = homePage.goToSignInPage();
        signInPage.wrongLogin();

        boolean isNotSignedIn = signInPage.isUserNotSignedIn();

        assertTrue(isNotSignedIn,"Пользователь залогинен");


    }

    @Test
    public void searchProductTest(){

        HomePage homePage = new HomePage(context);
        homePage.acceptCookie();

        String searchText = "Argus All-Weather Tank";
        homePage.search(searchText);

        String firstProductTitle = homePage.getFirstSearchResult().getText();
        assertTrue(firstProductTitle.contains(searchText), "Первый товар не соответствует поисковому запросу.");
    }

    @Test
    public void searchWrongProductTest(){

        HomePage homePage = new HomePage(context);
        homePage.acceptCookie();

        String searchText = "Футболка";
        homePage.search(searchText);

        String searchMessage = homePage.wrongSearchMessage.getText().trim();
        context.wait.until(ExpectedConditions.visibilityOf(homePage.wrongSearchMessage));
        assertEquals("Your search returned no results.", searchMessage);
    }
}
