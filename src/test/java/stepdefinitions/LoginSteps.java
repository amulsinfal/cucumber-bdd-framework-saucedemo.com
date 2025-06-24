package stepdefinitions;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginSteps {
	private WebDriver driver = DriverFactory.getDriver();
	private LoginPage loginPage = new LoginPage(driver);;
	private ProductsPage productsPage;
	
	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
		Assert.assertTrue(loginPage.isPageDisplayed(), "Login page is not displayed.");
	}

	@When("User enters username {string} and password {string}")
	public void user_enters_username_and_password(String username, String password) {
		loginPage = loginPage.enterUsername(username).enterPassword(password);
	}

	@When("Clicks on the login button")
	public void clicks_on_the_login_button() {
		productsPage = loginPage.clickLoginButton();
	}

	@Then("Products page should be displayed")
	public void products_page_should_be_displayed() {
		Assert.assertTrue(productsPage.isPageDisplayed(), "Products page is not displayed.");	
	}

	@Then("Error message {string} should be displayed")
	public void error_message_should_be_displayed(String errorMessage) {
		Assert.assertEquals(loginPage.getErrorMessage(), errorMessage, "Incorrect error message displayed.");
	}

}
