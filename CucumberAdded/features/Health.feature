Feature: Health Insurance Flow on GoDigit

  Scenario: User checks health insurance options
    Given the user launches the GoDigit website
    When the user clicks on Health Insurance
    And the user enters pincode "600001"
    And the user enters mobile number "9999999999"
    And the user clicks on View Prices
    And the user selects Health Insurance Policy
    Then the user should see the available health insurance menu items
