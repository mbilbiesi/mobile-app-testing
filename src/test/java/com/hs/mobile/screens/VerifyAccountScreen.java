package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;

@Getter
public abstract class VerifyAccountScreen extends AbstractScreen {

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/phone_number")
    private MobileElement txtPhoneNumber;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btn_login")
    private MobileElement btnNext;

    public VerifyAccountScreen(AppiumDriver driver) {
        super(driver);
    }
}
