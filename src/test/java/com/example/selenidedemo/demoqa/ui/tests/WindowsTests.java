package com.example.selenidedemo.demoqa.ui.tests;

import com.codeborne.selenide.Selenide;
import com.example.selenidedemo.BaseTest;
import com.example.selenidedemo.demoqa.ui.pages.MainPage;
import com.example.selenidedemo.demoqa.ui.pages.frameswindows.BrowserWindowsPage;
import com.example.selenidedemo.demoqa.ui.pages.frameswindows.SublistPage;
import com.example.selenidedemo.demoqa.ui.pages.frameswindows.SampleMessagePage;
import com.example.selenidedemo.demoqa.ui.pages.frameswindows.SamplePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class WindowsTests extends BaseTest {
    public final String URL = "https://demoqa.com";
    public SublistPage sublistPage;
    @BeforeEach
    public void open() {
        MainPage mainPage = new MainPage(URL);
        sublistPage = mainPage.clickFrameWindowsCard();
    }
    @RepeatedTest(3)
    public void testNewTab() {
        SamplePage samplePage = sublistPage
                .clickBrowserWindowsBtn()
                .clickNewTab();

        Selenide.webdriver().driver().switchTo().window(0);
        Selenide.webdriver().driver().switchTo().window(1);

        Assertions.assertEquals(2, Selenide.webdriver()
                                    .driver()
                                    .getWebDriver()
                                    .getWindowHandles().size());
        Assertions.assertEquals(Selenide.webdriver()
                                    .driver()
                                    .getWebDriver()
                                    .getCurrentUrl(), "https://demoqa.com/sample");
        Assertions.assertEquals("This is a sample page", samplePage.getPageName());
    }

    @Test
    public void testNewWindow() {
        BrowserWindowsPage browserWindowsPage = sublistPage
                .clickBrowserWindowsBtn();
        browserWindowsPage.clickNewWindow();
        SamplePage samplePage = browserWindowsPage.clickNewWindow();

        Selenide.webdriver().driver().switchTo().window(0);
        Selenide.webdriver().driver().switchTo().window(2);

        Assertions.assertEquals(3, Selenide.webdriver()
                .driver()
                .getWebDriver()
                .getWindowHandles().size());
        Assertions.assertEquals("https://demoqa.com/sample", Selenide.webdriver()
                .driver()
                .getWebDriver()
                .getCurrentUrl());
        Assertions.assertEquals("This is a sample page", samplePage.getPageName());
    }

    @Test
    public void testNewWindowMessage() {
        sublistPage
                .clickBrowserWindowsBtn()
                .clickNewWindowMessageBtn();

        Assertions.assertEquals(Selenide.webdriver()
                .driver()
                .getWebDriver()
                .getWindowHandles().size(), 2);
    }


}
