Feature: Account
  Scenario: Create Checking account without account type
    Given user is on "https://dbank-qa.wedevx.co/bank/login"
    And user inputs his username "vader@sith.com" and password "Lovetwo.123"
    And user clicks on login
    When user is on home page
    And user clicks on Checking
    And user clicks on New Checking
    And user selects "Individual" account ownership
    And user inputs account name "Darth Vader"
    And user inputs initial deposit $"1000"
    Then user clicks on submit.
    And user should be displayed with error message
    And validate no account was created