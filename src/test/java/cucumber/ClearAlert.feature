
@tag
Feature: Clearing the Alert
  test to clear the Active Alert
Background:
Given Open the browser and enter the url
 

  @skip
  Scenario Outline: Maintenance Alert Clear
    Given Logged in with username <name> and password <password>  
    When "DASHBOARD" is displayed 
    And Maintenance Alert is cleared with reason <comment>       
    Then Logout of the Application

    Examples: 
      | name  | password | comment  											 |
      | s2    |     s2   | Maintenace alert Clear test     |
      
      @skip
  Scenario Outline: Beacon Alert Clear
    Given Logged in with username <name> and password <password>  
    When "DASHBOARD" is displayed 
    And Beacon Alert is cleared with reason <comment>       
    Then Logout of the Application

    Examples: 
      | name  | password | comment                        |
      | s2    |     s2   | test to clear beacon alert     |
      