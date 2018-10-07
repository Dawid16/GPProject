package Waits;

import Driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Dawidek on 2018-10-07.
 */
public class CustomWaits {

    //custom wait for stale element avoiding
    public static void waitForElementPresent(final By by, int timeout){
        WebDriverWait wait = (WebDriverWait)new WebDriverWait(Driver.getDriver(),timeout)
                .ignoring(StaleElementReferenceException.class);
        wait.until(new ExpectedCondition<Boolean>(){
            @Override
            public Boolean apply(WebDriver webDriver) {
                WebElement element = webDriver.findElement(by);
                return element != null && element.isDisplayed();
            }
        });
    }
}
