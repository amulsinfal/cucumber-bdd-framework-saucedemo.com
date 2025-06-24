package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
				features = "src/test/resources/features", 
				glue     = { "stepdefinitions", "hooks" }, 
				dryRun   = false,
				tags	 = "@Sanity",
				plugin   = {"pretty",
						    "html:reports/CucumberReports/SanityCucumberReport.html"})
public class SanityTestNgRunner extends AbstractTestNGCucumberTests {

}
