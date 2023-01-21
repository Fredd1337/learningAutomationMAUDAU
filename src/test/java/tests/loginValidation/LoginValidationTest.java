package tests.loginValidation;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.Urls.OLX_HOME_PAGE;

public class LoginValidationTest extends BaseTest {

    @Test
    public void checkValidationsOnLoginPage (){
        basePage.open(OLX_HOME_PAGE);

        olxLoginPage
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
