@regression
Feature: Transfer
# one eof the main principles of writing cucumber feature files
# steps have to be as dynamic as possible to promote the step reuseability
# within other scenarios as well
  @smoke
  Scenario: Money transfer with insufficient funds
    Given User with account number 4210 is registered
    And User with account number 4210 deposits $1000.0
    When User with account number 4210 transfers $1100.0
    Then User with account number 4210 should have $1000.0 in balance
    And User should see Insufficient funds message

    #when the step is not highlighted it mean already has an implementation (step definition)
  @IGNORE
  Scenario: Demo String params
    Given Users on "qa-chase.com"