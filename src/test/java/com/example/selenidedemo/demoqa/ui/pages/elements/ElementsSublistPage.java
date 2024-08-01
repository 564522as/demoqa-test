package com.example.selenidedemo.demoqa.ui.pages.elements;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selenide.*;

public class ElementsSublistPage {
    private final SelenideElement textBoxBtn = $x("//div[@class='element-group'][1]//li[1]");
    private final SelenideElement checkBoxBtn = $x("//div[@class='element-group'][1]//li[2]");
    private final SelenideElement radioBtn = $x("//div[@class='element-group'][1]//li[3]");
    private final SelenideElement webTablesBtn = $x("//div[@class='element-group'][1]//li[4]");
    private final SelenideElement buttons = $x("//div[@class='element-group'][1]//li[5]");
    private final SelenideElement linksBtn = $x("//div[@class='element-group'][1]//li[6]");
    private SelenideElement brokenLinksBtn = $x("//div[@class='element-group'][1]//li[7]");
    private final SelenideElement uploadDownloadBtn = $x("//div[@class='element-group'][1]//li[8]");
    private final SelenideElement dynamicPropsBtn = $x("//div[@class='element-group'][1]//li[9]");
    public ElementsSublistPage() {

    }
    public TextBoxPage clickTextBox() {
        clickByJs(textBoxBtn);
        return new TextBoxPage();
    }
    public CheckBoxPage clickCheckBox() {
        clickByJs(checkBoxBtn);
        return new CheckBoxPage();
    }
    public void clickRadioBtn() {
        clickByJs(radioBtn);
    }
    public void clickWebTablesBtn() {
        clickByJs(webTablesBtn);
    }
    public void clickButtons() {
        clickByJs(buttons);
    }
    public void clickLinksBtn() {
        clickByJs(linksBtn);
    }
    public void clickBrokenLinksBtn() {
        clickByJs(brokenLinksBtn);
    }
    public void clickUploadDownloadBtn() {
        clickByJs(uploadDownloadBtn);
    }
    public void clickDynamicPropsBtn() {
        clickByJs(dynamicPropsBtn);
    }

    public static void clickByJs(SelenideElement selenideElement) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Selenide.webdriver().object();
        Selenide.webdriver().driver().executeJavaScript("arguments[0].click()", selenideElement);
    }
}
