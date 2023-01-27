package pages.maudau_my_cabinet;

import org.openqa.selenium.*;
import org.testng.Assert;
import pages.base.BasePage;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    private final By myAccountButton = By.xpath("//*[@id=\"my_account\"]/div/div[3]/div[1]/nav/ul/li[1]/a");
    private final By updateButton = By.xpath("//*[@id=\"my_account\"]/div/div[3]/div[2]/div/div[1]/div/div[1]/div[2]/button");
    private final By logoutButton = By.xpath("//*[@id=\"my_account\"]/div/div[3]/div[2]/div/div[2]/div[1]/span");
    private final By nameLabelViewMode = By.xpath("//*[@id=\"my_account\"]/div/div[3]/div[2]/div/div[1]/div/div[2]/div[1]/span[2]");
    private final By dateOfBirthLabelViewMode = By.xpath("//*[@id=\"my_account\"]/div/div[3]/div[2]/div/div[1]/div/div[2]/div[2]/span[2]");
    private final By genderLabelViewMode = By.xpath("//*[@id=\"my_account\"]/div/div[3]/div[2]/div/div[1]/div/div[2]/div[3]/span[2]");
    private final By phoneNumberLabelViewMode = By.xpath("//*[@id=\"my_account\"]/div/div[3]/div[2]/div/div[1]/div/div[2]/div[4]/span[2]/span");
    private final By surnameInputField = By.xpath("//*[@id=\"my_account\"]/div/div[3]/div[2]/div/div[1]/div/div[2]/div[1]/div/div[1]/div/input");
    private final By surnameValidationAlert = By.xpath("//*[@id=\"my_account\"]/div/div[3]/div[2]/div/div[1]/div/div[2]/div[1]/div/div[1]/div/div/span");
    private final By nameInputField = By.xpath("//*[@id=\"my_account\"]/div/div[3]/div[2]/div/div[1]/div/div[2]/div[1]/div/div[2]/div/input");
    private final By nameValidationAlert = By.xpath("//*[@id=\"my_account\"]/div/div[3]/div[2]/div/div[1]/div/div[2]/div[1]/div/div[2]/div/div/span");
    private final By fatherhoodInputField = By.xpath("//*[@id=\"my_account\"]/div/div[3]/div[2]/div/div[1]/div/div[2]/div[1]/div/div[3]/div/input");
    private final By fatherhoodValidationAlert = By.xpath("//*[@id=\"my_account\"]/div/div[3]/div[2]/div/div[1]/div/div[2]/div[1]/div/div[3]/div/div/span");
    private final By calendarPickerGeneral = By.xpath("//*[@id=\"my_account\"]/div/div[3]/div[2]/div/div[1]/div/div[2]/div[2]/div/div/div/input");
    private final By monthPicker = By.xpath("/html/body/div[4]/div/div/div/div[1]/span/button[1]");
    private final By monthPickerMarch = By.xpath("/html/body/div[4]/div/div/div/div[2]/table/tr[1]/td[3]/div");
    private final By yearPicker = By.xpath("/html/body/div[4]/div/div/div/div[1]/span/button[2]");
    private final By yearPicker1997 = By.xpath("/html/body/div[4]/div/div/div/div[2]/table/tr[4]/td[2]/div");
    private final By monthArrowLeft = By.xpath("/html/body/div[4]/div/div/div/div[1]/button[2]/i");
    private final By monthArrowRight = By.xpath("/html/body/div[4]/div/div/div/div[1]/button[4]/i");
    private final By yearArrowLeft = By.xpath("/html/body/div[4]/div/div/div/div[1]/button[1]/i");
    private final By yearArrowRight = By.xpath("/html/body/div[4]/div/div/div/div[1]/button[3]/i");
    private final By dateCell = By.xpath("/html/body/div[4]/div/div/div/div[2]/table/tbody/tr[3]/td[3]");
    private final By maleRadioButton = By.xpath("//*[@id=\"my_account\"]/div/div[3]/div[2]/div/div[1]/div/div[2]/div[3]/div/div/div[1]/div[1]/label/span");
    private final By femaleRadioButton = By.xpath("//*[@id=\"my_account\"]/div/div[3]/div[2]/div/div[1]/div/div[2]/div[3]/div/div/div[2]/div[1]/label/span");
    private final By phoneNumberInputField = By.xpath("//*[@id=\"my_account\"]/div/div[3]/div[2]/div/div[1]/div/div[2]/div[4]/div/div[1]/div/input");
    private final By phoneValidationAlert = By.xpath("//*[@id=\"my_account\"]/div/div[3]/div[2]/div/div[1]/div/div[2]/div[4]/div/div[1]/div/div/span");
    private final By saveButton = By.xpath("//*[@id=\"my_account\"]/div/div[3]/div[2]/div/div[1]/div/div[2]/div[5]/button[1]");
    private final By cancelButton = By.xpath("//*[@id=\"my_account\"]/div/div[3]/div[2]/div/div[1]/div/div[2]/div[5]/button[2]");
    private final By successfulAlert = By.xpath("//*[@id=\"viewport\"]/div[2]/span/div/div[1]/span");
    private final By logoutAlert = By.xpath("//*[@id=\"viewport\"]/div[2]/span/div/div[1]/span");
    private final By alertOkButton = By.xpath("//*[@id=\"notificationAction2\"]/span");


    public MyAccountPage loginIn(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement myProfileButton = driver.findElement(By.xpath("//*[@id=\"viewport\"]/header/div/div[2]/div[1]/div[2]/div[1]"));
        waitElementIsVisible(myProfileButton).click();
        driver.findElement(By.xpath("//*[@id=\"viewport\"]/div[3]/div/div[2]/div[3]/div/form/div[1]/div/input")).sendKeys("bogdansolodky@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"viewport\"]/div[3]/div/div[2]/div[3]/div/form/div[2]/div/input")).sendKeys("Ewq7567327!");
        driver.findElement(By.xpath("//*[@id=\"viewport\"]/div[3]/div/div[2]/div[3]/div/form/button")).click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String alertAfterLogIn = driver.findElement(successfulAlert).getText();
        Assert.assertEquals(alertAfterLogIn,"Ви увійшли в обліковий запис!");
        driver.findElement(alertOkButton).click();
        return this;
    }

    public MyAccountPage checkThatUserDataIsNotEmptyOnViewMode(){
        driver.findElement(myAccountButton).click();
        String nameLabel = driver.findElement(nameLabelViewMode).getText();
        Assert.assertEquals(nameLabel, "Богдан Солодкий Володимирович");
        String dateOfBirthLabel = driver.findElement(dateOfBirthLabelViewMode).getText();
        Assert.assertEquals(dateOfBirthLabel, "10 січня 1995 р.");
        String genderLabel = driver.findElement(genderLabelViewMode).getText();
        Assert.assertEquals(genderLabel, "Чоловіча");
        String phoneNumberLabel = driver.findElement(phoneNumberLabelViewMode).getText();
        Assert.assertEquals(phoneNumberLabel, "+38(097)991-36-56");
        return this;
    }

    public MyAccountPage checkThatMyAccountMayBeOpenedInEditMode(){
        driver.findElement(updateButton).click();
        boolean surnameInputFieldDisplayed = driver.findElement(surnameInputField).isDisplayed();
        Assert.assertTrue(surnameInputFieldDisplayed);
        boolean nameInputFieldDisplayed = driver.findElement(nameInputField).isDisplayed();
        Assert.assertTrue(nameInputFieldDisplayed);
        boolean fatherhoodInputFieldDisplayed = driver.findElement(fatherhoodInputField).isDisplayed();
        Assert.assertTrue(fatherhoodInputFieldDisplayed);
        boolean calendarPickerGeneralDisplayed = driver.findElement(calendarPickerGeneral).isDisplayed();
        Assert.assertTrue(calendarPickerGeneralDisplayed);
        boolean maleRadioButtonDisplayed = driver.findElement(maleRadioButton).isDisplayed();
        Assert.assertTrue(maleRadioButtonDisplayed);
        boolean femaleRadioButtonDisplayed = driver.findElement(femaleRadioButton).isDisplayed();
        Assert.assertTrue(femaleRadioButtonDisplayed);
        boolean phoneNumberInputFieldDisplayed = driver.findElement(phoneNumberInputField).isDisplayed();
        Assert.assertTrue(phoneNumberInputFieldDisplayed);
        boolean saveButtonDisplayed = driver.findElement(saveButton).isDisplayed();
        Assert.assertTrue(saveButtonDisplayed);
        boolean cancelButtonDisplayed = driver.findElement(cancelButton).isDisplayed();
        Assert.assertTrue(cancelButtonDisplayed);
        return this;
    }

    public MyAccountPage checkThatSurnameMayBeUpdated(){
        WebElement inputSurname = driver.findElement(surnameInputField);
        String value = inputSurname.getAttribute("value");

        if (value != null) {
            int valLen = value.length();
            for (int i = 0; i < valLen; i++) {
                inputSurname.sendKeys(Keys.BACK_SPACE);
            }
        }

        driver.findElement(nameInputField).click();
        String alertForEmptySurnameField = driver.findElement(surnameValidationAlert).getText();
        Assert.assertEquals(alertForEmptySurnameField, "Обов'язкове поле");
        driver.findElement(surnameInputField).sendKeys("З");
        String alertForShortSurnameField = driver.findElement(surnameValidationAlert).getText();
        Assert.assertEquals(alertForShortSurnameField, "Ім'я має складатися не менш ніж с двох букв");
        driver.findElement(surnameInputField).sendKeys("7");
        String alertForNumbersInSurnameField = driver.findElement(surnameValidationAlert).getText();
        Assert.assertEquals(alertForNumbersInSurnameField, "Використовуйте тільки кирилицю");
        driver.findElement(surnameInputField).sendKeys(Keys.BACK_SPACE);
        driver.findElement(surnameInputField).sendKeys("міненаФамілія");
        return this;
    }

    public MyAccountPage checkThatNameMayBeUpdated(){
        WebElement inputName = driver.findElement(nameInputField);
        String value = inputName.getAttribute("value");

        if (value != null) {
            int valLen = value.length();
            for (int i = 0; i < valLen; i++) {
                inputName.sendKeys(Keys.BACK_SPACE);
            }
        }

        String alertForEmptyNameField = driver.findElement(nameValidationAlert).getText();
        Assert.assertEquals(alertForEmptyNameField, "Обов'язкове поле");
        driver.findElement(nameInputField).sendKeys("З");
        String alertForShortNameField = driver.findElement(nameValidationAlert).getText();
        Assert.assertEquals(alertForShortNameField, "Ім'я має складатися не менш ніж с двох букв");
        driver.findElement(nameInputField).sendKeys("7");
        String alertForNumbersInNameField = driver.findElement(nameValidationAlert).getText();
        Assert.assertEquals(alertForNumbersInNameField, "Використовуйте тільки кирилицю");
        driver.findElement(nameInputField).sendKeys(Keys.BACK_SPACE);
        driver.findElement(nameInputField).sendKeys("міненеІм'я");
        return this;
    }

    public MyAccountPage checkThatFatherhoodMayBeUpdated(){
        WebElement inputFatherhood = driver.findElement(fatherhoodInputField);
        String value = inputFatherhood.getAttribute("value");

        if (value != null) {
            int valLen = value.length();
            for (int i = 0; i < valLen; i++) {
                inputFatherhood.sendKeys(Keys.BACK_SPACE);
            }
        }
        driver.findElement(fatherhoodInputField).sendKeys("ЗміненеПобатькові");
        driver.findElement(fatherhoodInputField).sendKeys("7");
        driver.findElement(nameInputField).click();
        String alertForNumbersInFatherhoodField = driver.findElement(fatherhoodValidationAlert).getText();
        Assert.assertEquals(alertForNumbersInFatherhoodField, "Використовуйте тільки кирилицю");
        driver.findElement(fatherhoodInputField).sendKeys(Keys.BACK_SPACE);
        return this;
    }

    public MyAccountPage checkCalendarPickerFunctions(){
        driver.findElement(calendarPickerGeneral).click();
        driver.findElement(monthArrowLeft).click();
        driver.findElement(monthArrowRight).click();
        driver.findElement(yearArrowLeft).click();
        driver.findElement(yearArrowRight).click();
        driver.findElement(monthPicker).click();
        driver.findElement(monthPickerMarch).click();
        driver.findElement(yearPicker).click();
        driver.findElement(yearPicker1997).click();
        driver.findElement(monthPickerMarch).click();
        driver.findElement(dateCell).click();
        return this;
    }

    public MyAccountPage checkGenderRadioButtons(){
        driver.findElement(femaleRadioButton).click();
        driver.findElement(maleRadioButton).click();
        return this;
    }

    public MyAccountPage checkThatPhoneNumberMayBeChanged(){
        WebElement inputPhoneNumber = driver.findElement(phoneNumberInputField);
        String value = inputPhoneNumber.getAttribute("value");

        if (value != null) {
            int valLen = value.length();
            for (int i = 0; i < valLen; i++) {
                inputPhoneNumber.sendKeys(Keys.BACK_SPACE);
            }
        }

        driver.findElement(maleRadioButton).click();
        String alertForEmptyPhoneField = driver.findElement(phoneValidationAlert).getText();
        Assert.assertEquals(alertForEmptyPhoneField, "Обов'язкове поле");
        driver.findElement(phoneNumberInputField).sendKeys("+");
        String alertForShortPhoneField = driver.findElement(phoneValidationAlert).getText();
        Assert.assertEquals(alertForShortPhoneField, "Будь-ласка, введіть валідний номер телефону");
        driver.findElement(phoneNumberInputField).sendKeys("380993355566");
        return this;
    }

    public MyAccountPage checkThatUpdatedDataMayBeSaved(){
        driver.findElement(saveButton).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String alertForSuccessfulSavedData = driver.findElement(successfulAlert).getText();
        Assert.assertEquals(alertForSuccessfulSavedData, "Дані облікового запису успішно оновлені");
        driver.findElement(alertOkButton).click();
        return this;
    }

    public MyAccountPage checkThatUserMayLogout(){
        driver.findElement(logoutButton).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String logoutAlertText = driver.findElement(logoutAlert).getText();
        Assert.assertEquals(logoutAlertText,"Ви вийшли з облікового запису");
        driver.findElement(alertOkButton).click();
        return this;
    }
}
