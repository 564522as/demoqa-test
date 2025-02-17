package com.example.selenidedemo.appleinsider;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

public class FoundPage {
    private final ElementsCollection articleTitles = $$x("//h2//a");

    /**
     * Возвращает href атрибут из первой статьи
     * @return
     */
    public String getHrefFromFirstArticle() {
        return articleTitles.first().getAttribute("href");
    }
}
