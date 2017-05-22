import Utilities.BuildTest;
import Utilities.PageContainer;
import Utilities.User;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Anthony Emerson on 5/10/2017.
 */

//Tests done Sequentially rather than independently due to a lack of API to inject users
public class EditShoppingCartTest extends BuildTest {

    public EditShoppingCartTest test;
    public PageContainer pageContainer;
    public User user = new User();

    public EditShoppingCartTest(){
        super();}

    @BeforeTest
    public void setup(){
        test = new EditShoppingCartTest();
        test.build();
        pageContainer = new PageContainer(test.driver);
        pageContainer.homePage().loginBtn().click();
        pageContainer.loginPage().login(user.email, user.passwd);
    }
    /**
     *This test will go to http://automationpractice.com/index.php
     * Login to the site
     * Verify the shopping cart is empty
     * Then add a dress to the cart
     * Verify the success message is displayed
     * Then return to the cart and remove the dress
     * Verify the shopping cart is empty again
     */
    @Test(priority = 0)
    public void verify_shopping_cart_is_empty(){
        //go to the shopping cart page
        pageContainer.userAcctPage().shoppingCartBtn().click();
        //Verify that the user's shopping cart is empty
        Assert.assertTrue(pageContainer.shoppingCartPage().emptyCartAlert().getText().contains("empty"));
    }
    @Test(priority = 1)
    public void verify_dresses_button_is_displayed() {
        //return to the user account page
        pageContainer.shoppingCartPage().userInfoBtn().click();
        //Verify Dresses Button is displayed on User Account Page
        Assert.assertTrue(pageContainer.userAcctPage().dressesBtn().isDisplayed());
    }
    @Test(priority = 2)
    public void verify_dress_page_was_reached() {
        //Go to the Dresses Page
        pageContainer.userAcctPage().dressesBtn().click();
        //verify page heading is for dresses
        Assert.assertTrue(pageContainer.dressPage().categoryHeader().getText().contains("Dresses"));
    }
    @Test(priority = 3)
    public void verify_dress_added_to_user_shopping_cart() {
        //add a dress to the shopping cart
        pageContainer.dressPage().addDressNumber6().click();
        //wait for popup message
        pageContainer.dressPage().waitForPopUp();
        //verify add to cart pop up message
        Assert.assertTrue(pageContainer.dressPage().addToCartPopUpMessage().getText().contains("" +
                "successfully added"));
        //close the pop up
        pageContainer.dressPage().closeAddToCartPopUp().click();
    }
    @Test(priority = 4)
    public void verify_presence_of_a_delete_button_next_to_item_in_cart() {
        //go to shopping cart
        pageContainer.dressPage().shoppingCartBtn().click();
        //wait for the shopping cart to populate
        pageContainer.shoppingCartPage().waitForDeleteBtn();
        //Verify that there is a delete button
        Assert.assertTrue(pageContainer.shoppingCartPage().deleteBtn().isDisplayed());
    }
    @Test(priority = 5)
    public void verify_dress_removed_from_user_shopping_cart(){
        //remove the dress from user shopping cart
        pageContainer.shoppingCartPage().deleteBtn().click();
        //wait for the shopping cart alert to appear
        pageContainer.shoppingCartPage().waitForAlert();
        //Verify that the user's shopping cart is empty
        Assert.assertTrue(pageContainer.shoppingCartPage().emptyCartAlert().getText().contains("empty"));
    }
    @AfterTest
    public void teardown() {
        test.quit(pageContainer);
    }
}