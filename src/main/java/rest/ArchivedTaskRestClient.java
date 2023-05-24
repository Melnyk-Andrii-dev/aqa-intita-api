package rest;

import cache.TestCache;
import cache.TestCacheKey;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.response.Response;
import rest.dto.CreateTaskResDTO;
import rest.dto.GetTaskResDTO;

import static io.restassured.RestAssured.given;

public class ArchivedTaskRestClient {

    public void sendArchiveRequest(String name) {
        String archiveEndpoint = "/cabinet/kanban/task/archive";

        Header tokenHeader = new Header("X-CSRF-TOKEN", TestCache.getStringFromCache(TestCacheKey.TOKEN));
        String body = String.format("{\"id\": \"%s\"}", name);

        Cookies loginCookie = TestCache.getCookiesFromCache(TestCacheKey.LOGGEDIN_COOKIES);

        given(RequestSpecifications.basicSpec)
                .header(tokenHeader)
                .cookies(loginCookie)
                .urlEncodingEnabled(false)
                .body(body)
                .log().all()
                .when().post(archiveEndpoint)
                .then().statusCode(200)
                .and().extract().response();

    }

    public String getArchivedTaskNameRequest(int taskId) {

        String getTaskEndpoint = "/cabinet/kanban/task/show/" + taskId;
        Header tokenHeader = new Header("X-CSRF-TOKEN", TestCache.getStringFromCache(TestCacheKey.TOKEN));
        Cookies loginCookie = TestCache.getCookiesFromCache(TestCacheKey.LOGGEDIN_COOKIES);

        Response response = given(RequestSpecifications.basicSpec)
                .header(tokenHeader)
                .cookies(loginCookie)
                .when().get(getTaskEndpoint)
                .then().statusCode(200)
                .and().extract().response();

        GetTaskResDTO getTaskResDTO = response.as(GetTaskResDTO.class);
        TestCache.putDataInCache(TestCacheKey.CREATED_TASK_DTO, getTaskResDTO);
        return getTaskResDTO.getTask().getName();


    }
    public void sendUnzipTaskRequest(int id) {
    String unzipEndpoint = "/cabinet/kanban/task/unzip";
        Header tokenHeader = new Header("X-CSRF-TOKEN", TestCache.getStringFromCache(TestCacheKey.TOKEN));
        Cookies loginCookie = TestCache.getCookiesFromCache(TestCacheKey.LOGGEDIN_COOKIES);

        String body = String.format("{\"id\": %d}", id);

        given(RequestSpecifications.basicSpec)
                .header(tokenHeader)
                .cookies(loginCookie)
                .body(body)
                .log().all()
                .when().post(unzipEndpoint)
                .then().statusCode(200);



    }
}