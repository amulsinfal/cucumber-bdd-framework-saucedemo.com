package stepdefinitions;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutCompletePage;

public class CheckoutCompleteSteps {
	private WebDriver driver = DriverFactory.getDriver();
	private CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
	
	@Then("Success message {string} should be displayed")
	public void success_message_should_be_displayed(String expectedMessage) {
		Assert.assertEquals(checkoutCompletePage.getSuccessMessage(), expectedMessage, "Success message is not matching.");
	}

	@When("User clicks on the Back Home button")
	public void user_clicks_on_the_back_home_button() {
		checkoutCompletePage.clickBackHome();
	}

}
