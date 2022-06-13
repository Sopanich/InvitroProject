package steps;

import driverInstallation.DriverInitialization;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import page.TestResultPage;

import static org.junit.Assert.assertTrue;

public class PerformanceCheckTestResultStep {
    WebDriver driver;
    TestResultPage testResultPage;


    @Given("I open MainPage")
    public void iOpenTestResultPage(){
        driver = DriverInitialization.getDriver();
        driver.get("https://www.invitro.ru/");
        testResultPage = new TestResultPage(driver);

    }

    @And("I click result button")
    public void iClickResultButton(){
        testResultPage.clickResultButtonOnMainPage();
    }

    @And("I click Search result button")
    public void iClickSearchResultButton(){
        testResultPage = testResultPage.clickSearchResultButton();
    }

    @Then("I check that the fields are red")
    public void iCheckThatTheFieldsAreRed(){
        assertTrue(testResultPage.checkThatTheFieldsAreRed());
    }

    @Then("I check for an error message")
    public void iCheckForAnErrorMessage(){
        assertTrue(testResultPage.checkWarningMessage().contains("Поля")
                && testResultPage.checkWarningMessage().contains("Код ИНЗ")
                && testResultPage.checkWarningMessage().contains("Дата рождения")
                && testResultPage.checkWarningMessage().contains("Фамилия")
                && testResultPage.checkWarningMessage().contains("обязательны для заполнения"));
        driver.close();
    }
}
