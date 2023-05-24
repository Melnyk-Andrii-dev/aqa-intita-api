package steps;

import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import rest.CourseInfoRestClient;
import rest.dto.CourseInfoDTO;

public class ApiServicesStepdefs {

    private static final CourseInfoRestClient courseInfoRestClient = new CourseInfoRestClient();

    @When("I send get service info request for course number {string} and I see {int} status code and title {string}")
    public void iSendGetServiceRequestAndISeeStatusCodeAndCourseTitle(String numberOfCourse, int statusCode, String expectedTitle) {

        Response response = courseInfoRestClient.sendGetCourseInformationRequest(statusCode,numberOfCourse);

        CourseInfoDTO courseInfoDTO = response.as(CourseInfoDTO.class);
        String actualTitle = courseInfoDTO.getService().getTitle();

        Assertions.assertThat(actualTitle).as(String.format("Expected : %s, Actual : %s", expectedTitle, actualTitle)).isEqualTo(expectedTitle);
    }

    @When("I send get service info request for course number {string} and I see {int} status code and organization name {string}")
    public void iSendGetServiceInfoRequestForCourseNumberAndISeeStatusCodeAndOrganizationName(String numberOfCourse, int statusCode, String expectedOrganizationName) {
        Response response = courseInfoRestClient.sendGetCourseInformationRequest(statusCode,numberOfCourse);

        CourseInfoDTO courseInfoDTO = response.as(CourseInfoDTO.class);
        String actualOrganizationName = courseInfoDTO.getService().getOrganization().getName();

        Assertions.assertThat(actualOrganizationName).as(String.format("Expected : %s, Actual : %s", expectedOrganizationName, actualOrganizationName)).isEqualTo(expectedOrganizationName);
    }
}
