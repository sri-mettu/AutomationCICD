@tag
Feature: Login Check
  test to check Login function

  @ErrorCheck
  Scenario Outline: Invalid Login check
    Given Open the browser and enter the url      
    When Logged in with username <name> and password <password>            
    Then Error message is displayed

    Examples: 
      | name  | password | 
      | s2    |     s3   |
      