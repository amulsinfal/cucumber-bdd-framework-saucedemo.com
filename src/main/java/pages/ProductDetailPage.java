package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage {

	private final static By PRODUCT_NAME_LABEL_LOCATOR = By.xpath("//div[@class='inventory_details_name large_size']");
	private final static By PRODUCT_DESCRIPTION_LABEL_LOCATOR = By.xpath("//div[@class='inventory_details_desc large_size']");
	private final static By PRODUCT_PRICE_LABEL_LOCATOR = By.xpath("//div[@class='inventory_details_price']");
	private final static By BACK_TO_PRODUCTS_BUTTON_LOCATOR = By.id("back-to-products");
	private static final Logger logger = LogManager.getLogger(ProductDetailPage.class);

	public ProductDetailPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isPageDisplayed() {
		try {
			boolean displayed = waitForElementToBeVisible(BACK_TO_PRODUCTS_BUTTON_LOCATOR).isDisplayed();
			logger.info("Product Detail page displayed: " + displayed);
			return displayed;
		} catch (Exception e) {
			logger.error("Error checking if Product Detail page is displayed. Exception : " + e.getMessage());
			return false;
		}
	}

	public String getProductName() {
		try {
			String name = waitForElementToBeVisible(PRODUCT_NAME_LABEL_LOCATOR).getText();
			logger.info("Product name: " + name);
			return name;
		} catch (Exception e) {
			logger.error("Error retrieving product name. Exception : " + e.getMessage());
			return "";
		}
	}

	public String getProductDescription() {
		try {
			String description = waitForElementToBeVisible(PRODUCT_DESCRIPTION_LABEL_LOCATOR).getText();
			logger.info("Product description: " + description);
			return description;
		} catch (Exception e) {
			logger.error("Error retrieving product description. Exception : " + e.getMessage());
			return "";
		}
	}

	public String getProductPrice() {
		try {
			String price = waitForElementToBeVisible(PRODUCT_PRICE_LABEL_LOCATOR).getText().trim().replace("$", "");
			logger.info("Product price: " + price);
			return price;
		} catch (Exception e) {
			logger.error("Error retrieving product price. Exception : " + e.getMessage());
			return "";
		}
	}
	
	
	//////////////////////////////
	
//	public boolean isPageDisplayed() {
//		return waitForElementToBeVisible(BACK_TO_PRODUCTS_BUTTON_LOCATOR).isDisplayed();
//	}
//	
//	public String getProductName() {
//		return waitForElementToBeVisible(PRODUCT_NAME_LABEL_LOCATOR).getText();
//	}
//	
//	public String getProductDescription() {
//		return waitForElementToBeVisible(PRODUCT_DESCRIPTION_LABEL_LOCATOR).getText();
//	}
//	
//	public String getProductPrice() {
//		return waitForElementToBeVisible(PRODUCT_PRICE_LABEL_LOCATOR).getText().trim().replace("$", "");
//	}

}
