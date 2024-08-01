package com.example.selenidedemo.demoqa.ui.pages.frameswindows;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class FramesPage {
    private final SelenideElement frame1 = $x("//*[@id=\"frame1\"]");
    private final SelenideElement frame2 = $x("//*[@id=\"frame2\"]");

    public SelenideElement getFrame1() {
        return frame1;
    }

    public SelenideElement getFrame2() {
        return frame2;
    }
}
