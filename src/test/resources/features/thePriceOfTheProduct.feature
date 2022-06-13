Feature: Remember The Price Of The Product
  Scenario: I want to compare the price in the cart with the price memorized
    Given I going to Main Page
    And I search "1515" product
    And I remember his price
    And I send product in to cart
    And I go to the cart
    Then I compare prices

