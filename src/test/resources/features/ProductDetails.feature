Feature: Product Details Verification

  Background: 
    Given User is on the login page
    When User enters username "standard_user" and password "secret_sauce"
    And Clicks on the login button
    And User clicks on the product title "Sauce Labs Backpack"

  @Sanity
  Scenario: Verify product name in Product details page
    Then Product detail page for product "Sauce Labs Backpack" should be displayed

  @Regression
  Scenario: Verify product description in Product details page
    Then Product detail page should have description "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."

  @Regression
  Scenario: Verify product price in Product details page
    Then Product detail page should have price "29.99"
