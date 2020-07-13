package com.hs.mobile.tests;

import com.hs.mobile.core.listener.TestListener;
import com.hs.mobile.tests.base.BaseStepsInitiator;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Feature("Homescreen smoke test")
@Story("Verify Homescreen")
@Issue("HSAP-168")
@Listeners(TestListener.class)
@Deprecated
public class HomescreenTests_Deprecated extends BaseStepsInitiator {

    @BeforeClass
    @Parameters({"platform"})
    public void skipApplePay(String platformInfo) {
        String[] platform = platformInfo.split(" ");

        if (platform[0].equalsIgnoreCase("ios")) {
            applePaySteps.skipApplePay();
        }
    }

    @Test(description = "Open the application with a new user")
    void navigateToHomeScreen_allHomeScreenElementsAreDisplayed() {
        // Given
        homeScreenSteps.verifyThatAllHomeElementsDisplayed();
    }

    @Test(
            description = "Open the application with an already registered user without any saved place")
    void verifyThatHomescreenElementsAreDisplayedForRegisteredUsers() {
        // Given
        homeScreenSteps.clickMyOrdersButton();
        myOrdersSteps.clickVerifyButton();
        verifyAccountScreenSteps.insertMobileNumber(testUser.getMobileNumber());
        verifyAccountScreenSteps.clickNextButton();
        pinCodeVerificationSteps.insertVerificationCode(testUser.getVerificationCode());

        // When
        myOrdersSteps.navigateToRestaurants();

        // Then
        homeScreenSteps.verifyThatAllHomeElementsDisplayed();
    }
}
