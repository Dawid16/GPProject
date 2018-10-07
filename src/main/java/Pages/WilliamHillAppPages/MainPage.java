package Pages.WilliamHillAppPages;

import Driver.Driver;
import Pages.BasePage;
import junitx.util.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Dawidek on 2018-10-03.
 */
public class MainPage extends BasePage {

    public MainPage(){
        this.PAGE_TITLE = "title";
        this.PAGE_URL = BASE_URL;
    }

    private final By footballField = By.id("nav-football");

    public FootballPage clickOnFootballField(){

        //for Mobile emulation
        if(PropertyManager.getProperty("BROWSER").toLowerCase().equals("mobile")) {
            WebElement element = Driver.getDriver().findElement(footballField);
            jsExecutor.executeScript("arguments[0].click();", element);
        } else {
            //for Web browsers
            clickOnElement(footballField);
        }

        return new FootballPage();
    }

}
