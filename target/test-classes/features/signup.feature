@signup
  Feature: Signup
#    @signup-success
#    Scenario Outline: signup - signup success
#      Given user navigate to "brick-signup"
#      When user enter valid <first_name>,<last_name>,<address>,<password>,<confirm_password>
#      And user enter a random valid email
#      And user select <country> in the phone number dropdown
#      And user should get <country_code> in the front of phone number input
#      And user enter a random valid phone number
#      And user click register button
#      Then user should get success text
#    Examples:
#      |first_name|last_name|address|password|confirm_password|country|country_code|
#      |"fakhri"    |"fadhila"|"jl bandung"|"123456"|"123456"|"Indonesia"|"+62"      |
#      |"fakhri"    |"fadhila"|""|"123456"|"123456"|"Singapore"          |"+65"      |

    @signup-failed
    Scenario Outline: signup - signup failed with invalid input
      Given user navigate to "brick-signup"
      When user enter <first_name>,<last_name>,<email>,<phone>,<address>,<password>,<confirm_password>
      And user click register button
      Then user should receive a <case> warning
      Examples:
        |first_name|last_name|email|phone|address|password|confirm_password|case|
#        |""    |""|""|""|""| ""   |""|"empty input"|
#        |"fakhri"    |"fadhila"|"new@email.com"|"12345666"|"jl bandung"|"123456"|"123457"|"password not match"|
#        |"fakhri"    |"fadhila"|"new@email.com"|"12345666"|"jl bandung"|"1"|"1"|"password length invalid"|
#        |"fakhri"    |"fadhila"|"email"|"12345666"|"jl bandung"|"123456"|"123456"|"invalid email"|
#        |"fakhri"    |"fadhila"|"new@email.com"|"1"|"jl bandung"|"123456"|"123456"|"invalid phone number"|
        |"fakhri"    |"fadhila"|"fakhrifadhila@live.com"|"12345666"|"jl bandung"|"123456"|"123456"|"email already registered"|

#    Scenario: signup - want to sign in
#      Given user navigate to "brick-signup"
#      When user click sign in text
#      Then user should be at the sign in page
#
#    Scenario: signup - want to contact sales
#      Given user navigate to "brick-signup"
#      When user want to click contact sales text
#      Then user should receive email link to contact sales