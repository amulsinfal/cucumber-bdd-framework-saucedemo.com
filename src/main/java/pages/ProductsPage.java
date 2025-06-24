package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage{

	private final static By PAGE_HEADER_LABEL_LOCATOR = By.xpath("//span[@class='title' and text()='Products']");
	private static final Logger logger = LogManager.getLogger(ProductsPage.class);

	public NavigationBar navigationBar;
	
	public ProductsPage(WebDriver driver) {
		super(driver);
		navigationBar = new NavigationBar(driver);
	}
	
	public NavigationBar getNavigationBar() {
		return navigationBar;
	}

	public boolean isPageDisplayed() {
		try {
			boolean displayed = waitForElementToBeVisible(PAGE_HEADER_LABEL_LOCATOR).getText().equals("Products");
			logger.info("Products page displayed: " + displayed);
			return displayed;
		} catch (Exception e) {
			logger.error("Error checking if Products page is displayed. Exception : " + e.getMessage());
			return false;
		}
	}

	public boolean isProductPresent(String productName) {
		try {
			By locator = By.xpath("//div[@class='inventory_item_name ' and text()='" + productName + "']");
			boolean present = waitForElementToBeVisible(locator).isDisplayed();
			logger.info("Product '" + productName + "' present on Products page: " + present);
			return present;
		} catch (Exception e) {
			logger.error("Error checking if product '" + productName + "'  is present. Exception : " + e.getMessage());
			return false;
		}
	}

	public ProductDetailPage clickProductName(String productName) {
		try {
			By locator = By.xpath("//div[@class='inventory_item_name ' and text()='" + productName + "']");
			waitForElementToBeClickable(locator).click();
			logger.info("Clicked product name: " + productName);
		} catch (Exception e) {
			logger.error("Error clicking product name: '" + productName + "'. Exception : " + e.getMessage());
		}
		return new ProductDetailPage(driver);
	}

	public String getProductDescription(String productName) {
		try {
			By locator = By.xpath("//div[@class='inventory_item_name ' and text()='" + productName + "']/parent::a/following-sibling::div[@class='inventory_item_desc']");
			String description = waitForElementToBeVisible(locator).getText();
			logger.info("Description for '" + productName + "': " + description);
			return description;
		} catch (Exception e) {
			logger.error("Error getting product description for '" + productName + "'. Exception : " + e.getMessage());
			return "";
		}
	}

	public String getProductPrice(String productName) {
		try {
			By locator = By.xpath("//div[@class='inventory_item_name ' and text()='" + productName + "']/ancestor::div[@class='inventory_item_label']/following-sibling::div[@class='pricebar']/div[@class='inventory_item_price']");
			String price = waitForElementToBeVisible(locator).getText().trim().replace("$", "");
			logger.info("Price for '" + productName + "': " + price);
			return price;
		} catch (Exception e) {
			logger.error("Error getting product price for '" + productName + "'. Exception : " + e.getMessage());
			return "";
		}
	}

	public ProductsPage addProductToCart(String productName) {
		try {
			By locator = By.xpath("//div[@class='inventory_item_name ' and text()='" + productName + "']/ancestor::div[@class='inventory_item_description']//button");
			waitForElementToBeClickable(locator).click();
			logger.info("Added product '" + productName+ "' to cart.");
		} catch (Exception e) {
			logger.error("Error adding product '" + productName+ "' to cart. Exception : " + e.getMessage());
		}
		return this;
	}
	
	///////////////////////////////////////
	
//	public boolean isPageDisplayed() {
//		return waitForElementToBeVisible(PAGE_HEADER_LABEL_LOCATOR).getText().equals("Products");
//	}
//	
//	public boolean isProductPresent(String productName) {
//		return waitForElementToBeVisible(By.xpath("//div[@class='inventory_item_name ' and text()='" + productName + "']")).isDisplayed();
//	}
//	
//	public ProductDetailPage clickProductName(String productName) {
//		waitForElementToBeClickable(By.xpath("//div[@class='inventory_item_name ' and text()='" + productName + "']")).click();
//		return new ProductDetailPage(driver);
//	}
//	
//	public String getProductDescription(String productName) {
//		return waitForElementToBeVisible(By.xpath("//div[@class='inventory_item_name ' and text()='" + productName + "']/parent::a/following-sibling::div[@class='inventory_item_desc']")).getText();
//	}
//	
//	public String getProductPrice(String productName) {
//		return waitForElementToBeVisible(By.xpath("//div[@class='inventory_item_name ' and text()='" + productName + "']/ancestor::div[@class='inventory_item_label']/following-sibling::div[@class='pricebar']/div[@class='inventory_item_price']")).getText().trim().replace("$", "");
//	}
//	
//	public ProductsPage addProductToCart(String productName) {
//		waitForElementToBeClickable(By.xpath("//div[@class='inventory_item_name ' and text()='" + productName + "']/ancestor::div[@class='inventory_item_description']//button")).click();
//		return this;
//	}
}
