Feature: As mandatory user
  I want to create task on Dashboard for other user

  Background: Dashboard Page is opened
    Given Login page is opened in pop up
    When I enter email '' on Login page
    And I enter password '' on Login page
    And I click Sign in button on Login page
    When I click Dropdown profile button on Header Component
    When I click DASHBOARD_BUTTON in dropdown menu on HeaderComponent
    Then The page "Дошка" is opened

  @ui
    Scenario: Successful creation new task on Dashboard page with all data
      When I click Create task button on DashboardSidebarComponent
      And I enter "TestTask1" in the field Name on Task Creation Page
      And I click the calendar button BEGIN on Task Creation Page
      And I click the beginning date on the calendar on Task Creation Page
      And I click the calendar button END on Task Creation Page
      And I click the expiration date on the calendar on Task Creation Page
      And Enter Completion time "10" on Task Creation Page
      And I click the calendar button DEADLINE on Task Creation Page
      And I click the deadline date on the calendar on Task Creation Page
      And I click the Type button on Task Creation Page
      And I click Bug type dropdown button on Task Creation Page
      And I click Priority button on Task Creation Page
      And I click Low Priority Dropdown button on Task Creation Page
      And I fill in the Body field "Body data" on Task Creation Page
      And I click the button Save a task on Task Creation Page
      And I click the button My Tasks on Dashboard Sidebar Component
      Then The task "TestTask1" is present on the Task Page

  @ui
  Scenario: Successful creation new task on Dashboard page with partially filled data (task name, beginning data and body)
    When I click Create task button on DashboardSidebarComponent
    And I enter "TestTask2" in the field Name on Task Creation Page
    And I click the calendar button BEGIN on Task Creation Page
    And I click the beginning date on the calendar on Task Creation Page
    And I fill in the Body field "Body data" on Task Creation Page
    And I click the button Save a task on Task Creation Page
    And I click the button My Tasks on Dashboard Sidebar Component
    Then The task "TestTask2" is present on the Task Page

  @ui
  Scenario: Unsuccessful creation new task on Dashboard page without task name
    When I click Create task button on DashboardSidebarComponent
    And I click the calendar button BEGIN on Task Creation Page
    And I click the beginning date on the calendar on Task Creation Page
    And I fill in the Body field "Body data" on Task Creation Page
    And I click the button Save a task on Task Creation Page
    Then The NO_DATA_ERROR_MESSAGE is displayed on Task Creation Field

  @ui
  Scenario: Unsuccessful creation new task on Dashboard page without body
    When I click Create task button on DashboardSidebarComponent
    And I enter "TestTask1" in the field Name on Task Creation Page
    And I click the calendar button BEGIN on Task Creation Page
    And I click the beginning date on the calendar on Task Creation Page
    And I click the button Save a task on Task Creation Page
    Then The NO_DATA_ERROR_MESSAGE is displayed on Task Creation Field
    And The Task Creation page "Створити" is opened

  @ui
  Scenario: Unsuccessful creation new task on Dashboard page without beginning date
    When I click Create task button on DashboardSidebarComponent
    And I enter "TestTask1" in the field Name on Task Creation Page
    And I fill in the Body field "Body data" on Task Creation Page
    And I click the button Save a task on Task Creation Page
    Then The NO_DATA_ERROR_MESSAGE is displayed on Task Creation Field
    And The Task Creation page "Створити" is opened




