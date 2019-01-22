Feature: Testing001 Testing my home page

  Scenario Outline: Test the title of my home page
    Given I have <URL>
    When I open the home page
    Then I can see the <title>
    Examples:
    |URL                     | title|
    | https://localhost:4234 | Hello|