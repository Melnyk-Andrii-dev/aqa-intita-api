package steps;

import cache.TestCache;
import cache.TestCacheKey;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.api.Assertions;
import rest.CourseRestClient;
import rest.dto.GetAllCoursesDTO;
import rest.dto.SearchCoursesAsClientDTO;
import rest.dto.GetCoursesQueryParamsDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ApiCourseStepdefs {
    CourseRestClient courseRestClient = new CourseRestClient();

    GetAllCoursesDTO getAllCoursesResponse;
    GetAllCoursesDTO getAllCoursesFilteredResponse;
    SearchCoursesAsClientDTO searchCoursesAsClientDTO;
    String courseTitle;
    Integer courseIdToUpdate;
    String updatedCourseTitle;
    String moduleTitle;
    Integer deletedCourseId;
    Boolean isAnswerRight;

    @And("I send default Get all courses request")
    public void iSendDefaultGetAllCoursesRequest() {
        getAllCoursesResponse = courseRestClient
                .sendGetAllCoursesRequest(TestCache.getStringFromCache(TestCacheKey.TOKEN),
                        TestCache.getCookiesFromCache(TestCacheKey.LOGGEDIN_COOKIES));
    }

    @Then("Response contains not more then {int} courses")
    public void responseContainsNotMoreThenCourses(int numberOfCourses) {
        Assertions.assertThat(courseRestClient.countCourses(getAllCoursesResponse))
                .as("Number of courses exceeds " + numberOfCourses).isLessThanOrEqualTo(numberOfCourses);
    }

    @And("Courses in response are sorted descending by creation date")
    public void coursesInResponseAreSortedDescendingByCreationDate() {
        Assertions.assertThat(courseRestClient.isCoursesSortedDescendingByCreationDate(getAllCoursesResponse))
                .as("Courses are not sorted descending by creation date")
                .isTrue();
    }

    @When("I send Get all courses filtered by title {string} request")
    public void iSendGetAllCoursesFilteredByTitleTestRequest(String title) {
        GetCoursesQueryParamsDTO.Filter filter = GetCoursesQueryParamsDTO.Filter.builder()
                .title(title)
                .build();
        getAllCoursesFilteredResponse = courseRestClient
                .sendGetAllCoursesFilteredRequest(TestCache.getStringFromCache(TestCacheKey.TOKEN),
                        TestCache.getCookiesFromCache(TestCacheKey.LOGGEDIN_COOKIES), filter);
    }

    @Then("Response contains only filtered by title {string} courses")
    public void responseContainsOnlyFilteredByTitleTestCourses(String title) {
        ArrayList<GetAllCoursesDTO.Row> courses = getAllCoursesFilteredResponse.getRows();
        List<String> titles = courses.stream()
                .map(GetAllCoursesDTO.Row::getTitle)
                .collect(Collectors.toList());
        Assertions.assertThat(courseRestClient.filterByTitleCaseInsensitive(getAllCoursesFilteredResponse, title))
                .as("Courses are not filtered by title " + title).hasSameElementsAs(titles);
    }

    @When("I send Create course titled {string} with image request")
    public void iSendCreateCourseTitledWithImageRequest(String title) {
        courseTitle = title;
        courseRestClient.sendCreateCourseWithImageRequest(TestCache.getStringFromCache(TestCacheKey.TOKEN),
                TestCache.getCookiesFromCache(TestCacheKey.LOGGEDIN_COOKIES), courseTitle);
    }

    @When("I send Create course randomly titled with image request")
    public void iSendCreateCourseRandomlyTitledWithImageRequest() {
        courseTitle = "apiCourse" + RandomStringUtils.randomNumeric(5, 5);
        courseRestClient.sendCreateCourseWithImageRequest(TestCache.getStringFromCache(TestCacheKey.TOKEN),
                TestCache.getCookiesFromCache(TestCacheKey.LOGGEDIN_COOKIES), courseTitle);
    }

    @And("I send Publish created course request")
    public void iSendPublishCreatedCourseRequest() {
        Integer courseId = courseRestClient.getLatestCourseId(TestCache.getStringFromCache(TestCacheKey.TOKEN),
                TestCache.getCookiesFromCache(TestCacheKey.LOGGEDIN_COOKIES));
        courseRestClient.sendPublishCourseRequest(TestCache.getStringFromCache(TestCacheKey.TOKEN),
                TestCache.getCookiesFromCache(TestCacheKey.LOGGEDIN_COOKIES), courseId);
    }

    @And("I send Search course {string} as client request")
    public void iSendSearchCourseAsClientRequest(String name) {
        searchCoursesAsClientDTO = courseRestClient.sendSearchCourseAsClientRequest(name);
    }

    @And("I send Search randomly titled course as client request")
    public void iSendSearchRandomlyTitledCourseAsClientRequest() {
        searchCoursesAsClientDTO = courseRestClient.sendSearchCourseAsClientRequest(courseTitle);
    }

    @Then("The course titled {string} is found")
    public void theCourseTitledIsFound(String title) {
        ArrayList<SearchCoursesAsClientDTO.Service> courses = searchCoursesAsClientDTO.getServices();
        Optional<String> expectedTitle = courses.stream()
                .map(course -> course.getTitle())
                .filter(courseTitle -> courseTitle.equals(title))
                .findFirst();
        Assertions.assertThat(expectedTitle.isPresent()).as("Expected title not found").isTrue();
    }

    @Then("The randomly titled course is found")
    public void theRandomlyTitledCourseIsFound() {
        AtomicInteger searchedCourseIndex = new AtomicInteger();
        ArrayList<SearchCoursesAsClientDTO.Service> courses = searchCoursesAsClientDTO.getServices();
        Optional<String> expectedTitle = courses.stream()
                .map(course -> course.getTitle())
                .filter(eachCourseTitle -> {
                    searchedCourseIndex.getAndIncrement();
                    return eachCourseTitle.equals(courseTitle);
                })
                .findFirst();
        Assertions.assertThat(expectedTitle.isPresent()).as("Expected title not found").isTrue();
        courseIdToUpdate = courses.get(searchedCourseIndex.get() - 1).getCourse_ID();
    }

    @When("I send Update the course's title request")
    public void iSendUpdateTheCourseTitleRequest() {
        updatedCourseTitle = courseRestClient.sendUpdateCourseRequest(TestCache.getStringFromCache(TestCacheKey.TOKEN),
                TestCache.getCookiesFromCache(TestCacheKey.LOGGEDIN_COOKIES), courseIdToUpdate);
    }

    @And("I send Publish updated course request")
    public void iSendPublishUpdatedCourseRequest() {
        courseRestClient.sendPublishCourseRequest(TestCache.getStringFromCache(TestCacheKey.TOKEN),
                TestCache.getCookiesFromCache(TestCacheKey.LOGGEDIN_COOKIES), courseIdToUpdate);
    }

    @Then("The course's title is updated")
    public void theCourseTitleIsUpdated() {
        SearchCoursesAsClientDTO coursesList = courseRestClient.sendSearchCourseAsClientRequest(updatedCourseTitle);
        ArrayList<SearchCoursesAsClientDTO.Service> courses = coursesList.getServices();
        Optional<Integer> updatedCourseId = courses.stream().map(course -> course.getCourse_ID())
                .filter(courseId -> courseId.equals(courseIdToUpdate))
                .findFirst();
        Assertions.assertThat(updatedCourseId.isPresent()).as("Updated course not found").isTrue();
    }

    @And("I send Сreate module request")
    public void iSendCreateModuleRequest() {
        moduleTitle = "apiModule" + RandomStringUtils.randomNumeric(5, 5);
        courseRestClient.sendCreateModuleRequest(TestCache.getStringFromCache(TestCacheKey.TOKEN),
                TestCache.getCookiesFromCache(TestCacheKey.LOGGEDIN_COOKIES), moduleTitle);
    }

    @And("I send Add module to course request")
    public void iSendAddModuleToCourseRequest() {
        Integer courseId = courseRestClient.getLatestCourseId(TestCache.getStringFromCache(TestCacheKey.TOKEN),
                TestCache.getCookiesFromCache(TestCacheKey.LOGGEDIN_COOKIES));
        Integer moduleId = courseRestClient.getLatestModuleId(TestCache.getStringFromCache(TestCacheKey.TOKEN),
                TestCache.getCookiesFromCache(TestCacheKey.LOGGEDIN_COOKIES));
        courseRestClient.sendAddModuleToCourseRequest(TestCache.getStringFromCache(TestCacheKey.TOKEN),
                TestCache.getCookiesFromCache(TestCacheKey.LOGGEDIN_COOKIES), courseId, moduleId);
    }

    @When("I send failing Delete course request")
    public void iSendFailingDeleteCourseRequest() {
        Integer courseId = courseRestClient.getLatestCourseId(TestCache.getStringFromCache(TestCacheKey.TOKEN),
                TestCache.getCookiesFromCache(TestCacheKey.LOGGEDIN_COOKIES));
        courseRestClient.sendDeleteCourseRequestNegative(TestCache.getStringFromCache(TestCacheKey.TOKEN),
                TestCache.getCookiesFromCache(TestCacheKey.LOGGEDIN_COOKIES), courseId);
    }

    @And("I send Remove module from course requests")
    public void iSendRemoveModuleFromCourseRequests() {
        getAllCoursesResponse = courseRestClient
                .sendGetAllCoursesRequest(TestCache.getStringFromCache(TestCacheKey.TOKEN),
                        TestCache.getCookiesFromCache(TestCacheKey.LOGGEDIN_COOKIES));
        ArrayList<GetAllCoursesDTO.CourseModule> addedModules = getAllCoursesResponse.getRows()
                .get(0)
                .getCourse_modules();
        for (GetAllCoursesDTO.CourseModule addedModule : addedModules) {
            courseRestClient.sendDeleteModuleConnectionRequest(TestCache.getStringFromCache(TestCacheKey.TOKEN),
                    TestCache.getCookiesFromCache(TestCacheKey.LOGGEDIN_COOKIES), addedModule.getId());
        }
    }

    @And("I send succeeding Delete course request")
    public void iSendSucceedingDeleteCourseRequest() {
        deletedCourseId = courseRestClient.getLatestCourseId(TestCache.getStringFromCache(TestCacheKey.TOKEN),
                TestCache.getCookiesFromCache(TestCacheKey.LOGGEDIN_COOKIES));
        courseRestClient.sendDeleteCourseRequestPositive(TestCache.getStringFromCache(TestCacheKey.TOKEN),
                TestCache.getCookiesFromCache(TestCacheKey.LOGGEDIN_COOKIES), deletedCourseId);
    }

    @Then("The course was deleted")
    public void theCourseWasDeleted() {
        GetAllCoursesDTO getAllCoursesDTO = courseRestClient.sendGetAllCoursesRequest(
                TestCache.getStringFromCache(TestCacheKey.TOKEN),
                TestCache.getCookiesFromCache(TestCacheKey.LOGGEDIN_COOKIES));
        Optional<Integer> deletedId = getAllCoursesDTO.getRows().stream().map(course -> course.getCourse_ID())
                .filter(courseId -> courseId.equals(deletedCourseId))
                .findFirst();

        Assertions.assertThat(deletedId.isEmpty())
                .as("The course was not deleted (course with deleted Id found)")
                .isTrue();
    }

    @When("I send Create lesson in the module request")
    public void iSendCreateLessonInTheModuleRequest() {
        courseRestClient.sendCreateLessonRequest(TestCache.getStringFromCache(TestCacheKey.TOKEN),
                TestCache.getCookiesFromCache(TestCacheKey.LOGGEDIN_COOKIES));
    }

    @And("I send Create part in the lesson request")
    public void iSendCreatePartInTheLessonRequest() {
        courseRestClient.sendCreatePartRequest(TestCache.getStringFromCache(TestCacheKey.TOKEN),
                TestCache.getCookiesFromCache(TestCacheKey.LOGGEDIN_COOKIES),
                TestCache.getIntegerFromCache(TestCacheKey.LESSON_ID));
    }

    @And("I send Add text to the part request")
    public void iSendAddTextToThePartRequest() {
        courseRestClient.sendAddTextToPartRequest(TestCache.getStringFromCache(TestCacheKey.TOKEN),
                TestCache.getCookiesFromCache(TestCacheKey.LOGGEDIN_COOKIES),
                TestCache.getIntegerFromCache(TestCacheKey.PART_ID));
    }

    @And("I send Create exercise in the part request")
    public void iSendCreateExerciseInThePartRequest() {
        courseRestClient.sendCreateExercisetRequest(TestCache.getStringFromCache(TestCacheKey.TOKEN),
                TestCache.getCookiesFromCache(TestCacheKey.LOGGEDIN_COOKIES),
                TestCache.getIntegerFromCache(TestCacheKey.PART_ID));
    }

    @And("I send Add wrong answer request")
    public void iSendAddWrongAnswerRequest() {
        courseRestClient.sendAddAnswerRequest(TestCache.getStringFromCache(TestCacheKey.TOKEN),
                TestCache.getCookiesFromCache(TestCacheKey.LOGGEDIN_COOKIES),
                TestCache.getIntegerFromCache(TestCacheKey.EXERCISE_ID), false);
    }

    @And("I send Add right answer request")
    public void iSendAddRightAnswerRequest() {
        courseRestClient.sendAddAnswerRequest(TestCache.getStringFromCache(TestCacheKey.TOKEN),
                TestCache.getCookiesFromCache(TestCacheKey.LOGGEDIN_COOKIES),
                TestCache.getIntegerFromCache(TestCacheKey.EXERCISE_ID), true);
    }

    @And("I send Pass test with wrong answer request")
    public void iSendPassTestWithWrongAnswerRequest() {
        isAnswerRight = courseRestClient.sendAnswerTestRequest(TestCache.getStringFromCache(TestCacheKey.TOKEN),
                TestCache.getCookiesFromCache(TestCacheKey.LOGGEDIN_COOKIES),
                false);
    }

    @And("I send Pass test with right answer request")
    public void iSendPassTestWithRightAnswerRequest() {
        isAnswerRight = courseRestClient.sendAnswerTestRequest(TestCache.getStringFromCache(TestCacheKey.TOKEN),
                TestCache.getCookiesFromCache(TestCacheKey.LOGGEDIN_COOKIES),
                true);
    }

    @Then("Response contains {} mark")
    public void responseContainsMark(Boolean mark) {
        Assertions.assertThat(isAnswerRight).as("Unexpected response body (mark)").isEqualTo(mark);
    }
}
