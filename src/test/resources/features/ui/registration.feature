Feature: As an unregistered user
  I want to register to the system with my credentials
  So that I can have access to site

  @ui
  Scenario: Successful registration with valid email
    Given Login page is opened in pop up
    When I click button Sign up
    And I enter in the enum field EMAIL random email on Registration page
    And I enter in the enum field PASSWORD data '' on Registration page
    And I click Start button
    Then Message 'На вашу електронну адресу було відправлено листа з інструкціями щодо активації облікового запису. Після отримання листа по електронній пошті, потрібно відвідати URL, вказаний у листі, щоб активувати свій аккаунт. Якщо лист з активацією не прийшов, перевірте папку Спам.' is displayed

    @ui
  Scenario: Unsuccessful registration with invalid email
    Given Login page is opened in pop up
    When I click button Sign up
    And I enter in the enum field EMAIL data '' on Registration page
    And I enter in the enum field PASSWORD data '' on Registration page
    And I click Start button
    Then Message INCORRECT_EMAIL_MESSAGE is displayed under the field

  @ui
  Scenario: Unsuccessful registration with empty password field
    Given Login page is opened in pop up
    When I click button Sign up
    And I enter in the enum field EMAIL data '' on Registration page
    And I enter in the enum field PASSWORD data '' on Registration page
    And I click Start button
    Then Message INCORRECT_PASSWORD_MESSAGE is displayed under the field

  @ui
  Scenario: Successful redirection to registration page via FACEBOOK
    Given Login page is opened in pop up
    When I click button Sign up
    And I click enum FACEBOOK button
    Then it should be redirected to page "https://www.facebook.com/login.php?"

  @ui
  Scenario: Registration with the help of LINKEDIN
    Given Login page is opened in pop up
    When I click button Sign up
    When I click enum LINKEDIN button
    Then it should be redirected to page "https://www.linkedin.com/uas/login"
    And I enter in the enum field LINKEDIN_EMAIL data '' on LinkedIn Registration Page
    And I enter in the enum field LINKEDIN_PASSWORD data '' on LinkedIn Registration Page
    And I click LinkedIn Continue button
    Then LinkedIn captcha is displayed OR Avatar button is displayed

  @ui
  Scenario: Successful redirection to registration page via GOOGLE
    Given Login page is opened in pop up
    When I click button Sign up
    And I click enum GOOGLE button
    Then it should be redirected to page "https://accounts.google.com/o/oauth2/auth/"







