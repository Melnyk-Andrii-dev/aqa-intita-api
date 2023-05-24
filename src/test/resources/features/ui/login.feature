Feature: As an registered user
  I want to log in to the system with my credentials
  So that I can have access to site

  @ui
  Scenario:[PARAMS] Error to activate account is displayed after unsuccessful login
    Given Login page is opened in pop up
    When I enter email '' on Login page
    And I enter password '' on Login page
    And I click Sign in button on Login page
    Then My Start page is displayed false

  @ui
  Scenario:[PARAMS] My Start page is displayed after successful login
    Given Login page is opened in pop up
    When I enter email '' on Login page
    And I enter password '' on Login page
    And I click Sign in button on Login page
    Then My Start page is displayed true

  @ui
    Scenario: The unsuccessful login message is displayed after entering an invalid email and invalid password
      Given Login page is opened in pop up
      When I enter email '' on Login page
      And I enter password '' on Login page
      And I click Sign in button on Login page
      Then The 'Невірна електронна пошта або пароль' message is displayed under the password field