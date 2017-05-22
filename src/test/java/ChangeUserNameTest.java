/**
 * Created by Anthony Emerson on 5/4/2017.
 */

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Utilities.*;

import java.io.FileNotFoundException;

//Tests done Sequentially rather than independently due to a lack of API to inject users
public class ChangeUserNameTest extends BuildTest {

    public ChangeUserNameTest test;
    public PageContainer pageContainer;
    public User user = new User();

    public ChangeUserNameTest(){
        super();
    }

    @BeforeTest
    public void setup(){
        test = new ChangeUserNameTest();
        test.build();
        pageContainer = new PageContainer(test.driver);
    }
    /**
     * This test will go to http://automationpractice.com/index.php
     * Verify home page title as My Store
     * Go to sign in page
     * Login to application
     * Verify the correct username
     * Then change the username and verify the change
     */
    @Test(priority = 0)
    public void verify_home_page_title() {
        //Verify the Name of the Site
        Assert.assertTrue(pageContainer.homePage().pageTitle().getAttribute("title").equals("My Store"));
        //go to sign in page
        pageContainer.homePage().loginBtn().click();
    }
    @Test(priority = 1)
    public void verify_login_form_is_displayed() {
        //Verify login form
        Assert.assertTrue(pageContainer.loginPage().loginForm().isDisplayed());
        //login to application
        pageContainer.loginPage().login(user.email, user.passwd);
    }
    @Test(priority = 2)
    public void verify_username() {
        //Verify Username on Landing Page
        Assert.assertTrue(pageContainer.userAcctPage().activeUser().getText().equals(user.name));
    }
    @Test(priority = 3)
    public void verify_update_user_info_is_displayed() {
        //Go to the User's Personal Information Page
        pageContainer.userAcctPage().userInfoBtn().click();
        //Verify the Update Personal Info Form is displayed
        Assert.assertTrue(pageContainer.userInfoPage().updateForm().isDisplayed());
        //Update User Name
        pageContainer.userInfoPage().fillForm(user.name2, user.passwd, false);
        pageContainer.userInfoPage().saveBtn().click();
    }
    @Test(priority = 4)
    public void verify_confirmation_message_is_displayed() {
        //Verify Confirmation Message is Displayed
        Assert.assertTrue(pageContainer.userInfoPage().confirmationMsg().isDisplayed());
        //Return to User Account Page
        pageContainer.userInfoPage().userAcctBtn().click();
    }@Test(priority = 5)
    public void verify_change_in_username(){
        //Verify User Name Change
        Assert.assertTrue(pageContainer.userAcctPage().activeUser().getText().equals(user.name2));
    }
    @AfterTest
    public void teardown(){
        test.resetUser(pageContainer, user.name, user.passwd);
        test.quit(pageContainer);
    }
}
