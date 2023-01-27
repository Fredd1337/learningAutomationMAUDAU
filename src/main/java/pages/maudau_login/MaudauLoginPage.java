package pages.maudau_login;

import org.openqa.selenium.*;
import org.testng.Assert;
import pages.base.BasePage;

public class MaudauLoginPage extends BasePage {

    public MaudauLoginPage(WebDriver driver) {
        super(driver);
    }

    private final By selectMyProfile = By.xpath("//*[@id=\"viewport\"]/header/div/div[2]/div[1]/div[2]/div[1]");
    private final By inputEmailOrNumber = By.xpath("//*[@id=\"viewport\"]/div[3]/div/div[2]/div[3]/div/form/div[1]/div/input");
    private final By inputPassword = By.xpath("//*[@id=\"viewport\"]/div[3]/div/div[2]/div[3]/div/form/div[2]/div/input");
    private final By submitButton = By.xpath("//*[@id=\"viewport\"]/div[3]/div/div[2]/div[3]/div/form/button");
    private final By alertForLoginFieldLocator = By.xpath("//*[@id=\"viewport\"]/div[3]/div/div[2]/div[3]/div/form/div[1]/div/div/span");
    private final By alertForPasswordFieldLocator = By.xpath("//*[@id=\"viewport\"]/div[3]/div/div[2]/div[3]/div/form/div[2]/div/div/span");
    private final By alertForIncorrectEmailOrPasswordLocator = By.xpath("//*[@id=\"viewport\"]/div[2]/span/div/div/span");
    private final By titleAfterSuccessfulLoginLocator = By.xpath("//*[@id=\"my_account\"]/div/h1");


    public MaudauLoginPage openingLoginPage(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement myProfileButton = driver.findElement(selectMyProfile);
        waitElementIsVisible(myProfileButton).click();

        return this;
    }

    public MaudauLoginPage checkValidationWithEmptyLoginField(){
        driver.findElement(inputEmailOrNumber).sendKeys("");
        driver.findElement(inputPassword).sendKeys("123qwe123qwe");
        String alertForEmptyLoginField = driver.findElement(alertForLoginFieldLocator).getText();
        Assert.assertEquals(alertForEmptyLoginField, "Обов'язкове поле");
        driver.findElement(submitButton).click();
        return this;
    }

    public MaudauLoginPage checkValidationWithEmptyPasswordField(){
        driver.findElement(inputEmailOrNumber).sendKeys("test@email.com");
        WebElement inputPass = driver.findElement(inputPassword);
        String value = inputPass.getAttribute("value");

        if (value != null) {
            int valLen = value.length();
            for (int i = 0; i < valLen; i++) {
                inputPass.sendKeys(Keys.BACK_SPACE);
            }
        }

        String alertForEmptyPasswordField = driver.findElement(alertForPasswordFieldLocator).getText();
        Assert.assertEquals(alertForEmptyPasswordField, "Обов'язкове поле");
        return this;
    }

    public MaudauLoginPage checkValidationWithIncorrectLoginField(){
        WebElement inputEmail = driver.findElement(inputEmailOrNumber);
        String value = inputEmail.getAttribute("value");

        if (value != null) {
            int valLen = value.length();
            for (int i = 0; i < valLen; i++) {
                inputEmail.sendKeys(Keys.BACK_SPACE);
            }
        }
        driver.findElement(inputEmailOrNumber).sendKeys("testIncorrectEmail");
        String alertForEmptyLoginField = driver.findElement(alertForLoginFieldLocator).getText();
        Assert.assertEquals(alertForEmptyLoginField, "Будь ласка вкажіть коректну адресу електронної пошти.");
        return this;
    }

    public MaudauLoginPage checkValidationWithShortPasswordField(){
        WebElement inputEmail = driver.findElement(inputEmailOrNumber);
        String value = inputEmail.getAttribute("value");

        if (value != null) {
            int valLen = value.length();
            for (int i = 0; i < valLen; i++) {
                inputEmail.sendKeys(Keys.BACK_SPACE);
            }
        }
        driver.findElement(inputEmailOrNumber).sendKeys("test@email.com");
        driver.findElement(inputPassword).sendKeys("12345");
        driver.findElement(submitButton).click();
        driver.findElement(alertForIncorrectEmailOrPasswordLocator);

        WebElement alertForShortPasswordE = driver.findElement(alertForIncorrectEmailOrPasswordLocator);
        waitElementIsVisible(alertForShortPasswordE).isDisplayed();
        String alertForShortPassword = driver.findElement(alertForIncorrectEmailOrPasswordLocator).getText();
        Assert.assertEquals(alertForShortPassword, "Помилка авторизації, перевірте введені дані та спробуйте ще раз.");
        return this;
    }

    public MaudauLoginPage checkValidationWithNotExistentEmail(){
        driver.findElement(inputPassword).sendKeys("new");
        driver.findElement(submitButton).click();
        WebElement alertForShortPasswordE = driver.findElement(alertForIncorrectEmailOrPasswordLocator);
        waitElementIsVisible(alertForShortPasswordE).isDisplayed();
        String alertForNotExistentEmail = driver.findElement(alertForIncorrectEmailOrPasswordLocator).getText();
        Assert.assertEquals(alertForNotExistentEmail, "Помилка авторизації, перевірте введені дані та спробуйте ще раз.");
        return this;
    }

    public MaudauLoginPage checkValidationWithCorrectEmailAndIncorrectPassword(){
        WebElement inputEmail = driver.findElement(inputEmailOrNumber);
        String value = inputEmail.getAttribute("value");

        if (value != null) {
            int valLen = value.length();
            for (int i = 0; i < valLen; i++) {
                inputEmail.sendKeys(Keys.BACK_SPACE);
            }
        }

        driver.findElement(inputEmailOrNumber).sendKeys("bogdansolodky@gmail.com");
        driver.findElement(submitButton).click();
        WebElement alertForShortPasswordE = driver.findElement(alertForIncorrectEmailOrPasswordLocator);
        waitElementIsVisible(alertForShortPasswordE).isDisplayed();
        String alertForIncorrectPass = driver.findElement(alertForIncorrectEmailOrPasswordLocator).getText();
        Assert.assertEquals(alertForIncorrectPass, "Помилка авторизації, перевірте введені дані та спробуйте ще раз.");
        return this;
    }


    public MaudauLoginPage checkValidationWithCorrectEmailAndCorrectPassword(){
        WebElement inputPass = driver.findElement(inputPassword);
        String value = inputPass.getAttribute("value");

        if (value != null) {
            int valLen = value.length();
            for (int i = 0; i < valLen; i++) {
                inputPass.sendKeys(Keys.BACK_SPACE);
            }
        }

        driver.findElement(inputPassword).sendKeys("Ewq7567327!");
        driver.findElement(submitButton).click();
        String titleAfterSuccessfulLogin = driver.findElement(titleAfterSuccessfulLoginLocator).getText();
        Assert.assertEquals(titleAfterSuccessfulLogin, "Особистий кабінет");
        return this;
    }
}