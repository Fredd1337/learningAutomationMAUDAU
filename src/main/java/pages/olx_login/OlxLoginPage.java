package pages.olx_login;

import org.openqa.selenium.*;
import org.testng.Assert;
import pages.base.BasePage;

public class OlxLoginPage extends BasePage {

    public OlxLoginPage(WebDriver driver) {
        super(driver);
    }

    private final By selectMyProfile = By.id("my-account-link");
    private final By inputEmailOrNumber = By.xpath("//*[@id=\"__next\"]/div/div/div/div/main/div/div[2]/div/form/div[1]/div/div/input");
    private final By inputPassword = By.xpath("//*[@id=\"__next\"]/div/div/div/div/main/div/div[2]/div/form/div[2]/div/div/div/input");
    private final By submitButton = By.xpath("//*[@id=\"__next\"]/div/div/div/div/main/div/div[2]/div/form/button[2]");
    private final By alertForLoginFieldLocator = By.xpath("//*[@id=\"username-error\"]");
    private final By alertForPasswordFieldLocator = By.xpath("//*[@id=\"__next\"]/div/div/div/div/main/div/div[2]/div/form/div[2]/div/p");
    private final By alertForNotExistentEmailLocator = By.xpath("//*[@id=\"__next\"]/div/div/div/div/main/div/div[2]/div/form/div[1]/p");
    private final By titleAfterSuccessfulLoginLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div[2]/div[1]/div[1]/h3");


    public OlxLoginPage openingLoginPage(){
        driver.findElement(selectMyProfile).click();
        return this;
    }

    public OlxLoginPage checkValidationWithEmptyLoginField(){
        driver.findElement(inputEmailOrNumber).sendKeys("");
        driver.findElement(inputPassword).sendKeys("123qwe123qwe");
        String alertForEmptyLoginField = driver.findElement(alertForLoginFieldLocator).getText();
        Assert.assertEquals(alertForEmptyLoginField, "Не забудьте ввести електронну пошту чи телефон");

        WebElement signButton = driver.findElement(submitButton);
        if(signButton.isEnabled()){
            driver.findElement(submitButton).click();
        } else {
            System.out.println("Submit button disabled");
        }
        return this;
    }

    public OlxLoginPage checkValidationWithEmptyPasswordField(){
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
        Assert.assertEquals(alertForEmptyPasswordField, "Не забудьте ввести пароль");
        return this;
    }

    public OlxLoginPage checkValidationWithIncorrectLoginField(){
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
        Assert.assertEquals(alertForEmptyLoginField, "Це не схоже на електронну пошту");
        return this;
    }

    public OlxLoginPage checkValidationWithShortPasswordField(){
        driver.findElement(inputPassword).sendKeys("12345");
        String alertForShortPassword = driver.findElement(alertForPasswordFieldLocator).getText();
        Assert.assertEquals(alertForShortPassword, "Ви впевнені?");
        return this;
    }

    public OlxLoginPage checkValidationWithNotExistentEmail(){
        driver.findElement(inputEmailOrNumber).sendKeys("@gmail.com");
        driver.findElement(inputPassword).sendKeys("new");

        WebElement signButton = driver.findElement(submitButton);
        if(signButton.isEnabled()){
            driver.findElement(submitButton).click();
        } else {
            System.out.println("Submit button disabled");
        }

        String alertForNotExistentEmail = driver.findElement(alertForNotExistentEmailLocator).getText();
        Assert.assertEquals(alertForNotExistentEmail, "Невірний логін або пароль");
        return this;
    }

    public OlxLoginPage checkValidationWithCorrectEmailAndIncorrectPassword(){
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
        String alertForIncorrectPass = driver.findElement(alertForNotExistentEmailLocator).getText();
        Assert.assertEquals(alertForIncorrectPass, "Щось тут не те...");
        return this;
    }


    public OlxLoginPage checkValidationWithCorrectEmailAndCorrectPassword(){
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
        Assert.assertEquals(titleAfterSuccessfulLogin, "Ваши объявления");
        return this;
    }
}