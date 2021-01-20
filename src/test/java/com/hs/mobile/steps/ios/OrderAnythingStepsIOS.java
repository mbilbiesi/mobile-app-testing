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

  @Override
  @Step("Click on a store on the map")
  public void clickFindStore() {
    orderAnythingScreen.lblShopFrom().click();
  }

  @Override
  @Step("Assert that 'order anything' delivery fees are present")
  public void verifyDeliveryFeeIsPresent() {
    assertThat(orderAnythingScreen.lblDeliveryFeesOA().isDisplayed())
        .as("Delivery fee is not present")
        .isTrue();
  }

  @Override
  // todo to be resumed in order and tracking test cases
  public void clickOnContinue() {
    orderAnythingScreen.btnContinue().click();
  }

  @Override
  @Step("Add order anything item")
  public void addOrderItem(String item) {
    orderAnythingScreen.txtOrderItem().sendKeys(item);
  }

  @Override
  @Step("Click on price estimate")
  public void clickOnPriceEstimate() {
    orderAnythingScreen.btnPriceEstimate().click();
  }

  @Override
  @Step("Click on place order")
  public void clickOnPlaceOrder() {
    orderAnythingScreen.btnPlaceOrder().click();
  }
}
