package steps;

import io.cucumber.java.en.Then;
import pages.TaskPage;

public class TaskPageStepdefs {

    public static final TaskPage taskPage = new TaskPage();

    @Then("The task {string} is present on the Task Page")
    public void theTaskIsPresentOnTheTaskPage(String taskName){
        taskPage.isTaskCardPresent(taskName);
    }
}
