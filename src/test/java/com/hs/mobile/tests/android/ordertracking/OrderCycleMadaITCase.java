package com.hs.mobile.tests.android.ordertracking;

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
  @Issue("HSAP-494"),
  @Issue("HSAP-500")
})
public class OrderCycleMadaITCase extends BaseTestSteps {

  @BeforeClass
  @Step("user is on restaurant screen")
  public void verifyAllVerticalsAreDisplayed() {
    // Given
    var cityToSearch = "Riyadh";
    landingScreenSteps.handlePromotionPopup();

    // When
    landingScreenSteps.selectNewAddress();
    selectLocationScreenSteps.clickOnSearchIcon();
    selectLocationScreenSteps.insertDesiredCity(cityToSearch);
    selectLocationScreenSteps.enterSearch();
    selectLocationScreenSteps.clickOnSelectAddressButton();
    selectLocationScreenSteps.clickOnDoneButton();

    // Then
    verticalsScreenSteps.assertAllVerticals();
    verticalsScreenSteps.assertDistrictIsAppearedInSearchField();
    verticalsScreenSteps.clickOnAllStores();
  }

  @Test(description = "Verify user can navigate to a restaurant and menu items load as expected")
  public void clickOnRestaurant_verifyMenuItems() {
    // When
    allStoresScreenSteps.selectFirstStore();

    // Then
    menuItemScreenSteps.verifyCaloriesLabel();
  }

  @Test(
      description = "Search for menu item and items to cart",
      dependsOnMethods = "clickOnRestaurant_verifyMenuItems")
  void searchForMenuItem_AddItemsToCart() {
    // Given
    var itemName = "Chicken 65";

    // When
    menuItemScreenSteps.clickOnMenuSearchIcon();
    menuItemScreenSteps.searchForMenuItem(itemName);
    menuItemScreenSteps.clickSearchResultItem();
    menuItemScreenSteps.addMoreItems(4);
    menuItemScreenSteps.addToCart();
    menuItemScreenSteps.clickCancelSearch();
    menuItemScreenSteps.clickOnViewCart();
  }

  @Test(
      description = "Verify checkout screen items",
      dependsOnMethods = "searchForMenuItem_AddItemsToCart")
  void loginPhoneNo_verifyCheckoutScreen() {
    // When
    loginScreenSteps.enterPhoneNumber("501020010");
    loginScreenSteps.clickOnNext();
    loginScreenSteps.enterOtpCode("000000");

    // Then
    checkoutScreenSteps.verifyCrossSellSectionIsDisplayed();
    checkoutScreenSteps.verifyItemsTotalPrice("92.0");
    checkoutScreenSteps.verifyItemQuantity("4 x");
    checkoutScreenSteps.verifyItemName("Chicken 65");
    checkoutScreenSteps.verifyWalletToggleIsEnabled();
    checkoutScreenSteps.verifyOrderPrice();
    checkoutScreenSteps.verifyDeliveryFee();
    checkoutScreenSteps.verifyOrderTotalPrice();
  }

  @Test(
      description = "Place order and verify order submission",
      dependsOnMethods = "loginPhoneNo_verifyCheckoutScreen")
  void placeOrder_verifyOrderSubmission() {
    // When
    checkoutScreenSteps.placeOrder();
    checkoutScreenSteps.enterMadaSecurityCode("257");
    checkoutScreenSteps.clickOnContinue();
    checkoutScreenSteps.clickOnDone();
    // todo: enable checkout simulator
    // checkoutScreenSteps.typeVerificationCodeOnGatewaySimulator("Checkout1!");
    // checkoutScreenSteps.clickOnContinueViaSimulator();

    checkoutScreenSteps.clickOnDone();

    // Then
    checkoutScreenSteps.verifyOrderIsSubmitted();
  }
}
