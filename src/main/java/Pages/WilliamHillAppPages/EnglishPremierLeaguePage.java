package Pages.WilliamHillAppPages;

import org.openqa.selenium.By;

/**
 * Created by Dawidek on 2018-10-06.
 */
public class EnglishPremierLeaguePage extends MainPage{

    public EnglishPremierLeaguePage() {
        this.PAGE_TITLE = "Online Betting from William Hill - The Home of Betting";
        this.PAGE_URL = BASE_URL + "/football/competitions/OB_TY295/English-Premier-League/matches/OB_MGMB/Match-Betting";
    }

    private final By betForHomeTeamButton = By.xpath("//div[@id='football']//div[5]//article[1]//button[1]");
    private final By stakeField = By.xpath("//span/input[@data-ng-model='bet.stake']");
    private final By placeBetButton = By.xpath("//input[@data-ng-click='placeBet()']");
    private final By toReturnField = By.xpath("//span[@id='total-to-return-price']");
    private final By totalStakeField = By.xpath("//span[@id='total-stake-price']");

    public EnglishPremierLeaguePage betForHomeTeamToWin() {
        clickOnElement(betForHomeTeamButton);
        return this;
    }

    public EnglishPremierLeaguePage setStake(double stake) {
        provideInput(stakeField, String.valueOf(stake));
        return this;
    }

    public EnglishPremierLeaguePage clickPlaceBetButton() {
        clickOnElementByActions(placeBetButton);
        return this;
    }

    public double getToReturnAmount() {
        return getLabelTextAsDouble(toReturnField);
    }

    public double getTotalStake() {
        return getLabelTextAsDouble(totalStakeField);
    }

    //getting bid in format 0.00
    public double getBidAmount() {
        return getAndConvertBidAmount(betForHomeTeamButton);
    }

}
