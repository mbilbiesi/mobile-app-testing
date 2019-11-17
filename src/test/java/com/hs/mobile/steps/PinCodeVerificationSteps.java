package com.hs.mobile.steps;

import com.hs.mobile.screens.PinCodeVerificationScreen;
import com.hs.mobile.screens.VerifyAccountScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.qameta.allure.Step;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PinCodeVerificationSteps extends PinCodeVerificationScreen {

    public PinCodeVerificationSteps(AppiumDriver driver, TouchAction touchAction) {
        super(driver, touchAction);
    }

    TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);

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
        getTxtVerificationCode().sendKeys(number);
    }

    @Step("Click \"Verify Number\" button")
    public void clickVerifyNumberButton() {
        touchAction.tap(tapOptions().withElement(element(getBtnVerifyNumber()))).perform();
    }
}
