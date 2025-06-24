Feature: Checkout Completion Page Validations

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
    And User clicks on the finish button

  @Sanity
  Scenario: Verify success message is shown after order completion
    Then Success message "Thank you for your order!" should be displayed

  @Regression
  Scenario: Verify Back Home button redirects to inventory page
    When User clicks on the Back Home button
    Then Products page should be displayed










