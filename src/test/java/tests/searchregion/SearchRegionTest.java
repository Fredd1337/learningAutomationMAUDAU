package tests.searchregion;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.Urls.OLX_HOME_PAGE;

public class SearchRegionTest extends BaseTest {

    @Test
    public void checkIsRedirectToListing (){
        basePage.open(OLX_HOME_PAGE);

        olxHomePage
                .selectRegion()
                .clickToSearch();

        olxListingPage.checkCountCards();
    }
}
