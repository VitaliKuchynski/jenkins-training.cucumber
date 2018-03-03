@amazon-login
Feature: Amazon login feature

  Background:
  Given I am on home page of Amazon

  @amazon-login-1
  Scenario: Verify user should not be able to login using invalid credentials

    When  I Hover over to Accounts & List
    And   I click on Sign in button
    And   I enter invalid semen.testerov@gmail.com into email address
    And   I click on continue button
    Then  I verify invalid error message

  @amazon-login-2
  Scenario: Verify user should not be able to login using invalid credentials second

    When  I click on Default Sign in button
    And   I enter invalid semen.testerov@gmail.com into email address
    And   I click on continue button
    Then  I verify invalid error message

  @amazon-login-3
  Scenario: Verify user should not be able to login using empty credentials third

    When  I click on Default Sign in button
    And   I click on continue button
    Then  I verify empty error message

  @amazon-login-4
  Scenario: Verify user should login using correct credential

    When  I click on Account & Lists button
    And   I enter invalid vikom84@mail.ru into email address
    And   I click on continue button
    Then  I verify password field appears
