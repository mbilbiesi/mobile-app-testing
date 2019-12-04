package com.hs.mobile.tests;

import com.hs.mobile.core.listener.TestListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Feature("Homescreen smoke test")
@Story("Verify Homescreen")
@Issue("HSAP-168")
@Listeners(TestListener.class)
public class HomescreenTests extends BaseTest {

    @Test(description = "Open the application with a new user")
    void navigateToHomeScreen_allHomeScreenElementsAreDisplayed() {
        //Given
        homeScreen.verifyThatAllHomeElementsDisplayed();
    }

    @Test(description = "Open the application with an already registered user without any saved place")
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
