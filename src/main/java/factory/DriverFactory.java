package factory;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import utilities.ConfigReader;

public class DriverFactory {

	private static WebDriver driver;
	private static final Logger logger = LogManager.getLogger(DriverFactory.class);

	public static WebDriver intializeDriver(String browserName) {
		logger.info("Initializing WebDriver for browser: " + browserName);

		try {
			if (browserName.equalsIgnoreCase("Chrome")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--incognito");
				driver = new ChromeDriver(options);
			} else if (browserName.equalsIgnoreCase("Firefox")) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--private");
				driver = new FirefoxDriver(options);
			} else if (browserName.equalsIgnoreCase("Edge")) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--inprivate");
				driver = new EdgeDriver(options);
			} else {
				logger.warn("Unsupported browser '" + browserName + "'. Launching Chrome.");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--incognito");
				driver = new ChromeDriver(options);
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getValue("implicitWait"))));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getValue("pageLoadTime"))));
			driver.manage().deleteAllCookies();
			logger.info("Driver initialized and configured successfully.");
		} catch (NumberFormatException e) {
			logger.error("Failed to initialize WebDriver for browser: " + browserName);
			throw new RuntimeException("WebDriver initialization failed: " + e.getMessage());
		}
		return driver;
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			logger.warn("WebDriver instance is null.");
		}
		return driver;	}
}
