package Pages.WilliamHillAppPages;

import Pages.BasePage;
import junitx.util.PropertyManager;
import org.openqa.selenium.By;

/**
 * Created by Dawidek on 2018-10-03.
 */
public class FootballPage extends BasePage {

    public FootballPage() {
        this.PAGE_TITLE = "Online Betting from William Hill - The Home of Betting";
        this.PAGE_URL = BASE_URL + "/football";
    }

    private final By competitionsField = By.xpath("//a[@title='football-competitions']");
    private final By competitionsFieldMobile = By.xpath("//a[@class='btn btn--tiny'][@data-position='4']/div");

    public CompetitionsPage clickOnCompetitionsField(){

        //for mobile click() method is not working so has to use JS executor
        if(PropertyManager.getProperty("BROWSER").toLowerCase().equals("mobile")) {
            clickOnElementByJSexec(competitionsFieldMobile);
        } else{
        clickOnElement(competitionsField);
        }
        return new CompetitionsPage();
    }



}
