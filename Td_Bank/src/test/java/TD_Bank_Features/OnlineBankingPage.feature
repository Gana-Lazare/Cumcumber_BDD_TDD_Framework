Feature: Online Banking Page test Features

  Scenario: Log in with credentials
    Given I nagivate to td bank website
    And I mouse Over Login
    And i click on Online Banking
    And I search  for my data corresponding
    And I enter "userName" and "Password"
    When I click on log in
    Then message incorrect credentials should apear