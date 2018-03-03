@departments-menu
Feature: Departments-menu feature

  Background:
    Given I am on Amazon home page

#  @departments-1
#  Scenario: Verify amazon list of departments
#    When I mouse over department drop-down
#    Then I verify that department Amazon Music in the list


  @departments-2
  Scenario Outline: Verify amazon list of departments
    When I mouse over department drop-down
    Then I verify that department <title> in the list

#  @navigate-to-department
#  Scenario: Verify navigation to the department
#    When I mouse over department drop-down
#     And I mouse over department in the menu
#     And I click on menu point
#    Then I verify that i am in the right page



  Examples:
  | title        |
  | Amazon Music |
#  | Prime Video  |