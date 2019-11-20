package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PinCodeVerificationScreen extends AbstractScreen {
    public PinCodeVerificationScreen(AppiumDriver driver, TouchAction touchAction) {
        super(driver, touchAction);
    }

    TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);

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

    public MobileElement getCustomerPhoneNumber() {
        return eleCustomerPhoneNumber;
    }

    public MobileElement getVerificationCode() {
        return txtVerificationCode;
    }

    public MobileElement getResendPin() {
        return lnkResendPin;
    }

    public MobileElement getResendPinCall() {
        return lnkResendPinCall;
    }

    public MobileElement getVerifyNumberButton() {
        return btnVerifyNumber;
    }

    @Step("Make sure that all Pin code verification screen elements are showing up")
    public void verifyThatAllPinCodeVerificationScreenElementsIsDisplayed() {
        assertAll(
                () -> assertThat(isEleCustomerPhoneNumberDisplayed())
                        .as("Customer's mobile number is not displayed.").isTrue(),
                () -> assertThat(isTxtVerificationCodeDisplayed()).as(
                        "Verification code text box is not displayed.").isTrue(),
                () -> assertThat(isLnkResendPinDisplayed()).as(
                        "Resend Pin link is not displayed.").isTrue(),
                () -> assertThat(isLnkResendPinCallDisplayed()).as(
                        "Call to Resend Pin link is not displayed.").isTrue(),
                () -> assertThat(isBtnVerifyNumberDisplayed()).as(
                        "Verify My Number button is not displayed.").isTrue()
        );
    }

    @Step("Insert Verification Code")
    public void insertVerificationCode(String number) {
        //TODO: Add a step to verify whether the inserted code is valid or not
        getVerificationCode().sendKeys(number);
    }

    @Step("Click \"Verify Number\" button")
    public void clickVerifyNumberButton() {
        touchAction.tap(tapOptions().withElement(element(getVerifyNumberButton()))).perform();
    }
}