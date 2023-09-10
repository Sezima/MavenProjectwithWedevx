#Gherkin has it's specific syntax that we need to follow
#first keyword in a feature should be (Feature: )
#  Feature: is a title of this Feature file
#  a Feature:  is like on teest class
#  one feature file will consist of all tests cases reloated to one particular functionality
@regression
Feature: Deposit Test

#  wa also have an ability to add more explanation about this feature file
#  here we would write the extra details about the feature

#  Scenario: is like 1 test case
#  1 scenario is a 1 test case
  Scenario: we dive scenario name here
#    Given is used to define pre-conditional steps
#    When  is used to define action steps. This is where we actually call the functionality that we are testing
#    Then is used to for vaildations / assertions
#    steps : given when then

    Given Bank account 1 exists with $1000 balance
    When Bank account 1 deposits $100 dollars
    Then Bank account 1 should have $1100 in balance

@smoke
    Scenario: Money Transfer with enough balance
      Given  User with account number 123456 is registers )
#      And  is a keyword that helps you avoid repeating the same words (and means given (dry))
      And User with account number 123456 deposited $500
      When User with account number 123456 transfers $300
#      this and means when
      And User with account number 123456 transfers $200
      Then User with account number 123456 should have $0 in balance


#      step definitions in cucumber