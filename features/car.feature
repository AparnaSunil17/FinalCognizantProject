Feature: Car Insurance Quote Validation on GoDigit.com

  Scenario: Get car insurance quote with invalid contact info
    Given User visits GoDigit's car insurance quote page
    When User proceeds without entering car number
    And Fills in other required details
    And Enters an invalid email or phone number
    Then Capture and display the error message shown by the site
