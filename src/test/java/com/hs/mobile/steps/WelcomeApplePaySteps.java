package com.hs.mobile.steps;

import com.hs.mobile.screens.WelcomeApplePayIosScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lombok.NonNull;

public class WelcomeApplePaySteps extends BaseSteps {
    @NonNull
    private HomeScreenSteps homeScreen;
    @NonNull
    private WelcomeApplePayIosScreen iosWelcomeScreen;

  public WelcomeApplePaySteps(AppiumDriver driver, String language) {
    super(driver);
    homeScreen = new HomeScreenSteps(driver, language);
    iosWelcomeScreen = new WelcomeApplePayIosScreen(driver);
  }

  @Step("Click Later")
  public void skipApplePay() {
    tap(iosWelcomeScreen.getBtnSkipApplePay());
    homeScreen.waitUntilHomescreenIsLoaded();
  }
}
