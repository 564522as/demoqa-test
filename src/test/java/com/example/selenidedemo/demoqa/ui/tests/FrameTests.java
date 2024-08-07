package com.example.selenidedemo.demoqa.ui.tests;

import com.codeborne.selenide.Driver;
import com.codeborne.selenide.Selenide;
import com.example.selenidedemo.BaseTest;
import com.example.selenidedemo.demoqa.ui.pages.MainPage;
import com.example.selenidedemo.demoqa.ui.pages.frameswindows.FramesPage;
import com.example.selenidedemo.demoqa.ui.pages.frameswindows.ModalDialogsPage;
import com.example.selenidedemo.demoqa.ui.pages.frameswindows.NestedFramesPage;
import com.example.selenidedemo.demoqa.ui.pages.frameswindows.SublistPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;

public class FrameTests extends BaseTest {
    public final String URL = "https://demoqa.com";
    private SublistPage sublistPage;
    @BeforeEach
    public void openPage() {
        MainPage mainPage = new MainPage(URL);
        sublistPage = mainPage.clickFrameWindowsCard();
    }

    @Test
    public void testBigIframe() {
        FramesPage framesPage = sublistPage.clickFramesBtn();
        Driver driver = Selenide.webdriver().driver();
        driver.switchTo().frame(framesPage.getFrame1());
        String frameHeader = $x("//*[@id=\"sampleHeading\"]").getText();
        Assertions.assertEquals("This is a sample page", frameHeader);
    }
    @Test
    public void testLittleIframe() {
        FramesPage framesPage = sublistPage.clickFramesBtn();
        Driver driver = Selenide.webdriver().driver();
        driver.switchTo().frame(framesPage.getFrame2());
        String frameHeader = $x("//*[@id=\"sampleHeading\"]").getText();
        Assertions.assertEquals("This is a sample page", frameHeader);
    }

    @Test
    public void testParentFrame() {
        NestedFramesPage nestedFramesPage = sublistPage.clickNestedFramesBtn();
        Driver driver = Selenide.webdriver().driver();
        driver.switchTo().frame(nestedFramesPage.getParentFrame());
        String frameHeader = $x("/html/body").getText();
        Assertions.assertEquals("Parent frame", frameHeader);
    }
    @Test
    public void testChildFrame() {
        NestedFramesPage nestedFramesPage = sublistPage.clickNestedFramesBtn();
        Driver driver = Selenide.webdriver().driver();
        driver.switchTo().frame(nestedFramesPage.getParentFrame());
        driver.switchTo().frame(nestedFramesPage.getChildFrame());
        String frameHeader = $x("/html/body/p").getText();
        Assertions.assertEquals("Child Iframe", frameHeader);
    }
    @Test
    public void testSmallModal() {
        ModalDialogsPage modalDialogsPage = sublistPage.clickModalDialogsBtn();
        modalDialogsPage.clickSmallModalBtn();
        String text = modalDialogsPage.getModalTxt();
        Assertions.assertEquals("This is a small modal. It has very less content", text);
        modalDialogsPage.closeModal();
    }
    @Test
    public void testBigModal() {
        ModalDialogsPage modalDialogsPage = sublistPage.clickModalDialogsBtn();
        modalDialogsPage.clickBigModalBtn();
        String text = modalDialogsPage.getModalTxt();
        Assertions.assertEquals("Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                "when an unknown printer took a galley of type and scrambled it to make a type specimen book. " +
                "It has survived not only five centuries, but also the leap into electronic typesetting, " +
                "remaining essentially unchanged. It was popularised in the 1960s with the release of " +
                "Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like " +
                "Aldus PageMaker including versions of Lorem Ipsum.", text);
        modalDialogsPage.closeModal();
    }
}
