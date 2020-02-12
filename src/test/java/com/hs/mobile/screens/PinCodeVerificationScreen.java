package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class PinCodeVerificationScreen extends AbstractScreen {

    //@iOSXCUITFindBy(id = "test")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/state_description")
    private MobileElement eleCustomerPhoneNumber;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField'")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/edt_verification_number")
    private MobileElement txtVerificationCode;

    //@iOSXCUITFindBy(id = "test")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/resend_pin")
    private MobileElement lnkResendPin;

    //@iOSXCUITFindBy(id = "test")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/resend_call_pin")
    private MobileElement lnkResendPinCall;

    //@iOSXCUITFindBy(id = "test")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btn_login")
    private MobileElement btnVerifyNumber;

    public PinCodeVerificationScreen(AppiumDriver driver) {
        super(driver);
    }

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
        SoftAssertions soft = new SoftAssertions();
        soft.assertThat(isEleCustomerPhoneNumberDisplayed())
                .as("Customer's mobile number is not displayed.")
                .isTrue();
        soft.assertThat(isTxtVerificationCodeDisplayed())
                .as("Verification code text box is not displayed.")
                .isTrue();
        soft.assertThat(isLnkResendPinDisplayed()).as("Resend Pin link is not displayed.").isTrue();
        soft.assertThat(isLnkResendPinCallDisplayed())
                .as("Call to Resend Pin link is not displayed.")
                .isTrue();
        soft.assertThat(isBtnVerifyNumberDisplayed())
                .as("Verify My Number button is not displayed.")
                .isTrue();
        soft.assertAll();
    }

    @Step("Insert Verification Code")
    public void insertVerificationCode(String number) {
        // TODO: Add a step to verify whether the inserted code is valid or not
        getVerificationCode().sendKeys(number);
    }

    @Step("Click 'Verify Number' button")
    public void clickVerifyNumberButton() {
        touchAction.tap(tapOptions().withElement(element(getVerifyNumberButton()))).perform();
    }
}
