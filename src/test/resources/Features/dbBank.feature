Feature: DBankSavings

  @poovi
  Scenario Outline: To verify user can able to perform Saving account opening
    Given User gets "<TestCase>" to perform savings account opening
    When Launch the digital bank application url in browser
    And User enters the userName and password to log in to application
    And User initiate the saving bank account opening
    And User inputs the AccountName, DepositAmount to complete the savings account opening
    And User can able to view the newly created account with AccountName successfully
    Then User logs out of the application

    Examples: 
      | TestCase |
      | TC_01    |
 