package stepdefinitions;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import pages.ProductDetailPage;

public class ProductDetailsSteps {
	private WebDriver driver = DriverFactory.getDriver();
	private ProductDetailPage productDetailPage = new ProductDetailPage(driver);;
	
	@Then("Product detail page should have description {string}")
	public void product_detail_page_should_have_description(String expectedDescription) {
		Assert.assertEquals(productDetailPage.getProductDescription(), expectedDescription, "Products description is not matching on Product detail page.");
	}

	@Then("Product detail page should have price {string}")
	public void product_detail_page_should_have_price(String expectedPrice) {
		Assert.assertEquals(expectedPrice, productDetailPage.getProductPrice(), "Products price is not matching on Product detail page.");
	}
	
}
