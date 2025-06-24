package pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage extends BasePage {

	private final static By CHECKOUT_OVERVIEW_LABEL_LOCATOR = By.xpath("//span[@data-test='title' and text()='Checkout: Overview']");
	private final static By SUBTOTAL_LABEL_LOCATOR = By.xpath("//div[@class='summary_subtotal_label']");
	private final static By TAX_LABEL_LOCATOR = By.xpath("//div[@class='summary_tax_label']");
	private final static By TOTAL_LABEL_LOCATOR = By.xpath("//div[@class='summary_total_label']");
	private final static By FINISH_BUTTON_LOCATOR = By.id("finish");
	private final static By CANCEL_BUTTON_LOCATOR = By.id("cancel");
	private static final Logger logger = LogManager.getLogger(CheckoutOverviewPage.class);

	public CheckoutOverviewPage(WebDriver driver) {
		super(driver);
	}

	
	public boolean isPageDisplayed() {
		try {
			boolean displayed = waitForElementToBeVisible(CHECKOUT_OVERVIEW_LABEL_LOCATOR).isDisplayed();
			logger.info("Checkout Overview page displayed: " + displayed);
			return displayed;
		} catch (Exception e) {
			logger.error("Error checking if Checkout Overview page is displayed. Exception : " + e.getMessage());
			return false;
		}
	}

	public boolean isProductPresent(String productName) {
		try {
			List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']"));
			boolean present = !products.isEmpty();
			logger.info("Product '" + productName + "' present in overview: " + present);
			return present;
		} catch (Exception e) {
			logger.error("Error checking if product '" + productName + "' is present. Exception: " + e.getMessage());
			return false;
		}
	}

	public String getProductDescription(String productName) {
		try {
			By descLocator = By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']//ancestor::div[@class='cart_item_label']/div[@class='inventory_item_desc']");
			String description = waitForElementToBeVisible(descLocator).getText().trim();
			logger.info("Product '" + productName + "' description: " + description);
			return description;
		} catch (Exception e) {
			logger.error("Error getting description for product '" + productName + "'. Exception: " + e.getMessage());
			return "";
		}
	}

	public String getProductPrice(String productName) {
		try {
			By priceLocator = By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']/ancestor::div[@class='cart_item_label']/descendant::div[@class='inventory_item_price']");
			String price = waitForElementToBeVisible(priceLocator).getText().trim().replace("$", "");
			logger.info("Product '" + productName + "' price: " + price);
			return price;
		} catch (Exception e) {
			logger.error("Error getting price for product '" + productName + "'. Exception: " + e.getMessage());
			return "";
		}
	}

	public String getProductQuantity(String productName) {
		try {
			By quantityLocator = By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']/ancestor::div[@class='cart_item']/div[@class='cart_quantity']");
			String quantity = waitForElementToBeVisible(quantityLocator).getText().trim();
			logger.info("Product '" + productName + "' quantity: " + quantity);
			return quantity;
		} catch (Exception e) {
			logger.error("Error getting quantity for product '" + productName + "'. Exception: " + e.getMessage());
			return "";
		}
	}

	public String getSubTotalInformation() {
		try {
			String subtotal = waitForElementToBeVisible(SUBTOTAL_LABEL_LOCATOR).getText().split(" ")[2].replace("$", "");
			logger.info("Subtotal: " + subtotal);
			return subtotal;
		} catch (Exception e) {
			logger.error("Error retrieving subtotal", e);
			return "";
		}
	}

	public String getTotalInformation() {
		try {
			String total = waitForElementToBeVisible(TOTAL_LABEL_LOCATOR).getText().split(" ")[1].replace("$", "");
			logger.info("Total: " + total);
			return total;
		} catch (Exception e) {
			logger.error("Error retrieving total. Exception: " + e.getMessage());
			return "";
		}
	}

	public String getTaxInformation() {
		try {
			String tax = waitForElementToBeVisible(TAX_LABEL_LOCATOR).getText().split(" ")[1].replace("$", "");
			logger.info("Tax: "+ tax);
			return tax;
		} catch (Exception e) {
			logger.error("Error retrieving tax. Exception: " + e.getMessage());
			return "";
		}
	}

	public CheckoutCompletePage clickFinish() {
		try {
			waitForElementToBeClickable(FINISH_BUTTON_LOCATOR).click();
			logger.info("Clicked Finish button.");
		} catch (Exception e) {
			logger.error("Error clicking Finish button. Exception: " + e.getMessage());
		}
		return new CheckoutCompletePage(driver);
	}

	public ProductsPage clickCancel() {
		try {
			waitForElementToBeClickable(CANCEL_BUTTON_LOCATOR).click();
			logger.info("Clicked Cancel button.");
		} catch (Exception e) {
			logger.error("Error clicking Cancel button. Exception: " + e.getMessage());
		}
		return new ProductsPage(driver);
	}
	/////////////////////////////////////////////////
//	public boolean isPageDisplayed() {
//		return waitForElementToBeVisible(CHECKOUT_OVERVIEW_LABEL_LOCATOR).isDisplayed();
//	}
//	
//	public boolean isProductPresent(String productName) {
//		boolean allPresent = true;
//		List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']"));
//		if (!products.isEmpty()) {
//			allPresent = true;
//		} else {
//			allPresent = false;
//		}
//		return allPresent;
//	}
//	
//	public String getProductDescription(String productName) {
//		return waitForElementToBeVisible(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']//ancestor::div[@class='cart_item_label']/div[@class='inventory_item_desc']")).getText().trim();
//	}
//	
//	public String getProductPrice(String productName) {
//		return waitForElementToBeVisible(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']/ancestor::div[@class='cart_item_label']/descendant::div[@class='inventory_item_price']")).getText().trim().replace("$", "");
//	}
//	
//	public String getProductQuantity(String productName) {
//		return waitForElementToBeVisible(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']/ancestor::div[@class='cart_item']/div[@class='cart_quantity']")).getText().trim();
//	}
//
//	public String getSubTotalInformation() {
//		return waitForElementToBeVisible(SUBTOTAL_LABEL_LOCATOR).getText().split(" ")[2].replace("$", "");
//	}
//	
//	public String getTotalInformation() {
//		return waitForElementToBeVisible(TOTAL_LABEL_LOCATOR).getText().split(" ")[1].replace("$", "");
//	}
//	
//	public String getTaxInformation() {
//		return waitForElementToBeVisible(TAX_LABEL_LOCATOR).getText().split(" ")[1].replace("$", "");
//	}
//	
//	public CheckoutCompletePage clickFinish() {
//		waitForElementToBeClickable(FINISH_BUTTON_LOCATOR).click();
//		return new CheckoutCompletePage(driver);
//	}
//	
//	public ProductsPage clickCancel() {
//		waitForElementToBeClickable(CANCEL_BUTTON_LOCATOR).click();
//		return new ProductsPage(driver);
//	}

}
