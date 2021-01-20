package com.hs.mobile.tests.android.order;

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
@Issues({@Issue("HSAP-527")})
public class OrderCycleCashPaymentITCase extends BaseTestSteps {

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
    assumeThat(verticalsScreenSteps.isAllStoresVerticalDisplayed())
        .as("'All stores' vertical is not displayed")
        .isTrue();
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
  void enterPhoneVerification_verifyCheckoutScreen() {

    // When
    loginScreenSteps.enterPhoneNumber("501020010");
    loginScreenSteps.clickOnNext();
    loginScreenSteps.enterOtpCode("000000");

    // Then
    checkoutScreenSteps.verifyCrossSellSectionIsDisplayed();
    checkoutScreenSteps.verifyItemsTotalPrice("92.0");
    checkoutScreenSteps.verifyItemQuantity("4 x");
    checkoutScreenSteps.verifyItemName("Chicken 65");
  }

  @Test(
      description = "Place order and verify order submission",
      dependsOnMethods = "enterPhoneVerification_verifyCheckoutScreen")
  void placeOrder_verifyOrderSubmission() {

    // When
    checkoutScreenSteps.clickChangePayment();
    checkoutScreenSteps.clickOnCashPayment();
    checkoutScreenSteps.verifyWalletToggleIsDisabled();
    checkoutScreenSteps.placeOrder();

    // Then
    checkoutScreenSteps.verifyOrderIsSubmitted();
  }
}
