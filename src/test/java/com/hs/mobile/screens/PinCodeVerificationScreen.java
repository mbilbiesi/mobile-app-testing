package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PinCodeVerificationScreen extends AbstractScreen {
    public PinCodeVerificationScreen(AppiumDriver driver, TouchAction touchAction) {
        super(driver, touchAction);
    }

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/state_description")
    private MobileElement eleCustomerPhoneNumber;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/edt_verification_number")
    private MobileElement txtVerificationCode;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/resend_pin")
    private MobileElement lnkResendPin;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/resend_call_pin")
    private MobileElement lnkResendPinCall;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btn_login")
    private MobileElement btnVerifyNumber;

    public boolean isEleCustomerPhoneNumberDisplayed() {
        return eleCustomerPhoneNumber.isDisplayed();
    }

    public boolean isTxtVerificationCodeDisplayed() {
        return txtVerificationCode.isDisplayed();
    }

    public boolean isLnkResendPinDisplayed() {
        return lnkResendPin.isDisplayed();
    }

    public boolean isLnkResendPinCallDisplayed() {
        return lnkResendPinCall.isDisplayed();
    }

    public boolean isBtnVerifyNumberDisplayed() {
        return btnVerifyNumber.isDisplayed();
    }

    public MobileElement getEleCustomerPhoneNumber() {
        return eleCustomerPhoneNumber;
    }

    public MobileElement getTxtVerificationCode() {
        return txtVerificationCode;
    }

    public MobileElement getLnkResendPin() {
        return lnkResendPin;
    }

    public MobileElement getLnkResendPinCall() {
        return lnkResendPinCall;
    }

    public MobileElement getBtnVerifyNumber() {
        return btnVerifyNumber;
    }
}
