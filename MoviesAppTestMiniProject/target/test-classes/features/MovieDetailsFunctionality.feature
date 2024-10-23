Feature: MovieDetails Page Test
  As a user of the movies website
  In home page I have to click on any movie and check the all ui elements are present
  In Popular page I have to click on any movie and check the all ui elements are present

  Scenario: Test the Movie Details Page
    Given I am on the login page 'MovieDetailsPg'
    When I enter the Valid user credential'MovieDetailsPg'
    And I click on the loginBtn 'MovieDetailsPg'
    When I click on home 'MovieDetailsPg'
    And I click on any movie in home section 'MovieDetailsPg'
    When I have to verify the home movie ui elements 'MovieDetailsPg'
    When I click on popular 'MovieDetailsPg'
    And I click on any movie in popular section 'MovieDetailsPg'
    Then I have to verify the popular movie ui elements 'MovieDetailsPg'

