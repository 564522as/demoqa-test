package com.example.selenidedemo.demoqa.api.model;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import net.minidev.json.annotate.JsonIgnore;

import java.util.Locale;
public class UserData {
    @JsonIgnore
    private String userId;
    private String userName;
    private String password;

    public UserData(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public UserData() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public static UserData getRandomUserData() {
        final FakeValuesService fakeValuesService =
                new FakeValuesService(new Locale("en-GB"), new RandomService());
        UserData userData = new UserData();
        userData.setUserName(fakeValuesService.bothify("????##"));
        userData.setPassword(fakeValuesService.regexify("[a-z]{5}[1-9]{4}[A-Z]{4}[&]"));
        return userData;
    }
}
