package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;

@Getter
public class PinCodeVerificationScreen extends AbstractScreen {

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

    public PinCodeVerificationScreen(AppiumDriver driver) {
        super(driver);
    }
}
