package com.example.selenidedemo.demoqa.ui.pages.frameswindows;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AlertsPage {
    private final SelenideElement showAlertBtn = $x("//*[@id=\"alertButton\"]");
    private final SelenideElement showAlertLaterBtn = $x("//*[@id=\"timerAlertButton\"]");
    private final SelenideElement showConfirmAlertBtn = $x("//*[@id=\"confirmButton\"]");
    private final SelenideElement showPromptAlertBtn = $x("//*[@id=\"promtButton\"]");
    private final SelenideElement selectConfirmAlertInfo = $x("//*[@id=\"confirmResult\"]");
    private final SelenideElement messagePromptAlertInfo = $x("//*[@id=\"promptResult\"]");
    public AlertsPage clickShowAlertBtn() {
        showAlertBtn.click();
        return this;
    }
    public AlertsPage clickShowAlertLaterBtn() {
        showAlertLaterBtn.click();
        return this;
    }
    public AlertsPage clickShowConfirmAlertBtn() {
        showConfirmAlertBtn.click();
        return this;
    }
    public AlertsPage clickShowPromptAlertBtn() {
        showPromptAlertBtn.click();
        return this;
    }
    public String getSelectConfirmAlertInfo() {
        return selectConfirmAlertInfo.getText();
    }
    public String getPromptAlertInfo() {
        return messagePromptAlertInfo.getText();
    }
}
