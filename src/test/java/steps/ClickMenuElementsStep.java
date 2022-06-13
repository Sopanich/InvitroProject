package steps;

import driverInstallation.DriverInitialization;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import page.MenuPage;

public class ClickMenuElementsStep {

    private WebDriver driver;
    private MenuPage menuPage;

    @Given("I open the tab medical services")
    public void i_open_the_tab_medical_services() {

        driver = DriverInitialization.getDriver();
        driver.get("https://www.invitro.ru/radiology/");
        menuPage = new MenuPage(driver);

    }

    @Then("I click all elements on menu")
    public void i_click_all_elements_on_menu() {
        for (int i = 0; i < menuPage.getListOfElements().size(); i++) {
            menuPage.clickElement(menuPage.getListOfElements().get(i));
        }
        driver.close();

    }
}
