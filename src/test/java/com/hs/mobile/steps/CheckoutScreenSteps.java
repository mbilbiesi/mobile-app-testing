package com.hs.mobile.steps;

import com.hs.mobile.screens.CheckoutScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;

public class CheckoutScreenSteps extends BaseSteps {
  private CheckoutScreen checkoutScreen;
  private HomeScreenSteps homeScreenSteps;
  private LocationScreenSteps locationScreenSteps;
  private RestaurantListScreenSteps restaurantListScreenSteps;
  private RestaurantScreenSteps restaurantScreenSteps;

  public CheckoutScreenSteps(AppiumDriver driver) {
    super(driver);
    checkoutScreen = new CheckoutScreen(driver);
    homeScreenSteps = new HomeScreenSteps(driver);
    locationScreenSteps = new LocationScreenSteps(driver);
    restaurantListScreenSteps = new RestaurantListScreenSteps(driver);
    restaurantScreenSteps = new RestaurantScreenSteps(driver);
  }

  @Step("Add the first menu item to cart")
  public Double addFirstMenuItemToCart(String restaurantName, int count) {
    homeScreenSteps.viewSavedLocations();
    locationScreenSteps.searchForRestaurants();
    locationScreenSteps.insertLocation("Riyadh");
    locationScreenSteps.selectItemArea(0);
    locationScreenSteps.submitAddress();
    locationScreenSteps.submitAddress();
    restaurantListScreenSteps.searchForRestaurant(restaurantName);
    restaurantListScreenSteps.selectDisplayedRestaurant();
    return restaurantScreenSteps.addFirstItemToCart(count);
  }

  @Step("Verify order, delivery, and total amounts on checkout screen")
  public void verifyAmountsOnCheckoutScreen(
      double expectedOrderAmount, double expectedDeliveryAmount) {
    restaurantScreenSteps.goToCheckout();

    SoftAssertions soft = new SoftAssertions();
    double expectedTotalAmount = expectedOrderAmount + expectedDeliveryAmount;
    String actualOrderAmountLabel = checkoutScreen.getOrderAmount().getText();
    double actualOrderAmount =
        Double.parseDouble(
            actualOrderAmountLabel.substring(
                actualOrderAmountLabel.indexOf(' '), actualOrderAmountLabel.length() - 1));
    String actualDeliveryAmountLabel = checkoutScreen.getDeliveryAmount().getText();
    double actualDeliveryAmount =
        Double.parseDouble(
            actualDeliveryAmountLabel.substring(
                actualDeliveryAmountLabel.indexOf(' '), actualDeliveryAmountLabel.length() - 1));
    String actualTotalAmountLabel = checkoutScreen.getTotalAmount().getText();
    double actualTotalAmount =
        Double.parseDouble(
            actualTotalAmountLabel.substring(
                actualTotalAmountLabel.indexOf(' '), actualTotalAmountLabel.length() - 1));

    soft.assertThat(expectedOrderAmount)
        .as(
            String.format(
                "Actual order amount is [%s] instead of [%s]",
                actualOrderAmount, expectedOrderAmount))
        .isEqualTo(expectedOrderAmount);
    soft.assertThat(actualDeliveryAmount)
        .as(
            String.format(
                "Actual delivery amount is [%s] instead of [%s]",
                actualDeliveryAmount, expectedDeliveryAmount))
        .isEqualTo(expectedDeliveryAmount);
    soft.assertThat(actualTotalAmount)
        .as(
            String.format(
                "Actual total amount is [%s] instead of [%s]",
                actualTotalAmount, expectedTotalAmount))
        .isEqualTo(expectedTotalAmount);
    navigateBack(3);
    soft.assertAll();
  }
}
