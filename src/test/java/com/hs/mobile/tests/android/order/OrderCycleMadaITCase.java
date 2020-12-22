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
@Issues({@Issue("HSAP-492"), @Issue("HSAP-493"), @Issue("HSAP-465")})
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
    menuItemScreenSteps.verifyCaloriesLabel();
    menuItemScreenSteps.clickOnMenuSearchIcon();
    menuItemScreenSteps.searchForMenuItem("Chicken 65");
    menuItemScreenSteps.clickSearchResultItem();
    menuItemScreenSteps.addMoreItems(4);
    menuItemScreenSteps.addToCart();
    menuItemScreenSteps.clickCancelSearch();
    menuItemScreenSteps.clickOnViewCart();
    loginScreenSteps.enterPhoneNumber("501020010");
    loginScreenSteps.clickOnNext();
    loginScreenSteps.enterOtpCode("000000");
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
