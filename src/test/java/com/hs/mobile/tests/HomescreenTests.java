package com.hs.mobile.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Epic("Smoke Tests")
@Feature("Homescreen")
@Execution(ExecutionMode.CONCURRENT)
class HomescreenTests extends BaseTest {

    @Test
    @Issue("HSAP-168")
    @Story("Open the application with a new user")
    @Description("We need to verify that all page elements are present, and the delivery place equals current location")
    @Severity(SeverityLevel.CRITICAL)
    void navigateToHomeScreen_allHomeScreenElementsAreDisplayed(TestInfo testInfo) {
        //GIVEN, WHEN for this test case are defined in the BaseTest as BeforeAll
        //Then verify that all homescreen elements are showing up
        homeScreen.verifyThatAllHomeElementsDisplayed();
    }

    @Test
    @Issue("HSAP-169")
    @Story("Open the application with an already registered user without any saved place")
    @Description("Login with an existing customer who doesnt have a saved address, and " +
            "verify that all home screen elements are present")
    @Severity(SeverityLevel.CRITICAL)
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
