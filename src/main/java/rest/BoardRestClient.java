package rest;

import cache.TestCache;
import cache.TestCacheKey;
import enums.taskAttributes.TaskPriority;
import enums.taskAttributes.TaskType;
import enums.userAttrubutes.UserEmail;
import enums.userAttrubutes.UserId;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.response.Response;
import rest.dto.*;
import rest.util.Attribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class BoardRestClient {

    public int sendCreateTaskRequest(String xCsrfToken, Cookies cookiesAfterLogin,
                                     String name, String body, TaskType taskType, TaskPriority taskPriority,
                                     String startDate, String endDate) {
        String createTaskEndpoint = "/cabinet/kanban/task/store";
        Header tokenHeader = new Header("X-CSRF-TOKEN", xCsrfToken);
        CreateTaskReqBodyDTO.CreateTaskBody.Collaborator collaborator = CreateTaskReqBodyDTO.CreateTaskBody.Collaborator
                .builder().id(UserId.ADMIN.toInt()).email(UserEmail.ADMIN.toString()).build();
        ArrayList<CreateTaskReqBodyDTO.CreateTaskBody.Collaborator> collaborators = new ArrayList<>();
        collaborators.add(collaborator);
        CreateTaskReqBodyDTO.CreateTaskBody.Watcher watcher = CreateTaskReqBodyDTO.CreateTaskBody.Watcher
                .builder().id(UserId.ADMIN.toInt()).build();
        ArrayList<CreateTaskReqBodyDTO.CreateTaskBody.Watcher> watchers = new ArrayList<>();
        watchers.add(watcher);

        CreateTaskReqBodyDTO.CreateTaskBody createTaskBody = CreateTaskReqBodyDTO.CreateTaskBody.builder()
                .tempUid(Attribute.getTaskTempUid())
                .task(CreateTaskReqBodyDTO.CreateTaskBody.Task.builder()
                        .name(name).body(body).type(taskType.toInt()).priority(taskPriority.toInt())
                        .startTask(startDate).endTask(endDate).build())
                .collaborator(collaborators)
                .creator(CreateTaskReqBodyDTO.CreateTaskBody.Creator.builder().id(UserId.ADMIN.toInt()).build())
                .assignee(CreateTaskReqBodyDTO.CreateTaskBody.Assignee.builder().id(UserId.ADMIN.toInt()).build())
                .watcher(watchers)
                .build();

        Response response = given(RequestSpecifications.basicSpec)
                .header(tokenHeader)
                .cookies(cookiesAfterLogin)
                .body(createTaskBody)
                .when().post(createTaskEndpoint)
                .then().statusCode(201)
                .and().extract().response();

        CreateTaskResDTO createTaskResDTO = response.as(CreateTaskResDTO.class);
        return createTaskResDTO.getTask().getId();
    }

    public String getTaskNameRequest(String xCsrfToken, Cookies cookiesAfterLogin, int taskId) {
        String getTaskEndpoint = "/cabinet/kanban/task/show/" + taskId;
        Header tokenHeader = new Header("X-CSRF-TOKEN", xCsrfToken);

        Response response = given(RequestSpecifications.basicSpec)
                .header(tokenHeader)
                .cookies(cookiesAfterLogin)
                .when().get(getTaskEndpoint)
                .then().statusCode(200)
                .and().extract().response();

        GetTaskResDTO getTaskResDTO = response.as(GetTaskResDTO.class);
        TestCache.putDataInCache(TestCacheKey.CREATED_TASK_DTO, getTaskResDTO);
        return getTaskResDTO.getTask().getName();
    }

    public void sendUpdateTaskNameRequest(String xCsrfToken, Cookies cookiesAfterLogin,
                                          Integer oldTaskId, String newTaskName) {
        String createTaskEndpoint = "/cabinet/kanban/task/store";
        Header tokenHeader = new Header("X-CSRF-TOKEN", xCsrfToken);
        CreateTaskReqBodyDTO.CreateTaskBody.Collaborator collaborator = CreateTaskReqBodyDTO.CreateTaskBody.Collaborator
                .builder().id(UserId.ADMIN.toInt()).email(UserEmail.ADMIN.toString()).build();
        ArrayList<CreateTaskReqBodyDTO.CreateTaskBody.Collaborator> collaborators = new ArrayList<>();
        collaborators.add(collaborator);
        CreateTaskReqBodyDTO.CreateTaskBody.Watcher watcher = CreateTaskReqBodyDTO.CreateTaskBody.Watcher
                .builder().id(UserId.ADMIN.toInt()).build();
        ArrayList<CreateTaskReqBodyDTO.CreateTaskBody.Watcher> watchers = new ArrayList<>();
        watchers.add(watcher);

        CreateTaskReqBodyDTO.CreateTaskBody createTaskBody = CreateTaskReqBodyDTO.CreateTaskBody.builder()
                .task(CreateTaskReqBodyDTO.CreateTaskBody.Task.builder()
                        .id(oldTaskId).name(newTaskName)
                        .body(TestCache.getCreatedTaskFromCache
                                (TestCacheKey.CREATED_TASK_DTO).getTask().getBody())
                        .priority(TestCache.getCreatedTaskFromCache(TestCacheKey.CREATED_TASK_DTO).getTask()
                                .getPriority())
                        .type(TestCache.getCreatedTaskFromCache(TestCacheKey.CREATED_TASK_DTO).getTask()
                                .getType())
                        .startTask(TestCache.getCreatedTaskFromCache(TestCacheKey.CREATED_TASK_DTO).getTask()
                                .getStartTask()).build())
                .collaborator(collaborators)
                .creator(CreateTaskReqBodyDTO.CreateTaskBody.Creator.builder().id(UserId.ADMIN.toInt()).build())
                .assignee(CreateTaskReqBodyDTO.CreateTaskBody.Assignee.builder().id(UserId.ADMIN.toInt()).build())
                .watcher(watchers)
                .build();

        given(RequestSpecifications.basicSpec)
                .header(tokenHeader)
                .cookies(cookiesAfterLogin)
                .body(createTaskBody)
                .when().post(createTaskEndpoint)
                .then().statusCode(201)
                .and().extract().response();
    }

    public List<GetTaskListItem> sendGetTaskListRequest(String xCsrfToken, Cookies cookiesAfterLogin){
        String getTaskListEndpoint = "/cabinet/kanban/task/index/assignee";
        Header tokenHeader = new Header("X-CSRF-TOKEN", xCsrfToken);

        Response response = given(RequestSpecifications.basicSpec)
                .header(tokenHeader)
                .cookies(cookiesAfterLogin)
                .when().get(getTaskListEndpoint)
                .then().statusCode(200)
                .and().extract().response();

        return Arrays.asList(response.as(GetTaskListItem[].class));
    }

    public void sendDeleteTaskRequest(String xCsrfToken, Cookies cookiesAfterLogin, String taskNameToDelete) {
        String deleteTaskEndpoint = "/cabinet/kanban/task/destroy";
        Header tokenHeader = new Header("X-CSRF-TOKEN", xCsrfToken);
        List<GetTaskListItem> allTasks = sendGetTaskListRequest(xCsrfToken, cookiesAfterLogin);
        GetTaskListItem taskToDelete = allTasks.stream()
                .filter(taskItem -> taskItem.getTask().getName()
                        .equals(taskNameToDelete)).findFirst()
                .orElseThrow(() -> new RuntimeException("No task with such a name"));

        DeleteTaskBodyDTO.DeleteTaskBody deleteTaskBody = DeleteTaskBodyDTO.DeleteTaskBody.builder()
                .id(taskToDelete.getId_task()).build();

        given(RequestSpecifications.basicSpec)
                .header(tokenHeader)
                .cookies(cookiesAfterLogin)
                .body(deleteTaskBody)
                .log().all()
                .when().post(deleteTaskEndpoint)
                .then().statusCode(200)
                .and().extract().response();
    }
}
