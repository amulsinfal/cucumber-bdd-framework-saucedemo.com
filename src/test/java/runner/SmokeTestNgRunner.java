package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
				features = "src/test/resources/features", 
				glue     = { "stepdefinitions", "hooks" }, 
				dryRun   = false,
				tags	 = "@Smoke",
				plugin   = {"pretty",
						    "html:reports/CucumberReports/SmokeCucumberReport.html"})
public class SmokeTestNgRunner extends AbstractTestNGCucumberTests {

}
