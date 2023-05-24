package steps;

import cache.TestCache;
import cache.TestCacheKey;
import enums.taskAttributes.TaskPriority;
import enums.taskAttributes.TaskType;
import enums.userAttrubutes.UserEmail;
import enums.userAttrubutes.UserPassword;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Cookies;
import org.assertj.core.api.Assertions;
import rest.BoardRestClient;
import rest.CourseRestClient;
import rest.LoginRestClient;
import rest.dto.GetTaskListItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ApiTaskStepdefs {
    LoginRestClient loginRestClient = new LoginRestClient();
    BoardRestClient boardRestClient = new BoardRestClient();

    private Cookies cookiesAfterLogin;

    @When("I send login request with email {string} and password {string}")
    public void iSendLoginRequestWithEmailAndPassword(String email, String password) {
        cookiesAfterLogin = loginRestClient.sendLoginRequest(email, password);
        TestCache.putDataInCache(TestCacheKey.LOGGEDIN_COOKIES, cookiesAfterLogin);
    }

    @When("[ENUM]I send login request with email {} and password {}")
    public void enumISendLoginRequestWithEmailAndPassword(UserEmail email, UserPassword password) {
       Cookies cookiesAfterLogin = loginRestClient.sendLoginRequest(email.toString(), password.toString());
        TestCache.putDataInCache(TestCacheKey.LOGGEDIN_COOKIES, cookiesAfterLogin);
    }

    @And("I send create task request with name {string} body {string} type {} priority {}" +
            " start date {string} end date {string}")
    public void iSendCreateTaskRequestWithName(String name, String body, TaskType type, TaskPriority priority,
                                               String startDate, String endDate) {
        final Integer taskId = boardRestClient.sendCreateTaskRequest(TestCache.getStringFromCache(TestCacheKey.TOKEN),
                cookiesAfterLogin, name, body, type, priority, startDate, endDate);
        TestCache.putDataInCache(TestCacheKey.TASK_ID, taskId);
    }

    @Then("The task {string} is created")
    public void theTaskIsCreated(String expectedTaskName) {
        String actualTaskName = boardRestClient.getTaskNameRequest(TestCache.getStringFromCache(TestCacheKey.TOKEN),
                cookiesAfterLogin, TestCache.getIntegerFromCache(TestCacheKey.TASK_ID));
        Assertions.assertThat(actualTaskName).as("Task name is different").isEqualTo(expectedTaskName);
    }

    @When("I send update the task name request to {string}")
    public void iSendUpdateTheTaskNameRequest(String newTaskName) {
        boardRestClient.sendUpdateTaskNameRequest(TestCache.getStringFromCache(TestCacheKey.TOKEN),
                cookiesAfterLogin, TestCache.getIntegerFromCache(TestCacheKey.TASK_ID), newTaskName);
    }

    @And("The task name was updated to {string}")
    public void theTaskNameWasUpdated(String newTaskName) {
        List<GetTaskListItem> allTasks = boardRestClient.sendGetTaskListRequest(TestCache.getStringFromCache
                (TestCacheKey.TOKEN), cookiesAfterLogin);
        GetTaskListItem foundTask = allTasks.stream().filter(task ->
                task.getId_task() == TestCache.getIntegerFromCache(TestCacheKey.TASK_ID)
        ).findFirst().orElseThrow(RuntimeException::new);
        Assertions.assertThat(foundTask.getTask().getName()).as("The task name was not updated").isEqualTo(newTaskName);
    }

    @When("I send delete task {string} request")
    public void iSendDeleteTaskRequest(String taskNameToDelete) {
        boardRestClient.sendDeleteTaskRequest(TestCache.getStringFromCache(TestCacheKey.TOKEN),
                cookiesAfterLogin, taskNameToDelete);
    }

    @Then("The task is deleted")
    public void theTaskIsDeleted() {
        List<GetTaskListItem> allTasks = boardRestClient.sendGetTaskListRequest(TestCache.getStringFromCache
                (TestCacheKey.TOKEN), cookiesAfterLogin);
        Optional<GetTaskListItem> notDeletedTask = allTasks.stream()
                .filter(task -> task.getId_task() == TestCache.getIntegerFromCache(TestCacheKey.TASK_ID)).findAny();
        Assertions.assertThat(notDeletedTask).isEmpty();
    }
}
