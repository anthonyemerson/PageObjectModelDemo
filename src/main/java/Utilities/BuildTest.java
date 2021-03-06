package Utilities;

/**
 * Created by Anthony Emerson on 5/4/2017.
 */

import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class BuildTest {
    private String website = "http://automationpractice.com/index.php";
    public WebDriver driver;

    public BuildTest(){
        driver = null;
    }
    public BuildTest(WebDriver driver){
        this.driver = driver;
    }

    public void build() {
        if (driver == null){
            //Use this method when using the Firefox browser
            //WARNING as of May 2017 gecko driver has a known bug that does not correctly use Waits
            //driver = BuildWebDriver.buildFirefoxDriver();

            //Use this method when using the Chrome browser
            driver = BuildWebDriver.buildChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(website);
    }
    //cleans up test data and reverts to original values
    public void resetUser(PageContainer pages, String user, String passwd){
        pages.userAcctPage().userInfoBtn().click();
        pages.userInfoPage().fillForm(user, passwd, true);
        pages.userInfoPage().saveBtn().click();
    }
    //logs out and closes the browser
    public void quit(PageContainer pages){
        pages.userAcctPage().logoutBtn().click();
        driver.close();
    }
}
