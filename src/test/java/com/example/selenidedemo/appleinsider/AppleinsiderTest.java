package com.example.selenidedemo.appleinsider;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppleinsiderTest extends BaseTest{

    private final String BASE_URL = "https://appleinsider.ru";
    private final String SEARCH_SENTENCE = "Чем iPhone 13 отличается от iPhone 12";
    private final String EXPECTED_WORD = "iphone-11";

    @Test
    public void checkHref() {
        String href = new MainPage(BASE_URL)
                .search(SEARCH_SENTENCE)
                .getHrefFromFirstArticle();
        Assertions.assertTrue(href.contains(EXPECTED_WORD));
    }
}
