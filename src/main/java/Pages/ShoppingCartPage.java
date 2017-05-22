package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Anthony Emerson on 5/10/2017.
 */
public class ShoppingCartPage {
    private WebDriver _driver;
    private WebDriverWait wait;

    public ShoppingCartPage(WebDriver driver){
        _driver = driver;
    }

    //non-traditional getters used for clarity in testing
    public WebElement emptyCartAlert() { return _driver.findElement(By.cssSelector("p.alert.alert-warning")); }
    public WebElement userInfoBtn(){ return _driver.findElement(By.cssSelector("a[href$='identity']")); }
    public WebElement deleteBtn(){ return _driver.findElement(By.cssSelector("a.cart_quantity_delete")); }
    public void waitForDeleteBtn(){
        wait = new WebDriverWait(_driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("i.icon-trash")));
    }
    public void waitForAlert(){
        wait = new WebDriverWait(_driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("p.alert.alert-" +
                        "warning"),"empty"));
    }
}
