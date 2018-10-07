package Pages;

import Driver.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static Driver.Driver.driver;

/**
 * Created by Dawidek on 2018-10-03.
 */
public class BasePage {

    //base class that is extended by every PageClass of the app
    //the class contains common methods which might be used by the child classess

    protected WebDriverWait wait;
    protected Actions actions;
    protected JavascriptExecutor jsExecutor;

    final int BASE_TIMEOUTS_SECONDS = 8;

    protected String BASE_URL = "http://sports.williamhill.com/betting/en-gb";
    protected String PAGE_TITLE;
    protected String PAGE_URL;

    public BasePage(){
        wait = new WebDriverWait(Driver.getDriver(), BASE_TIMEOUTS_SECONDS);
        actions = new Actions(Driver.getDriver());
        jsExecutor = ((JavascriptExecutor) Driver.getDriver());
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    public String getPageURL() {
        return PAGE_URL;
    }
    public String getPageTitle() {
        return PAGE_TITLE;
    }

    protected void clickOnElement(By elementBy){
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
        Driver.getDriver().findElement(elementBy).click();
    }

    protected void clickOnElementByActions(By elementBy){
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
        actions.moveToElement(findElement(elementBy)).click().perform();
    }

    protected WebElement findElement(By elementBy){
        return Driver.getDriver().findElement(elementBy);
    }

    protected Double getLabelTextAsDouble(By elementBy){
        return Double.valueOf(Driver.getDriver().findElement(elementBy).getText());
    }

    protected Double getAndConvertBidAmount(By elementBy){
        String text = Driver.getDriver().findElement(elementBy).getText();
        String[] numbers = text.split("/");

        double i1 = Double.valueOf(numbers[0]);
        double i2 = Double.valueOf(numbers[1]);
        return (i1/i2) + 1;
    }

    protected List<WebElement> findElements(By elementBy){
        return Driver.getDriver().findElements(elementBy);
    }

    protected void provideInput(By inputBy, CharSequence value){
        wait.until(ExpectedConditions.elementToBeClickable(inputBy));
        WebElement input = Driver.getDriver().findElement(inputBy);
        input.clear();
        input.sendKeys(value);
        Assert.assertEquals(input.getAttribute("value"), value);

    }

}
