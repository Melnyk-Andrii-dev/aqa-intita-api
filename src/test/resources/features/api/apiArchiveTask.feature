Feature: Intita Api Archive

  @session
  Scenario: To archive a created task on the board
    Given I send login request with email '' and password ''
    When I send to ARCHIVE created 2017 task request
    And The created TestTask1 task was archived
    Then The task 2017 was unzipped