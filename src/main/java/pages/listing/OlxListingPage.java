package pages.listing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;

public class OlxListingPage extends BasePage {

    public OlxListingPage(WebDriver driver) {
        super(driver);
    }

    private final By card = By.xpath("//div[@class='css-qfzx1y']");

    public OlxListingPage checkCountCards (){
        int countCard = driver.findElements(card).size();
        Assert.assertEquals(countCard, 52);
        return this;
    }
}
