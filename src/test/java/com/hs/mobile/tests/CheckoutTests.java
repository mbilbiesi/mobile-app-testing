package com.hs.mobile.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {

    boolean hasFirstTestExecuted = false;

    @BeforeMethod
    public void beforeEachTest() {

        //ToDo: Note: I've added this temporarily to resolve the issue of non logged-in customers on
        // checkout screen. But this has to change, and be replaced with a login method directly from
        // checkout screen once a code refactor is done for checkout.

        // Given
        homeScreenSteps.clickMyOrdersButton();
        if (!hasFirstTestExecuted) {
            myOrdersSteps.clickVerifyButton();
            verifyAccountScreenSteps.insertMobileNumber(testUser.getMobileNumber());
            verifyAccountScreenSteps.clickNextButton();
            pinCodeVerificationSteps.insertVerificationCode(testUser.getVerificationCode());
            myOrdersSteps.waitUntilMyOrdersScreenLoaded();
            homeScreenSteps.clickOnResturantIcon();

            hasFirstTestExecuted = true;
        }
    }

    @Test(description = "Verify order, delivery, and total amounts on checkout screen")
    public void navigateToCheckoutScreen_verifyCheckoutAmounts() {
        // When
        double orderAmount = checkoutScreenSteps.addFirstMenuItemToCart("Johnny Rockets", 6);
        double deliveryFee = restaurantScreenSteps.getDeliveryFee();

        // Then
        checkoutScreenSteps.verifyAmountsOnCheckoutScreen(orderAmount, deliveryFee);
    }
}
