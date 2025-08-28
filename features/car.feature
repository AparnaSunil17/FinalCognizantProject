Feature: Car Insurance Quote Validation on GoDigit.com

  Scenario: Missing car registration number
    Given User visits GoDigit's car insurance quote page
    When User proceeds without entering car number
    Then Capture and display the error message for missing car number

  Scenario: Invalid contact information
    Given User visits GoDigit's car insurance quote page
    And Enters a valid car number
    When User fills in other required details
    And Enters an invalid email or phone number
    Then Capture and display the error message for invalid contact info

    

