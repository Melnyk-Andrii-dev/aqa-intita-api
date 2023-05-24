package rest;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CourseInfoRestClient {

    static final String COURSE_INFO_ENDPOINT = "/course/info/%s?ajax=true";

    public Response sendGetCourseInformationRequest(int statusCode, String numberOfCourse) {
        return given(RequestSpecifications.basicSpec)
                .basePath(String.format(COURSE_INFO_ENDPOINT, numberOfCourse))
                .log().all()
                .when().get()
                .then()
                .statusCode(statusCode)
                .and().extract().response();
    }
}
