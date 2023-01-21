package pages.olx_home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class OlxHomePage extends BasePage {

    public OlxHomePage(WebDriver driver) {
        super(driver);
    }
    private final By setCity = By.id("cityField");
    private final By setRegion1 = By.xpath("//*[@id=\"regionslinks\"]/ul[3]/li[1]/a");
    private final By setRegion2 = By.xpath("//*[@id=\"a-region-479\"]");
    private final By searchRegion = By.xpath("//*[@id=\"submit-searchmain\"]");


    public OlxHomePage selectRegion(){
        driver.findElement(setCity).click();
        driver.findElement(setRegion1).click();
        driver.findElement(setRegion2).click();
        return this;
    }


    public OlxHomePage clickToSearch(){
        WebElement btnSearch = driver.findElement(searchRegion);
        waitElementIsVisible(btnSearch).click();
        return this;
    }
}
