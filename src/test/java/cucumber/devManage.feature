
@tag
Feature: Device Management Page
  To test the variuos functionalities of Device Management Page
  Background:
Given Open the browser and enter the url

  @ignore
  Scenario: Loading the devices from Hub  
    Given Logged in with username <name> and password <password>
    And Click on the menubutton   
    And Click on device managemnet and Load the devices
    Then Logout of the Application
    Examples: 
      | name  | password |
      | s2    |     s2   | 
      
    @tag1
  Scenario: Edit Device 
    Given Logged in with username <name> and password <password>
    And Click on the menubutton   
    And Click on device managemnet 
    And Search device id <id>
    Then Edit device with area <ar> and user <usr>
    Then Logout of the Application
    Examples: 
      | name  | password | id			|ar|usr|
      | s2    |     s2   |0012739	|0 | 2 |
      
    
     @tag2
  Scenario: Add Beacon 
    Given Logged in with username <name> and password <password>
    And Click on the menubutton   
    And Click on device managemnet 
    And Add the beacon devicename <devicename> and MacAddress <mcaddr>    
    Then Logout of the Application
    Examples: 
      | name  | password | devicename	|mcaddr       |
      | s2    |     s2   |AutoBeac	  |Beac01234567 |
    

 
