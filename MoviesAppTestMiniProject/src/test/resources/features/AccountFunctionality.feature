Feature: Account Page Testing
  As a user of Movies Website
  when i click on the account page section
  I should see all UI details are present in Account Page
  I want to able to logout from my account
  After logout i have to redirect to the loginPage

  Scenario: Test all the UI elements present on the web page
    Given I am on the login page 'AccountPg'
    When I have enter the valid Login details 'AccountPg'
    And I have click the login  button 'AccountPg'
    When I have click on account section 'AccountPg'
    And I have to verify the account page navigation 'AccountPg'
    And I have to verify the NavBar section 'AccountPg'
    Then I have to verify the account section 'AccountPg'
    When I click on the logout button 'AccountPg'
    Then I have to redirect to the login page 'AccountPg'

  Scenario: Test the Logout functionality
    Given I am on the login page 'AccountPg'
    When I have enter the valid Login details 'AccountPg'
    And I have click the login  button 'AccountPg'
    When I have click on account section 'AccountPg'
    When I click on the logout button 'AccountPg'
    Then I have to redirect to the login page 'AccountPg'


