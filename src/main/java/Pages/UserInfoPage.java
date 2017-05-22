package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Anthony Emerson on 5/9/2017.
 */
public class UserInfoPage {

    private WebDriver _driver;

    public UserInfoPage(WebDriver driver){
        this._driver = driver;
    }

    //non-traditional getters used for clarity in testing
    private WebElement mrBtn(){
        return _driver.findElement(By.id("uniform-id_gender1"));
    }
    private WebElement mrsBtn(){
        return _driver.findElement(By.id("uniform-id_gender2"));
    }
    private WebElement firstNameField(){
        return _driver.findElement(By.id("firstname"));
    }
    private WebElement lastNameField(){
        return _driver.findElement(By.id("lastname"));
    }
    private WebElement passwdField(){
        return _driver.findElement(By.id("old_passwd"));
    }
    public WebElement updateForm(){
        return _driver.findElement(By.id("center_column"));
    }
    public WebElement saveBtn(){
        return _driver.findElement(By.name("submitIdentity"));
    }
    public WebElement confirmationMsg(){
        return _driver.findElement(By.cssSelector("p.alert.alert-success"));
    }
    public WebElement userAcctBtn(){
        return _driver.findElement(By.cssSelector("a[href$='my-account']"));
    }

    public void fillForm(String userName, String passwd,  boolean male){
        if (male){mrBtn().click();}
        else{mrsBtn().click();}
        this.firstNameField().clear();
        this.firstNameField().sendKeys(userName.substring(0, userName.indexOf(" ")));
        this.lastNameField().clear();
        this.lastNameField().sendKeys(userName.substring(userName.indexOf(" ")+1));
        this.passwdField().sendKeys(passwd);
    }
}
