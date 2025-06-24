package stepdefinitions;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;

public class CheckoutSteps {

	private WebDriver driver = DriverFactory.getDriver();
	private CheckoutPage checkoutPage = new CheckoutPage(driver);
	private CheckoutOverviewPage checkoutOverviewPage; 
	
	@When("User enters first name {string}")
	public void user_enters_first_name(String firstName) {
		checkoutPage = checkoutPage.enterFirstName(firstName);
	}

	@When("User enters last name {string}")
	public void user_enters_last_name(String lastName) {
		checkoutPage = checkoutPage.enterLastName(lastName);
	}

	@When("User enters zip code {string}")
	public void user_enters_zip_code(String postalCode) {
		checkoutPage = checkoutPage.enterPostalCode(postalCode);
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		checkoutOverviewPage = checkoutPage.clickContinue();
	}

	@Then("Error message {string} should be displayed on checkout page")
	public void error_message_should_be_displayed_on_checkout_page(String expectedError) {
		Assert.assertEquals(checkoutPage.getErrorMessage(), expectedError, "Error message is not matching.");
	}

	@When("User clicks on the cancel button")
	public void user_clicks_on_the_cancel_button() {
		checkoutPage.clickCancel();
	}
	
    @Then("Checkout overview page should be displayed")
    public void checkout_overview_page_should_be_displayed() {
		Assert.assertTrue(checkoutOverviewPage.isPageDisplayed(), "Checkout Overview page is not displayed.");
    }

}
