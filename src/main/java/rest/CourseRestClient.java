package rest;

import cache.TestCache;
import cache.TestCacheKey;
import io.restassured.builder.MultiPartSpecBuilder;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import rest.dto.*;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class CourseRestClient {

    private final String CRUD_COURSES_ENDPOINT = "/cabinet/content_manager/manageCourses";
    private final String SEARCH_COURSES_AS_CLIENT_ENDPOINT = "/services";
    private final String CRUD_MODULE_ENDPOINT = "/cabinet/content_manager/manageModules";
    private final String ADD_MODULE_ENDPOINT = "/cabinet/content_manager/modulesInCourse";
    private final String CREATE_LESSON_ENDPOINT = "/cabinet/content_manager/lessons";
    private final String CREATE_PART_ENDPOINT = "/cabinet/content_manager/parts";
    private final String ADD_TEXT_ENDPOINT = "/cabinet/content_manager/blocks";
    private final String ADD_ANSWER_ENDPOINT = "/cabinet/content_manager/quizAnswerCases";
    private final String ANSWER_TEST_ENDPOINT = "/exercise/sendAnswer";

    public GetAllCoursesDTO sendGetAllCoursesRequest(String xCsrfToken, Cookies cookiesAfterLogin) {
        Header tokenHeader = new Header("X-CSRF-TOKEN", xCsrfToken);
        GetCoursesQueryParamsDTO.Sorting sorting = GetCoursesQueryParamsDTO.Sorting.builder()
                .field("created_at")
                .type("desc").build();
        ArrayList<GetCoursesQueryParamsDTO.Sorting> sortingList = new ArrayList<>();
        sortingList.add(sorting);
        GetCoursesQueryParamsDTO getCoursesQueryParamsDTO = GetCoursesQueryParamsDTO.builder()
                .count(1000)
                .page(1)
                .sorting(sortingList)
                .build();
        return given(RequestSpecifications.basicSpec)
                .queryParam("queryParams", getCoursesQueryParamsDTO)
                .queryParam("role", "content_manager")
                .header(tokenHeader)
                .cookies(cookiesAfterLogin)
                .when().get(CRUD_COURSES_ENDPOINT)
                .then().statusCode(200)
                .and().extract().response().as(GetAllCoursesDTO.class);
    }

    public int countCourses(GetAllCoursesDTO getAllCoursesResponse) {
        return getAllCoursesResponse.getRows().size();
    }

    public boolean isCoursesSortedDescendingByCreationDate(GetAllCoursesDTO getAllCoursesResponse) {
        ArrayList<GetAllCoursesDTO.Row> courses = getAllCoursesResponse.getRows();
        List<Date> courseCreationDates = courses.stream()
                .map(GetAllCoursesDTO.Row::getCreated_at)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        List<Date> courseCreationDatesSorted = new ArrayList<>(courseCreationDates);
        courseCreationDatesSorted.sort(Comparator.reverseOrder());
        return courseCreationDates.equals(courseCreationDatesSorted);
    }

    public GetAllCoursesDTO sendGetAllCoursesFilteredRequest(String xCsrfToken, Cookies cookiesAfterLogin,
                                                             GetCoursesQueryParamsDTO.Filter filter) {
        Header tokenHeader = new Header("X-CSRF-TOKEN", xCsrfToken);
        GetCoursesQueryParamsDTO.Sorting sorting = GetCoursesQueryParamsDTO.Sorting.builder()
                .field("created_at")
                .type("desc").build();
        ArrayList<GetCoursesQueryParamsDTO.Sorting> sortingList = new ArrayList<>();
        sortingList.add(sorting);
        GetCoursesQueryParamsDTO getCoursesQueryParamsDTO = GetCoursesQueryParamsDTO.builder()
                .count(20)
                .page(1)
                .sorting(sortingList)
                .filter(filter)
                .build();
        return given(RequestSpecifications.basicSpec)
                .queryParam("queryParams", getCoursesQueryParamsDTO)
                .queryParam("role", "content_manager")
                .header(tokenHeader)
                .cookies(cookiesAfterLogin)
                .when().get(CRUD_COURSES_ENDPOINT)
                .then().statusCode(200)
                .and().extract().response().as(GetAllCoursesDTO.class);

    }

    public List<String> filterByTitleCaseInsensitive(GetAllCoursesDTO getAllFilteredCoursesResponse, String title) {
        ArrayList<GetAllCoursesDTO.Row> courses = getAllFilteredCoursesResponse.getRows();
        return courses.stream()
                .map(course -> course.getTitle())
                .filter(courseTitle -> StringUtils.containsIgnoreCase(courseTitle, title))
                .collect(Collectors.toList());
    }

    public void sendCreateCourseWithImageRequest(String xCsrfToken, Cookies cookiesAfterLogin, String title) {
        Header tokenHeader = new Header("X-CSRF-TOKEN", xCsrfToken);
        CreateCourseReqDTO.CreateCourseBody createCourseBody = CreateCourseReqDTO.CreateCourseBody.builder()
                .language("ua")
                .alias("alias_" + title)
                .level(1)
                .status_online("1")
                .title(title)
                .course_number("")
                .start("")
                .status_offline("1")
                .for_whom("")
                .what_you_learn("")
                .what_you_get("")
                .internship("")
                .course_img("")
                .build();

        given(RequestSpecifications.formDataSpec)
                .multiPart(new MultiPartSpecBuilder(createCourseBody)
                        .emptyFileName()
                        .controlName("course")
                        .mimeType("application/json").build())
                .multiPart(new MultiPartSpecBuilder(new File("src//main//java//assets//course_logo.png"))
                        .fileName("course_logo.png")
                        .controlName("picture")
                        .mimeType("image/png").build())
                .header(tokenHeader)
                .cookies(cookiesAfterLogin)
                .when().post(CRUD_COURSES_ENDPOINT)
                .then().statusCode(200);
    }

    public Integer getLatestCourseId(String xCsrfToken, Cookies cookiesAfterLogin) {
        GetAllCoursesDTO allCourses = sendGetAllCoursesRequest(xCsrfToken, cookiesAfterLogin);
        assert allCourses != null;
        return allCourses.getRows().get(0).getCourse_ID();
    }

    public void sendPublishCourseRequest(String xCsrfToken, Cookies cookiesAfterLogin, Integer courseId) {
        String publishCourseEndpoint = "/cabinet/content_manager/manageCourses/" + courseId + "/cancelled";
        Header tokenHeader = new Header("X-CSRF-TOKEN", xCsrfToken);
        given(RequestSpecifications.basicSpec)
                .header(tokenHeader)
                .cookies(cookiesAfterLogin)
                .delete(publishCourseEndpoint)
                .then().statusCode(200);
    }

    public SearchCoursesAsClientDTO sendSearchCourseAsClientRequest(String name) {
        return given(RequestSpecifications.basicSpec)
                .queryParam("search", name)
                .queryParam("sorting", "rating_desc")
                .queryParam("perPage", 9)
                .when().get(SEARCH_COURSES_AS_CLIENT_ENDPOINT)
                .then().statusCode(200)
                .and().extract().response().as(SearchCoursesAsClientDTO.class);
    }

    public String sendUpdateCourseRequest(String xCsrfToken, Cookies cookiesAfterLogin, Integer courseIdToUpdate) {
        String newTitle = "updated" + RandomStringUtils.randomNumeric(5, 5);
        String updateCourseEndponint = "/cabinet/content_manager/manageCourses/" + courseIdToUpdate + "/update";
        Header tokenHeader = new Header("X-CSRF-TOKEN", xCsrfToken);
        UpdateCourseReqDTO.Body updateCourseBody = new UpdateCourseReqDTO.Body();
        updateCourseBody.setCourse_ID(courseIdToUpdate);
        updateCourseBody.setCourse_img("");
        updateCourseBody.setTitle(newTitle);

        given(RequestSpecifications.formDataSpec)
                .multiPart("course", updateCourseBody)
                .header(tokenHeader)
                .cookies(cookiesAfterLogin)
                .log().all()
                .when().post(updateCourseEndponint)
                .then().statusCode(200);

        return newTitle;
    }

    public void sendCreateModuleRequest(String xCsrfToken, Cookies cookiesAfterLogin, String moduleTitle) {
        Header tokenHeader = new Header("X-CSRF-TOKEN", xCsrfToken);
        CreateModuleReqDTO.Body body = CreateModuleReqDTO.Body.builder()
                .language("ua")
                .alias("")
                .level(1)
                .status_online("1")
                .status_offline("1")
                .title(moduleTitle)
                .module_img("")
                .module_price(0)
                .hours_in_day(3)
                .days_in_week(3)
                .build();

        given(RequestSpecifications.formDataSpec)
                .multiPart("module", body)
                .header(tokenHeader)
                .cookies(cookiesAfterLogin)
                .when().post(CRUD_MODULE_ENDPOINT)
                .then().statusCode(200);
    }

    public void sendAddModuleToCourseRequest(String xCsrfToken, Cookies cookiesAfterLogin,
                                             Integer courseId, Integer moduleId) {
        Header tokenHeader = new Header("X-CSRF-TOKEN", xCsrfToken);
        String body = "{\"module\":{\"id_course\":\"" + courseId + "\",\"id_module\":" + moduleId + "}}";

        given(RequestSpecifications.basicSpec)
                .header(tokenHeader)
                .cookies(cookiesAfterLogin)
                .body(body)
                .when().post(ADD_MODULE_ENDPOINT)
                .then().statusCode(200);
    }

    public GetAllModulesDTO sendGetAllModulesRequest(String xCsrfToken, Cookies cookiesAfterLogin) {
        Header tokenHeader = new Header("X-CSRF-TOKEN", xCsrfToken);
        GetCoursesQueryParamsDTO.Sorting sorting = GetCoursesQueryParamsDTO.Sorting.builder()
                .field("created_at")
                .type("desc").build();
        ArrayList<GetCoursesQueryParamsDTO.Sorting> sortingList = new ArrayList<>();
        sortingList.add(sorting);
        GetCoursesQueryParamsDTO getCoursesQueryParamsDTO = GetCoursesQueryParamsDTO.builder()
                .count(20)
                .page(1)
                .sorting(sortingList)
                .build();

        return given(RequestSpecifications.basicSpec)
                .queryParam("queryParams", getCoursesQueryParamsDTO)
                .queryParam("role", "content_manager")
                .header(tokenHeader)
                .cookies(cookiesAfterLogin)
                .when().get(CRUD_MODULE_ENDPOINT)
                .then().statusCode(200)
                .and().extract().response().as(GetAllModulesDTO.class);
    }

    public Integer getLatestModuleId(String xCsrfToken, Cookies cookiesAfterLogin) {
        GetAllModulesDTO allModules = sendGetAllModulesRequest(xCsrfToken, cookiesAfterLogin);
        assert allModules != null;
        return allModules.getRows().get(0).getModule_ID();
    }

    public Integer getLatestLessonIdOfLatestModule(String xCsrfToken, Cookies cookiesAfterLogin) {
        GetAllModulesDTO allModules = sendGetAllModulesRequest(xCsrfToken, cookiesAfterLogin);
        assert allModules != null;
        return allModules.getRows().get(0).getLessons()
                .get(allModules.getRows().get(0).getLessons().size() - 1).getId();
    }

    public void sendDeleteCourseRequestNegative(String xCsrfToken, Cookies cookiesAfterLogin, Integer courseId) {
        String deleteCourseEndpoint = "/cabinet/content_manager/manageCourses/" + courseId;
        Header tokenHeader = new Header("X-CSRF-TOKEN", xCsrfToken);
        given(RequestSpecifications.basicSpec)
                .header(tokenHeader)
                .cookies(cookiesAfterLogin)
                .when().delete(deleteCourseEndpoint)
                .then().statusCode(500);
    }

    public void sendDeleteModuleConnectionRequest(String xCsrfToken, Cookies cookiesAfterLogin, Integer connectionId) {
        String deleteConnectionEndpoint = "/cabinet/content_manager/modulesInCourse/" + connectionId;
        Header tokenHeader = new Header("X-CSRF-TOKEN", xCsrfToken);
        given(RequestSpecifications.basicSpec)
                .header(tokenHeader)
                .cookies(cookiesAfterLogin)
                .when().delete(deleteConnectionEndpoint)
                .then().statusCode(200);
    }

    public void sendDeleteCourseRequestPositive(String xCsrfToken, Cookies cookiesAfterLogin, Integer courseId) {
        String deleteCourseEndpoint = "/cabinet/content_manager/manageCourses/" + courseId;
        Header tokenHeader = new Header("X-CSRF-TOKEN", xCsrfToken);
        given(RequestSpecifications.basicSpec)
                .header(tokenHeader)
                .cookies(cookiesAfterLogin)
                .when().delete(deleteCourseEndpoint)
                .then().statusCode(200);
    }

    public void sendCreateLessonRequest(String xCsrfToken, Cookies cookiesAfterLogin) {
        String lessonTitle = "lesson" + RandomStringUtils.randomNumeric(5, 5);

        String moduleId = Integer.toString(getLatestModuleId(xCsrfToken, cookiesAfterLogin));
        Header tokenHeader = new Header("X-CSRF-TOKEN", xCsrfToken);
        CreateLessonReqDTO.Body body = new CreateLessonReqDTO.Body(
                new CreateLessonReqDTO.Body.Lesson(lessonTitle, lessonTitle, moduleId, "1", "1"));
        given(RequestSpecifications.basicSpec)
                .header(tokenHeader)
                .cookies(cookiesAfterLogin)
                .body(body)
                .when().post(CREATE_LESSON_ENDPOINT)
                .then().statusCode(201);

        TestCache.putDataInCache(TestCacheKey.LESSON_ID,
                getLatestLessonIdOfLatestModule(xCsrfToken, cookiesAfterLogin));
    }

    public void sendCreatePartRequest(String xCsrfToken, Cookies cookiesAfterLogin, Integer lessonId) {
        String partTitle = "part" + RandomStringUtils.randomNumeric(5, 5);
        Header tokenHeader = new Header("X-CSRF-TOKEN", xCsrfToken);
        CreatePartReqDTO.Body body = new CreatePartReqDTO.Body(new CreatePartReqDTO.Body.Part(partTitle, lessonId));

        CreatePartResDTO response = given(RequestSpecifications.basicSpec)
                .header(tokenHeader)
                .cookies(cookiesAfterLogin)
                .body(body)
                .when().post(CREATE_PART_ENDPOINT)
                .then().statusCode(201)
                .and().extract().response().as(CreatePartResDTO.class);

        TestCache.putDataInCache(TestCacheKey.PART_ID,
                response.getPart().getId());
    }

    public void sendAddTextToPartRequest(String xCsrfToken, Cookies cookiesAfterLogin, Integer partId) {
        String text = "<p>" + "text" + RandomStringUtils.randomNumeric(5, 5) + "</p>\n";
        Header tokenHeader = new Header("X-CSRF-TOKEN", xCsrfToken);
        AddTextReqDTO.Body body = AddTextReqDTO.Body.builder()
                .block(AddTextReqDTO.Body.Block.builder()
                        .html(text)
                        .part_id(partId)
                        .isEditor(true)
                        .type(1)
                        .tempUid(1L)
                        .build())
                .build();

        given(RequestSpecifications.basicSpec)
                .header(tokenHeader)
                .cookies(cookiesAfterLogin)
                .body(body)
                .when().post(ADD_TEXT_ENDPOINT)
                .then().statusCode(201);

        TestCache.putDataInCache(TestCacheKey.PART_TEXT,
                text);
    }

    public void sendCreateExercisetRequest(String xCsrfToken, Cookies cookiesAfterLogin, Integer partId) {
        String createExerciseEndpoint = "/cabinet/content_manager/partExercises";
        String description = "<p>" + "exercise" + RandomStringUtils.randomNumeric(5, 5) + "</p>\n";
        Header tokenHeader = new Header("X-CSRF-TOKEN", xCsrfToken);
        CreateExerciseReqDTO.Body body = new CreateExerciseReqDTO.Body(new CreateExerciseReqDTO.Body.Exercise(
                description, true, partId
        ), "quiz");

        CreateExerciseResDTO response = given(RequestSpecifications.basicSpec)
                .header(tokenHeader)
                .cookies(cookiesAfterLogin)
                .body(body)
                .when().post(createExerciseEndpoint)
                .then().statusCode(201)
                .and().extract().response().as(CreateExerciseResDTO.class);

        TestCache.putDataInCache(TestCacheKey.EXERCISE_ID,
                response.getExercise().getId());
    }

    public void sendAddAnswerRequest(String xCsrfToken, Cookies cookiesAfterLogin,
                                     Integer exerciseId, boolean isRight) {
        String rightOrWrong;
        if (isRight) {
            rightOrWrong = "right";
        } else {
            rightOrWrong = "wrong";
        }
        String title = "<p>" + rightOrWrong + RandomStringUtils.randomNumeric(5, 5) + "</p>\n";
        Header tokenHeader = new Header("X-CSRF-TOKEN", xCsrfToken);
        AddAnswerReqDTO.Body body = new AddAnswerReqDTO.Body(
                new AddAnswerReqDTO.Body.AnswerCase(exerciseId, isRight, title, true));

        AddAnswerResDTO response = given(RequestSpecifications.basicSpec)
                .header(tokenHeader)
                .cookies(cookiesAfterLogin)
                .body(body)
                .when().post(ADD_ANSWER_ENDPOINT)
                .then().statusCode(201)
                .and().extract().response().as(AddAnswerResDTO.class);

        if (isRight) {
            TestCache.putDataInCache(TestCacheKey.RIGHT_ANSWER_ID,
                    response.getAnswerCase().getId());
        } else {
            TestCache.putDataInCache(TestCacheKey.WRONG_ANSWER_ID,
                    response.getAnswerCase().getId());
        }
    }

    public Boolean sendAnswerTestRequest(String xCsrfToken, Cookies cookiesAfterLogin, boolean isRight) {
        Header tokenHeader = new Header("X-CSRF-TOKEN", xCsrfToken);
        Integer rightOrWrong;
        if (isRight) {
            rightOrWrong = TestCache.getIntegerFromCache(TestCacheKey.RIGHT_ANSWER_ID);
        } else {
            rightOrWrong = TestCache.getIntegerFromCache(TestCacheKey.WRONG_ANSWER_ID);
        }
        String body = "{\"type\":\"quiz\",\"answers\":{\"" + TestCache.getIntegerFromCache(TestCacheKey.EXERCISE_ID)
                + "\":[{\"" + rightOrWrong + "\":true}]}}";

        return given(RequestSpecifications.basicSpec)
                .header(tokenHeader)
                .cookies(cookiesAfterLogin)
                .body(body)
                .when().post(ANSWER_TEST_ENDPOINT)
                .then().statusCode(200)
                .and().extract().response().jsonPath().getBoolean("mark");
    }
}
