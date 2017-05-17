package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Anthony Emerson on 5/10/2017.
 */
public class DressPage {
    private WebDriver _driver;
    private WebDriverWait wait;

    public DressPage(WebDriver driver){
        _driver = driver;
    }

    //non-traditional getters used for clarity in testing
    private WebElement addToCartPopUp() { return _driver.findElement(By.id("layer_cart"));}

    public WebElement categoryHeader() { return _driver.findElement(By.cssSelector("span.category-name")); }
    public WebElement addDressNumber6(){ return _driver.findElement(By.cssSelector("a[href*=" +
            "\"cart&add=1&id_product=6\"]")); }
    public WebElement shoppingCartBtn(){ return _driver.findElement(By.cssSelector("a[href$=\"order\"]")); }

    public WebElement addToCartPopUpMessage() {
        return addToCartPopUp().findElement(By.cssSelector("#layer_cart > div.clearfix >" +
                " div.layer_cart_product.col-xs-12.col-md-6 > h2"));
    }
    public WebElement closeAddToCartPopUp() { return addToCartPopUp().findElement(By.cssSelector("span.cross"));}
    public void waitForPopUp(){
        wait = new WebDriverWait(_driver, 10);
        wait.until(ExpectedConditions.visibilityOf(addToCartPopUp()));
    }
}
