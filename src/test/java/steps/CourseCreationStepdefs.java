package steps;

import enums.elements.courseCreationPage.CourseCreationDropdown;
import enums.elements.courseCreationPage.CourseCreationInputField;
import enums.elements.courseCreationPage.CourseCreationTextarea;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.CourseCreationPage;

public class CourseCreationStepdefs {

    private static final CourseCreationPage courseCreationPage = new CourseCreationPage();

    @When("I enter in the field {} data {string} on the Course Creation page")
    public void iEnterInTheFieldCourseNameOnTheCourseCreatePage(CourseCreationInputField field, String data) {
        courseCreationPage.inputDataInCourseCreationInputField(field, data);
    }

    @And("I click the {} field on Course Creation page")
    public void iClickTheCourseCreateDropdown(CourseCreationDropdown field) {
        courseCreationPage.clickCourseCreationDropdown(field);
    }

    @And("I choose {string} in level dropdown on Course Creation page")
    @And("I choose {string} in offline status dropdown on Course Creation page")
    @And("I choose {string} in online status dropdown on Course Creation page")
    @And("I choose {string} in course language dropdown on Course Creation page")
    public void iChooseInDropdownMenu(String field) {
        courseCreationPage.clickCourseCreationDropdownButton(field);
    }

    @And("I enter in the {} the data {string} on Course Creation page")
    public void iEnterTheDataInTheTextarea(CourseCreationTextarea textarea, String data) {
        courseCreationPage.inputDataInCourseCreationTextarea(textarea, data);
    }

    @And("I click Autopublicate Alumni Checkbox on Course Creation page")
    public void iClickAutopublicateAlumniCheckbox() {
        courseCreationPage.clickAutopublicateAlumniCheckbox();
    }

    @And("I click Save button on Course Creation Page")
    public void iClickSaveButtonOnCourseCreationPage() {
        courseCreationPage.clickSaveButton();
    }

    @And("I click the field offline status on Course Creation page")
    public void iClickTheOfflineStatusField() {
        courseCreationPage.clickOfflineStatusDropdown();
    }

    @When("I enter in the Term of Internship field data {string} on the Course Creation page")
    public void iEnterInTheFieldTermOfInternshipDataOnTheCourseCreationPage(String data){
        courseCreationPage.inputTermOfInternship(data);
    }
}
