@tag
Feature: Reports
  test to reports functionality
 Background:
Given Open the browser and enter the url

  @tag1
  Scenario Outline: Report Generation   
    Given Logged in with username <name> and password <password>            
    And Click on the menubutton 
    Then Click on reports 
    And Generate report <type> with user/dev <urd> or users <usrs>  
    And Save the report with name <nm> 
    And Delete the report with name <nm>
    Then Logout of the Application

    Examples: 
      | name  | password | type|urd|nm	  |usrs|
      | s2    |     s2   |  0  | 1 |test02|1,2 |
  