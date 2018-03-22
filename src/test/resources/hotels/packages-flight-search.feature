@Hotels
Feature: Flight search feature

  Background:
    Given I an on flight packages page

  @Search-flight-verification
  Scenario Outline: Verify round flight search
    When  I click on Flight only tab
    And   I enter <departure city/airport> into Flying from field
    And   I enter <arrival city/airport> into Flying to field
    And   I select 29 and Mar 2018 from departure date
    And   I select 30 and May 2018 from returning date
    And   I select 2 adults passengers
    And   I click on search button
    And   I select departure nonstop trip
    And   I click on select button on first departure flight
    And   I select returning nonstop trip
    And   I click on select button on first returning flight
    And   I click on book now button
    And   I click on  Roundtrip Fligh link
    Then  I verify number of stops value
    And   I verify departure date
    And   I verify returning date
    And   I verify leaving and destination airports
    And   I verify passengers value

    Examples:
      |departure city/airport                   |arrival city/airport|
      |New York, NY (JFK-John F. Kennedy Intl.) |  San Diego Intl.   |

#  @Flight-filter-verification
#  Scenario Outline: Verify filtering by price and flight company search
#    When  I click on Flight only tab
#    And   I enter <departure city/airport> into Flying from field
#    And   I enter <arrival city/airport> into Flying to field
#    And   I select 29 and Mar 2018 from departure date
#    And   I select 30 and Mar 2018 from returning date
#    And   I click on search button
#    And   I check Jet blue airlines check box
#    And   I select highest price from dropdown
#    Then  I verify airlines is displayed correctly
#    And   I verify price is displayed correctly
#
#
#    Examples:
#      |departure city/airport|arrival city/airport|
#      |New York JFK          |  San Diego  Intl   |