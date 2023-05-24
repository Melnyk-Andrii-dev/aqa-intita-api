package rest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RedirectConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecifications {
    private static final String baseUrl = "https://qa.intita.com";
    public static RequestSpecification basicSpec = new RequestSpecBuilder()
            .setBaseUri(baseUrl).setConfig(RestAssuredConfig.config().redirect(RedirectConfig.redirectConfig().followRedirects(true)))
            .setContentType(ContentType.JSON)
            .setAccept("application/json, text/plain, */*")
            .addHeader("Connection", "keep-alive")
            .build();

    public static RequestSpecification formDataSpec = new RequestSpecBuilder()
            .setBaseUri(baseUrl)
            .addHeader("Connection", "keep-alive")
            .build();
}
