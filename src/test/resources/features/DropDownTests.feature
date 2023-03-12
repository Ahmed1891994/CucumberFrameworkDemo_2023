@DropDown
Feature: DropDown Tests

  Scenario Outline: Verify DropDown Functionality works for Indexes
    Given User in "Dropdown" page
    When User Chooses Item by index <index>
    Then Verify Item chosen is the right choice for index <index>

    Examples: 
      | index |
      |     1 |
      |     2 |

  Scenario Outline: Verify default value after refreshing when choosing by index
    Given User in "Dropdown" page
    When User Chooses Item by index <index>
    And Verify Item chosen is the right choice for index <index>
    And User Refreshes Page
    Then Verify No Item is chosen

    Examples: 
      | index |
      |     1 |
      |     2 |

  Scenario Outline: Verify DropDown Functionality works for Text
    Given User in "Dropdown" page
    When User Chooses Item by txt <text>
    Then Verify Item chosen is the right choice for txt <text>

    Examples: 
      | text                      |
      | "Please select an option" |
      | "Option 1"                |
      | "Option 2"                |

  Scenario Outline: Verify default value after refreshing when choosing by txt
    Given User in "Dropdown" page
    When User Chooses Item by txt <text>
    And Verify Item chosen is the right choice for txt <text>
    And User Refreshes Page
    Then Verify No Item is chosen

    Examples: 
      | text                      |
      | "Please select an option" |
      | "Option 1"                |
      | "Option 2"                |
