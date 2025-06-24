package stepdefinitions;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutCompletePage;
import pages.CheckoutOverviewPage;

public class CheckoutOverviewSteps {
	private WebDriver driver = DriverFactory.getDriver();
	private CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
	private CheckoutCompletePage checkoutCompletedPage;
	
	@Then("Product {string} should be listed on the overview page")
	public void product_should_be_listed_on_the_overview_page(String productName) {
		Assert.assertTrue(checkoutOverviewPage.isProductPresent(productName), "Product " + productName + " missing on the Checkout Overview page.");
		
	}

	@Then("Verify price of product {string} is {string}")
	public void price_of_product_should_be_visible(String productName, String expectedPrice) {
		Assert.assertEquals(checkoutOverviewPage.getProductPrice(productName), expectedPrice, "Products price is incorrect on the Checkout overview page.");
	}

	@Then("Verify quantity of product {string} is {string}")
	public void quantity_of_product_should_be_visible(String productName, String expectedQuantity) {
		Assert.assertEquals(checkoutOverviewPage.getProductQuantity(productName), expectedQuantity, "Products quantity is incorrect on the Checkout overview page.");
	}

	@Then("Verify tax displayed should be {string}")
	public void verify_tax_displayed_should_be(String expectedTax) {
		Assert.assertEquals(checkoutOverviewPage.getTaxInformation(), expectedTax, "Tax information is incorrect on the Checkout overview page.");

	}

	@Then("Verify subtotal amount displayed should be {string}")
	public void subtotal_amount_should_be_displayed(String expectedSubtotal) {
		Assert.assertEquals(checkoutOverviewPage.getSubTotalInformation(), expectedSubtotal, "Subtotal information is incorrect on the Checkout overview page.");
	}

	@Then("Verify Total amount displayed should be {string}")
	public void total_amount_should_be_displayed(String expectedTotal) {
		Assert.assertEquals(checkoutOverviewPage.getTotalInformation(), expectedTotal, "Total information is incorrect on the Checkout overview page.");
	}

	@When("User clicks on cancel button on overview page")
	public void user_clicks_on_cancel_button_on_overview_page() {
		checkoutOverviewPage.clickCancel();
	}

	@When("User clicks on the finish button")
	public void user_clicks_on_the_finish_button() {
		checkoutCompletedPage = checkoutOverviewPage.clickFinish();
	}

	@Then("Checkout complete page should be displayed")
	public void checkout_complete_page_should_be_displayed() {
		Assert.assertTrue(checkoutCompletedPage.isPageDisplayed(), "Checkout Complete is not displayed.");
	}

}
