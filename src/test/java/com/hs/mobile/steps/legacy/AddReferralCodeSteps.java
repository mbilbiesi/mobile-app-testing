package com.hs.mobile.steps.legacy;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.android.AddReferralCodeScreen;
import com.hs.mobile.steps.BaseSteps;
import io.qameta.allure.Step;
import lombok.NonNull;

public class AddReferralCodeSteps extends BaseSteps {

  @NonNull private AddReferralCodeScreen addReferralCodeScreen;

  public AddReferralCodeSteps(@NonNull TestSettings settings) {
    super(settings);
    addReferralCodeScreen = new AddReferralCodeScreen(settings);
  }

  @Step("Make sure that all Add Referral Code screen elements are displayed")
  public void verifyThatAllAddReferralCodeScreenElementsIsDisplayed() {
    verifyScreenElements(addReferralCodeScreen);
  }

  @Step("Click the Close button")
  public void clickCloseButton() {
    hideKeyboard();
    touchAction
        .tap(tapOptions().withElement(element(addReferralCodeScreen.getBtnClose())))
        .perform();
  }
}
