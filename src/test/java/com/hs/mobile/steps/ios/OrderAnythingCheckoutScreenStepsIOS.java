package com.hs.mobile.steps.ios;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.ios.OrderAnythingCheckoutScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.OrderAnythingCheckoutScreenSteps;
import io.qameta.allure.Step;
import lombok.NonNull;

public class OrderAnythingCheckoutScreenStepsIOS
    extends BaseSteps<OrderAnythingCheckoutScreenStepsIOS>
    implements OrderAnythingCheckoutScreenSteps {

  @NonNull private final OrderAnythingCheckoutScreen orderAnythingCheckoutScreen;

  public OrderAnythingCheckoutScreenStepsIOS(@NonNull TestSettings settings) {
    super(settings);
    orderAnythingCheckoutScreen = new OrderAnythingCheckoutScreen(settings);
  }

  @Override
  @Step("Verify order anything delivery is submitted")
  public void verifyDeliveryIsSubmitted() {
    assertThat(orderAnythingCheckoutScreen.getLblOrderSent().isDisplayed())
        .as("Order anything delivery is not sent")
        .isTrue();
  }

  @Override
  @Step("Verify personal shopper label is displayed")
  public void verifyPersonalShopperDelivery() {
    assertThat(orderAnythingCheckoutScreen.getLblPersonalShopper().isDisplayed())
        .as("Personal shopper delivery is not displayed")
        .isTrue();
  }
}
