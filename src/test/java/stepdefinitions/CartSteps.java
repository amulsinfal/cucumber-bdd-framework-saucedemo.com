package stepdefinitions;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ProductsPage;

public class CartSteps {
	private WebDriver driver = DriverFactory.getDriver();
	private ProductsPage productsPage = new ProductsPage(driver);
	private CartPage cartPage;
	private CheckoutPage checkoutPage;
		
	@When("User clicks on the cart icon")
	public void user_clicks_on_the_cart_icon() {
		cartPage = productsPage.getNavigationBar().clickCartButton();
	}

	@Then("Cart page should be displayed")
	public void cart_page_should_be_displayed() {
		Assert.assertTrue(cartPage.isCartPageDisplayed(), "Cart page is not displayed.");
	}

	@When("User removes {string} from the cart")
	public void user_removes_from_the_cart(String productName) {
		cartPage = cartPage.removeFromCart(productName);
	}

	@Then("Product {string} should not be visible in the cart")
	public void product_should_not_be_visible_in_the_cart(String productName) {
		Assert.assertFalse(cartPage.isProductPresent(productName),"Cart page is not displayed.");
	}

	@Then("Product {string} should have cart description {string}")
	public void product_should_have_cart_description(String productName, String expectedDescription) {
		Assert.assertEquals(cartPage.getProductDescription(productName), expectedDescription, "Products description is not matching on Products page.");
	}

	@Then("Product {string} should have cart price {string}")
	public void product_should_have_cart_price(String productName, String expectedPrice) {
		Assert.assertEquals(cartPage.getProductPrice(productName), expectedPrice, "Products price is not matching on Products page.");
	}

	@Then("Product {string} should have cart quantity {string}")
	public void product_should_have_cart_quantity(String productName, String expectedQuantity) {
		Assert.assertEquals(cartPage.getProductQuantity(productName), expectedQuantity, "Products quantity is not matching on Products page.");
	}

	@When("User clicks on Continue Shopping button")
	public void user_clicks_on_continue_shopping_button() {
		productsPage = cartPage.clickContinueShopping();
	}

	@When("User clicks on the checkout button")
	public void user_clicks_on_the_checkout_button() {
		checkoutPage = cartPage.clickCheckout();
	}

	@Then("Checkout step one page should be displayed")
	public void checkout_step_one_page_should_be_displayed() {
		Assert.assertTrue(checkoutPage.isPageDisplayed(), "Checkout page is not displayed.");
	}

}
