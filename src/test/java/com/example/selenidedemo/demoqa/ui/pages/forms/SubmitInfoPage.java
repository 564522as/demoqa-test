package com.example.selenidedemo.demoqa.ui.pages.forms;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SubmitInfoPage {
    private final SelenideElement name = $("body > div.fade.modal.show > div > div > div.modal-body > div > table > tbody > tr:nth-child(1) > td:nth-child(2)");
    private final SelenideElement email = $("body > div.fade.modal.show > div > div > div.modal-body > div > table > tbody > tr:nth-child(2) > td:nth-child(2)");
    private final SelenideElement gender = $("body > div.fade.modal.show > div > div > div.modal-body > div > table > tbody > tr:nth-child(3) > td:nth-child(2)");
    private final SelenideElement mobile = $("body > div.fade.modal.show > div > div > div.modal-body > div > table > tbody > tr:nth-child(4) > td:nth-child(2)");
    private final SelenideElement birthDate = $("body > div.fade.modal.show > div > div > div.modal-body > div > table > tbody > tr:nth-child(5) > td:nth-child(2)");
    private final SelenideElement subjects = $("body > div.fade.modal.show > div > div > div.modal-body > div > table > tbody > tr:nth-child(6) > td:nth-child(2)");
    private final SelenideElement hobbies = $("body > div.fade.modal.show > div > div > div.modal-body > div > table > tbody > tr:nth-child(7) > td:nth-child(2)");
    private final SelenideElement stateAndCity = $("body > div.fade.modal.show > div > div > div.modal-body > div > table > tbody > tr:nth-child(10) > td:nth-child(2)");

    public String getName() {
        return name.getText();
    }

    public String getEmail() {
        return email.getText();
    }

    public String getGender() {
        return gender.getText();
    }

    public String getMobile() {
        return mobile.getText();
    }

    public String getBirthDate() {
        return birthDate.getText();
    }

    public String getSubjects() {
        return subjects.getText();
    }

    public String getHobbies() {
        return hobbies.getText();
    }

    public String getStateAndCity() {
        return stateAndCity.getText();
    }
}
