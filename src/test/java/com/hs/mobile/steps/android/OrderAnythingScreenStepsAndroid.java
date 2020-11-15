package com.hs.mobile.steps.android;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.android.OrderAnythingScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.OrderAnythingScreenSteps;
import io.qameta.allure.Step;
import lombok.NonNull;

public class OrderAnythingScreenStepsAndroid extends BaseSteps<OrderAnythingScreenStepsAndroid>
    implements OrderAnythingScreenSteps {

  @NonNull private final OrderAnythingScreen orderAnythingScreen;

  public OrderAnythingScreenStepsAndroid(@NonNull TestSettings testSettings) {
    super(testSettings);
    orderAnythingScreen = new OrderAnythingScreen(testSettings);
  }

  @Override
  @Step("verify user navigated to 'OrderAnything' vertical's screen")
  public void verifyOrderAnythingVerticalIsAppeared() {
    assertThat(orderAnythingScreen.lblPickUpLocation().isDisplayed())
        .as("Order-anything page is not displayed")
        .isTrue();
  }
}
