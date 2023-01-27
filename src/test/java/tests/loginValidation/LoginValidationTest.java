package tests.loginValidation;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.Urls.MAUDAU_HOME_PAGE;

public class LoginValidationTest extends BaseTest {

    @Test
    public void checkValidationsOnLoginPage (){
        basePage.open(MAUDAU_HOME_PAGE);

        maudauLoginPage
                .openingLoginPage()
                .checkValidationWithEmptyLoginField()
                .checkValidationWithEmptyPasswordField()
                .checkValidationWithIncorrectLoginField()
                .checkValidationWithShortPasswordField()
                .checkValidationWithNotExistentEmail()
                .checkValidationWithCorrectEmailAndIncorrectPassword()
                .checkValidationWithCorrectEmailAndCorrectPassword();
    }
}
