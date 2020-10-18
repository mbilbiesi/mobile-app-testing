package com.hs.mobile.tests.ios.order;

import static org.assertj.core.api.Assumptions.assumeThat;

import com.hs.mobile.tests.BaseSteps;
import com.hs.mobile.util.annotation.OrderAndTracking;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@OrderAndTracking
@Feature("Ordering")
@Story("Create order using 'Cash on Delivery'")
public class OrderCycle_Cash extends BaseSteps {

  @BeforeClass
  @Step("User is on Restaurant screen")
  public void setup() {
    // Given
    var cityToSearch = "Riyadh";
    landingScreenSteps.handleLocationPopup();
    landingScreenSteps.handlePromotionPopup();
    landingScreenSteps.selectNewAddress();
    selectLocationScreenSteps.clickOnSearchIcon();
    selectLocationScreenSteps.insertDesiredCity(cityToSearch);
    selectLocationScreenSteps.enterSearch();
    selectLocationScreenSteps.selectCity(cityToSearch);
    selectLocationScreenSteps.clickOnSelectAddressButton();
    selectLocationScreenSteps.clickOnDoneButton();
    assumeThat(verticalsScreenSteps.isAllStoresVerticalDisplayed())
        .as("'All stores' vertical is not displayed")
        .isTrue();
  }

  @Test(description = "Click on a selected restaurant")
  void clickOnRestaurant_VerifyRestaurantMenuLoads() {
    // Given
    var restaurantName = "Al Reef Al Hindi";

    // When
    verticalsScreenSteps.clickOnAllRestaurants();
    restaurantScreenSteps.selectRestaurantByName(restaurantName);

    // Then
    restaurantMenuScreenSteps.verifyRestaurantName(restaurantName);
  }

  @Test(
      description = "Verify menu items are added to cart",
      dependsOnMethods = {"clickOnRestaurant_VerifyRestaurantMenuLoads"})
  void orderFood_VerifyItemsAdded() {
    // When
    restaurantMenuScreenSteps.selectMenuItemByName("Chicken 65");
    menuItemScreenSteps.addMoreItems(4);
    menuItemScreenSteps.addToCart();

    // Then
    menuItemScreenSteps.verifyViewCartButtonIsDisplayed();
  }

  @Test(
      description = "order using cash on delivery",
      dependsOnMethods = {"clickOnRestaurant_VerifyRestaurantMenuLoads"})
  void placeOrderUsingCashMethod_orderIsSubmitted() {
    // Given
    menuItemScreenSteps.clickOnViewCart();
    checkoutScreenSteps.enterPhoneNumber("501020010");
    checkoutScreenSteps.clickOnNext();
    checkoutScreenSteps.enterOtpCode("000000");

    // When
    checkoutScreenSteps.skipNoteHint();
    checkoutScreenSteps.changePaymentMethod();
    paymentOptionsScreenSteps.clickOnCashOnDeliveryPayment();
    checkoutScreenSteps.placeOrder();

    // Then
    checkoutScreenSteps.verifyOrderIsSubmitted();
  }
}
