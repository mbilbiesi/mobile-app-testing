package com.hs.mobile.steps;

import com.hs.mobile.screens.WelcomeApplePayIosScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lombok.NonNull;

public class WelcomeApplePaySteps extends BaseSteps {
  @NonNull HomeScreenSteps homeScreen;
  @NonNull WelcomeApplePayIosScreen iosWelcomeScreen;

  public WelcomeApplePaySteps(AppiumDriver driver) {
    super(driver);
    homeScreen = new HomeScreenSteps(driver);
    iosWelcomeScreen = new WelcomeApplePayIosScreen(driver);
  }

  @Step("Click Later")
  public void skipApplePay() {
    tap(iosWelcomeScreen.getBtnSkipApplePay());
    homeScreen.waitUntilHomescreenIsLoaded();
  }
}
