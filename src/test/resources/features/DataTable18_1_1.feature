Feature: User Registration

  Scenario: Fill out registration form
    Given the user is on the registration page
    When the user fills in the registration form with the following data
      | Title   | FirstName | LastName   | Gender | DOB        | SSN         | Email                      | Password      | ConfirmPassword |
      | Mr.     | Anakin    | Skywalker  | Male   | 11/22/1999 | 100-22-0442 | anakin.skywalker@jedi.com  | Anakin.skyguy1 | Anakin.skyguy1  |
    And the user submits the form
    Then the account creation is successful
