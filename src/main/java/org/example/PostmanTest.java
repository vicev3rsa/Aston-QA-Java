package org.example;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanTest {
    static RequestSpecification requestSpec;
    static ResponseSpecification responseSpec;

    @BeforeAll
    public static void setupRequestSpec() {
        requestSpec = given()
                .baseUri("https://postman-echo.com")
                .headers("User-Agent", "PostmanRuntime/7.39.0", "Accept", "*/*",
                        "Accept-Encoding", "gzip, deflate, br",
                        "Connection", "keep-alive");
    }

    @BeforeAll
    public static void setupResponseSpec() {
        responseSpec = expect()
                .statusCode(200)
                .body("headers.x-forwarded-proto", equalTo("https"),
                        "headers.host", equalTo("postman-echo.com"),
                        "headers.accept", equalTo("*/*"),
                        "headers.accept-encoding", equalTo("gzip, deflate, br"),
                        "headers.user-agent", equalTo("PostmanRuntime/7.39.0"),
                        "headers.x-forwarded-port", equalTo("443"));
    }

    @Test
    @DisplayName("Тестирование Get запроса с параметрами")
    public void getRequestTest() {
        given().log().headers().spec(requestSpec)
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("https://postman-echo.com/get")

                .then().log().body()
                .spec(responseSpec)
                .body(
                        "args.foo1", equalTo("bar1"),
                        "args.foo2", equalTo("bar2"),
                        "url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    @DisplayName("Тестирование Post запроса со строкой")
    public void postRequestTest() {
        given().log().body().spec(requestSpec)
                .headers("Content-Type", "text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .post("/post")
                .then().log().body()
                .spec(responseSpec)
                .body(
                        "data", equalTo("This is expected to be sent back as part of response body."),
                        "headers.content-length", equalTo("58"),
                        "headers.content-type", equalTo("text/plain; charset=ISO-8859-1"),
                        "json", equalTo(null),
                        "url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    @DisplayName("Тестирование Post запроса с параметрами")
    public void postRequestTest2() {
        given().log().body().spec(requestSpec)
                .headers("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .formParams("foo1", "bar1", "foo2", "bar2")
                .when()
                .post("/post")
                .then().log().body()
                .spec(responseSpec)
                .body(
                        "form.foo1", equalTo("bar1"),
                        "form.foo2", equalTo("bar2"),
                        "headers.content-length", equalTo("19"),
                        "headers.content-type", equalTo("application/x-www-form-urlencoded; charset=UTF-8"),
                        "json.foo1", equalTo("bar1"),
                        "json.foo2", equalTo("bar2"),
                        "url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    @DisplayName("Тестирование Put запроса со строкой")
    public void putRequestTest() {
        given().log().body().spec(requestSpec)
                .headers("Content-Type", "text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put("/put")
                .then().log().body()
                .spec(responseSpec)
                .body(
                        "data", equalTo("This is expected to be sent back as part of response body."),
                        "headers.content-length", equalTo("58"),
                        "headers.content-type", equalTo("text/plain; charset=ISO-8859-1"),
                        "json", equalTo(null),
                        "url", equalTo("https://postman-echo.com/put"));
    }

    @Test
    @DisplayName("Тестирование запроса Patch со строкой")
    public void patchRequestTest() {
        given().log().body().spec(requestSpec)
                .headers("Content-Type", "text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch("/patch")
                .then().log().body()
                .spec(responseSpec)
                .body(
                        "data", equalTo("This is expected to be sent back as part of response body."),
                        "headers.content-length", equalTo("58"),
                        "headers.content-type", equalTo("text/plain; charset=ISO-8859-1"),
                        "json", equalTo(null),
                        "url", equalTo("https://postman-echo.com/patch"));
    }

    @Test
    @DisplayName("Тестирование запроса Delete со строкой")
    public void deleteRequestTest() {
        given().log().body().spec(requestSpec)
                .headers("Content-Type", "text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .delete("/delete")
                .then().log().body()
                .spec(responseSpec)
                .body(
                        "data", equalTo("This is expected to be sent back as part of response body."),
                        "headers.content-length", equalTo("58"),
                        "headers.content-type", equalTo("text/plain; charset=ISO-8859-1"),
                        "json", equalTo(null),
                        "url", equalTo("https://postman-echo.com/delete"));
    }
}