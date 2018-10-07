package Runner;

/**
 * Created by Dawidek on 2018-10-04.
 */

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"D:\\GPProject\\src\\main\\java\\Features\\PlacingBets.feature"},
        glue = {"StepDefinitions"},
        format = {"pretty", "json:target/cucumber.json", "html:target/cucumber.html"}     //creating reports
)

public class TestRunner {

}
