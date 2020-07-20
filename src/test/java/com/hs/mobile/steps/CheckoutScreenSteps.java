package com.hs.mobile.steps;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.data.locations.LocationsProvider;
import com.hs.mobile.screens.CheckoutScreen;
import com.hs.mobile.screens.PaymentOptionsScreen;
import io.qameta.allure.Step;
import lombok.NonNull;
import org.assertj.core.api.SoftAssertions;

public class CheckoutScreenSteps extends BaseSteps {

  @NonNull private final CheckoutScreen checkoutScreen;
  @NonNull private final HomeScreenSteps homeScreenSteps;
  @NonNull private final LocationScreenSteps locationScreenSteps;
  @NonNull private final RestaurantListScreenSteps restaurantListScreenSteps;
  @NonNull private final RestaurantScreenSteps restaurantScreenSteps;
  @NonNull private final LocationsProvider locationsData;
  @NonNull private final PaymentOptionsScreen paymentOptionsScreen;

  public CheckoutScreenSteps(@NonNull TestSettings settings) {
    super(settings);
    checkoutScreen = new CheckoutScreen(settings);
    paymentOptionsScreen = new PaymentOptionsScreen(settings);
    locationsData = new LocationsProvider(settings);

    homeScreenSteps = new HomeScreenSteps(settings);
    locationScreenSteps = new LocationScreenSteps(settings);
    restaurantListScreenSteps = new RestaurantListScreenSteps(settings);
    restaurantScreenSteps = new RestaurantScreenSteps(settings);
  }

  @Step("Add the first menu item to cart")
  public Double addFirstMenuItemToCart(String restaurantName, int count) {
    //    homeScreenSteps.viewSavedLocations();
    //    locationScreenSteps.searchForRestaurants();
    //    locationScreenSteps.insertLocation("Riyadh");
    //    locationScreenSteps.selectItemArea(0);
    //    locationScreenSteps.submitAddress();
    //    locationScreenSteps.submitAddress();
    homeScreenSteps.clickSelectLocationManually();
    locationScreenSteps.searchForRestaurants();
    locationScreenSteps.insertLocation(locationsData.getLocationValue("area"));
    locationScreenSteps.selectItemArea(1);
    locationScreenSteps.submitAddress();
    locationScreenSteps.submitAddress();
    homeScreenSteps.clickViewRestaurantsButton();
    restaurantListScreenSteps.searchForRestaurant(restaurantName);
    restaurantListScreenSteps.selectDisplayedRestaurant();
    return restaurantScreenSteps.addFirstItemToCart(count);
  }

  @Step("Verify order, delivery, and total amounts on checkout screen")
  public void verifyAmountsOnCheckoutScreen(
      double expectedOrderAmount, double expectedDeliveryAmount) {
    restaurantScreenSteps.goToCheckout();

    tap(checkoutScreen.getBtnChoosePmtMethod());
    tap(paymentOptionsScreen.getBtnCashOnDelivery());

    swipe(checkoutScreen.getDeliveryAmount(), checkoutScreen.getBtnChoosePmtMethod());

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
