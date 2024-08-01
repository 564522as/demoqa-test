package com.example.selenidedemo.demoqa.ui.pages.frameswindows;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class NestedFramesPage {
    private final SelenideElement parentFrame = $x("//*[@id=\"frame1\"]");
    private final SelenideElement childFrame = $x("//*[@srcdoc='<p>Child Iframe</p>']");

    public SelenideElement getParentFrame() {
        return parentFrame;
    }

    public SelenideElement getChildFrame() {
        return childFrame;
    }
}
