Feature: Login functionality
 
  Scenario: Successful login
    Given I open the browser and launch the login page
    When I login with username "<username>" and password "<password>"
    Then I should see the home page
    
      Examples:
      | username      | password      |
      |marvel01@gmail.com     | IronMan   |
      | standard_user | bad_pass  |