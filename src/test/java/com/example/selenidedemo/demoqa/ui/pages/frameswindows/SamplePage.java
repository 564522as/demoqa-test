package com.example.selenidedemo.demoqa.ui.pages.frameswindows;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SamplePage {
    private final SelenideElement pageName = $x("//*[@id=\"sampleHeading\"]");
    public String getPageName() {
        return pageName.getText();
    }
}
