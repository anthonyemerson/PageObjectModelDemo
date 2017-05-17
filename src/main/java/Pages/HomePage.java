package Pages;

/**
 * Created by Anthony Emerson on 05/04/2017.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver _driver;

    public HomePage(WebDriver driver) {
        this._driver = driver;
    }

//non-traditional getters used for clarity in testing
    public WebElement pageTitle(){
        return _driver.findElement(By.cssSelector("#header_logo > a"));
    }
    public WebElement loginBtn(){
        return _driver.findElement(By.cssSelector("a.login"));
    }
}
