package stepdefinitions;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.NavigationBar;
import pages.ProductsPage;

public class LogoutSteps {
	private WebDriver driver = DriverFactory.getDriver();
	private LoginPage loginPage;
	private ProductsPage productsPage = new ProductsPage(driver);
	private NavigationBar navigationBar = productsPage.getNavigationBar();
	
	@When("User clicks on the sidebar menu button")
	public void user_clicks_on_the_sidebar_menu_button() {
		navigationBar = productsPage.getNavigationBar().clickMenuButton();
	}

	@Then("Logout button should be visible")
	public void logout_button_should_be_visible() {
		Assert.assertTrue(navigationBar.isLogoutLinkDisplayed(), "Logout link is missing in the side menu");
	}

	@When("User clicks on the logout button")
	public void user_clicks_on_the_logout_button() {
		loginPage = navigationBar.clickLogoutLink();
	}

	@Then("Login page should be displayed after logout")
	public void login_page_should_be_displayed_after_logout() {
		Assert.assertTrue(loginPage.isPageDisplayed(), "Login page not displayed.");
	}

}
