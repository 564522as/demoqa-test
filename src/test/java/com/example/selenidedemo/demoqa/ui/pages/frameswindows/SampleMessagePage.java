package com.example.selenidedemo.demoqa.ui.pages.frameswindows;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SampleMessagePage {
    private final SelenideElement message = $("body");
    public String getMessage() {
        return message.getText();
    }

}
