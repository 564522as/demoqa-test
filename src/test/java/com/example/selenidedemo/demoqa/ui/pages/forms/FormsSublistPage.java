package com.example.selenidedemo.demoqa.ui.pages.forms;

import com.codeborne.selenide.SelenideElement;
import com.example.selenidedemo.demoqa.ui.pages.elements.ElementsSublistPage;

import static com.codeborne.selenide.Selenide.$x;

public class FormsSublistPage {
    private final SelenideElement practiceFormEl = $x("/html/body/div[2]/div/div/div/div[1]/div/div/div[2]/div/ul/li");
    public PracticeFormPage clickPracticeFormEl() {
        ElementsSublistPage.clickByJs(practiceFormEl);
        return new PracticeFormPage();
    }
}
