package com.example.selenidedemo.demoqa.ui.pages.forms;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.example.selenidedemo.demoqa.ui.pages.elements.ElementsSublistPage;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class PracticeFormPage {
    private final SelenideElement firstNameInput = $x("//*[@id=\"firstName\"]");
    private final SelenideElement lastNameInput = $x("//*[@id=\"lastName\"]");
    private final SelenideElement emailInput = $x("//*[@id=\"userEmail\"]");
    private final ElementsCollection genderInputs = $$x("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[3]/div[2]/div/input");
    private final ElementsCollection hobbiesInput = $$x("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[7]/div[2]/div/input");
    private final SelenideElement mobileNumberInput = $x("//*[@id=\"userNumber\"]");
    private final SelenideElement dateOfBirthInput = $x("//*[@id=\"dateOfBirthInput\"]");
    private final SelenideElement subjectsInput = $x("//*[@id=\"subjectsInput\"]");
    private final SelenideElement stateInput = $x("//*[@id=\"react-select-3-input\"]");
    private final SelenideElement cityInput = $x("//*[@id=\"react-select-4-input\"]");
    private final SelenideElement submitBtn = $x("//*[@id=\"submit\"]");
    public PracticeFormPage inputFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }
    public PracticeFormPage inputLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }
    public PracticeFormPage inputEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }
    public PracticeFormPage clickGenderInputByNumber(int number) {
        ElementsSublistPage.clickByJs(genderInputs.get(number));
        return this;
    }
    public PracticeFormPage inputMobileNumber(String mobileNumber) {
        mobileNumberInput.sendKeys(mobileNumber);
        return this;
    }
    public PracticeFormPage clickDateOfBirthInput() {
        ElementsSublistPage.clickByJs(dateOfBirthInput);
        return this;
    }
    public PracticeFormPage inputSubjects(String subject) {
        subjectsInput.sendKeys(subject);
        subjectsInput.pressEnter();
        return this;
    }
    public PracticeFormPage clickHobbiesInputByNumber(int number) {
        ElementsSublistPage.clickByJs(hobbiesInput.get(number));
        return this;
    }
    public PracticeFormPage inputState(String state) {
        stateInput.sendKeys(state);
        stateInput.pressEnter();
        return this;
    }
    public PracticeFormPage inputCity(String city) {
        cityInput.sendKeys(city);
        cityInput.pressEnter();
        return this;
    }
    public SubmitInfoPage clickSubmit() {
        submitBtn.click();
        return new SubmitInfoPage();
    }

}
