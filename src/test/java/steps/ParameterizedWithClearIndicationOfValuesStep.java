package steps;

import driverInstallation.DriverInitialization;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import page.MainPage;

public class ParameterizedWithClearIndicationOfValuesStep {

    private WebDriver driver;
    private MainPage mainPage;

    @Given("Someone go to the Main Page")
    public void iOpenMainPage() {
        driver = DriverInitialization.getDriver();
        driver.get("https://www.invitro.ru/");
        mainPage = new MainPage(driver);
    }

    @And("I chose {string} city")
    public void choseCity(String text){
        mainPage.clickChangeCityButton()
                .writeCity(text);
        mainPage.choseYouCity();
    }

    @Then("I click on {string}")
    public void iClickOnChapter(String text){
        mainPage.clickChapter(text);
        driver.close();
    }
}
