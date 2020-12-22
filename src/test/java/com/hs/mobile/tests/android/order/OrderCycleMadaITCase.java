package com.hs.mobile.tests.android.order;

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
      description = "Enter phone verification",
      dependsOnMethods = "searchForMenuItem_AddItemsToCart")
  void enterPhoneVerification() {
    // Given
    var phoneNo = "501020010";
    var otpCode = "000000";

    // When
    loginScreenSteps.enterPhoneNumber(phoneNo);
    loginScreenSteps.clickOnNext();
    loginScreenSteps.enterOtpCode(otpCode);
  }

  @Test(description = "Verify checkout screen items", dependsOnMethods = "enterPhoneVerification")
  void verifyCheckoutScreen() {
    // Given
    var totalPrice = "92.0";
    var itemQuantity = "4 x";
    var itemName = "Chicken 65";

    // Then
    checkoutScreenSteps.verifyCrossSellSectionIsDisplayed();
    checkoutScreenSteps.verifyItemsTotalPrice(totalPrice);
    checkoutScreenSteps.verifyItemQuantity(itemQuantity);
    checkoutScreenSteps.verifyItemName(itemName);
  }

  @Test(
      description = "Place order and verify order submission",
      dependsOnMethods = "verifyCheckoutScreen")
  void placeOrder_verifyOrderSubmission() {

    // When
    checkoutScreenSteps.placeOrder();
    checkoutScreenSteps.enterMadaSecurityCode("257");
    checkoutScreenSteps.clickOnContinue();
    checkoutScreenSteps.clickOnDone();
    checkoutScreenSteps.typeVerificationCodeOnGatewaySimulator("Checkout1!");
    checkoutScreenSteps.clickOnContinueViaSimulator();
    checkoutScreenSteps.clickOnDone();

    // Then
    checkoutScreenSteps.verifyOrderIsSubmitted();
  }
}
