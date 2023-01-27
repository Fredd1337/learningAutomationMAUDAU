package pages.listing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;

public class MaudauListingPage extends BasePage {

    public MaudauListingPage(WebDriver driver) {
        super(driver);
    }

    private final By card = By.xpath("//div[@class='css-qfzx1y']");

    public MaudauListingPage checkCountCards (){
        int countCard = driver.findElements(card).size();
        Assert.assertEquals(countCard, 52);
        return this;
    }
}
