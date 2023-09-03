Feature: Outlines Demo

#    так выглядит сценарий
  Scenario: Test 1
    Given some precondition
    When some action is performed with "value1"
    Then some expected outcome is achieved with "value1"

  Scenario: Test 2
    Given some precondition
    When some action is performed with "value2"
    Then some expected outcome is achieved with "value2"

  Scenario: Test 3
    Given some precondition
    When some action is performed with "value3"
    Then some expected outcome is achieved with "value3"

#    это тот же сценарий
  Scenario Outline: Some scenario name
    Given some precondition
    When some action is performed with "<placeholder>"
    Then some expected outcome is achieved with "<placeholder>"

    Examples:
      | placeholder |
      | value1      |
      | value2      |
      | value3      |


  Scenario Outline: Processing an insurance claim for "<coverageType>"
    Given the customer has "<coverageType>" coverage
    And the customer has a claim with the following details:
      | claimID   | amount   | date     | description     | supportingDocuments   |
      | <claimId> | <amount> | "<date>" | "<description>" | <supportingDocuments> |
    When the customer submits the claim
    Then the claim should be processed successfully

    Examples:
      | coverageType | claimId | amount  | date       | description         | supportingDocuments     |
      | Health       | H-001   | 500.00  | 2023-07-15 | Medical expenses    | Medical receipts        |
      | Auto         | A-101   | 1000.00 | 2023-07-20 | Car accident repair | Repair invoice          |
      | Home         | Hm-202  | 2000.00 | 2023-07-25 | Roof damage         | Photos, repair estimate |
