Feature:  Test All Home Page Featuree


//  Scenario: test Small business navigation
 //   Given I nagivate to td bank website
//    When   I Click on smallBusiness
//    Then I should see small business Banking

  Scenario:  Navigate to online Banking under Log IN Drop Down Menu
    Given I nagivate to td bank website
    And I mouse Over Login
    When i click on Online Banking
    Then I should see online banking url
    #search
    Scenario:  Search anything on searchbare
      Given I nagivate to td bank website
      And I send searchkey "searchkey" on searchbare
      When i submit my search
      Then i should see the keysearch n search page