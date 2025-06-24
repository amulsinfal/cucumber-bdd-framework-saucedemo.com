Feature: Checkout Process

  Background: 
    Given User is on the login page
    When User enters username "standard_user" and password "secret_sauce"
    And Clicks on the login button
    And User clicks on Add to Cart for "Sauce Labs Backpack"
    And User clicks on the cart icon
    And User clicks on the checkout button

  @Sanity
  Scenario: Verify user can enter First Name, Last Name, and Zip Code
    When User enters first name "John"
    And User enters last name "Doe"
    And User enters zip code "12345"
    And User clicks on Continue button
    Then Checkout overview page should be displayed

  @Regression
  Scenario Outline: Verify error messages when mandatory fields are missing
    When User enters first name "<FirstName>"
    And User enters last name "<LastName>"
    And User enters zip code "<PostalCode>"
    And User clicks on Continue button
    Then Error message "<ErrorMessage>" should be displayed on checkout page

    Examples:
      | FirstName | LastName | PostalCode | ErrorMessage                     |
      |           | Doe      | 12345      | Error: First Name is required    |
      | John      |          | 12345      | Error: Last Name is required     |
      | John      | Doe      |            | Error: Postal Code is required   |

  @Sanity @Regression
  Scenario: Verify Cancel button navigates back to cart
    When User clicks on the cancel button
    Then Cart page should be displayed
    

