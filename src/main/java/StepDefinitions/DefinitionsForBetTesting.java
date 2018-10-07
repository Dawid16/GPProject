package StepDefinitions;

import Pages.WilliamHillAppPages.CompetitionsPage;
import Pages.WilliamHillAppPages.EnglishPremierLeaguePage;
import Pages.WilliamHillAppPages.FootballPage;
import Pages.WilliamHillAppPages.MainPage;
import Runner.BaseTest;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by Dawidek on 2018-10-04.
 */
public class DefinitionsForBetTesting extends BaseTest {

    MainPage mainPage;
    FootballPage footballPage;
    CompetitionsPage competitionsPage;
    EnglishPremierLeaguePage engPLPage;

    private double stake = 0.05;

    @Before
    public void initialization(){
        initializeDriver();
        mainPage = new MainPage();
    }

    @Given("^I navigate to a Football bets$")
    public void navigateToFootballBets() throws Throwable {
        footballPage = mainPage.clickOnFootballField();

    }

    @When("^I navigate to competitions Site$")
    public void iNavigateToCompetitionsSite() throws Throwable {
        competitionsPage = footballPage.clickOnCompetitionsField();

    }

    @And("^I navigate to the English Premier League Events$")
    public void iNavigateToTheEnglishPremierLeagueEvents() throws Throwable {
        engPLPage = competitionsPage.clickOnEnglishPLfield();
    }

    @And("^I select an event and place a bet for the Home team to win$")
    public void selectAndPlaceBet() throws Throwable {
        engPLPage.betForHomeTeamToWin().setStake(stake).clickPlaceBetButton();

    }

    @Then("^I should see proper results of bet$")
    public void checkResult() throws Throwable {
        double currentTotalStake = engPLPage.getTotalStake();
        double currentToReturnAmount= engPLPage.getToReturnAmount();
        double currentBidAmount = engPLPage.getBidAmount();

        double expectedToReturnAmount = stake*currentBidAmount;

        Assert.assertEquals("Difference in total stake", stake, currentTotalStake, 0.01);
        Assert.assertEquals("Difference in expected win amount", expectedToReturnAmount, currentToReturnAmount, 0.01);

    }

    @After
    public void quit(){
        quitDriver();

    }



}
