Feature: feature to test login functionality

  Background:
    Given User is on Swag Labs page

  Scenario: Correct Username and Password combination
    Given User enters valid username and password
    When  Clicks on login button
    Then  User is navigated to home page

  Scenario Outline: Login fail - possible combinations
    Given User entered invalid "<username>" and "<password>"
    When  User click on the login button
    Then  User should see an error message

    Examples:
      | username          | password        |
      | invalid@email.com | invalidPassword |
      | abcccc            | validPassword   |
      | valid@email.com   | abccc           |

  Scenario: Logout Successfully
    Given User login using valid username and password
    When  Goto Dashboard
    And   Clicks on Logout Button
    Then  User should be redirected to the Login Page