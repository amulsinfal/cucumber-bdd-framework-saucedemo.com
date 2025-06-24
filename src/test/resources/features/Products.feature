Feature: Products Functionality

  Background:
    Given User is on the login page
    When User enters username "standard_user" and password "secret_sauce"
    And Clicks on the login button

	@Sanity
  Scenario: Verify a product is listed on the Products page
    Then Product "Sauce Labs Backpack" should be visible on the Products page

	@Regression
  Scenario: Verify clicking product item title navigates to item detail page
    When User clicks on the product title "Sauce Labs Backpack"
    Then Product detail page for product "Sauce Labs Backpack" should be displayed

	@Regression
  Scenario: Verify product description is displayed
    Then Product "Sauce Labs Backpack" should have a description "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."

	@Regression
  Scenario: Verify product price is displayed
    Then Product "Sauce Labs Backpack" should have a price "29.99"

  @Sanity @Regression
  Scenario: Verify cart badge shows correct item count after adding a product
    When User clicks on Add to Cart for "Sauce Labs Backpack"
    Then Cart badge should show item count as "1"