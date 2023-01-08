package tests;

import org.junit.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;

public class CheckoutTests extends BaseTest{
    public LoginPage loginPage;
    public HomePage homePage;

    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String expectedText ="PRODUCTS";
    String expectedTextYourCart ="YOUR CART";

    String expectedInformationTitleText ="CHECKOUT: YOUR INFORMATION";

    String firstName = "Pera";
    String lastName = "Peric";
    String postalCode = "000";
    
    //String expectedOverviewText = "CHECKOUT: OVERVIEW";
    String expectedItem1 = "Sauce Labs Backpack";
    String expectedItem2 = "Sauce Labs Bike Light";

    Double expectedTotalPrice = 43.18;

    String expectedEndedMessage ="THANK YOU FOR YOUR ORDER";


    @Test
    public void verifySuccesfulYourInformationPage(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccesfulLogin(expectedText);

        homePage.verifySuccesfulAddedTwoProductsToCard();
        homePage.clickOnShoppingCardBadgeTwoElements();
        checkoutPage.verifySuccesfulYourCartPage(expectedTextYourCart);
        checkoutPage.clickOnCheckoutButton();
        checkoutPage.verifySuccesfulYourInformationPage(expectedInformationTitleText);

        try{
            Thread.sleep(5000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }

    }

    @Test
    public void verifySuccesfulCheckoutFilds(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccesfulLogin(expectedText);

        homePage.verifySuccesfulAddedTwoProductsToCard();
        homePage.clickOnShoppingCardBadgeTwoElements();
        checkoutPage.verifySuccesfulYourCartPage(expectedTextYourCart);
        checkoutPage.clickOnCheckoutButton();
        checkoutPage.verifySuccesfulYourInformationPage(expectedInformationTitleText);
        checkoutPage.verifyCheckoutFilds(firstName, lastName, postalCode);
        
        try{
            Thread.sleep(5000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }

    }

    @Test
    public void verifyTotalCheckoutTotalPrice(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccesfulLogin(expectedText);

        homePage.verifySuccesfulAddedTwoProductsToCard();
        homePage.clickOnShoppingCardBadgeTwoElements();
        checkoutPage.verifySuccesfulYourCartPage(expectedTextYourCart);
        checkoutPage.clickOnCheckoutButton();
        checkoutPage.verifySuccesfulYourInformationPage(expectedInformationTitleText);
        checkoutPage.verifyCheckoutFilds(firstName, lastName, postalCode);
        checkoutPage.clickOnContinueButtonOnCheckoutFilds();
        checkoutPage.verifySuccesfulOverviewPage(expectedItem1, expectedItem2);
        //checkoutPage.verifyTotalPrice(expectedTotalPrice);
        checkoutPage.vvverifyTotalPrice(expectedTotalPrice);
        
        try{
            Thread.sleep(5000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }

    }

    @Test
    public void verifySuccesfulEndedMessage(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccesfulLogin(expectedText);

        homePage.verifySuccesfulAddedTwoProductsToCard();
        homePage.clickOnShoppingCardBadgeTwoElements();
        checkoutPage.verifySuccesfulYourCartPage(expectedTextYourCart);
        checkoutPage.clickOnCheckoutButton();
        checkoutPage.verifySuccesfulYourInformationPage(expectedInformationTitleText);
        checkoutPage.verifyCheckoutFilds(firstName, lastName, postalCode);
        checkoutPage.clickOnContinueButtonOnCheckoutFilds();
        checkoutPage.verifySuccesfulOverviewPage(expectedItem1, expectedItem2);
        checkoutPage.clickOnFinishButton();
        checkoutPage.verifySuccesEndedMessage(expectedEndedMessage);

        try{
            Thread.sleep(5000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
