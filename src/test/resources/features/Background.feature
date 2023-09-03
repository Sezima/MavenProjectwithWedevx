Feature: background demo

  Background:
    Given user is on "qa-chase.com"
    And user is logged in as "test@gmail.com" "test1Pass"

  Scenario: Demo1
    When user clicks on the transaction
    Then user should see all transactions

  Scenario: Demo2
    And user balance is 1000
    When user deposits 200
    Then user balance should be 1200

  Scenario: Demo3
    And user balance is 1000
    When user withdraws 200
    Then user balance should be 800
