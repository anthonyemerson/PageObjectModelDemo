package Pages;

/**
 * Created by Anthony Emerson on 05/04/2017.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver _driver;

    public LoginPage(WebDriver driver){
        _driver = driver;
    }

    //non-traditional getters used for clarity in testing
    public WebElement loginForm(){ return _driver.findElement(By.id("login_form")); }
    public WebElement userEmail(){
        return _driver.findElement(By.name("email"));
    }
    public WebElement userPassword(){
        return _driver.findElement(By.name("passwd"));
    }
    public WebElement submitBtn(){
        return _driver.findElement(By.name("SubmitLogin"));
    }

    public void login(String email, String passwd){
        userEmail().sendKeys(email);
        userPassword().sendKeys(passwd);
        submitBtn().click();
    }
}
