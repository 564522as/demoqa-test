package com.example.selenidedemo.demoqa.ui.pages.frameswindows;

import com.codeborne.selenide.SelenideElement;
import com.example.selenidedemo.demoqa.ui.pages.elements.ElementsSublistPage;

import static com.codeborne.selenide.Selenide.$x;

public class SublistPage {
    private final SelenideElement browserWindowsBtn = $x("//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[3]/div/ul/li[1]");
    private final SelenideElement alertsBtn = $x("//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[3]/div/ul/li[2]");
    private final SelenideElement framesBtn = $x("//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[3]/div/ul/li[3]");
    private final SelenideElement nestedFramesBtn = $x("//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[3]/div/ul/li[4]");
    private final SelenideElement modalDialogsBtn = $x("//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[3]/div/ul/li[5]");
    public BrowserWindowsPage clickBrowserWindowsBtn() {
        ElementsSublistPage.clickByJs(browserWindowsBtn);
        return new BrowserWindowsPage();
    }
    public AlertsPage clickAlertsBtn() {
        ElementsSublistPage.clickByJs(alertsBtn);
        return new AlertsPage();
    }
    public FramesPage clickFramesBtn() {
        ElementsSublistPage.clickByJs(framesBtn);
        return new FramesPage();
    }
    public NestedFramesPage clickNestedFramesBtn() {
        ElementsSublistPage.clickByJs(nestedFramesBtn);
        return new NestedFramesPage();
    }
    public ModalDialogsPage clickModalDialogsBtn() {
        ElementsSublistPage.clickByJs(modalDialogsBtn);
        return new ModalDialogsPage();
    }
}
