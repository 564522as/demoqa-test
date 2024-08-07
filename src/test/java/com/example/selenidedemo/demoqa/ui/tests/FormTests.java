package com.example.selenidedemo.demoqa.ui.tests;

import com.example.selenidedemo.BaseTest;
import com.example.selenidedemo.demoqa.ui.pages.MainPage;
import com.example.selenidedemo.demoqa.ui.pages.forms.FormsSublistPage;
import com.example.selenidedemo.demoqa.ui.pages.forms.SubmitInfoPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FormTests extends BaseTest{
    public final String URL = "https://demoqa.com/";
    private FormsSublistPage formsSublistPage;
    @BeforeEach
    public void open() {
        MainPage mainPage = new MainPage(URL);
        formsSublistPage = mainPage.clickFormsCard();
    }
    @Test
    public void testPracticeForm() {
        SubmitInfoPage submitInfoPage = formsSublistPage.clickPracticeFormEl()
                .inputFirstName("Liza")
                .inputLastName("Katz")
                .inputEmail("test@mail.com")
                .inputMobileNumber("9999999999")
                .clickGenderInputByNumber(1)
                .inputSubjects("Maths")
                .inputSubjects("Arts")
                .clickHobbiesInputByNumber(1)
                .clickHobbiesInputByNumber(0)
                .inputState("NCR")
                .inputCity("Gurgaon")
                .clickSubmit();

        Assertions.assertEquals("Liza Katz", submitInfoPage.getName());
        Assertions.assertEquals("test@mail.com", submitInfoPage.getEmail());
        Assertions.assertEquals("9999999999", submitInfoPage.getMobile());
        Assertions.assertEquals("Maths, Arts", submitInfoPage.getSubjects());
        Assertions.assertEquals("Female", submitInfoPage.getGender());
        Assertions.assertEquals("Reading, Sports", submitInfoPage.getHobbies());
        Assertions.assertEquals("NCR Gurgaon", submitInfoPage.getStateAndCity());
    }
}
