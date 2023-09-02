Feature: Transfer

  Scenario: Money Transfer with insufficient funds
#    when the step is not highlighted it means if already on implementation (step def)
    Given User with account number 123456 is registered
    And User with account number 4210 deposited $1000
    When User with account number 4210 transfers $1100
    Then User with account number 4210 should have $1000 in balance
    And User should see Insufficient Funds message

    
    Scenario: Money transfer with sufficient funds
      Given User with account number 123 is registered


      Scenario: Demo String params
        Given User is on "qa-chase.com"