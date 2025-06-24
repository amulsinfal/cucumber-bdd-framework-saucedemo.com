package stepdefinitions;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductDetailPage;
import pages.ProductsPage;

public class ProductsSteps {
	private WebDriver driver = DriverFactory.getDriver();
	private ProductsPage productsPage = new ProductsPage(driver);
	private ProductDetailPage productDetailPage;

	@Then("Product {string} should be visible on the Products page")
	public void product_should_be_visible_on_the_products_page(String productName) {
		Assert.assertTrue(productsPage.isProductPresent(productName), "Product " + productName + " missing on the Products page.");
	}

	@When("User clicks on the product title {string}")
	public void user_clicks_on_the_product_title(String productName) {
		productDetailPage = productsPage.clickProductName(productName);
	}

	@Then("Product detail page for product {string} should be displayed")
	public void product_detail_page_for_product_should_be_displayed(String productName) {
		Assert.assertEquals(productDetailPage.getProductName(), productName, "Products name is not matching on Product detail page.");
	}

	@Then("Product {string} should have a description {string}")
	public void product_should_have_a_description(String productName, String expectedDescription) {
		Assert.assertEquals(productsPage.getProductDescription(productName), expectedDescription, "Products description is not matching on Products page.");
	}

	@Then("Product {string} should have a price {string}")
	public void product_should_have_a_price(String productName, String expectedPrice) {
		Assert.assertEquals(productsPage.getProductPrice(productName), expectedPrice, "Products price is not matching on Products page.");
	}

	@When("User clicks on Add to Cart for {string}")
	public void user_clicks_on_add_to_cart_for(String productName) {
		productsPage = productsPage.addProductToCart(productName);
	}

	@Then("Cart badge should show item count as {string}")
	public void cart_badge_should_show_item_count_as(String expectedCount) {
		Assert.assertEquals(productsPage.navigationBar.getCartCount(), expectedCount, "Products count is not matching on in the cart badge.");
	}

}
