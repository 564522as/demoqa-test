package com.example.selenidedemo.demoqa.ui.pages.frameswindows;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ModalDialogsPage {
    private final SelenideElement smallModalBtn = $x("//*[@id=\"showSmallModal\"]");
    private final SelenideElement bigModalBtn = $x("//*[@id=\"showLargeModal\"]");
    private final SelenideElement modalTxt = $("body > div.fade.modal.show > div > div > div.modal-body");
    private final SelenideElement closeModal = $x("//button[contains(text(),'Close')]");
    public void clickSmallModalBtn() {
        smallModalBtn.click();
    }
    public void clickBigModalBtn() {
        bigModalBtn.click();
    }
    public String getModalTxt() {
        return modalTxt.getText();
    }
    public void closeModal() {
        closeModal.click();
    }
}
