Feature: Digital Bank

  @test1
  Scenario Outline: To verify user can able to perform Saving account opening
    When User gets "<TestCase>" to perform savings account opening
    And User enters the userName and password to log in to application
    And User initiate the saving bank account opening
    And User inputs the AccountName, DepositAmount to complete the savings account opening
    And User can able to view the newly created account with AccountName successfully
    Then User logs out of the application

    Examples: 
      | TestCase |
      | TC_01    |
      #| TC_02    |
      #| TC_03    |

  #Scenario Outline: To verify the application is able to perform deposit into account
    #Given User gets "<testCaseId>" to perform  deposit into account
    #When Launch the digital bank application url in browser
    #When User enters the username and password to log in to application
    #And User gets the inital balance from Savings page
    #And User initiates the deposit into account
    #Then User inputs the accountForDeposit and depositAmount to complete the deposit
    #And User logs out of the application
#
    #Examples: 
      #| testCaseId |
      #| TC001      |
