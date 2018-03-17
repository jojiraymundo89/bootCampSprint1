@regression @hotels
Feature: Verify user is able to successfully search for hotels

  Background:
    Given I am on Hotels homepage

  @hotels-1
  Scenario: Verify selected dates display correct number of nights
    When I click on destination box
    And I enter California as search key
    And I enter Los Angeles as final destination
    And I select tomorrows date in Check-in date
    And I select 7 days stay
    Then I verify that number of nights is correctly displayed
    And I click on options
    And I enter 2 adults, 2 children and ages
    And I click on search button
    Then I verify that selection made is correctly displayed

