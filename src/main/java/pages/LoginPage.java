package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

	private final static By USERNAME_TEXTBOX_LOCATOR = By.id("user-name");
	private final static By PASSWORD_TEXTBOX_LOCATOR = By.id("password");
	private final static By LOGIN_BUTTON_LOCATOR = By.id("login-button");
	private final static By ERROR_LABEL_LOCATOR = By.xpath("//h3[@data-test='error']");
	private static final Logger logger = LogManager.getLogger(LoginPage.class);

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isPageDisplayed() {
		try {
			boolean displayed = waitForElementToBeVisible(LOGIN_BUTTON_LOCATOR).isDisplayed();
			logger.info("Login page is displayed: " + displayed);
			return displayed;
		} catch (Exception e) {
			logger.error("Error verifying if login page is displayed. Exception : " + e.getMessage());
			return false;
		}
	}

	public LoginPage enterUsername(String username) {
		try {
			waitForElementToBeClickable(USERNAME_TEXTBOX_LOCATOR).clear();
			waitForElementToBeClickable(USERNAME_TEXTBOX_LOCATOR).sendKeys(username);
			logger.info("Entered username: " + username);
		} catch (Exception e) {
			logger.error("Error entering username: '" + username + "'. Exception : " + e.getMessage());
		}
		return this;
	}

	public LoginPage enterPassword(String password) {
		try {
			waitForElementToBeClickable(PASSWORD_TEXTBOX_LOCATOR).clear();
			waitForElementToBeClickable(PASSWORD_TEXTBOX_LOCATOR).sendKeys(password);
			logger.info("Entered password: " + password);
		} catch (Exception e) {
			logger.error("Error entering password: '" + password + "'. Exception : " + e.getMessage());
		}
		return this;
	}

	public ProductsPage clickLoginButton() {
		try {
			waitForElementToBeClickable(LOGIN_BUTTON_LOCATOR).click();
			logger.info("Clicked Login button");
		} catch (Exception e) {
			logger.error("Error clicking Login button. Exception : " + e.getMessage());
		}
		return new ProductsPage(driver);
	}

	public String getErrorMessage() {
		try {
			String errorMessage = waitForElementToBeVisible(ERROR_LABEL_LOCATOR).getText().trim();
			logger.info("Captured login error message: " + errorMessage);
			return errorMessage;
		} catch (Exception e) {
			logger.error("Error retrieving login error message. Exception : " + e.getMessage());
			return "";
		}
	}

	public boolean isErrorDisplayed() {
		try {
			boolean isDisplayed = waitForElementToBeVisible(ERROR_LABEL_LOCATOR).isDisplayed();
			logger.info("Login error message displayed: " + isDisplayed);
			return isDisplayed;
		} catch (Exception e) {
			logger.error("Error checking if error message is displayed. Exception : " + e.getMessage());
			return false;
		}
	}
	
	
	/////////////////////////////////////////
	

//	
//	public boolean isPageDisplayed() {
//		return waitForElementToBeVisible(LOGIN_BUTTON_LOCATOR).isDisplayed();
//	}
//	
//	public LoginPage enterUsername(String username) {
//		waitForElementToBeClickable(USERNAME_TEXTBOX_LOCATOR).sendKeys(username);
//		return this;
//	}
//	
//	public LoginPage enterPassword(String password) {
//		waitForElementToBeClickable(PASSWORD_TEXTBOX_LOCATOR).sendKeys(password);
//		return this;
//	}
//	
//	public ProductsPage clickLoginButton() {
//		waitForElementToBeClickable(LOGIN_BUTTON_LOCATOR).click();
//		return new ProductsPage(driver);
//	}
//	
//	public String getErrorMessage() {
//		return waitForElementToBeVisible(ERROR_LABEL_LOCATOR).getText();
//	}
//	
//	public boolean isErrorDisplayed() {
//		return waitForElementToBeVisible(ERROR_LABEL_LOCATOR).isDisplayed();
//	}
}
