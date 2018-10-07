package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dawidek on 2018-10-04.
 */
public class DriverManager {

    //creating drivers

    public static WebDriver createChromeDriver(){

        System.setProperty("webdriver.chrome.driver", "D://GPProject//src//main//resources//drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        return driver;

    }

    public static WebDriver createChromeMobileDriver(){

        System.setProperty("webdriver.chrome.driver", "D://GPProject//src//main//resources//drivers//chromedriver.exe");

        Map<String, String> mobileEmulation = new HashMap<>();

        mobileEmulation.put("deviceName", "iPhone 8 Plus");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new ChromeDriver(chromeOptions);
        return driver;
    }

    public static WebDriver createFirefoxDriver(){
        return new FirefoxDriver();
    }
}
