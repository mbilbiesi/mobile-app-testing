package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;


public class HomeScreenSideMenu extends AbstractScreen {
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[@index='2']")
    private WebElement profile;
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[@index='3']")
    private WebElement invoices;

    public HomeScreenSideMenu(AppiumDriver driver) {
        super(driver);
    }

    @Step("Go to profile page")
    public void goToProfile() {
        tap(profile);
    }

    @Step("Go to profile page")
    public void goToInvoices() {
        tap(invoices);
    }
}