package Pages.WilliamHillAppPages;

import Pages.BasePage;
import junitx.util.PropertyManager;
import org.openqa.selenium.By;

/**
 * Created by Dawidek on 2018-10-06.
 */
public class CompetitionsPage extends BasePage{

    public CompetitionsPage() {
        this.PAGE_TITLE = "Online Betting from William Hill - The Home of Betting";
        this.PAGE_URL = BASE_URL + "/football/competitions";
    }

    private final By englishPLfield = By.xpath("//span[contains(text(),'English Premier League')]");
    private final By englishPLfieldMobile = By.xpath("//tbody[@data-test-id='Grid.tbody']/tr[2]//a");


    //for mobile click() method is not working so has to use JS executor
    public EnglishPremierLeaguePage clickOnEnglishPLfield(){
        if(PropertyManager.getProperty("BROWSER").toLowerCase().equals("mobile")) {
            clickOnElementByJSexec(englishPLfieldMobile);
        } else{
            clickOnElement(englishPLfield);
        }
        return new EnglishPremierLeaguePage();
    }
}
