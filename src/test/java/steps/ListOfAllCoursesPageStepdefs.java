package steps;

import cache.TestCache;
import cache.TestCacheKey;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import pages.ListOfAllCoursesPage;

public class ListOfAllCoursesPageStepdefs {

    private static final ListOfAllCoursesPage listOfAllCoursesPage = new ListOfAllCoursesPage();

    @And("I enter the course nickname {string} in the field Nickname on the ListOfAllCourses Page")
    public void iEnterTheCourseNicknameInTheFieldNicknameOnTheListOfAllCoursesPage(String data) {
        String randomNickname = TestCache.getStringFromCache(TestCacheKey.COURSE_NICKNAME);
        listOfAllCoursesPage.inputDataInTheFindCourseByNicknameField(randomNickname);

    }

    @And("The course nickname {string} is displayed on the ListOfAllCourses Page")
    public void theNicknameIsDisplayedOnTheListOfAllCoursesPage(String data) {
        String randomNickname = TestCache.getStringFromCache(TestCacheKey.COURSE_NICKNAME);
        Assertions.assertThat(data).as(String.format("Expected : %s, Actual : %s", data, randomNickname)).contains("TestNickname1");
    }

    @Then("I click Create Course Button on List Of All Courses page")
    public void iClickCreateCourseButtonOnListOfAllCoursesPage() {
        listOfAllCoursesPage.clickCreateCourseButton();
    }

    @And("I click button delete Course button")
    public void iClickButtonDeleteCourseButton() {
        listOfAllCoursesPage.clickDeleteCourseButton();
        listOfAllCoursesPage.deleteCourse();
    }
}
