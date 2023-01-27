package tests.searchregion;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.Urls.MAUDAU_HOME_PAGE;

public class SearchRegionTest extends BaseTest {

    @Test
    public void checkIsRedirectToListing (){
        basePage.open(MAUDAU_HOME_PAGE);

        maudauHomePage
                .selectRegion()
                .clickToSearch();

        maudauListingPage.checkCountCards();
    }
}
