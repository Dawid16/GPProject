Feature: Test BetApp Smoke Scenario:

  Scenario: Test placing bet on a English Premier League Event:

    Given I navigate to a Football bets
    When I navigate to competitions Site
    And I navigate to the English Premier League Events
    And I select an event and place a bet for the Home team to win
    Then I should see proper results of bet