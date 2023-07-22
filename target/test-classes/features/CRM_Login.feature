Feature: ERP login functionality
  Agile Story: User should be able to login in with correct credentials

  @GeneralUser
  Scenario: Positive login scenario
    Given user is on ERP login page
    When user enter "salesmanager55@info.com" username
    And user enter "salesmanager" password
    Then user clicks to login button

    @PosManager
    Scenario: Positive login scenario (scenario outline)
      Given user is on login page
      When user enters below correct credentials
        | username | posmanager55@info.com |
        | password | posmanager            |
      Then user clicks to login button

      @SalesManager
      Scenario: Positive login scenario (scenario outline)
        Given user is on login page
        When user enters below correct credentials info
          | username | salesmanager55@info.com|
          | password | salesmanager            |
          Then user clicks to login button