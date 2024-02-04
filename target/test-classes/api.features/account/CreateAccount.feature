@api
Feature: Create account Test Scenarios

#  Background:
#    Given the user with email "steve@apple.com" and ssn "122-44-3122" is not in the db
#    And the following user is created in the db
#      | title | firstName | lastName | gender | dob        | ssn         | emailAddress    | password     | address         | locality | region | postalCode | country | homePhone   | mobilePhone | workPhone   |
#      | Mr.   | Steve     | Jobs     | M      | 03/20/1954 | 122-44-3122 | steve@apple.com | Nubmaster#69 | 1 Infinite Loop | CA       | CA     | 44432      | USA     | 444-3244323 | 444-3244323 | 444-3244323 |

  Scenario: Create a valid account
    Given the user with email "steve@apple.com" and ssn "122-44-3122" is not in the db
    And the following user is created in the db
      | title | firstName | lastName | gender | dob        | ssn         | emailAddress    | password     | address         | locality | region | postalCode | country | homePhone   | mobilePhone | workPhone   |
      | Mr.   | Steve     | Jobs     | M      | 03/20/1954 | 122-44-3122 | steve@apple.com | Nubmaster#69 | 1 Infinite Loop | CA       | CA     | 44432      | USA     | 444-3244323 | 444-3244323 | 444-3244323 |
    When the following banking account is created
      | accountName                       | accountTypeCode | openingDeposit | ownerTypeCode |
      | Steve Jobs Test Standard Checking | SCK             | 10000.00       | IND           |
    Then the following account details are returned in the response
      | accountName                       | accountTypeCode | openingDeposit | ownerTypeCode | accountStandingName |
      | Steve Jobs Test Standard Checking | SCK             | 10000.00       | IND           | Open                |
    And the following account details are saved in the db


  Scenario: Create an account with wrong account name
    Given blank
    When attempting to create an account with the following data
      | accountName | accountTypeCode | openingDeposit | ownerTypeCode |
      |             | SCK             | 15000.00       | IND           |
    Then "400" status code is received with the following response
      | error                                                       | type   |
      | "size must be between 1 and 40","Account Name is required." | noName |
    And the following account details are not saved in the db

  Scenario: Create an account with wrong account type code
    Given blank
    When attempting to create an account with the following data
      | accountName                       | accountTypeCode | openingDeposit | ownerTypeCode |
      | Steve Jobs Test Standard Checking | SDK             | 15000.00       | IND           |
    Then "400" status code is received with the following response
      | error                                                                                         | type      |
      | "Account Type Code must either be 'SCK' or 'ICK' for checking or 'SAV' or 'MMA' for savings." | wrongType |


  Scenario: Create an account with wrong user id
    Given blank
    When attempting to create an account with a wrong user id and the following data
      | accountName                         | accountTypeCode | openingDeposit | ownerTypeCode |
      | Steve Jobs Test Standard Checking 2 | SCK             | 10000.00       | IND           |
    Then "404" status code is received with the following response details
      | timestamp                    | status | error     | message                                                | path                           |
      | 2023-10-26T06:38:30.633+0000 | 404    | Not Found | Object Not Found. Unable to locate object with id 1000 | /bank/api/v1/user/1000/account |

  Scenario: Create an account with an account name length 1 (boundary testing)
    Given blank
    When the following banking account is created
      | accountName | accountTypeCode | openingDeposit | ownerTypeCode |
      | 1           | SCK             | 15000.00       | IND           |
    Then the following account details are returned in the response
      | accountName | accountTypeCode | openingDeposit | ownerTypeCode | accountStandingName |
      | 1           | SCK             | 15000.00       | IND           | Open                |
    And the following account details are saved in the db


  Scenario: Attempt to create an account with an account name length 41
    Given blank
    When attempting to create an account with the following data
      | accountName                                               | accountTypeCode | openingDeposit | ownerTypeCode |
      | Checking Account 1234567890123456789012345678901234567890 | SCK             | 15000.00       | IND           |
    Then "400" status code is received with the following response
      | error                           | type     |
      | "size must be between 1 and 40" | boundary |
    And the following account details are not saved in the db


  Scenario: Get user by username
    Given
    When
    Then


#    Given the user with email "steve@apple.com" and ssn "122-44-3122" is not in the db
#    And the following user is created in the db
#      | title | firstName | lastName | gender | dob        | ssn         | emailAddress    | password     | address         | locality | region | postalCode | country | homePhone   | mobilePhone | workPhone   |
#      | Mr.   | Steve     | Jobs     | M      | 03/20/1954 | 122-44-3122 | steve@apple.com | Nubmaster#69 | 1 Infinite Loop | CA       | CA     | 44432      | USA     | 444-3244323 | 444-3244323 | 444-3244323 |

