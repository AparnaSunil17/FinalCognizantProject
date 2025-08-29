Feature: Travel Insurance Quote

  Scenario: User selects travel insurance for France and views prices for two travellers
    Given the user launches the Digit insurance website
    When the user navigates to the Travel Insurance section
    And selects France as the destination
    And selects departure date as "26 September 2025"
    And selects return date as "12 December 2025"
    And clicks on Get Quote
    Then the quote form should be displayed
    When the user enters date of birth "10/04/2000" for the first traveller
    And adds another traveller with date of birth "19/04/2001"
    And clicks on View Prices
    Then the user should see available insurance plans with their prices
