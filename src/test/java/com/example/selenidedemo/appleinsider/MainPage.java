package com.example.selenidedemo.appleinsider;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

/*
 * Главная страница сайта appleinsider.ru
 */
public class MainPage {
    private final SelenideElement textBoxInput = $x("//input[@type='text']");
    public MainPage(String url) {
        Selenide.open(url);
    }

    /**
     * Выполняется поиск среди статей и нажимается кнопка enter
     * @param searchValue
     */
    public FoundPage search(String searchValue) {
        textBoxInput.setValue(searchValue);
        textBoxInput.sendKeys(Keys.ENTER);
        return new FoundPage();
    }
}
