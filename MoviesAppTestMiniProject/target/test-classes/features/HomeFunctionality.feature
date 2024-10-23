Feature: Home Page Test
  As a user of Movie website
  I have able to see the heading's, access the play button And access the movies in the corresponding section
  I have able to access the contact us section

  Scenario: Test the Home Page
    Given I am on the login page 'HomePg'
    When I have enter the valid Login details 'HomePg'
    And I have click the login  button 'HomePg'
    Then I have to access all the home page contents 'HomePg'


