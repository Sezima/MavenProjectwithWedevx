Feature: Banking Operations

  Scenario: Transfer funds from USD to EUR account
    Given a bank account with account number "A-12345" and balance "$1000" in USD
    And a bank account with account number "B-67890" and balance "€800" in EUR
    When I transfer $300 from account "A-12345" to account "B-67890" in EUR
    Then the account balance for account "A-12345" should be "$600"
    And the account balance for account "B-67890" should be "€1000"

  Scenario: Transfer funds from EUR to GBP account
    Given a bank account with account number "B-67890" and balance "€800" in EUR
    And a bank account with account number "C-24680" and balance "£500" in GBP
    When I transfer €200 from account "B-67890" to account "C-24680" in GBP
    Then the account balance for account "B-67890" should be "€600"
    And the account balance for account "C-24680" should be "£700"

  Scenario: Transfer funds from GBP to USD account
    Given a bank account with account number "C-24680" and balance "£500" in GBP
    And a bank account with account number "A-12345" and balance "$1000" in USD
    When I transfer £100 from account "C-24680" to account "A-12345" in USD
    Then the account balance for account "C-24680" should be "£400"
    And the account balance for account "A-12345" should be "$700"



#DataTable

#  This is data driven framework (i can say i have exoerience building BDD)
#  this is more easy than previous scenario
  Scenario: Transfer funds between different currency accounts
    Given the following bank accounts with their respective balances:
#    row index 0
      | Account Number | Currency | Balance   |
#      row index 1
#      also with colum
      | A-12345        | USD      | $1000     |
      | B-67890        | EUR      | €800      |
      | C-24680        | GBP      | £500      |
    When I transfer the following amounts between accounts:
      | From Account | To Account | Transfer Amount | Transfer Currency |
      | A-12345      | B-67890    | $300            | EUR              |
      | B-67890      | C-24680    | €200            | GBP              |
      | C-24680      | A-12345    | £100            | USD              |
    Then the account balances should be updated as follows:
      | Account Number | Currency | New Balance   |
      | A-12345        | USD      | $600          |
      | B-67890        | EUR      | €1000         |
      | C-24680        | GBP      | £700          |



  Scenario: Process Orders
    Given the following orders:
      | Order ID | Product | Quantity |
      | 101      | Apple   | 5        |
      | 102      | Banana  | 3        |
      | 103      | Orange  | 2        |


#    List.get(0).get(key)
#  List.get(0).get(product)
#  if i wand to get Orange i would write List.get(2).get(Product)