package Runner;

import Driver.Driver;

/**
 * Created by Dawidek on 2018-10-05.
 */
public class BaseTest {

    //BaseTest which is going to be extended by every step definition

    public void initializeDriver(){
        Driver.getDriver(Driver.getBrowserName()).navigate().to("http://sports.williamhill.com/betting/en-gb");
    }

    public void quitDriver(){
        Driver.quit();
    }

}
