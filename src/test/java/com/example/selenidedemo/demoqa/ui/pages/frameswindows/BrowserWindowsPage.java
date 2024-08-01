package com.example.selenidedemo.demoqa.ui.pages.frameswindows;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BrowserWindowsPage {
    private final SelenideElement newTabBtn = $x("//*[@id=\"tabButton\"]");
    private final SelenideElement newWindowBtn = $x("//*[@id=\"windowButton\"]");
    private final SelenideElement newWindowMessageBtn = $x("//*[@id=\"messageWindowButton\"]");
    public SamplePage clickNewTab() {
        newTabBtn.click();
        return new SamplePage();
    }
    public SamplePage clickNewWindow() {
        newWindowBtn.click();
        return new SamplePage();
    }
    public SampleMessagePage clickNewWindowMessageBtn() {
        newWindowMessageBtn.click();
        return new SampleMessagePage();
    }

}
