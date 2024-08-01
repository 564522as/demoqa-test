package com.example.selenidedemo.demoqa.ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TypesListPage {
    private final SelenideElement bookStoreAppSublist = $x("//div[@class='element-group'][6]");
    public void clickBookStoreAppSublist() {
        bookStoreAppSublist.click();
    }

}
