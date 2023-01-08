package tests;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest{

    public LoginPage loginPage;

    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String expectedText ="PRODUCTS";

    String lockedOutUser ="locked_out_user";
    String errorLOUText ="Epic sadface: Sorry, this user has been locked out.";

    String emptyUsername = "";
    String errorEmptyUsernameText ="Epic sadface: Username is required";

    String bedPassword = "bed";
    String errorBedPasswordBedUsernameText = "Epic sadface: Username and password do not match any user in this service";
    String bedUsername = "wrong";


    @Test
    public void verifySuccesfulLogin(){

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccesfulLogin(expectedText);
        

        try{
            Thread.sleep(5000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }

    }

    @Test
    public void verifyUnsuccesfuLoginLOU(){

        LoginPage loginPage = new LoginPage(driver);

        loginPage.basePage();
        loginPage.login(lockedOutUser, password);
        loginPage.verifyUnsuccesfuLoginPage(errorLOUText);

        try{
            Thread.sleep(5000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test
    public void verifyUnsuccesfuLoginWithEmptyUsernameField(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.basePage();
        loginPage.login(emptyUsername, password);
        loginPage.verifyUnsuccesfuLoginPage(errorEmptyUsernameText);

        try{
            Thread.sleep(5000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test
    public void verifyUnsuccesfuLoginWithBedPassword(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.basePage();
        loginPage.login(standardUsername, bedPassword);
        loginPage.verifyUnsuccesfuLoginPage(errorBedPasswordBedUsernameText);

        try{
            Thread.sleep(5000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }

    }


    
}
