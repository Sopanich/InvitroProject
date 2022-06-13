package steps;

import driverInstallation.DriverInitialization;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.MainPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ChangeCityStep {

    private WebDriver driver;
    private MainPage mainPage;

    @Given("I open Main page")
    public void iOpenMainPage() {
        driver = DriverInitialization.getDriver();
        driver.get("https://www.invitro.ru/");
        mainPage = new MainPage(driver);
    }

    @When("I click change City button")
    public void iClickChangeCityButton() {

        mainPage = mainPage.clickChangeCityButton();
    }

    @And("I write in search {string}")
    public void iWriteInSearchCity(String city) {
        mainPage.writeCity(city);
    }

    @And("I check the search is correct and contains {string}")
    public void iCheckTheSearchIsCorrectAndContainsCity(String city) {
        assertEquals(mainPage.checkCorrectCity(), city);
    }

    @And("I chose city")
    public void iChoseCity() {
        mainPage.choseYouCity();
    }

    @Then("I see {string} in the Main page")
    public void checkTrueCity(String text) {
        assertTrue(mainPage.checkCityIsCorrectOnMainPage(text));
        driver.close();
    }

}
