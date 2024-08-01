package com.example.selenidedemo.demoqa.ui.pages.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class TextBoxPage {
    private final SelenideElement nameField = $x("//input[@id='userName']");
    private final SelenideElement emailField = $x("//input[@id='userEmail']");
    private final SelenideElement currentAddressField = $x("//textarea[@id='currentAddress']");
    private final SelenideElement permanentAddressField = $x("//textarea[@id='permanentAddress']");
    private final SelenideElement submitBtn = $x("//button[@id='submit']");
    private final ElementsCollection messageValues = $$x("//div[@id='output']/div/p");
    public TextBoxPage setNameValue(String value) {
        nameField.setValue(value);
        return this;
    }
    public TextBoxPage setEmailValue(String value) {
        emailField.setValue(value);
        return this;
    }
    public TextBoxPage setCurrentAddressValue(String value) {
        currentAddressField.setValue(value);
        return this;
    }
    public TextBoxPage setPermanentAddressValue(String value) {
        permanentAddressField.setValue(value);
        return this;
    }
    public TextBoxPage clickSubmit() {
        ElementsSublistPage.clickByJs(submitBtn);
        return this;
    }
    public String getNameMessage() {
        return messageValues.first().getText().split(":")[1];
    }
    public String getEmailMessage() {
        return messageValues.get(1).getText().split(":")[1];
    }
    public String getCurrentAddressMessage() {
        return messageValues.get(2).getText().split(":")[1];
    }
    public String getPermanentAddressMessage() {
        return messageValues.get(3).getText().split(":")[1];
    }
    public boolean isEmailFieldHasError() {
        return emailField.getAttribute("class").contains("field-error");
    }
}
