Feature: Login functionality

  @UI @Login
  Scenario Outline: User can login with valid credentials
    Given user is on "Login" page
    And user types in username as <username>
    And user types in password as <password>
    When user clicks login
    Examples:
      | username | password |
      | 1234     | failure    |
      | 2315     | failure    |