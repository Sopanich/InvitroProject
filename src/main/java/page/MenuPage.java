package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static util.ActionsOnSite.click;

public class MenuPage {
    private WebDriver driver;


    @FindBy(xpath = "//ul[contains(@class, 'side-bar-second__list')]//a")
    private List<WebElement> listOfElements;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getListOfElements() {
        return listOfElements;
    }

    public MenuPage clickElement(WebElement element) {
        click(driver, element);
        return new MenuPage(driver);
    }
}
