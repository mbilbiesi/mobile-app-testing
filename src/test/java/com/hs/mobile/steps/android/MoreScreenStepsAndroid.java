package com.hs.mobile.steps.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.android.MoreScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.MoreScreenSteps;
import io.qameta.allure.Step;
import lombok.NonNull;

public class MoreScreenStepsAndroid extends BaseSteps<MoreScreenStepsAndroid>
    implements MoreScreenSteps {

  @NonNull private final MoreScreen moreScreen;

  public MoreScreenStepsAndroid(@NonNull TestSettings settings) {
    super(settings);
    moreScreen = new MoreScreen(settings);
  }

  @Override
  @Step("click on slide 'Login'")
  public void clickOnLogin() {
    moreScreen.getBtnSlideLogin().click();
  }

  @Override
  public void clickOnHome() {}

  @Override
  @Step("Click on payment options")
  public void clickOnPaymentOptions() {
    moreScreen.getBtnSlidePaymentOptions().click();
  }
}
