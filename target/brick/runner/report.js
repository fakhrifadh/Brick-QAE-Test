$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/signup.feature");
formatter.feature({
  "name": "Signup",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@signup"
    }
  ]
});
formatter.scenarioOutline({
  "name": "signup - signup failed with invalid input",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@signup-failed"
    }
  ]
});
formatter.step({
  "name": "user navigate to \"brick-signup\"",
  "keyword": "Given "
});
formatter.step({
  "name": "user enter \u003cfirst_name\u003e,\u003clast_name\u003e,\u003cemail\u003e,\u003cphone\u003e,\u003caddress\u003e,\u003cpassword\u003e,\u003cconfirm_password\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "user click register button",
  "keyword": "And "
});
formatter.step({
  "name": "user should receive a \u003ccase\u003e warning",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "first_name",
        "last_name",
        "email",
        "phone",
        "address",
        "password",
        "confirm_password",
        "case"
      ]
    },
    {
      "cells": [
        "\"fakhri\"",
        "\"fadhila\"",
        "\"fakhrifadhila@live.com\"",
        "\"12345666\"",
        "\"jl bandung\"",
        "\"123456\"",
        "\"123456\"",
        "\"email already registered\""
      ]
    }
  ]
});
formatter.scenario({
  "name": "signup - signup failed with invalid input",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@signup"
    },
    {
      "name": "@signup-failed"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user navigate to \"brick-signup\"",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.BrickSignupSteps.userNavigates(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enter \"fakhri\",\"fadhila\",\"fakhrifadhila@live.com\",\"12345666\",\"jl bandung\",\"123456\",\"123456\"",
  "keyword": "When "
});
formatter.match({
  "location": "steps.BrickSignupSteps.userInputRegistrationData(java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user click register button",
  "keyword": "And "
});
formatter.match({
  "location": "steps.BrickSignupSteps.userClickRegisterButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should receive a \"email already registered\" warning",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.BrickSignupSteps.userRegistrationFailed(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});