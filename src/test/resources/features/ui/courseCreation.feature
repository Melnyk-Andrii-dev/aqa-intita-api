Feature: As authorised user
  I want to create new course
  So I see it in the list of all courses

  Background: The Course Creation page is opened
    Given Login page is opened in pop up
    When I enter email '' on Login page
    And I enter password '' on Login page
    And I click Sign in button on Login page
    When I click Dropdown profile button on Header Component
    When I click DASHBOARD_BUTTON in dropdown menu on HeaderComponent
    And I click Content Button on DashboardPage
    And I click COURSES_CONTENT_DROPDOWN_BUTTON on Dashboard Page
    Then I click Create Course Button on List Of All Courses page

  @ui
  Scenario: Successful creation course with valid data
    When I enter in the field COURSE_NAME_INPUT_FIELD data 'TestCourse1' on the Course Creation page
    And I enter in the field COURSE_NICKNAME_INPUT_FIELD data 'TestNickname1' on the Course Creation page
    And I click the LANGUAGE field on Course Creation page
    And I choose 'Англійською' in course language dropdown on Course Creation page
    And I click the ONLINE_STATUS field on Course Creation page
    And I choose 'доступний' in online status dropdown on Course Creation page
    And I click the LEVEL field on Course Creation page
    And I choose 'початківець' in level dropdown on Course Creation page
    And I enter in the Term of Internship field data '12' on the Course Creation page
    And I click the field offline status on Course Creation page
    And I choose 'доступний' in offline status dropdown on Course Creation page
    And I enter in the FOR_WHOM_TEXTAREA the data 'Для студента' on Course Creation page
    And I enter in the WHAT_WILL_YOU_LEARN_TEXTAREA the data 'Знанням' on Course Creation page
    And I enter in the WHAT_WILL_YOU_GET_TEXTAREA the data 'Знання' on Course Creation page
    And I click Autopublicate Alumni Checkbox on Course Creation page
    And I click Save button on Course Creation Page
    And I enter the course nickname 'TestNickname1' in the field Nickname on the ListOfAllCourses Page
    And The course nickname 'TestNickname1' is displayed on the ListOfAllCourses Page
    And I click button delete Course button

  @ui
  Scenario: Unsuccessful creation course with not valid data in required fields
    When I enter in the field COURSE_NAME_INPUT_FIELD data 'TestCourse@1' on the Course Creation page
    And I enter in the field COURSE_NICKNAME_INPUT_FIELD data 'TestNickname#1' on the Course Creation page
    And I click the LANGUAGE field on Course Creation page
    And I choose 'Англійською' in course language dropdown on Course Creation page
    And I click the ONLINE_STATUS field on Course Creation page
    And I choose 'доступний' in online status dropdown on Course Creation page
    And I click the LEVEL field on Course Creation page
    And I choose 'початківець' in level dropdown on Course Creation page
    And I click Autopublicate Alumni Checkbox on Course Creation page
    And I click Save button on Course Creation Page
    Then The page 'Створити' is opened
