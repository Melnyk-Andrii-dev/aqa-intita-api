package steps;

import enums.elements.taskCreationPage.CalendarButton;
import enums.elements.taskCreationPage.ErrorMessage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import pages.TaskCreationPage;

public class TaskCreationPageStepdef {

    private static final TaskCreationPage taskCreationPage = new TaskCreationPage();

    @And("I enter {string} in the field Name on Task Creation Page")
    public void iEnterInTheFieldName(String name) {
        taskCreationPage.inputDataToTaskNameField(name);
    }

    @And("I click the calendar button {} on Task Creation Page")
    public void iClickTheCalendarButton(CalendarButton button) {
        taskCreationPage.clickBeginButton(button);
    }

    @And("I click the beginning date on the calendar on Task Creation Page")
    @And("I click the expiration date on the calendar on Task Creation Page")
    @And("I click the deadline date on the calendar on Task Creation Page")
    public void iClickTheBeginningDateOnTheCalendar() {
        taskCreationPage.clickCalendarDate();
    }

    @And("I fill in the Body field {string} on Task Creation Page")
    public void iFillInTheBodyField(String data) {
        taskCreationPage.inputDataToBodyField(data);
    }

    @And("I click the button Save a task on Task Creation Page")
    public void iClickTheButtonSaveATask() {
        taskCreationPage.clickSaveTaskButton();
    }

    @Then("The {} is displayed on Task Creation Field")
    public void theErrorMessageIsDisplayedOnTaskCreationField(ErrorMessage expectedErrorMessage) {
        String actualErrorMessage = taskCreationPage.noNameErrorMessageGetText();
        Assertions.assertThat(actualErrorMessage).isEqualTo(expectedErrorMessage.toString());
    }

    @And("Enter Completion time {string} on Task Creation Page")
    public void enterCompletionTimeOnTaskCreationPage(String time) {
        taskCreationPage.inputDataToCompletionTimeField(time);
    }

    @And("I click the Type button on Task Creation Page")
    public void iClickTheTypeButtonOnTaskCreationPage() {
        taskCreationPage.clickTypeDropdown();
    }

    @And("I click Bug type dropdown button on Task Creation Page")
    public void iClickBugTypeDropdownButtonOnTaskCreationPage() {
        taskCreationPage.clickBugTypeDropdown();
    }

    @And("I click Priority button on Task Creation Page")
    public void iClickPriorityButtonOnTaskCreationPage() {
        taskCreationPage.clickPriorityDropdown();
    }

    @And("I click Low Priority Dropdown button on Task Creation Page")
    public void iClickLowPriorityDropdownButtonOnTaskCreationPage() {
        taskCreationPage.clickPriorityDropdownButton();
    }
}
