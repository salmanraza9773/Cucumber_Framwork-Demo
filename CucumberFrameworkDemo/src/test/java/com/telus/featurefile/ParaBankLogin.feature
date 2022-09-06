Feature: To test the customer login for parabank application

  Background: 
    Given user is navigating to login page

  Scenario: Login using valid credentials
    When enter username as "Salman999" and password as "Salman999"
    And click on login button
    Then display the user home page
    And logout the application
    And close the application

  Scenario: Login using invalid user name and password
    When enter invalid username as "Salman999" and password as ""
    And click on login button
    Then unable to login
    And close the application

 