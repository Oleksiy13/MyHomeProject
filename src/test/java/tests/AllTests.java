package tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.CartPage;
import pages.HomePage;
import pages.JacketPage;
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

    @Test
    public void addToCartTest(){

        HomePage homePage = new HomePage(context);
        homePage.acceptCookie();
        JacketPage jacketPage = homePage.goToJacketPage();
        jacketPage.addToCart();

        CartPage cartPage = new CartPage(context);
        String expectedProductName = "Montana Wind Jacket";


        Assert.assertTrue("Not on cart page", cartPage.isOnCartPage());
        Assert.assertTrue("Product is not in the cart", cartPage.isCorrectProductInCart(expectedProductName));

    }

    //*[contains(text(), 'Proteus')]/ancestor::li//button
}
