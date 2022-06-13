package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static util.ActionsOnSite.click;

public class MainPage {
    private final WebDriver driver;

    @FindBy(xpath = "//span[contains(@class, 'city__btn')]")
    private WebElement cityButton;

    @FindBy(xpath = "//a[contains(@class, 'city__change-btn')]")
    private WebElement changeCityButton;

    @FindBy(xpath = "//input[contains(@class, 'change-city-search-input')]")
    private WebElement searchField;

    @FindBy(xpath = "//div[contains(@class, 'eac-item')]/b")
    private WebElement trueCity;

    @FindBy(xpath = "//div[contains(@class, 'eac-item')]")
    private WebElement yourCity;

    @FindBy(xpath = "//input[contains(@name, 'q')]")
    private WebElement searchFieldOnMainPage;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean checkCityIsCorrectOnMainPage(String text) {
        return cityButton.getText().equals(text);
    }

    public MainPage clickChangeCityButton() {
        click(driver, changeCityButton);
        return this;
    }

    public void writeCity(String city) {
        searchField.clear();
        new Actions(driver).sendKeys(searchField, city).build().perform();
    }

    public String checkCorrectCity() {
        return trueCity.getText();
    }

    public void choseYouCity() {
        click(driver, yourCity);
    }

    public SearchMenuPage searchSomeProduct(String text){
        searchFieldOnMainPage.clear();
        new Actions(driver).sendKeys(searchFieldOnMainPage, text).build().perform();
        searchFieldOnMainPage.submit();
        return new SearchMenuPage(driver);
    }

    public void clickChapter(String chapter) {
        WebElement chapterElement = driver.findElement(
                By.xpath("//li[contains(@class,'menu_main')]/a[contains(text(),'" + chapter + "')]"));
        click(driver, chapterElement);
    }
}
