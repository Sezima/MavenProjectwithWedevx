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




