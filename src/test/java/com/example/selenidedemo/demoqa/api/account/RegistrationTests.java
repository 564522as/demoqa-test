package com.example.selenidedemo.demoqa.api.account;

import com.example.selenidedemo.demoqa.api.model.UserData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class RegistrationTests {

    private final UserData userData = UserData.getRandomUserData();
    private final String URL = "https://demoqa.com/Account/v1/";
    @Test
    public void testSignUp() {
        String userID = given()
                .contentType(ContentType.JSON)
                .body(userData)
                .post(URL + "User")
                .then()
                .body("userID", notNullValue())
                .body("username", notNullValue())
                .log().all().extract().jsonPath().getString("userID");
        userData.setUserId(userID);
    }

    @AfterEach
    public void deleteUser() {
        String token = AccountUtil.generateToken(userData);
        AccountUtil.deleteUser(userData.getUserId(), token);
    }
}
