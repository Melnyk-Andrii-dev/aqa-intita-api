package pages;


import enums.elements.registrationPage.IncorrectInputFieldMessage;
import enums.elements.registrationPage.RegistrationCredentials;
import enums.elements.registrationPage.SocialMediaRegistration;
import org.apache.commons.lang3.RandomStringUtils;

public class RegistrationPage extends BasePage {

    private static final String EXTENDED_LINK = "//a[text()='Extended' or text()='Розширена']";
    private static final String REGISTRATION_FIELD = "//div[@id='signUpModal']//input[@type='%s']";
    private static final String START_BUTTON = "//button[text()='ПОЧАТИ ']";
    private static final String CONFIRM_EMAIL_MESSAGE = "//div[contains(text(), 'На вашу')]";
    private static final String INCORRECT_INPUT_FIELD_MESSAGE = "//div[text()='%s']";
    private static final String SOCIAL_MEDIA_REGISTRATION = "//div[@class='modal-subtitle']//following-sibling::div[@class='socials-auth']//child::a[@href='/login/%s']";


    public void clickExtendedLink(){
        findElementByXPath(EXTENDED_LINK).click();
    }

    public void inputDataToRegistrationField(RegistrationCredentials field, String data) {
        findElementByXPath(String.format(REGISTRATION_FIELD, field.toString())).sendKeys(data);
    }

    public void inputRandomEmailToRegistrationField(RegistrationCredentials field){
        findElementByXPath(String.format(REGISTRATION_FIELD, field.toString()))
                .sendKeys(String.format("%s@gmail.com", RandomStringUtils.randomAlphanumeric(6)));
    }

    public void clickStartButton(){
        findElementByXPath(START_BUTTON).click();
    }
    public String getConfirmEmailMessage(){
        return findElementByXPath(CONFIRM_EMAIL_MESSAGE).getText();
    }

    public Boolean getWarningInvalidEmailMessage(IncorrectInputFieldMessage message) {
        return isElementPresent(String.format(INCORRECT_INPUT_FIELD_MESSAGE, message.toString()));
    }

    public void clickSocialMediaRegistration(SocialMediaRegistration button){
        findElementByXPath(String.format(SOCIAL_MEDIA_REGISTRATION, button.toString())).click();
    }



}