package com.hs.mobile.steps;

import com.hs.mobile.screens.AddReferralCodeScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lombok.NonNull;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class AddReferralCodeSteps extends BaseSteps {
    @NonNull
    private AddReferralCodeScreen addReferralCodeScreen;

    public AddReferralCodeSteps(AppiumDriver driver) {
        super(driver);
    }

    @Step("Make sure that all Add Referal Code screen elements are displayed")
    public void verifyThatAllAddReferalCodeScreenElementsIsDisplayed() {
        verifyScreenElements();
    }

    @Step("Click the Close button")
    public void clickCloseButton() {
        hideKeyboard();
        touchAction
                .tap(tapOptions().withElement(element(addReferralCodeScreen.getBtnClose())))
                .perform();
    }
}
