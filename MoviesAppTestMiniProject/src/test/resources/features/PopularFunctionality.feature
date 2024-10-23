Feature: Popular Page Test
  As a user of the movies website
  I have verify the Popular page movie are displayed or not

  Scenario: Test the Popular Page UI
    Given I am on the login page 'PopularPg'
    When I enter the Valid user credential 'PopularPg'
    And I click on the loginBtn 'PopularPg'
    When I click on popular 'PopularPg'
    Then I have verify the movies are displayed or not 'PopularPg'