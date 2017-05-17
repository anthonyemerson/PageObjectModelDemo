package Utilities;

import Pages.*;
import org.openqa.selenium.WebDriver;

/**
 * Created by Anthony Emerson on 5/4/2017.
 */


public class PageContainer {
    private WebDriver _driver;
    private HomePage _homePage = null;
    private LoginPage _loginPage = null;
    private UserAcctPage _userAcctPage = null;
    private UserInfoPage _userInfoPage = null;
    private ShoppingCartPage _shoppingCartPage = null;
    private DressPage _dressPage = null;

    public PageContainer(WebDriver driver){
        _driver= driver;
    }

    //non-traditional getters used for clarity in testing
    public DressPage dressPage(){
        if (_dressPage == null) _dressPage = new DressPage(_driver);
        return _dressPage;
    }
    public HomePage homePage(){
        if(_homePage == null) _homePage = new HomePage(_driver);
        return _homePage;
    }
    public LoginPage loginPage(){
        if(_loginPage == null) _loginPage = new LoginPage(_driver);
        return _loginPage;
    }
    public ShoppingCartPage shoppingCartPage(){
        if (_shoppingCartPage == null) _shoppingCartPage = new ShoppingCartPage(_driver);
        return _shoppingCartPage;
    }
    public UserAcctPage userAcctPage() {
        if (_userAcctPage == null) _userAcctPage = new UserAcctPage(_driver);
        return _userAcctPage;
    }
    public UserInfoPage userInfoPage() {
        if (_userInfoPage == null) _userInfoPage = new UserInfoPage(_driver);
        return _userInfoPage;
    }
 }
