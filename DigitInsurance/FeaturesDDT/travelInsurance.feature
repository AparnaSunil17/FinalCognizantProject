Feature: Travel Insurance Plan
	Scenario: display three lowest international travel insurance plan
		Given the user selects the travel insurance icon
		When the user fills the details then clicks the View Prices button "<row_index>"
		And adds the Date of Births of travelers then clicks View Prices button "<row_index>"
		Then find the three lowest insurance plan
		Examples: 
	      | row_index |
	      |         1 |
	      |         2 |
	      |         3 |
