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

  @Override
  @Step("Click on pick up location button in order-anything")
  public void clickFindStore() {
    orderAnythingScreen.lblPickUpLocation().click();
  }

  @Override
  @Step("Assert delivery fees are present for order anything")
  public void verifyDeliveryFeeIsPresent() {
    assertThat(orderAnythingScreen.lblDeliveryFee().isDisplayed())
        .as("Delivery fee is not present")
        .isTrue();
  }

  @Override
  @Step("Click on continue")
  public void clickOnContinue() {
    orderAnythingScreen.btnContinue().click();
  }
}
