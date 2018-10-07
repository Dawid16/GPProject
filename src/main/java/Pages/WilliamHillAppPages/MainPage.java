package Pages.WilliamHillAppPages;

import Pages.BasePage;
import junitx.util.PropertyManager;
import org.openqa.selenium.By;

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

        //for mobile click() method is not working so has to use JS executor
        if(PropertyManager.getProperty("BROWSER").toLowerCase().equals("mobile")) {
            clickOnElementByJSexec(footballField);
        } else {
            //for Web browsers
            clickOnElement(footballField);
        }

        return new FootballPage();
    }

}
