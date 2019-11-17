package com.hs.mobile.steps;

import com.hs.mobile.screens.AddReferalCodeScreen;
import com.hs.mobile.screens.VerifyAccountScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.qameta.allure.Step;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class AddReferalCodeSteps extends AddReferalCodeScreen {

    public AddReferalCodeSteps(AppiumDriver driver, TouchAction touchAction) {
        super(driver, touchAction);
    }

    TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);

    @Step("Make sure that all Add Referal Code screen elements are displayed")
    public void verifyThatAllAddReferalCodeScreenElementsIsDisplayed() {
        assertAll(
                () -> assertThat(isBtnCloseDisplayed())
                        .as("Close button is not displayed.").isTrue(),
                () -> assertThat(isImgReferralCodeDisplayed())
                        .as("Referral Code Image is not displayed.").isTrue(),
                () -> assertThat(isLblReferralCodeDisplayed())
                        .as("Referral Code Label is not displayed.").isTrue(),
                () -> assertThat(isTxtReferralCodeDisplayed())
                        .as("Referral Code Text is not displayed.").isTrue(),
                () -> assertThat(isBtnVerifyReferralCodeDisplayed()).as(
                        "Verify Referral Code button is not displayed.").isTrue()
        );
    }

    @Step("Click the Close button")
    public void clickCloseButton() {
        hideKeyboard();
        touchAction.tap(tapOptions().withElement(element(getBtnClose()))).perform();
    }
}
