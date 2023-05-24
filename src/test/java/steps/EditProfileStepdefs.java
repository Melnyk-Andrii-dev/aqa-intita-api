package steps;

import enums.TableFields;
import enums.elements.editProfilePage.ChangePasswordTextInput;
import enums.elements.editProfilePage.EducationShift;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.vavr.API;
import org.assertj.core.api.Assertions;
import pages.*;

import static io.vavr.API.$;
import static io.vavr.API.Case;

import java.util.Map;

public class EditProfileStepdefs {
    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage = new ProfilePage();
    EditProfilePage editProfilePage = new EditProfilePage();

    @And("I click My Profile button")
    public void iClickMyProfileButton() {
        loginPage.headerComponent().clickAvatarButton();
    }

    @When("I erase text input fields of Main section:")
    public void iEraseTextInputFieldsOfMainSection(DataTable dataTable) {
        String field;
        for (Map<String, String> map : dataTable.asMaps()) {
            field = map.get(TableFields.FIELD.toString());
            editProfilePage.eraseMainFormTextField(field);
        }
    }

    @And("I fill text input fields of Main section:")
    public void iFillTextInputFieldsOfMainSection(DataTable dataTable) {
        for (Map<String, String> pair : dataTable.asMaps()) {
            String field = pair.get(TableFields.FIELD.toString());
            String text = pair.get(TableFields.TEXT.toString());
            editProfilePage.eraseMainFormTextField(field);
            editProfilePage.inputMainFormTextFields(field, text);
        }
    }

    @And("I select first day of month as day of birth")
    public void iSelectFirstDayOfMonthAsDayOfBirth() {
        editProfilePage.selectFirstDayOfCurrentMonthAsDOB();
    }

    @And("I fill selector input fields of Main section:")
    public void iFillSelectorInputFieldsOfMainSection(DataTable dataTable) {
        for (Map<String, String> pair : dataTable.asMaps()) {
            String selector = pair.get(TableFields.FIELD.toString());
            String choice = pair.get(TableFields.TEXT.toString());
            editProfilePage.selectMainFormSelectors(selector, choice);
        }
    }

    @And("I click Edit Profile button")
    public void iClickEditProfileButton() {
        profilePage.clickEditProfile();
    }

    @And("I choose offline education form")
    public void iChooseOffloneEducationForm() {
        editProfilePage.clickOfflineEducationCheckbox();
    }

    @And("I choose {} education shift")
    public void iChooseEVENINGEducationShift(EducationShift shift) {
        editProfilePage.chooseEducationShift(shift);
    }

    @And("I click Submit button")
    public void iClickSubmitButton() {
        editProfilePage.clickSubmitButton();
    }

    @Then("I am redirected to My Profile page with updated data:")
    public void iAmRedirectedToMyProfilePageWithUpdatedData(DataTable dataTable) {
        for (Map<String, String> pair : dataTable.asMaps()) {
            String text = pair.get(TableFields.TEXT.toString());
            String field = pair.get(TableFields.FIELD.toString());

            API.Match(field).of(
                    Case($("firstName"), () -> Assertions.assertThat(profilePage.getFirstName())
                            .as("First Name is different").isEqualTo(text)),
                    Case($("secondName"), () -> Assertions.assertThat(profilePage.getLastName())
                            .as("Last Name is different").isEqualTo(text)),
                    Case($("nickname"), () -> Assertions.assertThat(profilePage.getNickName())
                            .as("Nickname is different").isEqualTo(text)),
                    Case($("address"), () -> Assertions.assertThat(profilePage.getAddress())
                            .as("Address is different").isEqualTo(text)),
                    Case($("phone"), () -> Assertions.assertThat(profilePage.getPhone())
                            .as("Phone is different").isEqualTo(text)),
                    Case($("aboutMy"), () -> Assertions.assertThat(profilePage.getAboutme())
                            .as("About Me is different").isEqualTo(text)),
                    Case($("interests"), () -> Assertions.assertThat(profilePage.getInterests())
                            .as("Interest is different").isEqualTo(text)),
                    Case($("education"), () -> Assertions.assertThat(profilePage.getEducation())
                            .as("Education is different").isEqualTo(text)),
                    Case($("aboutUsSource"), () -> Assertions.assertThat(profilePage.getInfosource())
                            .as("Source is different").isEqualTo(text)),
                    Case($("Skype"), () -> Assertions.assertThat(profilePage.getSkype())
                            .as("Skype is different").isEqualTo(text))
            );
        }
    }

    @And("I see {} education shift")
    public void iSeeEVENINGEducationShift(EducationShift shift) {
        Assertions.assertThat(profilePage.getEducform()).as("Education shift is different")
                .isEqualTo(profilePage.getEducform());
    }

    @When("I click Change Email link")
    public void iClickChangeEmailLink() throws InterruptedException {
        editProfilePage.clickChangeEmail();
    }

    @And("I fill Email field with email {string}")
    public void iFillEmailFieldWithEmail(String email) {
        editProfilePage.inputEmail(email);
    }

    @Then("Invalid email error {string} is displayed")
    public void invalidEmailErrorIsDisplayed(String emailValidationError) {
        Assertions.assertThat(editProfilePage.getEmailError()).as("Email validation error is different")
                .isEqualTo(emailValidationError);
    }

    @When("I click Submit Email button")
    public void iClickSubmitEmailButton() {
        editProfilePage.clickSubmitEmail();
    }

    @Then("Change Email popup is displayed")
    public void changeEmailPopupIsDisplayed() {
        Assertions.assertThat(editProfilePage.isChangeEmailPopupOpened()).as("Change Email popup is not opened")
                .isEqualTo(true);
    }

    @When("I click Change Password link")
    public void iClickChangePasswordLink() throws InterruptedException {
        editProfilePage.clickChangePassword();
    }

    @And("I fill {} field with data {string}")
    public void iFillCurrentPaswordFieldWithData(ChangePasswordTextInput field, String password) {
        editProfilePage.inputCurrentPassword(field, password);
    }

    @And("I click Submit Password button")
    public void iClickSubmitPasswordButton() {
        editProfilePage.clickSubmitPassword();
    }

    @Then("Current password error {string} is displayed")
    public void CurrentPasswordErrorIsDisplayed(String currentPasswordValidationError) {
        Assertions.assertThat(editProfilePage.getCurrentPasswordError())
                .as("Current password validation error is different")
                .isEqualTo(currentPasswordValidationError);
    }

    @Then("New password error {string} is displayed")
    public void newPasswordErrorIsDisplayed(String newPasswordValidationError) {
        Assertions.assertThat(editProfilePage.getNewPasswordError())
                .as("New password validation error is different")
                .isEqualTo(newPasswordValidationError);
    }

    @And("Confirm password error {string} is displayed")
    public void confirmPasswordErrorIsDisplayed(String confirmPasswordValidationError) {
        Assertions.assertThat(editProfilePage.getConfirmPasswordError())
                .as("Confirm password validation error is different")
                .isEqualTo(confirmPasswordValidationError);
    }

    @Then("Change Password popup is displayed")
    public void changePasswordPopupIsDisplayed() {
        Assertions.assertThat(editProfilePage.isChangePasswordPopupOpened())
                .as("Change Password popup is not opened")
                .isEqualTo(true);
    }

    @And("I reload current page")
    public void iReloadCurrentPage() {
        loginPage.reloadPage();
    }
}
