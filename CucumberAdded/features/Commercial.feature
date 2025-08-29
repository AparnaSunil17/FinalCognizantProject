Feature: Commercial Insurance Quote Validation

  Scenario: User tries to view price without entering registration number
    Given the user opens the Digit site for commercial insurance
    When the user clicks on the Commercial Insurance section
    And clicks on View Price without entering registration number
    Then an error message for missing registration number should be displayed

  Scenario: User enters registration number and invalid mobile number
    Given the user opens the Digit site for commercial insurance
    When the user clicks on the Commercial Insurance section
    And enters registration number "KA04DK1234"
    And enters invalid mobile number "123455"
    And clicks on View Price
    Then an error message for invalid mobile number should be displayed
