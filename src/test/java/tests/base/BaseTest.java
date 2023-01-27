package tests.base;

import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import pages.base.BasePage;
import pages.listing.MaudauListingPage;
import pages.maudau_home.MaudauHomePage;
import pages.maudau_login.MaudauLoginPage;
import pages.maudau_my_cabinet.MyAccountPage;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static common.Config.HOLD_BROWSER_OPEN;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected MaudauHomePage maudauHomePage = new MaudauHomePage(driver);
    protected MaudauListingPage maudauListingPage = new MaudauListingPage(driver);
    protected MaudauLoginPage maudauLoginPage = new MaudauLoginPage(driver);
    protected MyAccountPage maudauMyAccountPage = new MyAccountPage(driver);


    @AfterTest
    public void clearCookiesAndLocalStorage(){
        if (CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterTest(alwaysRun = true)
    public void close(){
        if(HOLD_BROWSER_OPEN){
            driver.quit();
        }
    }
}
