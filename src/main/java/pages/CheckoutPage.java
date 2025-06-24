package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{

	private final static By CHECKOUT_LABEL_LOCATOR = By.xpath("//span[@data-test='title' and text()='Checkout: Your Information']");
	private final static By FIRST_NAME_TEXTBOX_LOCATOR = By.id("first-name");
	private final static By LAST_NAME_TEXTBOX_LOCATOR = By.id("last-name");
	private final static By POSTAL_CODE_TEXTBOX_LOCATOR = By.id("postal-code");
	private final static By CONTINUE_BUTTON_LOCATOR = By.id("continue");
	private final static By CANCEL_BUTTON_LOCATOR = By.id("cancel");
	private final static By ERROR_MESSAGE_LABEL_LOCATOR = By.xpath("//h3[@data-test='error']");
	private static final Logger logger = LogManager.getLogger(CheckoutPage.class);

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	public boolean isPageDisplayed() {
		try {
			boolean displayed = waitForElementToBeVisible(CHECKOUT_LABEL_LOCATOR).isDisplayed();
			logger.info("Checkout Page displayed: " + displayed);
			return displayed;
		} catch (Exception e) {
			logger.error("Error checking if Checkout Page is displayed. Exception : " + e.getMessage());
			return false;
		}
	}

	public CheckoutPage enterFirstName(String firstName) {
		try {
			waitForElementToBeVisible(FIRST_NAME_TEXTBOX_LOCATOR).clear();
			waitForElementToBeVisible(FIRST_NAME_TEXTBOX_LOCATOR).sendKeys(firstName);
			logger.info("Entered first name: " + firstName);
		} catch (Exception e) {
			logger.error("Error entering first name: '"+ firstName + "'. Exception : " + e.getMessage());
		}
		return this;
	}

	public CheckoutPage enterLastName(String lastName) {
		try {
			waitForElementToBeVisible(LAST_NAME_TEXTBOX_LOCATOR).clear();
			waitForElementToBeVisible(LAST_NAME_TEXTBOX_LOCATOR).sendKeys(lastName);
			logger.info("Entered last name: " + lastName);
		} catch (Exception e) {
			logger.error("Error entering last name: '"+ lastName + "'. Exception : " + e.getMessage());
		}
		return this;
	}

	public CheckoutPage enterPostalCode(String postalCode) {
		try {
			waitForElementToBeVisible(POSTAL_CODE_TEXTBOX_LOCATOR).clear();
			waitForElementToBeVisible(POSTAL_CODE_TEXTBOX_LOCATOR).sendKeys(postalCode);
			logger.info("Entered postal code: " + postalCode);
		} catch (Exception e) {
			logger.error("Error entering postal code: '"+ postalCode + "'. Exception : " + e.getMessage());
		}
		return this;
	}

	public String getErrorMessage() {
		try {
			String errorMessage = waitForElementToBeVisible(ERROR_MESSAGE_LABEL_LOCATOR).getText().trim();
			logger.info("Captured error message: " + errorMessage);
			return errorMessage;
		} catch (Exception e) {
			logger.error("Error retrieving error message. Exception : " + e.getMessage());
			return "";
		}
	}

	public CheckoutOverviewPage clickContinue() {
		try {
			waitForElementToBeClickable(CONTINUE_BUTTON_LOCATOR).click();
			logger.info("Clicked Continue button on Checkout Page");
		} catch (Exception e) {
			logger.error("Error clicking Continue button. Exception : " + e.getMessage());
		}
		return new CheckoutOverviewPage(driver);
	}

	public CartPage clickCancel() {
		try {
			waitForElementToBeClickable(CANCEL_BUTTON_LOCATOR).click();
			logger.info("Clicked Cancel button on Checkout Page");
		} catch (Exception e) {
			logger.error("Error clicking Cancel button. Exception : " + e.getMessage());
		}
		return new CartPage(driver);
	}
	
	
	///////////////////////////////////
	
//	public boolean isPageDisplayed() {
//		return waitForElementToBeVisible(CHECKOUT_LABEL_LOCATOR).isDisplayed();
//	}
//	
//	public CheckoutPage enterFirstName(String firstName) {
//		waitForElementToBeVisible(FIRST_NAME_TEXTBOX_LOCATOR).clear();
//		waitForElementToBeVisible(FIRST_NAME_TEXTBOX_LOCATOR).sendKeys(firstName);
//		return this;
//	}
//	
//	public CheckoutPage enterLastName(String lastName) {
//		waitForElementToBeVisible(LAST_NAME_TEXTBOX_LOCATOR).clear();
//		waitForElementToBeVisible(LAST_NAME_TEXTBOX_LOCATOR).sendKeys(lastName);
//		return this;
//	}
//	
//	public CheckoutPage enterPostalCode(String postalCode) {
//		waitForElementToBeVisible(POSTAL_CODE_TEXTBOX_LOCATOR).clear();
//		waitForElementToBeVisible(POSTAL_CODE_TEXTBOX_LOCATOR).sendKeys(postalCode);
//		return this;
//	}
//	
//	public String getErrorMessage() {
//		return waitForElementToBeVisible(ERROR_MESSAGE_LABEL_LOCATOR).getText().trim();
//	}
//	
//	public CheckoutOverviewPage clickContinue() {
//		waitForElementToBeClickable(CONTINUE_BUTTON_LOCATOR).click();
//		return new CheckoutOverviewPage(driver);
//	}
//	
//	public CartPage clickCancel() {
//		waitForElementToBeClickable(CANCEL_BUTTON_LOCATOR).click();
//		return new CartPage(driver);
//	}
	
}
