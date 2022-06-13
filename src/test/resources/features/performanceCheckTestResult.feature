Feature: Performance test check results
  Scenario: I want chek performance check rest result
    Given I open MainPage
    And I click result button
    And I click Search result button
    Then I check that the fields are red
    Then I check for an error message

