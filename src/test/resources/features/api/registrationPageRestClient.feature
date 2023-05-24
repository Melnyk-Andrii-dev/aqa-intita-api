Feature: Registration API

  @session
  Scenario: Registration new account on INTITA
    When I send registration new account request with random email and password '' and I see 200 code

