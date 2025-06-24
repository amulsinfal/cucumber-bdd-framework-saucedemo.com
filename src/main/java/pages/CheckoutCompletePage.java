package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {

	private final static By CHECKOUT_COMPLETED_LABEL_LOCATOR = By.xpath("//span[@data-test='title' and text()='Checkout: Complete!']");
	private final static By COMPELETE_MESSAGE_LABEL_LOCATOR = By.xpath("//h2[@class='complete-header']");
	private final static By HOME_BUTTON_LOCATOR = By.id("back-to-products");
	private static final Logger logger = LogManager.getLogger(CheckoutCompletePage.class);

	public CheckoutCompletePage(WebDriver driver) {
		super(driver);
	}

//	public boolean isPageDisplayed() {
//		return waitForElementToBeVisible(CHECKOUT_COMPLETED_LABEL_LOCATOR).isDisplayed();
//	}

	public boolean isPageDisplayed() {
		try {
			boolean displayed = waitForElementToBeVisible(CHECKOUT_COMPLETED_LABEL_LOCATOR).isDisplayed();
			logger.info("Checkout Complete page displayed: " + displayed);
			return displayed;
		} catch (Exception e) {
			logger.error("Error checking if Checkout Complete page is displayed. Exception: " + e.getMessage());
			return false;
		}
	}
	
//	public boolean isSuccessMessageDisplayed() {
//		return waitForElementToBeVisible(COMPELETE_MESSAGE_LABEL_LOCATOR).isDisplayed();
//	}
	
	public boolean isSuccessMessageDisplayed() {
		try {
			boolean displayed = waitForElementToBeVisible(COMPELETE_MESSAGE_LABEL_LOCATOR).isDisplayed();
			logger.info("Success message displayed: " + displayed);
			return displayed;
		} catch (Exception e) {
			logger.error("Error checking if success message is displayed. Exception: " + e.getMessage());
			return false;
		}
	}
	
//	public String getSuccessMessage() {
//		return waitForElementToBeVisible(COMPELETE_MESSAGE_LABEL_LOCATOR).getText();
//	}

	public String getSuccessMessage() {
		try {
			String message = waitForElementToBeVisible(COMPELETE_MESSAGE_LABEL_LOCATOR).getText();
			logger.info("Success message text: " + message);
			return message;
		} catch (Exception e) {
			logger.error("Error retrieving success message. Exception: " + e.getMessage());
			return "";
		}
	}
	
//	public ProductsPage clickBackHome() {
//		waitForElementToBeClickable(HOME_BUTTON_LOCATOR).click();
//		return new ProductsPage(driver);
//	}

	public ProductsPage clickBackHome() {
		try {
			waitForElementToBeClickable(HOME_BUTTON_LOCATOR).click();
			logger.info("Clicked 'Back Home' button.");
		} catch (Exception e) {
			logger.error("Error clicking 'Back Home' button. Exception: " + e.getMessage());
		}
		return new ProductsPage(driver);
	}
	
}
