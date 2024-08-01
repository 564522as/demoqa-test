package com.example.selenidedemo.demoqa.ui.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.example.selenidedemo.demoqa.ui.pages.frameswindows.SublistPage;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement elementsCard = $x("//div[@class='card mt-4 top-card']");
    private final SelenideElement frameWindowsCard = $x("//*[@id=\"app\"]/div/div/div[2]/div/div[3]");

    public MainPage(String url) {
        Selenide.open(url);
    }
    public void clickElementsCard() {
        elementsCard.click();
    }
    public SublistPage clickFrameWindowsCard() {
        frameWindowsCard.click();
        return new SublistPage();
    }
}
