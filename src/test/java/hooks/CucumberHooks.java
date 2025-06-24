package hooks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ConfigReader;

public class CucumberHooks {
	
	protected WebDriver driver;
	private static final Logger logger = LogManager.getLogger(CucumberHooks.class);

	@Before
	public void setup() {
		
		String browser = ConfigReader.getValue("browser");
		String testUrl = ConfigReader.getValue("testUrl");
		
		driver = DriverFactory.intializeDriver(browser);
		logger.info(browser + " browser launched successfully.");
		driver.get(testUrl);
		logger.info("Navigating to url: " + testUrl);

	}

	@After
	public void tearDown(Scenario scenario) {
		String screenshotName = scenario.getName().replaceAll(" ", "_");
		if (scenario.isFailed()) {
			byte[] sourceScreenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourceScreenshot, "image/png", screenshotName);
			logger.error("Scenario '" + screenshotName + "' failed. Screenshot captured.");
		}
		driver.quit();
	}
}
