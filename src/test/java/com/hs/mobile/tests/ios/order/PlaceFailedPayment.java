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
@Story("Create order using 'Mada' failed payment")
@Issue("HSAP-498")
public class PlaceFailedPayment extends BaseTestSteps {

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
      dependsOnMethods = "userNavigateToVendorScreen_verifyUserIsOnVendorScreen")
  void orderFood_verifyItemsAdded() {
    // When
    menuItemScreenSteps.clickOnMenuSearchIcon();
    menuItemScreenSteps.searchForMenuItem("Chicken 65");
    menuItemScreenSteps.clickSearchResultItem();
    menuItemScreenSteps.addMoreItems(4);
    menuItemScreenSteps.addToCart();
    menuItemScreenSteps.clickCancelSearch();
    menuItemScreenSteps.clickOnCheckoutFromMenuScreen();
  }

  @Test(
      description = "place order using Mada credit card for a failed payment",
      dependsOnMethods = {"orderFood_verifyItemsAdded"})
  void orderViaMadaCreditCard() {
    // Given
    loginScreenSteps.enterPhoneNumber("501020010");
    loginScreenSteps.clickOnNext();
    loginScreenSteps.enterOtpCode("000000");

    // When
    checkoutScreenSteps.placeOrder();
    checkoutScreenSteps.enterMadaSecurityCode("256");
    checkoutScreenSteps.typeVerificationCodeOnGatewaySimulator("Ch");
    checkoutScreenSteps.clickOnContinue();
    checkoutScreenSteps.verifyCancelOrderButton();
    checkoutScreenSteps.verifyChangePaymentButton();
  }
}
