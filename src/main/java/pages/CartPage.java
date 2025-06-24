package pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

	private static final By YOUR_CART_LABEL_LOCATOR = By.xpath("//span[text()='Your Cart']");
	private static final By CART_ITEM_LOCATOR = By.className("cart_item");
	private static final By CONTINUE_SHOPPING_BUTTON_LOCATOR = By.id("continue-shopping");
	private static final By CHECKOUT_BUTTON_LOCATOR = By.id("checkout");
	private static final Logger logger = LogManager.getLogger(CartPage.class);

	public CartPage(WebDriver driver) {
		super(driver);
	}

	public boolean isProductPresent(String productName) {
		try {
			List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']"));
			boolean isPresent = !products.isEmpty();
			logger.info("Checked presence of product '" + productName + "': " + isPresent);
			return isPresent;
		} catch (Exception e) {
			logger.error("Error checking presence of product '" + productName + "'. Exception: " + e.getMessage());
			return false;
		}
	}

	public boolean isProductPresentx(String productName) {
	    logger.info("Checking if product '" + productName + "' is present in the cart.");
	    try {
	        List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']"));
	        boolean isPresent = !products.isEmpty();
	        logger.info("Product '" + productName + "' present: " + isPresent);
	        return isPresent;
	    } catch (Exception e) {
	        logger.error("Error checking if product '" + productName + "' is present in the cart. Exception: " + e.getMessage());
	        return false;
	    }
	}
	
//	public boolean isProductPresenty(String productName) {
//		return waitForElementToBeVisible(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']")).isDisplayed();
//	}

	public boolean isProductPresenty(String productName) {
		try {
			boolean isDisplayed = waitForElementToBeVisible(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']")).isDisplayed();
			logger.info("Product '" + productName + "' is visible in the cart: '" + isDisplayed + "'.");
			return isDisplayed;
		} catch (Exception e) {
			logger.error("Error checking visibility of product '" + productName + "'. Exception: " + e.getMessage());
			return false;
		}
	}
	
//	public boolean isCartPageDisplayed() {
//		return waitForElementToBeVisible(YOUR_CART_LABEL_LOCATOR).isDisplayed();
//	}

	public boolean isCartPageDisplayed() {
		try {
			boolean isDisplayed = waitForElementToBeVisible(YOUR_CART_LABEL_LOCATOR).isDisplayed();
			logger.info("Cart page is displayed: " + isDisplayed);
			return isDisplayed;
		} catch (Exception e) {
			logger.error("Error checking if cart page is displayed. Exception: " + e.getMessage());
			return false;
		}
	}
	
//	public CartPage removeFromCart(String productName) {
//		waitForElementToBeClickable(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']/parent::a/following-sibling::div[@class='item_pricebar']/button[text()='Remove']")).click();
//		return this;
//	}

	public CartPage removeFromCart(String productName) {
		try {
			By removeBtnLocator = By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']/parent::a/following-sibling::div[@class='item_pricebar']/button[text()='Remove']");
			waitForElementToBeClickable(removeBtnLocator).click();
			logger.info("Removed product '" + productName + "' from cart.");
		} catch (Exception e) {
			logger.error("Error removing product '" + productName + "' from cart. Exception: " + e.getMessage());
		}
		return this;
	}
	
//	public boolean isCartEmpty() {
//		List<WebElement> cartItems = driver.findElements(CART_ITEM_LOCATOR);
//		if (cartItems.isEmpty()) {
//			return true;
//		} else {
//			return false;
//		}
//	}

	public boolean isCartEmpty() {
		try {
			List<WebElement> cartItems = driver.findElements(CART_ITEM_LOCATOR);
			boolean isEmpty = cartItems.isEmpty();
			logger.info("Cart is empty: "+ isEmpty);
			return isEmpty;
		} catch (Exception e) {
			logger.error("Error while checking if cart is empty. Exception: " + e.getMessage());
			return false;
		}
	}
	
//	public String getProductDescription(String productName) {
//		return waitForElementToBeVisible(By.xpath("//div[@class='inventory_item_name' and text()='" + productName
//				+ "']//ancestor::div[@class='cart_item_label']/div[@class='inventory_item_desc']")).getText().trim();
//	}

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
	
//	public String getProductPrice(String productName) {
//		By priceLocator = By.xpath("//div[@class='inventory_item_name' and text()='" + productName
//				+ "']//ancestor::div[@class='cart_item_label']/div[@class='item_pricebar']/div[@class='inventory_item_price']");
//		String text = waitForElementToBeVisible(priceLocator).getText().trim().replace("$", "");
//		System.out.println("Price for '" + productName + "' is: '" + text + "'");
//		return text;
//	}


	public String getProductPrice(String productName) {
		try {
			By priceLocator = By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']//ancestor::div[@class='cart_item_label']/div[@class='item_pricebar']/div[@class='inventory_item_price']");
			String price = waitForElementToBeVisible(priceLocator).getText().trim().replace("$", "");
			logger.info("Product '" + productName + "' price: " + price);
			return price;
		} catch (Exception e) {
			logger.error("Error getting price for product '" + productName + "'. Exception: " + e.getMessage());
			return "";
		}
	}

//	public String getProductQuantity(String productName) {
//		return waitForElementToBeVisible(By.xpath("//div[@class='inventory_item_name' and text()='" + productName
//				+ "']//ancestor::div[@class='cart_item']/div[@class='cart_quantity']")).getText();
//	}
	
	public String getProductQuantity(String productName) {
		try {
			By qtyLocator = By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']//ancestor::div[@class='cart_item']/div[@class='cart_quantity']");
			String quantity = waitForElementToBeVisible(qtyLocator).getText();
			logger.info("Product '" + productName + "' quantity: " + quantity);
			return quantity;
		} catch (Exception e) {
			logger.error("Error getting quantity for product '" + productName + "'. Exception: " + e.getMessage());
			return "";
		}
	}


//	public ProductsPage clickContinueShopping() {
//		waitForElementToBeClickable(CONTINUE_SHOPPING_BUTTON_LOCATOR).click();
//		return new ProductsPage(driver);
//	}

	public ProductsPage clickContinueShopping() {
		try {
			waitForElementToBeClickable(CONTINUE_SHOPPING_BUTTON_LOCATOR).click();
			logger.info("Clicked 'Continue Shopping' button.");
		} catch (Exception e) {
			logger.error("Error clicking 'Continue Shopping' button. Exception: " + e.getMessage());
		}
		return new ProductsPage(driver);
	}
	
//	public CheckoutPage clickCheckout() {
//		waitForElementToBeClickable(CHECKOUT_BUTTON_LOCATOR).click();
//		return new CheckoutPage(driver);
//	}


	public CheckoutPage clickCheckout() {
		try {
			waitForElementToBeClickable(CHECKOUT_BUTTON_LOCATOR).click();
			logger.info("Clicked 'Checkout' button.");
		} catch (Exception e) {
			logger.error("Error clicking 'Checkout' button. Exception: " + e.getMessage());
		}
		return new CheckoutPage(driver);
	}
}
