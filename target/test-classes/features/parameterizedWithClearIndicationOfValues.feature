Feature: parameterized step with clear indication of values

  Scenario Outline: I create parameterized step with clear indication of values
    Given Someone go to the Main Page
    And I chose "Москва" city
    Then I click on <sections>
    Examples:
      | sections          |
      | "Запись к врачу" |
      | "Анализы"        |
      | "Акции"          |
      | "Адреса"         |