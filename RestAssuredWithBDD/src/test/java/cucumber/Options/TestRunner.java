package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
			features = "src/test/java/features",
			glue = {"stepDefinations"},
			plugin = {"pretty", "json:Reports/jsonReports/cucumber.json"}
			
		)

public class TestRunner {

}
