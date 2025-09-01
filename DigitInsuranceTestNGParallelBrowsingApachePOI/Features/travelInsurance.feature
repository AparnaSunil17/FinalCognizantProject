Feature: Travel Insurance Plan
	Scenario: display three lowest international travel insurance plan
		Given the user selects the travel insurance icon
		When the user fills the details then clicks the View Prices button (country="Canada", startDay="29",startMonth="September",startYear="2025",startDay="20",startMonth="October",startYear="2025")
		And adds the Date of Births of travelers then clicks View Prices button (DOB1= "29/10/2003", DOB2="20/01/2004")
		Then find the three lowest insurance plan
