package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class VerifyAccountScreen extends AbstractScreen {
    public VerifyAccountScreen(AppiumDriver driver, TouchAction touchAction) {
        super(driver, touchAction);
    }

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/phone_number")
    private MobileElement txtPhoneNumber;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btn_login")
    private MobileElement btnNext;

    public boolean isTxtPhoneNumberDisplayed() {
        return txtPhoneNumber.isDisplayed();
    }

    public boolean isBtnNextDisplayed() {
        return btnNext.isDisplayed();
    }

    public MobileElement getTxtPhoneNumber() {
        return txtPhoneNumber;
    }

    public MobileElement getBtnNext() {
        return btnNext;
    }
}
