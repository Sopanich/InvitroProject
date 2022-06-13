package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static util.ActionsOnSite.click;

public class SearchMenuPage {
    private WebDriver driver;
    private String productPrice;

    @FindBy(xpath = "//div[contains(@class, 'search__result-order-meta-price ')]")
    WebElement productPriceOnSearch;

    @FindBy(xpath = "//a[contains(@class, 'basket-analysis')]")
    WebElement sendToCartButton;

    @FindBy(xpath = "//div[contains(@class,'cart row')]//a")
    WebElement cartButton;

    @FindBy(xpath = "//div[contains(@class,'CartProduct_productPrice')]")
    WebElement productPriceOnCart;


    public SearchMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public void saveProductPrice(){
        productPrice = productPriceOnSearch.getText();
    }

    public SearchMenuPage sendToCart(){
        click(driver, sendToCartButton);
        return this;
    }

    public SearchMenuPage clickCartButton(){
        click(driver,cartButton);
        return this;
    }

    public boolean comparePrices(){
        return productPriceOnCart.getText().equals(productPrice);
    }
}
