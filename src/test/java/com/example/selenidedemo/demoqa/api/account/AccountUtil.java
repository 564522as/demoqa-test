package com.example.selenidedemo.demoqa.api.account;

import com.example.selenidedemo.demoqa.api.Specifications;
import com.example.selenidedemo.demoqa.api.model.UserData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class AccountUtil {
    private static final String URL = "https://demoqa.com/Account/v1/";
    public static UserData registration() {
        final UserData userData = UserData.getRandomUserData();
        String userID = given()
                .contentType(ContentType.JSON)
                .body(userData)
                .post("User")
                .then()
                .log().all()
                .extract().jsonPath()
                .getString("userID");
        userData.setUserId(userID);
        return userData;
    }

    public static void deleteUser(String userId, String token) {
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .delete("User/" + userId)
                .then().log().all()
                .extract().jsonPath();
    }

    public static String generateToken(UserData userData) {
        JsonPath jsonPath = given()
                .contentType(ContentType.JSON)
                .body(userData)
                .post(URL + "GenerateToken")
                .then()
                .extract().jsonPath();

        return jsonPath.getString("token");
    }
}
