@regression @darkSky
Feature: Verify different display on DarkSky

  Background:
    Given I am on homepage of DarkSky

  @darkSky-1
  Scenario: Verify days of the week are displayed correctly
    When I scroll to days of the week
    Then I verify days of the week is displayed correctly

  @darkSky-2
  Scenario: Verify low and high temp displayed correctly on parent bar
    When I click on todays bar
    Then I verify low and high temp displayed correctly on parent bar

  @darkSky-3
  Scenario: Verify selected tomorrow's date not clickable
    When I click on Time Machine
    And I select tomorrow's date
    Then I verify selected date is not clickable
    And I verify date is displayed in correct format