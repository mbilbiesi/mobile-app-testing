package com.hs.mobile.tests;

import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {

    @Test(description = "Verify order, delivery, and total amounts on checkout screen")
    public void navigateToCheckoutScreen_verifyCheckoutAmounts() {
        //When
        double orderAmount = checkoutScreenSteps.addFirstMenuItemToCart("Johnny Rockets", 6);
        double deliveryFee = restaurantScreenSteps.getDeliveryFee();

        //Then
        checkoutScreenSteps.verifyAmountsOnCheckoutScreen(orderAmount, deliveryFee);
    }
}
