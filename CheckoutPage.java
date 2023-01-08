package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver){
        super(driver);
    }

    By yourCartTitleBy = By.xpath("//*[@id='header_container']/div[2]");

    By checkoutButtonBy = By.id("checkout");
    By checkoutInformationTitleBy = By.xpath("//*[@id='header_container']/div[2]/span");

    By firstNameBy = By.id("first-name");
    By lastNameBy = By.id("last-name");
    By postalCodeBy = By.id("postal-code");
    By continueButtonBy = By.id("continue");

   // By checkoutOverviewTextBy = By.xpath("//*[@id='header_container']/div[2]/span");
    By item1By = By.xpath("//*[@id='item_4_title_link']/div");
    By item2By = By.xpath("//*[@id='item_0_title_link']/div");

    //By totalItem1Item2TaxBy = By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[7]");
    By priceItem1By = By.xpath("//*[@id='checkout_summary_container']/div/div[1]/div[3]/div[2]/div[2]/div");
    By priceItem2By = By.xpath("//*[@id='checkout_summary_container']/div/div[1]/div[4]/div[2]/div[2]/div");


    By finishButtonBy = By.id("finish");
    By endedMessageBy = By.xpath("//*[@id='checkout_complete_container']/h2");


    public CheckoutPage verifySuccesfulYourCartPage(String expectedTextYourCart){
        String actualText = readText(yourCartTitleBy);
        assertTextEquals(expectedTextYourCart, actualText);
        return this;
    }

    public CheckoutPage clickOnCheckoutButton(){
        click(checkoutButtonBy);
        return this;
    }

    public CheckoutPage verifySuccesfulYourInformationPage(String expectedInformationTitleText){
        String actualText = readText(checkoutInformationTitleBy);
        assertTextEquals(expectedInformationTitleText, actualText);
        return this;
    }

    public CheckoutPage verifyCheckoutFilds(String firstName, String lastName, String postalCode){
        writeText(firstNameBy, firstName);
        writeText(lastNameBy, lastName);
        writeText(postalCodeBy, postalCode);
        return this;
    }

   // public CheckoutPage veryfuSuccesfulOverviewPage(String expectedOverviewText){
    //    String actualOverviewText = readText(checkoutOverviewTextBy);
      //  assertTextEquals(expectedOverviewText, actualOverviewText);
        //return this;
    //}

    public CheckoutPage clickOnContinueButtonOnCheckoutFilds(){
        click(continueButtonBy);
        return this;
    }

    public CheckoutPage verifySuccesfulOverviewPage(String expectedItem1, String expectedItem2){
        String actualItem1 = readText(item1By);
        String actualItem2 = readText(item2By);
        assertTextEquals(expectedItem1, actualItem1);
        assertTextEquals(expectedItem2, actualItem2);
        return this;
    }

    //public CheckoutPage verifyTotalPrice(double expectedTotalPrice){
      //  double totalItem1Item2Tax = Double.parseDouble(readText(totalItem1Item2TaxBy).substring(8));
       //assertDoubleEquals(expectedTotalPrice, totalItem1Item2Tax);
        //return this;
    //}

    public CheckoutPage vvverifyTotalPrice(double expectedTotalPrice){
        double priceItem1 = Double.parseDouble(readText(priceItem1By).substring(1));
        double priceItem2 = Double.parseDouble(readText(priceItem2By).substring(1));
        double sumaPriceItem1Item2 = priceItem1 + priceItem2;
        double totalItem1Item2Tax = 1.08 * sumaPriceItem1Item2;
        assertDoubleEquals(expectedTotalPrice, totalItem1Item2Tax);
        
        return this;
    }

    public CheckoutPage clickOnFinishButton(){
        click(finishButtonBy);
        return this;
    }

    public CheckoutPage verifySuccesEndedMessage(String expectedEndedMessage){
        String actualEndedMessageText = readText(endedMessageBy);
        assertTextEquals(expectedEndedMessage, actualEndedMessageText);
        return this;
    }
}
