package steps;

import driverInstallation.DriverInitialization;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import page.MainPage;
import page.SearchMenuPage;

import static org.junit.Assert.assertTrue;

public class ProductPriceStep {
    WebDriver driver;
    MainPage mainPage;
    SearchMenuPage searchMenuPage;

    @Given("I going to Main Page")
    public void iGoingToMainPage(){
        driver = DriverInitialization.getDriver();
        driver.get("https://www.invitro.ru/");
        mainPage = new MainPage(driver);
    }

    @And("I search {string} product")
    public void iSearchSomeProduct(String text){
        searchMenuPage = mainPage.searchSomeProduct(text);
    }

    @And("I remember his price")
    public void iRememberHisPrice(){
        searchMenuPage.saveProductPrice();
    }

    @And("I send product in to cart")
    public void iSendProductInToCart(){
        searchMenuPage.sendToCart();
    }

    @And("I go to the cart")
    public void iGoToTheCart(){
        searchMenuPage.clickCartButton();
    }

    @And("I compare prices")
    public void iComparePrices(){
        assertTrue(searchMenuPage.comparePrices());
        driver.close();
    }
}
