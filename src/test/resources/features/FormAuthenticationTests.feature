@FormAuthentication
Feature: Form Authentication Tests

  Scenario: Login successfully
    Given User in "Form Authentication" page
    When User Login with "tomsmith" and "SuperSecretPassword!"
    Then Verify alert message "You logged into a secure area!" appears

    Scenario: Logout successfully
    Given User in "Form Authentication" page
    When User Login with "tomsmith" and "SuperSecretPassword!"
    And Verify alert message "You logged into a secure area!" appears
    When User Clicks logout button
    Then Verify alert message "You logged out of the secure area!" appears
    
    Scenario: Login Failed using wrong username
    Given User in "Form Authentication" page
    When User Login with "tomsmithx" and "SuperSecretPassword!"
    Then Verify alert message "Your username is invalid!" appears
    
    Scenario: Login Failed using wrong password
    Given User in "Form Authentication" page
    When User Login with "tomsmith" and "SuperSecretPassword"
    Then Verify alert message "Your password is invalid!" appears