Feature: Cart Functionality
  This feature covers the cart operations like viewing items in cart, removing items, 
  verifying product details (name, price, description, quantity), and navigation options 
  like Continue Shopping and Checkout.

  Background:
    Given User is on the login page
    When User enters username "standard_user" and password "secret_sauce"
    And Clicks on the login button

  @Smoke
  Scenario: Verify user can navigate to cart page from Products page
    When User clicks on the cart icon
    Then Cart page should be displayed

  @Regression
  Scenario: Verify user can remove an item from the cart page
    When User clicks on Add to Cart for "Sauce Labs Backpack"
    And User clicks on the cart icon
    And User removes "Sauce Labs Backpack" from the cart
    Then Product "Sauce Labs Backpack" should not be visible in the cart

	@Regression
  Scenario: Verify product description is correct in the cart
    When User clicks on Add to Cart for "Sauce Labs Backpack"
    And User clicks on the cart icon
    Then Product "Sauce Labs Backpack" should have cart description "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."

  @Regression
  Scenario: Verify product price is correct in the cart
    When User clicks on Add to Cart for "Sauce Labs Backpack"
    And User clicks on the cart icon
    Then Product "Sauce Labs Backpack" should have cart price "29.99"

  @Regression
  Scenario: Verify product quantity is correct in the cart
    When User clicks on Add to Cart for "Sauce Labs Backpack"
    And User clicks on the cart icon
    Then Product "Sauce Labs Backpack" should have cart quantity "1"

  @Sanity 
  Scenario: Verify 'Continue Shopping' button redirects user back to Products Page
    When User clicks on Add to Cart for "Sauce Labs Backpack"
    And User clicks on the cart icon
    And User clicks on Continue Shopping button
    Then Products page should be displayed

  @Sanity @Checkout @Cart
  Scenario: Verify checkout button on cart page navigates to checkout step one
    When User clicks on Add to Cart for "Sauce Labs Backpack"
    And User clicks on the cart icon
    And User clicks on the checkout button
    Then Checkout step one page should be displayed