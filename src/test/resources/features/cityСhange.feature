Feature: City Change

  Scenario: I want change city on Omsk
    Given I open Main page
    When I click change City button
    And I write in search "Омск"
    And I check the search is correct and contains "Омск"
    And I chose city
    Then I see "Омск" in the Main page
