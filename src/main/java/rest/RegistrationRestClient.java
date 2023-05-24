package rest;

import cache.TestCache;
import cache.TestCacheKey;
import io.restassured.http.Cookie;
import io.restassured.http.Header;
import org.apache.commons.lang3.RandomStringUtils;
import rest.dto.RegistrationBodyDTO;

import static io.restassured.RestAssured.given;

public class RegistrationRestClient {
    static final String REGISTRATION_NEW_ACCOUNT_ENDPOINT = "/register?ajax=true";

    public void sendRegistrationRequest(String password){

        Cookie sessionCookie = new Cookie.Builder("intita_session", TestCache
                .getStringFromCache(TestCacheKey.SESSION_ID)).build();
        Header tokenHeader = new Header("X-CSRF-TOKEN", TestCache.getStringFromCache(TestCacheKey.TOKEN));
        RegistrationBodyDTO.RegistrationBody registrationBody = RegistrationBodyDTO.RegistrationBody.builder().email(RandomStringUtils.randomAlphanumeric(6)+"%s@gmail.com")
                .password(password).build();

       given(RequestSpecifications.basicSpec)
                .header(tokenHeader)
                .cookie(sessionCookie)
                .body(registrationBody)
                .log().all()
                .when().post(REGISTRATION_NEW_ACCOUNT_ENDPOINT)
                .then().statusCode(200);
    }
}
