@FormAuthentication
Feature: Form Authentication Tests

  Scenario: Login successfully
    Given User Clicks on link "Form Authentication"
    When User Enters username "tomsmith"
    And User Enters password "SuperSecretPassword!"
    And User Clicks on Login
    Then Verify alert message "You logged into a secure area!" appears

    Scenario: Logout successfully
    Given User Clicks on link "Form Authentication"
    When User Enters username "tomsmith"
    And User Enters password "SuperSecretPassword!"
    And User Clicks on Login
    And Verify alert message "You logged into a secure area!" appears
    When User Clicks logout button
    Then Verify alert message "You logged out of the secure area!" appears
    
    Scenario: Login Failed using wrong username
    Given User Clicks on link "Form Authentication"
    When User Enters username "tomsmithx"
    And User Enters password "SuperSecretPassword!"
    And User Clicks on Login
    Then Verify alert message "Your username is invalid!" appears
    
    Scenario: Login Failed using wrong password
    Given User Clicks on link "Form Authentication"
    When User Enters username "tomsmith"
    And User Enters password "SuperSecretPassword"
    And User Clicks on Login
    Then Verify alert message "Your password is invalid!" appears