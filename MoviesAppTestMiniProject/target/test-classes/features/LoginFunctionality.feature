Feature: Login Page Test
  As a user of the movies website
  I have able to login to the movie website
  and redirected to the home page

  Scenario: Test the Login Page UI
    Given I am on the login page 'LoginPg'
    Then I have able to see the website logo, heading, labelText and loginBtn 'LoginPg'

  Scenario: Test the login functionality with empty input fields
    Given I am on the login page 'LoginPg'
    When I click on the loginBtn 'LoginPg'
    Then I have to verify the error text 'Empty Input Field' 'LoginPg'

  Scenario: Test the login functionality with empty USERNAME
    Given I am on the login page 'LoginPg'
    When I enter the 'Password' 'LoginPg'
    And I click on the loginBtn 'LoginPg'
    Then I have to verify the error text 'Empty UserName Field' 'LoginPg'

  Scenario: Test the login functionality with an empty PASSWORD
    Given I am on the login page 'LoginPg'
    When I enter the 'UserName' 'LoginPg'
    And I click on the loginBtn 'LoginPg'
    Then I have to verify the error text 'Empty Password Field' 'LoginPg'

  Scenario: Test the login functionality with Invalid Credentials
    Given I am on the login page 'LoginPg'
    When I enter the 'UserName' 'LoginPg'
    And I enter the 'Wrong Password' 'LoginPg'
    And I click on the loginBtn 'LoginPg'
    Then I have to verify the error text 'Wrong Password' 'LoginPg'

  Scenario: Test the login functionality with Valid Credentials
    Given I am on the login page 'LoginPg'
    When I enter the 'UserName' 'LoginPg'
    When I enter the 'Password' 'LoginPg'
    And I click on the loginBtn 'LoginPg'
    Then I have to verify the login Url 'LoginPg'



