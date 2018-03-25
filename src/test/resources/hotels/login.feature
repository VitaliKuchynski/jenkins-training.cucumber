@Hotels
  Feature: Login feature

    Background:
    Given I am on Hotels home page for sign in

#      @Login-1
#      Scenario: I verify user cs log in with correct credential
#        When I enter correct email into Email address field
#        And  I enter correct password into password field
#        And  I click on Sign-in button
#        Then I verify user successfully logged in


     @Login-2
    Scenario: I verify user cs log in with incorrect email
       When I enter incorrect email@gmail.com into Email address field
       And  I enter incorrect password6546 into password field
       And  I click on Sign-in button
       Then I verify error message