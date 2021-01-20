package com.hs.mobile.steps.android;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.android.OrderAnythingCheckoutScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.OrderAnythingCheckoutScreenSteps;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class OrderAnythingCheckoutScreenStepsAndroid
    extends BaseSteps<OrderAnythingCheckoutScreenStepsAndroid>
    implements OrderAnythingCheckoutScreenSteps {

  @NonNull private final OrderAnythingCheckoutScreen orderAnythingCheckoutScreen;

  public OrderAnythingCheckoutScreenStepsAndroid(@NonNull TestSettings settings) {
    super(settings);
    orderAnythingCheckoutScreen = new OrderAnythingCheckoutScreen(settings);
  }

  @Override
  @Step("Verify order anything delivery is submitted")
  public void verifyDeliveryIsSubmitted() {
    assertThat(orderAnythingCheckoutScreen.lblOrderNumber().isDisplayed())
        .as("Order anything delivery is not sent")
        .isTrue();
  }

  @Override
  @Step("Verify personal shopper label is displayed")
  public void verifyPersonalShopperDelivery() {
    assertThat(orderAnythingCheckoutScreen.lblPersonalShopper().isDisplayed())
        .as("Personal shopper delivery is not displayed")
        .isTrue();
  }
}
