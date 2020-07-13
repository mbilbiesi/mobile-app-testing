package com.hs.mobile.steps;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.WelcomeApplePayIosScreen;
import io.qameta.allure.Step;
import lombok.NonNull;

public class WelcomeApplePaySteps extends BaseSteps {

  @NonNull
  private final HomeScreenSteps homeScreen;
  @NonNull
  private final WelcomeApplePayIosScreen iosWelcomeScreen;

  public WelcomeApplePaySteps(@NonNull TestSettings settings) {
    super(settings);
    homeScreen = new HomeScreenSteps(settings);
    iosWelcomeScreen = new WelcomeApplePayIosScreen(settings);
  }

  @Step("Click Later")
  public void skipApplePay() {
    tap(iosWelcomeScreen.getBtnSkipApplePay());
    homeScreen.waitUntilHomeScreenIsLoaded();
  }
}
