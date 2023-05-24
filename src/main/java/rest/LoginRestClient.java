package rest;

import cache.TestCache;
import cache.TestCacheKey;
import enums.userAttrubutes.UserEmail;
import io.restassured.http.*;
import io.restassured.response.Response;
import rest.dto.LoginReqBodyDTO;

import java.lang.instrument.Instrumentation;

import static io.restassured.RestAssured.given;
public class LoginRestClient {

    public Cookies sendLoginRequest(String email, String password) {
        String loginEndpoint = "/login/customLogin";
        Cookie sessionCookie = new Cookie.Builder("intita_session", TestCache
                .getStringFromCache(TestCacheKey.SESSION_ID)).build();
        Header tokenHeader = new Header("X-CSRF-TOKEN", TestCache.getStringFromCache(TestCacheKey.TOKEN));
        LoginReqBodyDTO.LoginBody loginBody = LoginReqBodyDTO.LoginBody.builder().email(email)
                .password(password).build();
        Response response = given(RequestSpecifications.basicSpec)
                .header(tokenHeader)
                .cookie(sessionCookie)
                .body(loginBody)
                .when().post(loginEndpoint)
                .then().statusCode(200)
                .and().extract().response();

        return response.getDetailedCookies();
    }
}
