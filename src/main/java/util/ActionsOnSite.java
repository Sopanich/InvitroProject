package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsOnSite {
    public static void click(WebDriver driver, WebElement element){
        new Actions(driver).click(element).build().perform();
    }
}
