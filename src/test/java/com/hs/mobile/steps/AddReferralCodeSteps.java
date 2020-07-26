package com.hs.mobile.steps;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.android.AddReferralCodeScreen;
import io.qameta.allure.Step;
import lombok.NonNull;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class AddReferralCodeSteps extends BaseSteps {

  @NonNull
  private AddReferralCodeScreen addReferralCodeScreen;

  public AddReferralCodeSteps(@NonNull TestSettings settings) {
    super(settings);
  }

  @Step("Make sure that all Add Referral Code screen elements are displayed")
  public void verifyThatAllAddReferralCodeScreenElementsIsDisplayed() {
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
