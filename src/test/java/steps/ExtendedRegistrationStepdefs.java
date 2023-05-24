package steps;

import enums.elements.registrationPage.ExtendedRegistration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import pages.ConfirmationPage;
import pages.ExtendedRegistrationPage;

public class ExtendedRegistrationStepdefs {

    private static final ExtendedRegistrationPage extendedRegistrationPage = new ExtendedRegistrationPage();

    private static final ConfirmationPage confirmationPage = new ConfirmationPage();

    @And("I enter {} data in the {} field on Registration Page")
    public void iEnterDataInTheFieldOnRegistrationPage(String data, ExtendedRegistration field) {
        extendedRegistrationPage.inputDataToExtendedRegistrationField(data, field);
    }

    @And("I enter the {} information in the {} field on Registration Page")
    public void iEnterTheInformationInTheFieldOnRegistrationPage(String text, ExtendedRegistration field) {
        extendedRegistrationPage.inputYourInformationInTheField(text, field);
    }

    @And("I input the {string} information in the {} field on Registration Page")
    public void iInputTheAdditionalInformationInTheFieldOnRegistrationPage(String information, ExtendedRegistration field) {
        extendedRegistrationPage.inputAdditionalInformationInTheField(information, field);
    }

    @And("I click on the DATA_OF_BIRTH field")
    public void iClickOnTheDATA_OF_BIRTHField() {
        extendedRegistrationPage.clickBirthdayField();
    }

    @And("click on the year")
    public void clickOnTheYear() {
        extendedRegistrationPage.clickOnTheYear();
    }

    @And("click on the arrow")
    public void clickOnTheArrow() {
        extendedRegistrationPage.clickOnTheArrowLink();
    }

    @And("select the number of birthday")
    public void selectTheNumberOfBirthday() {
        extendedRegistrationPage.selectDateOfBirth();
    }

    @And("I select the month of birthday")
    public void iSelectTheMonthOfBirthday() {
        extendedRegistrationPage.clickOnTheMonthOfBirthday();
    }


    @And("I click on the specialization field")
    public void iClickOnTheSpecializationField() {

        extendedRegistrationPage.iClickInTheSpecializationField();
    }

    @And("I select the {string} specialization in the dropdown on Registration Page")
    public void iSelectTheManualQASpecializationInTheDropdownOnRegistrationPage(String specialization) {
        extendedRegistrationPage.iSelectMySpecialization();
    }

    @And("I click in the EARLY_CAREER_FIELD field")
    public void iClickInTheEarlyEARLY_CAREER_FIELDField() {
        extendedRegistrationPage.clickEarlyCareerField();
    }

    @And("I select Freelance option from  dropdown on Registration page")
    public void iSelectFreelanceOptionFromDropdownOnRegistrationPage() {
        extendedRegistrationPage.selectCareerStart();
    }

    @And("I click Offline checkbox in the educational form on Registration page")
    public void iClickOfflineCheckboxInTheEducationalFormOnRegistrationPage() {
        extendedRegistrationPage.clickEducationFormCheckbox();
    }

    @And("I click the EDUCATION_FORM in the evening checkbox on Registration page")
    public void iClickTheEDUCATION_FORMInTheEveningCheckboxOnRegistrationPage() {
        extendedRegistrationPage.clickEducationFormCheckbox();

    }
    @And("I click SAVE button")
    public void iClickSAVEButton() {
        extendedRegistrationPage.clickSaveButton();
    }

    @And("I click on the COUNTRY field")
    public void iClickOnTheCOUNTRYField() {
        extendedRegistrationPage.clickCountryField();
    }

    @And("Select country option on Registration Page")
    public void selectCountryOptionOnRegistrationPage() {
        extendedRegistrationPage.selectCountry();
    }

    @Then("The {} message is displayed on confirmation")
    public void theMessageIsDisplayedOnConfirmation(String expectedMessage) {
        String actualMessage = confirmationPage.getConfirmMessage();
        String actualTrimmedMessage = actualMessage.trim();
        Assertions.assertThat(actualTrimmedMessage).as(String.format("Expected : %s, Actual : %s", expectedMessage,
                actualTrimmedMessage)).isEqualTo(expectedMessage);

    }

    @Then("The {string} message is displayed under the field")
    public void theMessageIsDisplayedUnderTheEmailField(String message) {
        String actualMessage = extendedRegistrationPage.getErrorMessage();
        Assertions.assertThat(actualMessage).as(String.format("Expected : %s, Actual : %s", message, actualMessage)).isEqualTo(message);
    }

    @And("I enter random data in the field {} random data on Registration page")
    @And("I input random data in the {} field on Registration Page")
    public void iInputRandomDataInTheEMAILFieldOnRegistrationPage(ExtendedRegistration field) {
        extendedRegistrationPage.inputEmailToEmailField(field);

    }
}
