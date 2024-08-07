package com.example.selenidedemo.demoqa.api.account;

import com.example.selenidedemo.demoqa.api.Specifications;
import com.example.selenidedemo.demoqa.api.model.UserData;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class GenerateTokenTest {
    private UserData userData;
    private final String URL = "https://demoqa.com/Account/v1/";
    private String token;
    @BeforeEach
    public void userRegistration() {
        userData = AccountUtil.registration();
    }
    @Test
    public void testGetToken() {
        token = given()
                .body(userData)
                .post("GenerateToken")
                .then()
                .body("token", notNullValue())
                .body("status", equalTo("Success"))
                .body("result", notNullValue())
                .body("expires", notNullValue())
                .log().all()
                .extract().jsonPath()
                .getString("token");
    }
    @AfterEach
    public void deleteUser() {
        AccountUtil.deleteUser(userData.getUserId(), token);
    }
}