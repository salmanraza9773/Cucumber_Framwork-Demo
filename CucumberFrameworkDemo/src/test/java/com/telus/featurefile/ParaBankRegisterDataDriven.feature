Feature: User registration for opening a bank account using data driven concept
  Using different combination of data

  Scenario Outline: Register the user for bank account
    Given user is navigating to register page
    When enter first name as "<FirstName>" and last name as "<LastName>"
    And enter address as "<Address>", city as "<City>", state as "<State>" and zipcode as "<Zipcode>"
    And enter phone number as "<PhoneNumber>"
    And enter SSN as "<SSN>"
    And login credentials as "<UserName>", "<Password>" and "<ConfirmPassword>"
    And click on register
    Then user is successfully registered
    And close the application

    Examples: 
      | FirstName | LastName | Address      | City | State | Zipcode | PhoneNumber | SSN       | UserName| Password | ConfirmPassword |
      | Salman    | Raza     | Station Road | Siwan| Bihar |  841226 |  9773782031 | 212312323 | Salman  | Hello    | Hello           |
      | Jimmi     | C        | Station Road | Siwan| Bihar |  841226 |  9773782031 | 212312323 | Jimmi   | Hello    | Hello           |
      | Qasim     | S        | Station Road | Delhi| Delhi |  110044 |  9773782031 | 212312323 | Qasim   | Hello    | Hello           |
