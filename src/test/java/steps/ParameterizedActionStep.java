package steps;

import driverInstallation.DriverInitialization;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.MainPage;

public class ParameterizedActionStep {

    private WebDriver driver;
    private MainPage mainPage;

    @Given("I visit Main page")
    public void iOpenMainPage() {
        driver = DriverInitialization.getDriver();
        driver.get("https://www.invitro.ru/");
        mainPage = new MainPage(driver);
    }

    @When("I write in the search field {string}")
    public void iSearchSomeProduct(String text){
        mainPage.searchSomeProduct(text);
        driver.close();
    }

}
