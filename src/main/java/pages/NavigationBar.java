package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar extends BasePage{

	private final static By MENU_BUTTON_LOCATOR = By.id("react-burger-menu-btn");
	private final static By LOGOUT_LINK_LOCATOR = By.id("logout_sidebar_link");
	private final static By CART_BADGE_LABEL_LOCATOR = By.xpath("//span[@class='shopping_cart_badge']");
	private final static By CART_BUTTON_LOCATOR = By.xpath("//a[@class='shopping_cart_link']");
	private static final Logger logger = LogManager.getLogger(NavigationBar.class);

	public NavigationBar(WebDriver driver) {
		super(driver);
	}
	
	
	public NavigationBar clickMenuButton() {
		try {
			waitForElementToBeClickable(MENU_BUTTON_LOCATOR).click();
			logger.info("Clicked Menu button");
		} catch (Exception e) {
			logger.error("Error clicking Menu button. Exception : " + e.getMessage());
		}
		return this;
	}

	public LoginPage clickLogoutLink() {
		try {
			waitForElementToBeClickable(LOGOUT_LINK_LOCATOR).click();
			logger.info("Clicked Logout link");
		} catch (Exception e) {
			logger.error("Error clicking Logout link. Exception : " + e.getMessage());
		}
		return new LoginPage(driver);
	}

	public boolean isLogoutLinkDisplayed() {
		try {
			boolean displayed = waitForElementToBeVisible(LOGOUT_LINK_LOCATOR).isDisplayed();
			logger.info("Logout link displayed: " + displayed);
			return displayed;
		} catch (Exception e) {
			logger.error("Error checking if Logout link is displayed. Exception : " + e.getMessage());
			return false;
		}
	}

	public String getCartCount() {
		try {
			String count = waitForElementToBeVisible(CART_BADGE_LABEL_LOCATOR).getText();
			logger.info("Cart badge count: " + count);
			return count;
		} catch (Exception e) {
			logger.error("Error retrieving cart badge count. Exception : " + e.getMessage());
			return "0";
		}
	}

	public boolean isCartBadgeDisplayed() {
		try {
			boolean displayed = waitForElementToBeVisible(CART_BADGE_LABEL_LOCATOR).isDisplayed();
			logger.info("Cart badge is displayed: " + displayed);
			return displayed;
		} catch (Exception e) {
			logger.error("Error checking if cart badge is displayed. Exception : " + e.getMessage());
			return false;
		}
	}

	public CartPage clickCartButton() {
		try {
			waitForElementToBeClickable(CART_BUTTON_LOCATOR).click();
			logger.info("Clicked Cart button");
		} catch (Exception e) {
			logger.error("Error clicking Cart button. Exception : " + e.getMessage());
		}
		return new CartPage(driver);
	}
	
	
	////////////
	
//	public NavigationBar clickMenuButton() {
//		waitForElementToBeClickable(MENU_BUTTON_LOCATOR).click();
//		return this;
//	}
//	
//	public LoginPage clickLogoutLink() {
//		waitForElementToBeClickable(LOGOUT_LINK_LOCATOR).click();
//		return new LoginPage(driver);
//	}
//
//	public boolean isLogoutLinkDisplayed() {
//		return waitForElementToBeVisible(LOGOUT_LINK_LOCATOR).isDisplayed();
//	}
//	
//	public String getCartCount() {
//		return waitForElementToBeVisible(CART_BADGE_LABEL_LOCATOR).getText();
//	}
//	
//	public boolean isCartBadgeDisplayed() {
//		return waitForElementToBeVisible(CART_BADGE_LABEL_LOCATOR).isDisplayed();
//	}
//	
//	public CartPage clickCartButton() {
//		waitForElementToBeClickable(CART_BUTTON_LOCATOR).click();
//		return new CartPage(driver);
//	}

}
