package tests.myAccount;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.Urls.MAUDAU_HOME_PAGE;

public class MyAccountViewEditValidationTest extends BaseTest {

    @Test
    public void checkViewModeOnMyAccountPage(){
        basePage.open(MAUDAU_HOME_PAGE);

        maudauMyAccountPage
                .loginIn()
                /*.checkThatUserDataIsNotEmptyOnViewMode()*/
                .checkThatMyAccountMayBeOpenedInEditMode()
                .checkThatSurnameMayBeUpdated()
                .checkThatNameMayBeUpdated()
                .checkThatFatherhoodMayBeUpdated()
                .checkCalendarPickerFunctions()
                .checkGenderRadioButtons()
                .checkThatPhoneNumberMayBeChanged()
                .checkThatUpdatedDataMayBeSaved()
                .checkThatUserMayLogout();
    }
}
