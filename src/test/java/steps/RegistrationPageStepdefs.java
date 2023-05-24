package steps;


import enums.elements.registrationPage.FacebookRegistrationInputFields;
import enums.elements.registrationPage.LinkedinRegistrationInputFields;
import enums.elements.registrationPage.IncorrectInputFieldMessage;
import enums.elements.registrationPage.RegistrationCredentials;
import enums.elements.registrationPage.SocialMediaRegistration;
import enums.elements.socialMediaRegistrationPage.GoogleRegistrationInputFields;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import pages.HeaderComponent;
import pages.RegistrationPage;
import pages.SocialMediaRegistrationPage;

public class RegistrationPageStepdefs {

    private static final RegistrationPage registrationPage = new RegistrationPage();
    private static final SocialMediaRegistrationPage socialMediaRegistrationPage = new SocialMediaRegistrationPage();
    private static final HeaderComponent headerComponent = new HeaderComponent();

    @And("I click Extended link")
    public void iClickExtendedLink() {registrationPage.clickExtendedLink();
    }

    @And("I enter in the enum field {} data {string} on Registration page")
    public void iEnterInTheFieldDataOnRegistrationPage(RegistrationCredentials field, String data) {
        registrationPage.inputDataToRegistrationField(field, data);
    }

    @And("I click Start button")
    public void iClickStartButton() {
        registrationPage.clickStartButton();
    }

    @Then("Message {string} is displayed")
    public void messageToConfirmEmailIsDisplayed(String expectedMessage) {
        String actualMessage = registrationPage.getConfirmEmailMessage();
        String actualTrimmedMessage = actualMessage.trim();
        Assertions.assertThat(actualTrimmedMessage).as(String.format("Expected : %s, Actual : %s", expectedMessage,
                actualTrimmedMessage)).isEqualTo(expectedMessage);
    }

    @Then("Message {} is displayed under the field")
    public void messageIncorrectRegistrationDataIsDisplayedUnderTheField(IncorrectInputFieldMessage message) {
        registrationPage.getWarningInvalidEmailMessage(message);
    }

    @And("I click enum {} button")
    public void iClickEnumLINKEDINButton(SocialMediaRegistration socialMedia) {
        registrationPage.clickSocialMediaRegistration(socialMedia);
    }


    @Then("it should be redirected to page {string}")
    public void itShouldBeRedirectedToGoogleSite(String expectedURL) {
        String actualURL = socialMediaRegistrationPage.getPageURL();
        Assertions.assertThat(actualURL).as("").contains(expectedURL);
    }

    @And("I enter in the enum field {} data {string} on Google Registration Page")
    public void iEnterInTheEnumFieldDataOnGoogleRegistrationPage(
            GoogleRegistrationInputFields field, String data) {
        socialMediaRegistrationPage.inputDataToRegistrationViaGoogle(field, data);
    }

    @And("I click Google Continue button")
    public void iClickGoogleContinueButton() {
        socialMediaRegistrationPage.clickContinueGoogleButton();
    }

    @And("I click LinkedIn Continue button")
    public void iClickLinkedInContinueButton() {
        socialMediaRegistrationPage.clickContinueLinkedinButton();
    }

    @And("I enter in the enum field {} data {string} on LinkedIn Registration Page")
    public void iEnterInTheEnumFieldLINKEDIN_PASSWORDDataOnLinkedInRegistrationPage(
            LinkedinRegistrationInputFields field, String data) {
        socialMediaRegistrationPage.inputDataToRegistrationViaLinkedIn(field, data);
    }

    @And("I click Confirm button")
    public void iClickConfirmButton() {
        socialMediaRegistrationPage.confirmationOfUserLinkedinButton();
    }

    @Then("Avatar button is displayed")
    public void avatarButtonIsDisplayed() {
        headerComponent.isAvatarButtonDisplayed();
    }

    @And("I enter in the enum field {} data {string} on Facebook Registration Page")
    public void iEnterInTheEnumFieldFacebookRegistrationPage(FacebookRegistrationInputFields field, String data) {
        socialMediaRegistrationPage.inputDataToRegistrationViaFacebook(field, data);
    }

    @And("I click Facebook Login button")
    public void iClickFacebookLoginButton() {
        socialMediaRegistrationPage.clickLoginFacebookButton();
    }

    @And("I click button Continue As")
    public void iClickButtonContinueAs() {
        socialMediaRegistrationPage.clickLoginFacebookContinueAsButton();
    }

    @And("I click LinkedIn Submit button")
    public void iClickLinkedInSubmitButton() {
        socialMediaRegistrationPage.clickLinkedInConfirmButton();
    }

    @And("I enter in the enum field {} random email on Registration page")
    public void iEnterInTheEnumFieldEMAILRandomEmailOnRegistrationPage(RegistrationCredentials field) {
        registrationPage.inputRandomEmailToRegistrationField(field);
    }

    @Then("LinkedIn captcha is displayed")
    public void linkedinCaptchaIsDisplayed() {
        Assertions.assertThat(socialMediaRegistrationPage.isLinkedinCaptchaDisplayed())
                .as("LinkedIn captcha is not displayed").isTrue();
    }

    @Then("LinkedIn captcha is displayed OR Avatar button is displayed")
    public void linkedinCaptchaIsDisplayedORAvatarButtonIsDisplayed() {
        boolean isCaptchaDisplayed = socialMediaRegistrationPage.isLinkedinCaptchaDisplayed();
        boolean isAvatarDisplayed = headerComponent.isAvatarButtonDisplayed();
        Assertions.assertThat(isCaptchaDisplayed || isAvatarDisplayed)
                .as("Is LinkedIn captcha displayed: " + isCaptchaDisplayed +
                        "\nIs avatar button displayed: " + isAvatarDisplayed).isTrue();
    }
}
