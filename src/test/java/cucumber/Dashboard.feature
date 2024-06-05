@tag
Feature: Dashboard
  Feature to test the Dashboard functionality

  Background:
    Given Open the browser and enter the url

  @tag1
  Scenario Outline: Device Status Alert Clear
    Given Logged in with username <name> and password <password>  
    When DASHBOARD is displayed 
    And Device Status Alert is cleared with reason <comment>       
    Then Logout of the Application

    Examples: 
      | name  | password | comment                        |
      | s2    |     s2   | test to clear Device Status alert     |

      
    @tag2
  Scenario Outline: Maintenance Alert Clear
    Given Logged in with username <name> and password <password>  
    When DASHBOARD is displayed 
    And Maintenance Alert is cleared with reason <comment>       
    Then Logout of the Application

    Examples: 
      | name  | password | comment  											 |
      | s2    |     s2   | Maintenace alert Clear test     |
      
   @tag3
  Scenario Outline: Beacon Alert Clear
    Given Logged in with username <name> and password <password>  
    When DASHBOARD is displayed 
    And Beacon Alert is cleared with reason <comment>       
    Then Logout of the Application

    Examples: 
      | name  | password | comment                        |
      | s2    |     s2   | test to clear beacon alert     |
      
    @tag4  
    Scenario Outline: Check Charts Tab
    Given Logged in with username <name> and password <password>  
    When DASHBOARD is displayed 
    And Check Charts Information       
    Then Logout of the Application

    Examples: 
      | name  | password |
      | s2    |     s2   |
      
     @tag5  
    Scenario Outline: Check AlarmHistory Tab
    Given Logged in with username <name> and password <password>  
    When DASHBOARD is displayed 
    And Check Alarm History Information       
    Then Logout of the Application

    Examples: 
      | name  | password |
      | s2    |     s2   |
      
     @tag6  
    Scenario Outline: Check MableHistory Tab
    Given Logged in with username <name> and password <password>  
    When DASHBOARD is displayed 
    And Check Mable History Information       
    Then Logout of the Application

    Examples: 
      | name  | password |
      | s2    |     s2   |  
      