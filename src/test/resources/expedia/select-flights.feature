@regression @selectFlight

Feature: Select flight feature

  Background:
    Given I am on home page

  @selectFlight-1
  Scenario: Verify empty selection
      When  I click on search button on home screen
      Then  I verify that i get an error messages

  @selectFlight-2
  Scenario: Verify correct flight selection
    When I click on flight tab
    And  I select Flying from city airport
    And  I select Flying to city airport
    And  I select Departing date
    And  I select Returning date
    And  I click on search button
    Then I verify page with result

