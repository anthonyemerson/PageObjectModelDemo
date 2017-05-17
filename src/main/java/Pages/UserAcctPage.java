package Pages;

/**
 * Created by Anthony Emerson on 05/04/2017.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserAcctPage {
    private WebDriver _driver;

    public UserAcctPage(WebDriver driver){
        _driver = driver;
    }

    //non-traditional getters used for clarity in testing
    public WebElement activeUser(){
        return _driver.findElement(By.cssSelector("div.header_user_info"));
    }
    public WebElement userInfoBtn(){ return _driver.findElement(By.cssSelector("a[href$=\"identity\"]")); }
    public WebElement logoutBtn(){
        return _driver.findElement(By.cssSelector("a.logout"));
    }
    public WebElement dressesBtn() { return _driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")); }
    public WebElement shoppingCartBtn(){ return _driver.findElement(By.cssSelector("a[href$=\"order\"]")); }

}
