package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class HomeScreenSideMenu extends AbstractScreen {
    //@iOSXCUITFindBy(id = "test")
    @AndroidFindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[@index='2']")
    private WebElement profile;

    //@iOSXCUITFindBy(id = "test")
    @AndroidFindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[@index='3']")
    private WebElement invoices;

    //@iOSXCUITFindBy(id = "test")
    @AndroidFindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[@index='4']")
    private WebElement paymentOptions;

    //@iOSXCUITFindBy(id = "test")
    @AndroidFindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[@index='6']")
    private WebElement settings;

    public HomeScreenSideMenu(AppiumDriver driver) {
        super(driver);
    }

    @Step("Go to profile screen")
    public void goToProfile() {
        tap(profile);
    }

    @Step("Go to profile screen")
    public void goToInvoices() {
        tap(invoices);
    }

    @Step("Go to settings screen")
    public void goToSettings() {
        tap(settings);
    }

    @Step("Go to payment options screen")
    public void goToPaymentOptions() {
        tap(paymentOptions);
    }
}
