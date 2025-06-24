Feature: Logout Functionality

  Background:
    Given User is on the login page
    When User enters username "standard_user" and password "secret_sauce"
    And Clicks on the login button

  @Sanity
  Scenario: Verify logout button is visible in the sidebar menu
    When User clicks on the sidebar menu button
    Then Logout button should be visible

  @Regression
  Scenario: Verify user is successfully logged out using the sidebar menu
    When User clicks on the sidebar menu button
    And User clicks on the logout button
    Then Login page should be displayed after logout