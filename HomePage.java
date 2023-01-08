package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver){
        super(driver);
    }

    By HomePageTitleBy = By.xpath("//*[@id='header_container']/div[2]/span");

    By addToCardButton1By = By.id("add-to-cart-sauce-labs-backpack");
    By addToCardButton2By = By.id("add-to-cart-sauce-labs-bike-light");
    By choppingCardBadgeTwoElementsBy = By.className("shopping_cart_badge");

    By numberOfItemsBy = By.className("inventory_item");

    By hamburgerMenuBy = By.id("react-burger-menu-btn");
    By logoutButtonBy = By.id("logout_sidebar_link");


    public HomePage verifySuccesfulLogin (String expectedText){
        String actualText = readText(HomePageTitleBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public HomePage verifySuccesfulAddedTwoProductsToCard(){
        click(addToCardButton1By);
        click(addToCardButton2By);
        waitVisibility(choppingCardBadgeTwoElementsBy);
        return this;
    }

    public HomePage numbersOfItems(int expectedNumberOfItems){
        int actualNumberOfItems = countItems(numberOfItemsBy);
        assertIntegerEquals(expectedNumberOfItems, actualNumberOfItems);
        return this;
    }

    public HomePage clickOnHamburgerMenu(){
        click(hamburgerMenuBy);
        return this;
    }

    public HomePage clickOnLogoutButton(){
        click(logoutButtonBy);
        return this;
    }

    public HomePage clickOnShoppingCardBadgeTwoElements(){
        click(choppingCardBadgeTwoElementsBy);
        return this;
    }



}
