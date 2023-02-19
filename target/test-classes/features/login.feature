@login
Feature: Login
  @login-success
  Scenario: login - Success login
    Given user open to "brick-login"
    When user input email "fakhrifadhila@live.com"
    And  user input password "123456"
    And user click login button
    Then user should be at the dashboard page

  @login-failed
  Scenario Outline: login - Failed login with invalid credentials
    Given user open to "brick-login"
    When user input email <email>
    And  user input password <password>
    And user click login button
    Then a text "Error" and "Wrong email or password" should appear in the validation errors region
    Examples:
      | email  | password  |
      | "fakhrifadhila@live.com" | "0000000" |
      | "invalid@invalid.com" | "123456" |

  Scenario Outline: login - Failed with Empty input
    Given user open to "brick-login"
    When user input email <email>
    And  user input password <password>
    And user click login button
    Then a text "Please fill out this field." should appear in the <email> or <password> form
    Examples:
      | email  | password  |
      | "fakhrifadhila@live.com" | "" |
      | "" | "123456" |
      |""  |""        |

  @forgot-password
  Scenario: Login - User forgot their password
    Given user open to "brick-login"
    When user click forgot password text
    Then user should be at the forgot password page

  @sign-up
  Scenario: Login - User want to register a new account
    Given user open to "brick-login"
    When user click Sign Up text
    Then user should be at the Sign Up page