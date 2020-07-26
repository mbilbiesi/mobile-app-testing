package com.hs.mobile.steps;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.android.OrdersScreen;
import io.qameta.allure.Step;
import lombok.NonNull;
import org.assertj.core.api.SoftAssertions;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static org.assertj.core.api.Assertions.assertThat;

public class OrdersSteps extends BaseSteps {

  @NonNull private final OrdersScreen ordersScreen;

  public OrdersSteps(@NonNull TestSettings settings) {
    super(settings);
    ordersScreen = new OrdersScreen(settings);
  }

  @Step("Make sure that 'Verify Mobile Number' button if customer is not logged in")
  public void verifyThatVerifyMobileButtonIsDisplayed() {
    assertThat(ordersScreen.getBtnVerify().isDisplayed())
        .as("Verify mobile number button is not displayed.")
        .isTrue();
  }

  @Step("Make sure that all orders details are displayed if customer is logged in")
  public void verifyThatAllOrdersElementsIsDisplayed() {
    SoftAssertions soft = new SoftAssertions();
    soft.assertThat(ordersScreen.getEleOrders().size() > 0)
        .as("Customer orders are not displayed.")
        .isTrue();
    soft.assertThat(ordersScreen.getEleOrderTitles().size() > 0)
        .as("Customer order titles are not displayed.")
        .isTrue();
    soft.assertThat(ordersScreen.getEleOrderPrice().size() > 0)
        .as("Order prices are not displayed.")
        .isTrue();
    soft.assertThat(ordersScreen.getEleOrderStatus().size() > 0)
        .as("Orders statuses are not displayed.")
        .isTrue();
    soft.assertThat(ordersScreen.getEleOrders().size() > 0)
        .as("Orders item is not displayed.")
        .isTrue();
    soft.assertThat(ordersScreen.getEleOrderDate().size() > 0)
        .as("Orders dates are not displayed.")
        .isTrue();
    soft.assertAll();
  }

  @Step("Click the 'Verify' button")
  public void clickVerifyButton() {
    touchAction.tap(tapOptions().withElement(element(ordersScreen.getBtnVerify()))).perform();
  }

  @Step("Navigate back to Restaurants")
  public void navigateToRestaurants() {
    touchAction.tap(tapOptions().withElement(element(ordersScreen.getBtnRestaurants()))).perform();
  }
}
