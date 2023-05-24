Feature: As a logged in user
  I want the ability to update my profile
  So that I can keep my profile up-to-date

  Background: Logged in user has opened Edit Profile Page
    Given Login page is opened in pop up
    When I enter email '' on Login page
    And I enter password '' on Login page
    And I click Sign in button on Login page
    Then My Start page is displayed true
    When I click My Profile button
    And I click Edit Profile button

  @ui
  Scenario: I can update profile (EXCEPT credentials) with a valid data
    And I select first day of month as day of birth
    And I fill text input fields of Main section:
      | field       | text          |
      | firstName   | Testfirstname |
      | secondName  | secondName    |
      | nickname    | Testnickname  |
      | address     | Соборна 1а    |
      | phone       | 0123456789    |
      | aboutMy     | Test About Me |
      | interests   | testing       |
      | education   | Educated      |
      | prev_job    | none          |
      | current_job | IT specialst  |
      | aboutUs     | Radio         |
      | skype       | TestSkype     |
      | facebook    | TestFacebook  |
      | linkedin    | TestLinkedIn  |
      | twitter     | TestTwitter   |
    And I fill selector input fields of Main section:
      | field           | text          |
      | address_country | Україна       |
      | specializations | Програмування |
      | careers         | Фріланс       |
    And I choose EVENING education shift
    And I click Submit button
    Then I am redirected to My Profile page with updated data:
      | field         | text              |
      | phone         | +38(012)345-67-89 |
      | aboutMy       | Test About Me     |
      | interests     | testing           |
      | education     | Educated          |
      | aboutUsSource | Radio             |
      | Skype         | TestSkype         |
    And I see EVENING education shift

  @ui
  Scenario: I can not update email with invalid data
    When I click Change Email link
    And I fill Email field with email 'invalid@email@com'
    Then Invalid email error 'Електронна пошта не являється правильною' is displayed
    When I click Submit Email button
    Then Change Email popup is displayed

  @ui
  Scenario: I can not update password using invalid current password
    When I click Change Password link
    And I fill CURRENT_PASSWORD field with data ''
    And I fill NEW_PASSWORD field with data ''
    And I fill CONFIRM_PASSWORD field with data ''
    And I click Submit Password button
    Then Current password error 'Паролі не співпадають' is displayed

  @ui
  Scenario: I can not update password using different password for confirmation
    When I click Change Password link
    And I fill CURRENT_PASSWORD field with data ''
    And I fill NEW_PASSWORD field with data ''
    And I fill CONFIRM_PASSWORD field with data ''
    Then New password error 'Паролі не співпадають' is displayed
    And Confirm password error 'Паролі не співпадають' is displayed
    When I click Submit Password button
    Then Change Password popup is displayed

  @ui
  Scenario: I can not update password with invalid data
    When I click Change Password link
    And I fill CURRENT_PASSWORD field with data ''
    And I fill NEW_PASSWORD field with data ''
    And I fill CONFIRM_PASSWORD field with data ''
    Then New password error 'Мінімальна довжина рядка - 8 символ(и)ів' is displayed
    And Confirm password error 'Мінімальна довжина рядка - 8 символ(и)ів' is displayed
    When I click Submit Password button
    Then Change Password popup is displayed