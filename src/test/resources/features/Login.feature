Feature: Login Functionality

  Background: 
    Given User is on the login page

  @Sanity @Smoke
  Scenario: Verify login with valid credentials
    When User enters username "standard_user" and password "secret_sauce"
    And Clicks on the login button
    Then Products page should be displayed

  @Regression
  Scenario: Verify login with invalid username and password
    When User enters username "invalid_user" and password "wrong_pass"
    And Clicks on the login button
    Then Error message "Epic sadface: Username and password do not match any user in this service" should be displayed

  @Regression
  Scenario: Verify login with locked out user
    When User enters username "locked_out_user" and password "secret_sauce"
    And Clicks on the login button
    Then Error message "Epic sadface: Sorry, this user has been locked out." should be displayed

  @Regression
  Scenario: Verify login with blank username and password
    When User enters username "" and password ""
    And Clicks on the login button
    Then Error message "Epic sadface: Username is required" should be displayed
