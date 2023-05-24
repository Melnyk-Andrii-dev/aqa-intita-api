package rest.util;

import cache.TestCache;
import cache.TestCacheKey;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;

public class Session {

    public static void saveSessionId() {
        String basicUrl = "https://qa.intita.com/";
        Header header = new Header("Connection", "keep-alive");
        Response response = given()
                .contentType(ContentType.JSON)
                .header(header)
                .when()
                .get(basicUrl)
                .then().statusCode(200)
                .and().extract().response();

        Headers responseHeaders = response.getHeaders();
        List<String> headersValues = responseHeaders.getValues("set-cookie");
        String toParse = headersValues.get(1);
        Pattern pattern = Pattern.compile("(?:intita_session=)(\\w+)(?:;)");
        Matcher matcher = pattern.matcher(toParse);
        if (matcher.find()) {
            TestCache.putDataInCache(TestCacheKey.SESSION_ID, matcher.group(1));
        }
    }

    public static void saveXCsrfToken(String sessionId) {
        String basicUrl = "https://qa.intita.com/";
        Header header = new Header("Connection", "keep-alive");
        Cookie cookie = new Cookie.Builder("intita_session", sessionId).build();

        Response response = given()
                .contentType(ContentType.JSON)
                .header(header)
                .cookie(cookie)
                .when()
                .get(basicUrl)
                .then().statusCode(200)
                .and().extract().response();

        String htmlString = response.getBody().asString();
        Document document = Jsoup.parse(htmlString);
        Element element = document.selectFirst("meta[name='csrf-token']");
        if (element != null) {
            TestCache.putDataInCache(TestCacheKey.TOKEN, element.attr("content"));
        }
    }
}
