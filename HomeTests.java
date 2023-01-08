package tests;

import org.junit.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;

public class HomeTests extends BaseTest{

    public LoginPage loginPage;
    public HomePage homePage;

    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String expectedText ="PRODUCTS";

    int numberOfAllItemsOnHomePage = 6;

    String expectedTextYourCart ="YOUR CART";

    @Test
    public void verifySuccesfulAddedTwoProductsToCard(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccesfulLogin(expectedText);
        homePage.verifySuccesfulAddedTwoProductsToCard();

        try{
            Thread.sleep(5000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test
    public void verifyNumberOfAllItemsOnHomePage(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccesfulLogin(expectedText);
        homePage.numbersOfItems(numberOfAllItemsOnHomePage);

        try{
            Thread.sleep(5000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test
    public void verifySuccesfulLogout(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccesfulLogin(expectedText);
        homePage.clickOnHamburgerMenu();
        homePage.clickOnLogoutButton();
        loginPage.verfyLogout();

        try{
            Thread.sleep(5000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test
    public void verifySuccesfulYourCardPage(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccesfulLogin(expectedText);
        homePage.verifySuccesfulAddedTwoProductsToCard();
        homePage.clickOnShoppingCardBadgeTwoElements();
        checkoutPage.verifySuccesfulYourCartPage(expectedTextYourCart);

        try{
            Thread.sleep(5000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
