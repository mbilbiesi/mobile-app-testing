package com.hs.mobile.steps.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.android.LandingScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.LandingScreenSteps;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import lombok.NonNull;

public class LandingScreenStepsAndroid extends BaseSteps<LandingScreenStepsAndroid>
    implements LandingScreenSteps {

  @NonNull private final LandingScreen landingScreen;
  @NonNull private final AppiumDriver<MobileElement> driver;

  public LandingScreenStepsAndroid(@NonNull TestSettings testSettings) {
    super(testSettings);
    landingScreen = new LandingScreen(testSettings);
    driver = testSettings.getDriver();
  }

  @Override
  public void handleLocationPopup() {}

  @Step("click on 'Select' to choose new address")
  public void selectNewAddress() {
    tap(landingScreen.getLblDelivery());
  }
}
