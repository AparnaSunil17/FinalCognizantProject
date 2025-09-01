Feature: Commercial Insurance Quote Validation on GoDigit.com

  Scenario: Missing commercial registration number
    Given User visits GoDigit commercial insurance quote page
    When User enters the phone number and proceeds clicks View Prices button without entering registration number "<row_index>"
    Then Capture and display the error message for missing registration number
    Examples: 
	      | row_index |
	      |         1 |
	      |         2 |
	      |         3 |

  Scenario: Invalid contact information
    Given User visits GoDigits commercial insurance quote page
    When Enters a valid registration number "<row_index>"
    And Enters an invalid phone number and clicks View Prices button "<row_index>"
    Then Capture and display the error message for invalid contact info
    Examples: 
	      | row_index |
	      |         1 |
	      |         2 |
	      |         3 |