Feature: Checkout Overview Page Validations

  Background:
    Given User is on the login page
    When User enters username "standard_user" and password "secret_sauce"
    And Clicks on the login button
    And User clicks on Add to Cart for "Sauce Labs Backpack"
    And User clicks on the cart icon
    And User clicks on the checkout button
    And User enters first name "John"
    And User enters last name "Doe"
    And User enters zip code "12345"
    And User clicks on Continue button

  @Regression
  Scenario: Verify product and details are correctly displayed on overview page
    Then Product "Sauce Labs Backpack" should be listed on the overview page
    And Verify price of product "Sauce Labs Backpack" is "29.99"
    And Verify quantity of product "Sauce Labs Backpack" is "1"
 
	@Sanity
  Scenario: Verify tax is displayed correctly
    Then Verify tax displayed should be "2.40"

  @Sanity
  Scenario: Verify subtotal is displayed correctly
    Then Verify subtotal amount displayed should be "29.99"

  @Sanity
  Scenario: Verify Total is displayed correctly
    Then Verify Total amount displayed should be "32.39"

  @Regression
  Scenario: Verify Cancel button on overview page returns user to cart
    When User clicks on cancel button on overview page
    Then Products page should be displayed

  @Sanity
  Scenario: Verify Finish button completes the checkout process
    When User clicks on the finish button
    Then Checkout complete page should be displayed