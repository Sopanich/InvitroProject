package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static util.ActionsOnSite.click;

public class TestResultPage {
    private WebDriver driver;


    @FindBy(xpath = "//button[contains(@class, 'UnauthResultsPage')]")
    WebElement searchResultButton;

    @FindBy(xpath = "//a[contains(@class, 'invitro_header-get_result')]")
    WebElement resultButtonOnMainPage;

    @FindBy(xpath = "//input[contains(@name, 'orderNumber')]")
    WebElement orderNumber;

    @FindBy(xpath = "//input[contains(@name, 'birthday')]")
    WebElement birthday;

    @FindBy(xpath = "//input[contains(@name, 'lastName')]")
    WebElement lastName;

    @FindBy(xpath = "//div[contains(@class, 'Page_error')]")
    WebElement warningMessage;


    public TestResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public TestResultPage clickResultButtonOnMainPage() {
        click(driver, resultButtonOnMainPage);
        return this;
    }

    public TestResultPage clickSearchResultButton() {
        click(driver, searchResultButton);
        return this;
    }

    public boolean checkThatTheFieldsAreRed() {
        String redColor = "rgba(255, 0, 0, 1)";
        return orderNumber.getCssValue("color").equals(redColor)
                && birthday.getCssValue("color").equals(redColor)
                && lastName.getCssValue("color").equals(redColor);
    }

    public String checkWarningMessage(){
        return warningMessage.getText();
    }


}
