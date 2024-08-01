package com.example.selenidedemo.authWithCookie;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import java.util.Date;

import static com.codeborne.selenide.Selenide.$x;
import static io.restassured.RestAssured.given;

public class AuthUtil {
    @Test
    public void authWithRestCookiesTest(){
        Selenide.open("https://at-sandbox.workbench.lanit.ru/tickets/");
        String token = WebDriverRunner.getWebDriver().manage().getCookieNamed("csrftoken").getValue();
        String sessionId = given()
                .contentType(ContentType.MULTIPART)
                .cookie("csrftoken", token)
                .multiPart("username", "admin")
                .multiPart("password", "adminat")
                .multiPart("next", "/")
                .multiPart("csrfmiddlewaretoken", token)
                .post("https://at-sandbox.workbench.lanit.ru/login/")
                .then().log().all().extract().cookie("sessionid");
        System.out.println(sessionId);

        Date expDate = new Date();
        expDate.setTime(expDate.getTime() * (10000*10000));
        Cookie cookie = new Cookie("sessionid", sessionId,
                "at-sandbox.workbench.lanit.ru", "/", expDate);
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
        Selenide.refresh();

        $x("//a[@id='userDropdown']").should(Condition.text("admin"));

    }
}
