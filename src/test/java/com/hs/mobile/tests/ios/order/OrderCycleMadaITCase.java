package com.hs.mobile.tests.ios.order;

import static org.assertj.core.api.Assumptions.assumeThat;

import com.hs.mobile.tests.BaseTestSteps;
import com.hs.mobile.util.annotation.OrderAndTracking;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Issues;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@OrderAndTracking
@Feature("Ordering")
@Story("Create order using 'Mada'")
@Issues({
  @Issue("HSAP-492"),
  @Issue("HSAP-493"),
  @Issue("HSAP-465"),
  @Issue("HSAP-496"),
  @Issue("HSAP-494")
})
public class OrderCycleMadaITCase extends BaseTestSteps {

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

  @Issue("HSAP-465")
  @Test(
      description = "Verify calories label",
      dependsOnMethods = "clickOnRestaurant_verifyRestaurantMenuLoads")
  void verifyCaloriesLabel() {
    // When
    menuItemScreenSteps.verifyCaloriesLabel();
  }

  @Test(
      description = "Verify menu items are added to cart",
      dependsOnMethods = "userNavigateToVendorScreen_verifyUserIsOnVendorScreen")
  void orderFood_verifyItemsAdded() {
    // When
    var searchItem = "Chicken 65";
    menuItemScreenSteps.clickOnMenuSearchIcon();
    menuItemScreenSteps.searchForMenuItem(searchItem);
    menuItemScreenSteps.clickSearchResultItem();
    menuItemScreenSteps.addMoreItems(4);
    menuItemScreenSteps.addToCart();
    menuItemScreenSteps.clickCancelSearch();
    menuItemScreenSteps.clickOnCheckoutFromMenuScreen();
  }

  @Test(
      description = "Enter phone verification",
      dependsOnMethods = {"orderFood_verifyItemsAdded"})
  void enterPhoneVerification() {
    loginScreenSteps.enterPhoneNumber("501020010");
    loginScreenSteps.clickOnNext();
    loginScreenSteps.enterOtpCode("000000");
  }

  @Test(
      description = "Choose payment method and verify checkout screen",
      dependsOnMethods = {"enterPhoneVerification"})
  void choosePaymentMethod_VerifyCheckoutScreen() {
    // Given
    var itemName = "Chicken 65";
    var quantity = "x4";
    var price = "92.00";

    // When
    // checkoutScreenSteps.skipNoteHint(); //todo apply id on new version
    checkoutScreenSteps.verifyCrossSellSectionIsDisplayed();
    checkoutScreenSteps.changePaymentMethod();
    paymentOptionsScreenSteps.clickOnMadaPaymentOption();

    // Then
    checkoutScreenSteps.verifyItemName(itemName);
    checkoutScreenSteps.verifyItemQuantity(quantity);
    checkoutScreenSteps.verifyItemsTotalPrice(price);
  }

  @Test(
      description = "Place order and verify order is submitted",
      dependsOnMethods = {"choosePaymentMethod_VerifyCheckoutScreen"})
  void placeOrder_verifyOrderSubmission() {
    // When
    checkoutScreenSteps.placeOrder();
    checkoutScreenSteps.enterMadaSecurityCode("257");

    // Then
    checkoutScreenSteps.verifyOrderIsSubmitted();
  }
}
