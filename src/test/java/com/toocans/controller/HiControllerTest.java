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

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


@Slf4j
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableConfigurationProperties
public class HiControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        // 设置RestAssured的基础URL，以便后续发送请求时使用
        RestAssured.baseURI = "http://127.0.0.1";
        RestAssured.port = port;
    }

    @Test
    public void testHiEndpointWithQueryParam() {
        String name = "testUser";
        given()
                .contentType(ContentType.JSON)
                .queryParam("name", name)
                .when()
                .post("/hi")
                .then()
                .statusCode(200)
                .body(equalTo("hi " + name));
    }

    @Test
    public void testHiEndpointWithoutQueryParam() {
        String name = "simbabdytech";
        given()
                .contentType(ContentType.JSON)
                .when()
                .post("/hi")
                .then()
                .statusCode(200)
                .body(equalTo("hi " + name));
    }
}

