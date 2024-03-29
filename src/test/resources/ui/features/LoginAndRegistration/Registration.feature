@Registration
Feature: Digital Bank Registration Page

  Background:
#    Given The user with "test2@gmail.co" is not in DB
#    And User navigates to digital Bank signup page
    Given User navigates to digital Bank signup page
@Test
  Scenario: Positive Case. As a user, I want to successfully create a Digital Bank account
    When User creates account with following fields
      | title | firstName | lastName | gender | dob        | ssn         | email                | password   | address    | locality | region | postalCode | country | homePhone  | mobilePhone | workPhone  | termsCheckMark |
      | Mr.   | Jack      | Test1    | M      | 12/12/1980 | 500-45-1151 | test2@gmail.com      | Tester123  | 12 Main st | City     | CA     | 99921      | US      | 2136591008 | 4328952347  | 2740378462 | true           |
      | Ms.   | Sezima    | Osm      | F      | 06/02/2004 | 000-85-1789 | testSezim1@gmail.com | Sezima2004 | 245 New Ln | Galo     | IL     | 70865      | US      | 8760988899 | 4788088999  | 6897997799 | true           |

    Then User should be displayed with the message "Registration Successful. Please Login."
    Then The following user info should be saved in the DB
      | title | firstName | lastName | gender | dob        | ssn         | email                | password   | address    | locality | region | postalCode | country | homePhone  | mobilePhone | workPhone  | termsCheckMark |
      | Mr.   | Jack      | Test1    | M      | 12/12/1990 | 567-45-8878 | test2@gmail.com      | Tester123  | 12 Main st | City     | CA     | 99921      | US      | 2136591008 | 4328952347  | 2740378462 | true           |
      | Ms.   | Sezima    | Osm      | F      | 03/25/1997 | 087-85-8789 | testSezim1@gmail.com | Sezima2004 | 245 New Ln | Galo     | IL     | 70865      | US      | 8760988899 | 4788088999  | 6897997799 | true           |

  @NegativeRegistrationCases
  Scenario Outline: Negative Test Case. As a Digital Bank admin, I want to make sure the user can not register without all valid data
    When User creates account with following fields
      | title   | firstName   | lastName   | gender   | dob   | ssn   | email   | password   | address   | locality   | region   | postalCode   | country   | homePhone   | mobilePhone   | workPhone   | termsCheckMark   |
      | <title> | <firstName> | <lastName> | <gender> | <dob> | <ssn> | <email> | <password> | <address> | <locality> | <region> | <postalCode> | <country> | <homePhone> | <mobilePhone> | <workPhone> | <termsCheckMark> |
    Then User should see the "<fieldWithError>" required field message "<errorMessage>"

    Examples:
      | title | firstName | lastName | gender | dob        | ssn         | email               | password  | address | locality | region | postalCode | country | homePhone | mobilePhone | workPhone | termsCheckMark | fieldWithError | errorMessage                        |
      |       |           |          |        |            |             |                     |           |         |          |        |            |         |           |             |           |                | title          | Please select an item in the list.  |
      | Mr.   |           |          |        |            |             |                     |           |         |          |        |            |         |           |             |           |                | firstName      | Please fill out this field.         |
      | Mr.   | Jack      |          |        |            |             |                     |           |         |          |        |            |         |           |             |           |                | lastName       | Please fill out this field.         |
      | Mr.   | Jack      | Black    |        |            |             |                     |           |         |          |        |            |         |           |             |           |                | gender         | Please select one of these options. |
      | Mr.   | Jack      | Black    | M      |            |             |                     |           |         |          |        |            |         |           |             |           |                | dob            | Please fill out this field.         |
      | Mr.   | Jack      | Black    | M      | 12/12/1998 |             |                     |           |         |          |        |            |         |           |             |           |                | ssn            | Please fill out this field.         |
      | Mr.   | Jack      | Black    | M      | 12/12/1998 | 567-89-9765 |                     |           |         |          |        |            |         |           |             |           |                | email          | Please fill out this field.         |
      | Mr.   | Jack      | Black    | M      | 12/12/1998 | 684-38-2938 | jackblack@gmail.com |           |         |          |        |            |         |           |             |           |                | password       | Please fill out this field.         |
#      | Mr.   | Jack      | Black    | M      | 12/12/1998 | 238-28-4281 | jackblack@gmail.com | Black123$ | 01 Smm  |          |        |            |         |           |             |           |                | address        | Please fill out this field.         |
#

