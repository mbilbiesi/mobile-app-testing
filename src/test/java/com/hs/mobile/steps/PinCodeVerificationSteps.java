package com.hs.mobile.steps;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.android.PinCodeVerificationScreen;
import io.qameta.allure.Step;
import lombok.NonNull;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class PinCodeVerificationSteps extends BaseSteps {

  @NonNull
  private final PinCodeVerificationScreen pinCodeVerificationScreen;

  public PinCodeVerificationSteps(@NonNull TestSettings settings) {
    super(settings);
    pinCodeVerificationScreen = new PinCodeVerificationScreen(settings);
  }

  @Step("Make sure that all Pin code verification screen elements are showing up")
  public void verifyThatAllPinCodeVerificationScreenElementsIsDisplayed() {
    verifyScreenElements();
  }

  @Step("Insert Verification Code")
  public void insertVerificationCode(String number) {
    // TODO: Add a step to verify whether the inserted code is valid or not
    pinCodeVerificationScreen.getTxtVerificationCode().sendKeys(number);
  }

  @Step("Click 'Verify Number' button")
  public void clickVerifyNumberButton() {
    touchAction
        .tap(tapOptions().withElement(element(pinCodeVerificationScreen.getBtnVerifyNumber())))
        .perform();
  }
}
