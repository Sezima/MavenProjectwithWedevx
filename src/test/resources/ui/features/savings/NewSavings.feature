@SavingsPositive
Feature: Create new savings account

  Scenario: Create a standard individual savings account
    Given the user logged in with the following credentials "milavolo@gmail.com" "MilaVolo1995"
    When the user creates new savings account with data
      | savingsAccountType | accountOwnership | accountName  | initialDepositAmount |
      | Savings            | Individual       | Sezim Osm 1  | 120000.00            |
      | Money Market       | Joint            | Sezim Osm  2 | 80000.00             |
    Then the user should see the following green "Successfully created new Savings account named Mila Volo Savings 1" message
    And the user should see the newly added savings account card
      | accountName  | account | ownership  | accountNumber | interestRate | balance   |
      | Sezim Osm  1 | Savings | Individual | 486133589     | 1.85%        | 120000.00 |
    And the user should see the following transactions displayed
      | date             | category | description               | amount    | balance   |
      | 2023-12-19 04:47 | Income   | 845324678 (DPT) - Deposit | 120000.00 | 120000.00 |