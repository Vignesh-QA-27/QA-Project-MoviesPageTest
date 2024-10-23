Feature: Search Page Test
  As a user of the movies website
  I have to search any movie and count the display of movie count
  I have click the search button and I have to verify the Error Msg ang Img is Displayed or not

  Scenario: Test the Search Functionality By Movie Name
    Given I am on the login page 'SearchPg'
    When I enter the Valid user credential 'SearchPg'
    And I click on the loginBtn 'SearchPg'
    When I click on the search bar 'SearchPg'
    And I enter the search correct movie name input 'SearchPg'
    And I click ont the search button 'SearchPg'
    Then I have to verify the count of movies 'SearchPg'

  Scenario: Test the Search Functionality Failure case
    Given I am on the login page 'SearchPg'
    When I enter the Valid user credential 'SearchPg'
    And I click on the loginBtn 'SearchPg'
    When I click on the search bar 'SearchPg'
    And I enter the search wrong movie name input 'SearchPg'
    And I click ont the search button 'SearchPg'
    Then I have to verify the Error Msg of empty search 'SearchPg'
