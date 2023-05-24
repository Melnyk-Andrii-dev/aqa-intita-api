Feature: As a logged in user
  I want to create a module in the cabinet
  So that I can give tasks to students

  Background: Logged in Content Manager user has opened Cabinet Dashboard
    Given Login page is opened in pop up
    When I enter email '' on Login page
    And I enter password '' on Login page
    And I click Sign in button on Login page
    Then My Start page is displayed true
    When I click Dropdown profile button on Header Component
    When I click DASHBOARD_BUTTON in dropdown menu on HeaderComponent
    Then The page "Дошка" is opened
    When I click filling content dropdown button
    And Click active button Modules
    Then The page "Перегляд" is opened

  @ui
    Scenario: Successful creation of a module in Cabinet filling all fields and editing its name
      When I click button Create
      And I enter in the enum field ID data '1' on Creating Module Page
      And I enter in the field NAME data 'Module' on Creating Module Page
      And I enter in the enum field NICKNAME data 'Module' on Creating Module Page
      And I click in the enum dropdown field LEVEL
      And I choose enum dropdown item JUNIOR on Creating Module Page dropdown fields
      And I click in the enum dropdown field LANGUAGE
      And I choose enum dropdown item ENGLISH_LANGUAGE on Creating Module Page dropdown fields
      And I click in the enum dropdown field ONLINE_STATUS
      And I choose enum dropdown item IN_DEVELOPMENT on Creating Module Page dropdown fields
      And I click in the enum dropdown field OFFLINE_STATUS
      And I choose enum dropdown item IN_DEVELOPMENT on Creating Module Page dropdown fields
      And I enter in the enum field HOURS data '1' on Creating Module Page
      And I enter in the enum field DAYS data '1' on Creating Module Page
      And I delete the text from the field
      And I enter the price '150'
      And I click button Save
      And I enter the module name in the field Name on the Modules Page
      Then Module is displayed on the page AllModulesPage
      And I click the current module
      And I delete the text from the field NAME
      And I enter in the enum field NAME data 'Edited' on Creating Module Page
      And I click button Save
      And I click Module button
      And I enter the module name in the field Name on the Modules Page
      Then Module is displayed on the page AllModulesPage

  @ui
      Scenario: Successful creation of a module with only required fields and deleting it
        When I click button Create
        And I enter in the field NAME data 'Module' on Creating Module Page
        And I delete the text from the field
        And I enter the price '140'
        And I click button Save
        And I enter the module name in the field Name on the Modules Page
        And I click delete the module button
        Then message of absence data is visible true




