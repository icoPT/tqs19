Feature: Search for cheese
  Sample feature to demo webdrivr  and cucumber integration

  Scenario: Finding some cheese
    Given I am on the Google search page
    When I search for "Cheese!"
    Then the page title should start with "cheese"