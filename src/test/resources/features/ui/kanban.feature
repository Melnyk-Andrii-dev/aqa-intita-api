Feature: As a registered user
  I want to use a kanban board

  Background: MyTasks page is opened with more than one ticket in "Expect execution" column
    Given Login page is opened in pop up
    When I enter email '' on Login page
    And I enter password '' on Login page
    And I click Sign in button on Login page
    And I click Dropdown Profile button
    And I choose Dashboard option
    And I click MyTasks button
    Then MyTasks page is opened

  @ui
  Scenario: Moving tickets to different columns (status changes)
    Given More than one ticket are in EXPECT_EXECUTION column
    When I change ticket status from EXPECT_EXECUTION to IN_PROGRESS column
    Then The ticket is added to IN_PROGRESS column
    When I change ticket status from IN_PROGRESS to DONE column
    Then The ticket is added to DONE column
    And The ticket was removed from IN_PROGRESS column
    When I change ticket status from EXPECT_EXECUTION to DONE column
    Then The ticket is added to DONE column
    When I change ticket status from DONE to IN_PROGRESS column
    Then The ticket is added to IN_PROGRESS column

  @ui
  Scenario: Filter tickets by title
    When I fill search by title form with 'test'
    And I click search button
    Then Tickets are filtered by title 'test'

  @ui
  Scenario: Filter tickets by priority
    Given There are tickets with different priorities on the board
    When I click FilterByPriority Button
    And I select a higher priority option
    Then Tickets are filtered by selected priority