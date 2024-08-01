package com.example.selenidedemo.demoqa.ui.tests;

import com.example.selenidedemo.BaseTest;
import com.example.selenidedemo.demoqa.ui.pages.MainPage;
import com.example.selenidedemo.demoqa.ui.pages.elements.CheckBoxPage;
import com.example.selenidedemo.demoqa.ui.pages.elements.ElementsSublistPage;
import com.example.selenidedemo.demoqa.ui.pages.elements.TextBoxPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ElementsTest extends BaseTest {
    public final String URL = "https://demoqa.com";
    public final String FULL_NAME = "Bob";
    public final String EMAIL = "some@mail.com";
    public final String CURRENT_ADDRESS = "Moscow";
    public final String PERMANENT_ADDRESS = "Samara";
    private ElementsSublistPage elementsSublistPage;
    @BeforeEach
    public void openElementsPage() {
        MainPage mainPage = new MainPage(URL);
        mainPage.clickElementsCard();
        elementsSublistPage = new ElementsSublistPage();
    }
    @Test
    public void testTextBox() {
        TextBoxPage textBoxPage = elementsSublistPage
                .clickTextBox()
                .setNameValue(FULL_NAME)
                .setEmailValue(EMAIL)
                .setCurrentAddressValue(CURRENT_ADDRESS)
                .setPermanentAddressValue(PERMANENT_ADDRESS)
                .clickSubmit();
        Assertions.assertEquals(FULL_NAME, textBoxPage.getNameMessage());
        Assertions.assertEquals(EMAIL, textBoxPage.getEmailMessage());
        Assertions.assertEquals(CURRENT_ADDRESS, textBoxPage.getCurrentAddressMessage());
        Assertions.assertEquals(PERMANENT_ADDRESS, textBoxPage.getPermanentAddressMessage());
    }
    @Test
    public void testTextBoxWithWrongEmail() {
        TextBoxPage textBoxPage = elementsSublistPage
                .clickTextBox()
                .setNameValue(FULL_NAME)
                .setEmailValue("ert")
                .setCurrentAddressValue(CURRENT_ADDRESS)
                .setPermanentAddressValue(PERMANENT_ADDRESS)
                .clickSubmit();
        Assertions.assertTrue(textBoxPage.isEmailFieldHasError());
    }
    @Test
    public void testHomeCheckboxClickResult() {
        CheckBoxPage checkBoxPage = elementsSublistPage
                .clickCheckBox()
                .clickHomeCheckbox();
        boolean result = checkBoxPage.getResult().contains("home\n" +
                "desktop\n" +
                "notes\n" +
                "commands\n" +
                "documents\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu\n" +
                "office\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general\n" +
                "downloads\n" +
                "wordFile\n" +
                "excelFile");
        Assertions.assertTrue(result);
    }
    @Test
    public void testIconClassAfterHomeCheckboxClicked() {
        CheckBoxPage checkBoxPage = elementsSublistPage
                .clickCheckBox()
                .clickHomeCheckbox();
        Assertions.assertTrue(checkBoxPage.isHomeSelectedIconHasClass());
    }
    @Test
    public void testHomeToggleBtn() {
        CheckBoxPage checkBoxPage = elementsSublistPage
                .clickCheckBox()
                .clickHomeToggleBtn();
        Assertions.assertTrue(checkBoxPage.isHomeItemsAppeared());
    }
    @Test
    public void testDocumentCheckBox() {
        CheckBoxPage checkBoxPage = elementsSublistPage
                .clickCheckBox()
                .clickHomeToggleBtn()
                .clickDocumentCheckbox()
                .clickDocumentToggleBtn();
        Assertions.assertTrue(checkBoxPage.isDocumentItemIconHasCheckedClass());
    }

    @Test
    public void testWorkSpaceCheckBox() {
        CheckBoxPage checkBoxPage = elementsSublistPage
                .clickCheckBox()
                .clickHomeToggleBtn()
                .clickDocumentCheckbox()
                .clickDocumentToggleBtn()
                .clickWorkSpaceToggleBtn();
        Assertions.assertTrue(checkBoxPage.isWordSpaceItemIconHasCheckedClass());
    }

    @Test
    public void testWorkSpaceItemsClick() {
        CheckBoxPage checkBoxPage = elementsSublistPage
                .clickCheckBox()
                .clickHomeToggleBtn()
                .clickDocumentCheckbox()
                .clickDocumentToggleBtn()
                .clickWorkSpaceToggleBtn()
                .click2WorkSpaceItems();
        Assertions.assertTrue(checkBoxPage.getResult().contains("angular\n" +
                "office\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general"));
    }
}
