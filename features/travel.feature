Feature: Student Travel Insurance on GoDigit.com

  Scenario: Find student travel insurance for 2 students to Europe
    Given Two students aged 21 and 22 want to study in a European country
    When They visit GoDigit's student travel insurance page
    And Fill in dummy travel details for both students
    Then Display three lowest international student travel insurance plans with amount and provider name
