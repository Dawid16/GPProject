package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junitx.util.PropertyManager;

import static Driver.DriverManager.createChromeDriver;
import static Driver.DriverManager.createChromeMobileDriver;
import static Driver.DriverManager.createFirefoxDriver;


/**
 * Created by Dawidek on 2018-10-03.
 */
public class Driver {

    //Setting webdriver as Singleton in order to have the control of the driver (only one instance should be created)

    public static WebDriver driver;

    public static WebDriver getDriver() {
        if (null == driver) {
            driver = new ChromeDriver();
            System.setProperty("webdriver.chrome.driver", "D://GPProject//src//main//resources//drivers//chromedriver.exe");
        }
        return driver;
    }

    //driver parametrized based on the DriverSetup.properties file

    public static WebDriver getDriver(EBrowser browser) {
        switch (browser){
            case FIREFOX:
                driver = createFirefoxDriver();
                break;
            case CHROME:
                driver = createChromeDriver();
                break;
            case MOBILE:
                driver = createChromeMobileDriver();
                break;
            default:
                driver = createChromeDriver();
                break;
        }
        return driver;
    }

    //Enum helper

    public static EBrowser getBrowserName(){
        switch(PropertyManager.getProperty("BROWSER").toLowerCase()){
            case "firefox":
                return EBrowser.FIREFOX;
            case "chrome":
                return EBrowser.CHROME;
            case "mobile":
                return EBrowser.MOBILE;
            default:
                return EBrowser.CHROME;
        }
    }

    public static void quit() {
        if(null != driver) {
            getDriver().quit();
        }
        driver = null;
    }

}
