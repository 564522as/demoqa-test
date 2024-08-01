package com.example.selenidedemo.demoqa.ui.pages.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Exist;

import static com.codeborne.selenide.Selenide.*;

public class CheckBoxPage {
    public final SelenideElement homeCheckbox = $x("//*[@id='tree-node-home']");
    public final SelenideElement resultElement = $x("//div[@id='result']");
    public final SelenideElement homeSelectIcon = $("#tree-node > ol > li > span > label > span.rct-checkbox > svg");
    public final SelenideElement homeToggleBtn = $x("//*[@id=\"tree-node\"]/ol/li/span/button");
    private final SelenideElement desktopCheckbox = $x("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/label");
    private final SelenideElement documentCheckbox = $x("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/label");
    private final SelenideElement downloadsCheckbox = $x("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/label");
    private final SelenideElement documentToggleBtn = $x("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/button");
    private final SelenideElement workSpaceToggleBtn = $x("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/span/button");
    private final ElementsCollection documentsItemIcons = $$x("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li/span/label/span[1]/*[local-name()='svg']");
    private final ElementsCollection workSpaceItemIcons = $$x("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/ol/li/span/label/span[1]/*[local-name()='svg']");
    private final ElementsCollection workSpaceItems = $$x("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/ol/li/span/label");
    public CheckBoxPage clickHomeCheckbox() {
        ElementsSublistPage.clickByJs(homeCheckbox);
        return this;
    }

    public String getResult() {
        return resultElement.getText();
    }

    public boolean isHomeSelectedIconHasClass() {
        return homeSelectIcon.getAttribute("class").contains("rct-icon-check");
    }

    public CheckBoxPage clickHomeToggleBtn() {
        ElementsSublistPage.clickByJs(homeToggleBtn);
        return this;
    }

    public CheckBoxPage clickDesktopCheckBox() {
        ElementsSublistPage.clickByJs(desktopCheckbox);
        return this;
    }

    public boolean isHomeItemsAppeared() {
        return desktopCheckbox.is(new Exist())
                && documentCheckbox.is(new Exist())
                && downloadsCheckbox.is(new Exist());
    }

    public CheckBoxPage clickDocumentCheckbox() {
        documentCheckbox.click();
        return this;
    }

    public CheckBoxPage clickDocumentToggleBtn() {
        documentToggleBtn.click();
        return this;
    }

    public CheckBoxPage clickWorkSpaceToggleBtn() {
        workSpaceToggleBtn.click();
        return this;
    }

    public CheckBoxPage click2WorkSpaceItems() {
        workSpaceItems.get(0).click();
        workSpaceItems.get(2).click();
        return this;
    }

    public boolean isDocumentItemIconHasCheckedClass() {
        for (SelenideElement element: documentsItemIcons)
            if (!element.attr("class").contains("rct-icon-check"))
                return false;
        return true;
    }

    public boolean isWordSpaceItemIconHasCheckedClass() {
        for (SelenideElement element: workSpaceItemIcons)
            if (!element.attr("class").contains("rct-icon-check"))
                return false;
        return true;
    }

}
