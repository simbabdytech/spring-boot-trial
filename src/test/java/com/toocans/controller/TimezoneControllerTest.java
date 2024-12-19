package com.toocans.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.ZoneId;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


@Slf4j
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableConfigurationProperties
public class TimezoneControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        // 设置RestAssured的基础URL，以便后续发送请求时使用
        RestAssured.baseURI = "http://127.0.0.1";
        RestAssured.port = port;
    }

    @Test
    public void testTimezoneEndpointWithGetMethodWithHeaderParam() {
        String zoneName = "Europe/London";
        ZoneId zoneId = ZoneId.of(zoneName);
        String result = "当前时区:" + zoneId;

        given()
                .contentType(ContentType.JSON)
                .header("X-Timezone", zoneName)
                .when()
                .get("/get-time")
                .then()
                .statusCode(200)
                .body(equalTo(result));
    }

    @Test
    public void testTimezoneEndpointWithGetMethodWithoutHeaderParam() {
        String zoneName = "Asia/Shanghai";
        ZoneId zoneId = ZoneId.of(zoneName);
        String result = "当前时区:" + zoneId;

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/get-time")
                .then()
                .statusCode(200)
                .body(equalTo(result));
    }

    @Test
    public void testTimezoneEndpointWithGetMethodWithInvalidHeaderParam() {
        String invalidZoneName = "Invalid/Timezone";
        String zoneName = "Asia/Shanghai";
        ZoneId zoneId = ZoneId.of(zoneName);
        String result = "当前时区:" + zoneId;

        given()
                .contentType(ContentType.JSON)
                .header("X-Timezone", invalidZoneName)
                .when()
                .get("/get-time")
                .then()
                .statusCode(200)
                .body(equalTo(result));
    }

    @Test
    public void testTimezoneEndpointWithGetMethodWithEmptyHeaderParam() {
        String emptyZoneName = "";
        String zoneName = "Asia/Shanghai";
        ZoneId zoneId = ZoneId.of(zoneName);
        String result = "当前时区:" + zoneId;

        given()
                .contentType(ContentType.JSON)
                .header("X-Timezone", emptyZoneName)
                .when()
                .get("/get-time")
                .then()
                .statusCode(200)
                .body(equalTo(result));
    }


    @Test
    public void testTimezoneEndpointWithPostMethodWithHeaderParam() {
        String zoneName = "Europe/London";
        ZoneId zoneId = ZoneId.of(zoneName);
        String result = "当前时区:" + zoneId;

        given()
                .contentType(ContentType.JSON)
                .header("X-Timezone", zoneName)
                .when()
                .post("/post-time")
                .then()
                .statusCode(200)
                .body(equalTo(result));
    }

    @Test
    public void testTimezoneEndpointWithPostMethodWithoutHeaderParam() {
        String zoneName = "Asia/Shanghai";
        ZoneId zoneId = ZoneId.of(zoneName);
        String result = "当前时区:" + zoneId;

        given()
                .contentType(ContentType.JSON)
                .when()
                .post("/post-time")
                .then()
                .statusCode(200)
                .body(equalTo(result));
    }

    @Test
    public void testTimezoneEndpointWithPostMethodWithInvalidHeaderParam() {
        String invalidZoneName = "Invalid/Timezone";
        String zoneName = "Asia/Shanghai";
        ZoneId zoneId = ZoneId.of(zoneName);
        String result = "当前时区:" + zoneId;

        given()
                .contentType(ContentType.JSON)
                .header("X-Timezone", invalidZoneName)
                .when()
                .post("/post-time")
                .then()
                .statusCode(200)
                .body(equalTo(result));
    }

    @Test
    public void testTimezoneEndpointWithPostMethodWithEmptyHeaderParam() {
        String emptyZoneName = "";
        String zoneName = "Asia/Shanghai";
        ZoneId zoneId = ZoneId.of(zoneName);
        String result = "当前时区:" + zoneId;

        given()
                .contentType(ContentType.JSON)
                .header("X-Timezone", emptyZoneName)
                .when()
                .post("/post-time")
                .then()
                .statusCode(200)
                .body(equalTo(result));
    }
}
