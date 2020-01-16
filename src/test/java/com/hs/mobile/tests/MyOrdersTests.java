package com.hs.mobile.tests;

import io.qameta.allure.Issue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.ParseException;

public class MyOrdersTests extends BaseTest {

    boolean hasFirstTestExecuted = false;

    @BeforeMethod
    public void beforeEachTest() {
        // Given
        homeScreenSteps.clickMyOrdersButton();
        if (!hasFirstTestExecuted) {
            myOrdersSteps.clickVerifyButton();
            verifyAccountScreenSteps.insertMobileNumber("503263813");
            verifyAccountScreenSteps.clickNextButton();
            pinCodeVerificationScreen.insertVerificationCode("395406");
            myOrdersSteps.waitUntilMyOrdersScreenLoaded();

            hasFirstTestExecuted = true;
        }
    }

    @Issue("HSAP-229")
    @Test(description = "Verify that orders are sorted by date from newest to oldest")
    public void navigateToOrders_OrdersShouldBeSortedByDate() throws ParseException {
        // Then
        myOrdersSteps.verifyOrdersSortedByDateDesc("ar");
    }

    @Issue("HSAP-230")
    @Test(description = "Verify that orders are sorted by date from newest to oldest")
    public void navigateToOrder_OrderSummaryShouldDisplayCorrectly() {
        // When
        myOrdersSteps.navigateToOrder("delivered");
        orderSteps.waitUntilOrderScreenLoaded();

        // Then
        orderSteps.verifyAllOrderElements();
    }
}
