Feature: Health Insurance Menu Retrieval on GoDigit.com

  Scenario: Retrieve health insurance menu items
    Given User navigates to GoDigit's health insurance section
    When User accesses the health insurance menu
    Then Store all menu items in a list
    And Display the list of health insurance menu items
