package com.hs.mobile.tests.ios.order;

import static org.assertj.core.api.Assumptions.assumeThat;

import com.hs.mobile.tests.BaseTestSteps;
import com.hs.mobile.util.annotation.OrderAndTracking;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@OrderAndTracking
@Feature("Ordering")
@Story("Create order using 'Cash on Delivery'")
public class OrderCycle_Cash extends BaseTestSteps {

  @BeforeClass
  @Step("User is on Restaurant screen")
  public void testPrecondition() {
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

  @Issue("HSAP-513")
  @Test(description = "Verify that user is directed to vendor screen")
  void userNavigateToVendorScreen_verifyUserIsOnVendorScreen() {
    // When
    verticalsScreenSteps.clickOnAllStores();

    // Then
    allStoresScreenSteps.verifyLocationIsAppearedScreenHeader();
  }

  @Test(
      description = "Verify user can navigate into restaurant",
      dependsOnMethods = "userNavigateToVendorScreen_verifyUserIsOnVendorScreen")
  void clickOnRestaurant_verifyRestaurantMenuLoads() {
    // Given
    var restaurantName = "Al Reef Al Hindi";

    // When
    allStoresScreenSteps.selectRestaurantByName(restaurantName);

    // Then
    restaurantMenuScreenSteps.verifyRestaurantName(restaurantName);
  }

  @Test(
      description = "Verify menu items are added to cart",
      dependsOnMethods = {"clickOnRestaurant_verifyRestaurantMenuLoads"})
  void orderFood_verifyItemsAdded() {
    // When
    restaurantMenuScreenSteps.selectMenuItemByName("Chicken 65");
    menuItemScreenSteps.addMoreItems(4);
    menuItemScreenSteps.addToCart();

    // Then
    menuItemScreenSteps.verifyViewCartButtonIsDisplayed();
  }

  @Test(
      description = "place order using cash on delivery",
      dependsOnMethods = {"clickOnRestaurant_verifyRestaurantMenuLoads"})
  void placeOrderUsingCashMethod_orderIsSubmitted() {
    // Given
    menuItemScreenSteps.clickOnViewCart();
    loginScreenSteps.enterPhoneNumber("501020010");
    loginScreenSteps.clickOnNext();
    loginScreenSteps.enterOtpCode("000000");

    // When
    checkoutScreenSteps.skipNoteHint();
    checkoutScreenSteps.changePaymentMethod();
    paymentOptionsScreenSteps.clickOnCashOnDeliveryPayment();
    checkoutScreenSteps.placeOrder();

    // Then
    checkoutScreenSteps.verifyOrderIsSubmitted();
  }
}
