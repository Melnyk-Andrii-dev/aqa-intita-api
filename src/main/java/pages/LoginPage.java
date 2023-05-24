package pages;

public class LoginPage extends BasePage {

    private static final String SIGN_IN_BUTTON = "//button[text()='Sign in ' or text()='Увійти ']";
    private static final String SIGN_UP = "//div[@class='modal-link']";
    private static final String EMAIL_INPUT_FIELD = "//div[@id='authModal']//input[@type='email']";
    private static final String PASSWORD_INPUT_FIELD = "//div[@id='authModal']//input[@type='password']";
    private static final String VERIFY_MESSAGE = "//div[@class='infoblock']";
    private static final String INCORRECT_EMAIL_OR_PASSWORD_DISPLAYED_MESSAGE = "//div[text()='Невірна електронна пошта або пароль']";


    public void clickSignInButton() {
        findElementByXPath(SIGN_IN_BUTTON).click();
    }

    public void clickSignUpButton() {
        findElementByXPath(SIGN_UP).click();
    }

    public void inputEmailToEmailField(String email) {
        findElementByXPath(EMAIL_INPUT_FIELD).sendKeys(email);
    }

    public void inputPasswordToPasswordField(String password) {
        findElementByXPath(PASSWORD_INPUT_FIELD).sendKeys(password);
    }

    public Boolean isYourVerifyMessageDisplayed() {
        return findElementByXPath(VERIFY_MESSAGE).isDisplayed();
    }

    public String getIncorrectEmailOrPasswordDisplayedMessage(){
        return findElementByXPath(INCORRECT_EMAIL_OR_PASSWORD_DISPLAYED_MESSAGE).getText();

    }
}


