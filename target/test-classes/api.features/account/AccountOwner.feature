Feature: Account Owner Test Scenarios

  Background:
    Given the user is authenticated with ADMIN privileges

  Scenario Outline: Get all users
    Given the user is authenticated with ADMIN privileges
    When the user sends GET request to "users"
      | paramKey | paramValue |
      | null     | null       |
    Then the user gets "200" status code with the following response
      | id   | username   | enabled   | accountNonExpired   | accountNonLocked   | credentialsNonExpired   | profile_id   | firstName   | lastName   | title   | gender   | ssn   | dob   | dom   | emailAddress   | homePhone   | mobilePhone   | workPhone   | address   | locality   | region   | postalCode   | country   |
      | <id> | <username> | <enabled> | <accountNonExpired> | <accountNonLocked> | <credentialsNonExpired> | <profile_id> | <firstName> | <lastName> | <title> | <gender> | <ssn> | <dob> | <dom> | <emailAddress> | <homePhone> | <mobilePhone> | <workPhone> | <address> | <locality> | <region> | <postalCode> | <country> |
    Examples:
      | id | username      | enabled | accountNonExpired | accountNonLocked | credentialsNonExpired | profile_id | firstName | lastName | title | gender | ssn         | dob        | dom        | emailAddress  | homePhone    | mobilePhone  | workPhone    | address             | locality       | region | postalCode | country |
      | 4  | admin@demo.io | true    | true              | true             | true                  | 5          | Ardella   | Carter   | Mrs.  | F      | 827-59-9447 | 03/12/2003 | 12/13/2023 | admin@demo.io | 781-419-1083 | 269-675-0521 | 970-534-0520 | 5507 Harber Islands | Daughertyville | IN     | 69183      | US      |
#      | 71  | jsmith@demo.io             | true    | true              | true             | true                  | 72         | Josh      | Smith    | Mr.   | M      | 274-07-2576 | 09/02/1994 | 12/13/2023 | jsmith@demo.io             | 707-203-8632 | 109-061-8113 | 608-918-8849 | 83840 Linsey Walks              | Cristshire     | GA     | 61678      | US            |
#      | 153 | nurkenalimbek125@gmail.com | true    | true              | true             | true                  | 154        | Alimbek   | Nurken   | Mr.   | M      | 232-12-4212 | 07/22/2005 | 12/15/2023 | nurkenalimbek125@gmail.com | 19175738673  | 19175738673  | 19175738673  | 745 7th Ave, New York, NY 10019 | New Jersey     | NY     | 10019      | United States |

  Scenario: Get user by username
    When the user sends GET request to "user/find"
      | paramKey | paramValue     |
      | username | jsmith@demo.io |
    Then the user gets "200" status code with the following response
      | id | username       | enabled | accountNonExpired | accountNonLocked | credentialsNonExpired | profile_id | firstName | lastName | title | gender | ssn         | dob        | dom        | emailAddress   | homePhone    | mobilePhone  | workPhone    | address            | locality   | region | postalCode | country |
      | 71 | jsmith@demo.io | true    | true              | true             | true                  | 72         | Josh      | Smith    | Mr.   | M      | 274-07-2576 | 09/02/1994 | 12/13/2023 | jsmith@demo.io | 707-203-8632 | 109-061-8113 | 608-918-8849 | 83840 Linsey Walks | Cristshire | GA     | 61678      | US      |


  Scenario: Get account owner of a valid account
    When the user sends GET request to "account/{id}/owner"
      | paramKey | paramValue |
      | id       | 71         |
    Then the user gets "200" status code with the following response
      | id | username       | enabled | accountNonExpired | accountNonLocked | credentialsNonExpired | profile_id | firstName | lastName | title | gender | ssn         | dob        | dom        | emailAddress   | homePhone    | mobilePhone  | workPhone    | address            | locality   | region | postalCode | country |
      | 71 | jsmith@demo.io | true    | true              | true             | true                  | 72         | Josh      | Smith    | Mr.   | M      | 274-07-2576 | 09/02/1994 | 12/13/2023 | jsmith@demo.io | 707-203-8632 | 109-061-8113 | 608-918-8849 | 83840 Linsey Walks | Cristshire | GA     | 61678      | US      |


  Scenario: Get account owner of a non existing account


  Scenario: Get account owner of an account that has no owner attached to it




#  | id | username | enabled | accountNonExpired | accountNonLocked | credentialsNonExpired | profile_id | firstName | lastName | title | gender | ssn | dob | dom | emailAddress | homePhone | mobilePhone | workPhone | address | locality | region | postalCode | country |
#  |    |          |         |                   |                  |                       |            |           |          |       |        |     |     |     |              |           |             |           |         |          |        |            |         |