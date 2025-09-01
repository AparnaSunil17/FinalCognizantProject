Feature: Health Insurance Menu Retrieval on GoDigit.com

  Scenario: Retrieve health insurance menu items
    Given User navigates to GoDigits health insurance section
    When User fills the pincode and mobile number then click View Prices (pincode="603103", phone_no="9999999999")
    Then User accesses the health insurance menu
    Then Store all menu items in a list and display them