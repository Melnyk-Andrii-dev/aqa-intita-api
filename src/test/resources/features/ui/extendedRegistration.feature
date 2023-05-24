Feature: As an unregistered user
  I want to register to the system  with my credentials
  So that I can have access to site

  @ui
  Scenario: Successful extended registration with valid data
    Given Login page is opened in pop up
    When I click button Sign up
    And I click Extended link
    And I enter 'Lena' data in the NAME field on Registration Page
    And I enter 'Bondar' data in the LAST_NAME field on Registration Page
    And I enter 'LB' data in the NICKNAME field on Registration Page
    And I click on the DATA_OF_BIRTH field
    And click on the year
    And click on the arrow
    And I select the month of birthday
    And select the number of birthday
    And I click on the COUNTRY field
    And Select country option on Registration Page
    And I enter 'Pushkina 24' data in the ADDRESS field on Registration Page
    And I enter '0505555555' data in the PHONE field on Registration Page
    And I input random data in the EMAIL field on Registration Page
    And I enter '' data in the PASSWORD field on Registration Page
    And I enter '' data in the RE_ENTER_PASSWORD field on Registration Page
    And I enter the 'Test about myself' information in the ABOUT_MYSELF field on Registration Page
    And I input the 'testing' information in the INTERESTS field on Registration Page
    And I enter the 'none' information in the PREVIOUS_JOB field on Registration Page
    And I enter the 'IT specialist' information in the CURRENT_JOB field on Registration Page
    And I click in the EARLY_CAREER_FIELD field
    And I select Freelance option from  dropdown on Registration page
    And I input the 'TestSkype' information in the SKYPE field on Registration Page
    And I input the 'TestFacebook' information in the FACEBOOK field on Registration Page
    And I input the 'LINKEDIN' information in the LINKEDIN field on Registration Page
    And I input the 'TestTweeter' information in the TWITTER field on Registration Page
    And I click on the specialization field
    And I select the 'Manual QA' specialization in the dropdown on Registration Page
    And I click Offline checkbox in the educational form on Registration page
    And I click the EDUCATION_FORM in the evening checkbox on Registration page
    And I click SAVE button
    Then The Дякуємо за реєстрацію! message is displayed on confirmation

  @ui
  Scenario: Unsuccessful extended registration with invalid email
    Given Login page is opened in pop up
    When I click button Sign up
    And I click Extended link
    And I enter 'Lena' data in the NAME field on Registration Page
    And I enter 'Bondar' data in the LAST_NAME field on Registration Page
    And I enter 'LB' data in the NICKNAME field on Registration Page
    And I click on the DATA_OF_BIRTH field
    And click on the year
    And click on the arrow
    And I select the month of birthday
    And select the number of birthday
    And I click on the COUNTRY field
    And Select country option on Registration Page
    And I enter 'Pushkina 24' data in the ADDRESS field on Registration Page
    And I enter '0505555555' data in the PHONE field on Registration Page
    And I enter zco5agmail.com data in the EMAIL field on Registration Page
    And I enter '' data in the PASSWORD field on Registration Page
    And I enter '' data in the RE_ENTER_PASSWORD field on Registration Page
    And I enter the 'Test about myself' information in the ABOUT_MYSELF field on Registration Page
    And I input the 'testing' information in the INTERESTS field on Registration Page
    And I enter the 'none' information in the PREVIOUS_JOB field on Registration Page
    And I enter the 'IT specialist' information in the CURRENT_JOB field on Registration Page
    And I click in the EARLY_CAREER_FIELD field
    And I select Freelance option from  dropdown on Registration page
    And I input the 'TestSkype' information in the SKYPE field on Registration Page
    And I input the 'TestFacebook' information in the FACEBOOK field on Registration Page
    And I input the 'LINKEDIN' information in the LINKEDIN field on Registration Page
    And I input the 'TestTweeter' information in the TWITTER field on Registration Page
    And I click on the specialization field
    And I select the 'Manual QA' specialization in the dropdown on Registration Page
    And I click Offline checkbox in the educational form on Registration page
    And I click the EDUCATION_FORM in the evening checkbox on Registration page
    And I click SAVE button
    Then The 'Електронна пошта не являється правильною' message is displayed under the field

  @ui
  Scenario: Unsuccessful extended registration with different password
    Given Login page is opened in pop up
    When I click button Sign up
    And I click Extended link
    And I enter 'Lena' data in the NAME field on Registration Page
    And I enter 'Bondar' data in the LAST_NAME field on Registration Page
    And I enter 'LB' data in the NICKNAME field on Registration Page
    And I click on the DATA_OF_BIRTH field
    And click on the year
    And click on the arrow
    And I select the month of birthday
    And select the number of birthday
    And I click on the COUNTRY field
    And Select country option on Registration Page
    And I enter 'Pushkina 24' data in the ADDRESS field on Registration Page
    And I enter '0505555555' data in the PHONE field on Registration Page
    And I input random data in the EMAIL field on Registration Page
    And I enter '' data in the PASSWORD field on Registration Page
    And I enter '' data in the RE_ENTER_PASSWORD field on Registration Page
    And I enter the 'Test about myself' information in the ABOUT_MYSELF field on Registration Page
    And I input the 'testing' information in the INTERESTS field on Registration Page
    And I enter the 'none' information in the PREVIOUS_JOB field on Registration Page
    And I enter the 'IT specialist' information in the CURRENT_JOB field on Registration Page
    And I click in the EARLY_CAREER_FIELD field
    And I select Freelance option from  dropdown on Registration page
    And I input the 'TestSkype' information in the SKYPE field on Registration Page
    And I input the 'TestFacebook' information in the FACEBOOK field on Registration Page
    And I input the 'LINKEDIN' information in the LINKEDIN field on Registration Page
    And I input the 'TestTweeter' information in the TWITTER field on Registration Page
    And I click on the specialization field
    And I select the 'Manual QA' specialization in the dropdown on Registration Page
    And I click Offline checkbox in the educational form on Registration page
    And I click the EDUCATION_FORM in the evening checkbox on Registration page
    And I click SAVE button
    Then The 'Паролі не співпадають' message is displayed under the field