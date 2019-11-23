package com.hs.mobile.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Feature("Homescreen smoke test")
@Story("Verify Homescreen")
@Issue("HSAP-168")
@Execution(ExecutionMode.CONCURRENT)
public class HomescreenTests extends BaseTest {

    @Test
    @DisplayName("Open the application with a new user")
    void navigateToHomeScreen_allHomeScreenElementsAreDisplayed(TestInfo testInfo) {
        //GIVEN, WHEN for this test case are defined in the BaseTest as BeforeAll
        //Then verify that all homescreen elements are showing up
        homeScreen.verifyThatAllHomeElementsDisplayed();
    }

    @Test
    @DisplayName("Open the application with an already registered user without any saved place")
    void verifyThatHomescreenElementsAreDisplayedForRegisteredUsers() {
        //Given
        homeScreen.clickMyOrdersButton();
        ordersScreen.clickVerifyButton();
        verifyAccountScreen.insertMobileNumber("503263813");
        verifyAccountScreen.clickNextButton();
        pinCodeVerificationScreen.insertVerificationCode("395406");
        addReferalCodeScreen.clickCloseButton();

        //When
        ordersScreen.navigateToRestaurants();

        //Then
        homeScreen.verifyThatAllHomeElementsDisplayed();
    }
}
