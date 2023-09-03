
Feature: User Management
  @smoke
  Scenario: Creating a new user
    Given the user is on the registration page
    When the user fills in the registration form
    Then the user should be registered successfully

  @regression
  Scenario: Editing user information
    Given the user is logged in
    When the user navigates to the profile page
    Then the user can edit their information



#    i want to add this feature file smoke test
#  so i want all of the feature files to ve included in a smoke test? Maybe not. Maybe you only wnat to, add creating a new user
#  si i put a smoke test tag here , and also do i want all of the scenarios to be included into regression?
#  so i would just instead of putting regression on top of each scenario
#   i can just put it on top of feature and it'll basically mean that each scenario has it
#  i'm not limited to having only one attack on top of each of these i can have multiple.
#  i can add @api @ui separate with space @regression @api / @regression @ui
#  or @ smoke @creteUser