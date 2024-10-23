Feature: Header Page Test
  As a user of Movies Website
  when i have in home page in header section
  I have to see the website logo and navBar items are visible
  I have abel to click on home navBar and I have to redirect to home page
  I have abel to click on the popular navBar and I have to redirect to popular Page
  I have abel to click on the search navBar and I have to redirect to search Page
  I have abel to click on the account navBar and I have to redirect to account Page

  Scenario: Test the Header Section UI
    Given I am on the login page 'HeaderPg'
    When I have enter the valid Login details 'HeaderPg'
    And I have click the login  button 'HeaderPg'
    Then I have to check the logo and navBar's items are visible 'HeaderPg'

  Scenario: Test the Header Section Functionalities
    Given I am on the login page 'HeaderPg'
    When I have enter the valid Login details 'HeaderPg'
    And I have click the login  button 'HeaderPg'
    And I have to check the home section by 'HeaderPg'
    And I have to check the popular section by 'HeaderPg'
    Then I have to check the account section by 'HeaderPg'

