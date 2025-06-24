package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
			features = "src/test/resources/features", 
			glue     = { "stepdefinitions", "hooks" }, 
			dryRun   = false,
			tags	 = "@Regression",
			plugin   = {"pretty", "html:reports/CucumberReports/RegressionCucumberReport.html"}
		)
public class RegressionTestNgRunner extends AbstractTestNGCucumberTests {

}
