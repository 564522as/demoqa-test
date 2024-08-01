package com.example.selenidedemo.demoqa.api.account;

import com.example.selenidedemo.demoqa.api.model.UserData;
import io.restassured.http.ContentType;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class UserInfoTest {
    private static UserData userData;
    private final static String URL = "https://demoqa.com/Account/v1/";
    private static String token;
    @BeforeAll
    public static void userRegistrationAndGetToken() {
        userData = AccountUtil.registration();
        token = AccountUtil.generateToken(userData);
    }

    @Test
    public void testIsUserAuthorized() {
        String result = given()
                .contentType(ContentType.JSON)
                .body(userData)
                .post(URL + "Authorized")
                .then()
                .extract().asString();
        Assertions.assertEquals("true", result);
    }

    @Test
    public void getUserTest() {
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(URL + "User/" + userData.getUserId())
                .then()
                .body("userId", equalTo(userData.getUserId()))
                .body("username", equalTo(userData.getUserName()))
                .log().all();
    }

    @AfterAll
    public static void deleteUser() {
        AccountUtil.deleteUser(userData.getUserId(), token);
    }
}
