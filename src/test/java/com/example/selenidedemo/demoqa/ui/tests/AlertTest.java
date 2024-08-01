package com.example.selenidedemo.demoqa.ui.tests;

import com.codeborne.selenide.Driver;
import com.codeborne.selenide.Selenide;
import com.example.selenidedemo.demoqa.ui.pages.MainPage;
import com.example.selenidedemo.demoqa.ui.pages.frameswindows.AlertsPage;
import com.example.selenidedemo.demoqa.ui.pages.frameswindows.SublistPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertTest extends BaseTest {
    public final String URL = "https://demoqa.com";
    private SublistPage sublistPage;
    @BeforeEach
    public void openPage() {
        MainPage mainPage = new MainPage(URL);
        sublistPage = mainPage.clickFrameWindowsCard();
    }

    @Test
    public void testAlertBtn() {
        AlertsPage alertsPage = sublistPage.clickAlertsBtn();
        alertsPage.clickShowAlertBtn();
        Alert alert = Selenide
                .webdriver().driver().getWebDriver()
                .switchTo()
                .alert();
        Assertions.assertEquals("You clicked a button", alert.getText());
        alert.accept();
        Selenide.sleep(5000);
    }

    @Test
    public void testAlertLaterNotAppearBefore() {
        Driver driver = Selenide.webdriver().driver();
        AlertsPage alertsPage = sublistPage.clickAlertsBtn();

        alertsPage.clickShowAlertLaterBtn();
        Assertions.assertNull(
                ExpectedConditions.alertIsPresent().apply(driver.getWebDriver()));
    }

    @Test
    public void testAlertLaterAppearAfter5Seconds() {
        Driver driver = Selenide.webdriver().driver();
        AlertsPage alertsPage = sublistPage.clickAlertsBtn();

        alertsPage.clickShowAlertLaterBtn();
        new WebDriverWait(driver.getWebDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
        Assertions.assertNotNull(ExpectedConditions.alertIsPresent().apply(driver.getWebDriver()));
        Assertions.assertEquals("This alert appeared after 5 seconds",
                driver.switchTo().alert().getText());
    }

    @Test
    public void testAcceptConfirmAlertBtn() {
        Driver driver = Selenide.webdriver().driver();
        AlertsPage alertsPage = sublistPage
                .clickAlertsBtn()
                .clickShowConfirmAlertBtn();

        driver.switchTo().alert().accept();
        Assertions.assertEquals("You selected Ok", alertsPage.getSelectConfirmAlertInfo());
    }
    @Test
    public void testDismissConfirmAlertBtn() {
        Driver driver = Selenide.webdriver().driver();
        AlertsPage alertsPage = sublistPage
                .clickAlertsBtn()
                .clickShowConfirmAlertBtn();

        driver.switchTo().alert().dismiss();
        Assertions.assertEquals("You selected Cancel", alertsPage.getSelectConfirmAlertInfo());
    }

    @Test
    public void testPromptAlert() {
        Driver driver = Selenide.webdriver().driver();
        AlertsPage alertsPage = sublistPage
                .clickAlertsBtn()
                .clickShowPromptAlertBtn();

        driver.switchTo().alert().sendKeys("Name");
        Assertions.assertEquals("You entered Name", alertsPage.getPromptAlertInfo());
    }
}
