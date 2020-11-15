package com.hs.mobile.steps.ios;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.ios.OrderAnythingScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.OrderAnythingScreenSteps;
import io.qameta.allure.Step;
import lombok.NonNull;

public class OrderAnythingStepsIOS extends BaseSteps<OrderAnythingStepsIOS>
    implements OrderAnythingScreenSteps {

  @NonNull private final OrderAnythingScreen orderAnythingScreen;

  public OrderAnythingStepsIOS(@NonNull TestSettings testSettings) {
    super(testSettings);
    orderAnythingScreen = new OrderAnythingScreen(testSettings);
  }

  @Override
  @Step("verify user navigated to 'OrderAnything' vertical's screen")
  public void verifyOrderAnythingVerticalIsAppeared() {
    assertThat(orderAnythingScreen.lblShopFrom().isDisplayed())
        .as("Order anything screen is not displayed")
        .isTrue();
  }
}
