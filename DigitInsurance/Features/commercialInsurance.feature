Feature: Commercial Insurance Quote Validation on GoDigit.com

  Scenario: Missing commercial registration number
    Given User visits GoDigit commercial insurance quote page
    When User enters the phone number and proceeds clicks View Prices button without entering registration number (phone_no="9999999999") 
    Then Capture and display the error message for missing registration number 

  Scenario: Invalid contact information
    Given User visits GoDigits commercial insurance quote page
    When Enters a valid registration number (reg_number="Kl03GH1234")
    And Enters an invalid phone number and clicks View Prices button (phone_no="9999")
    Then Capture and display the error message for invalid contact info