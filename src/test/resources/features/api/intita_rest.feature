Feature: Intita Api

  @session
  Scenario: CRUD task on the Board
    Given I send login request with email '' and password ''
    When I send create task request with name 'testTitle991' body 'testBody1' type TASK priority MEDIUM start date '2022-01-28' end date '2022-03-30'
    Then The task 'testTitle991' is created
    When I send update the task name request to 'testTitle9901'
    Then The task name was updated to 'testTitle9901'
    When I send delete task 'testTitle9901' request
    Then The task is deleted

  @session
  Scenario: Get all courses
    Given [ENUM]I send login request with email CMANAGER_EMAIL and password CMANAGER_PASSWORD
    When I send default Get all courses request
    And Courses in response are sorted descending by creation date
    When I send Get all courses filtered by title 'test' request
    Then Response contains only filtered by title 'test' courses

  @session
  Scenario: Create course
    Given [ENUM]I send login request with email CMANAGER_EMAIL and password CMANAGER_PASSWORD
    When I send Create course randomly titled with image request
    And I send Publish created course request
    And I send Search randomly titled course as client request
    Then The randomly titled course is found
    When I send Update the course's title request
    And I send Publish updated course request
    Then The course's title is updated

  @session
  Scenario: Course deletion
    Given [ENUM]I send login request with email CMANAGER_EMAIL and password CMANAGER_PASSWORD
    And I send Create course randomly titled with image request
    And I send Сreate module request
    And I send Add module to course request
    When I send failing Delete course request
    And I send Remove module from course requests
    And I send succeeding Delete course request
    Then The course was deleted

  @session
  Scenario: Create course with test
    Given [ENUM]I send login request with email CMANAGER_EMAIL and password CMANAGER_PASSWORD
    And I send Create course randomly titled with image request
    And I send Publish created course request
    And I send Сreate module request
    And I send Add module to course request
    When I send Create lesson in the module request
    And I send Create part in the lesson request
    And I send Add text to the part request
    And I send Create exercise in the part request
    And I send Add wrong answer request
    And I send Add right answer request
    And I send Pass test with wrong answer request
    Then Response contains false mark
    When I send Pass test with right answer request
    Then Response contains true mark



