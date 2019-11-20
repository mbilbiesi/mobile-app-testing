package com.hs.mobile.tests;

import com.hs.mobile.exception.TestExecutionException;
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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

@Epic("Smoke Tests")
@Feature("Homescreen Tests")
@Execution(ExecutionMode.CONCURRENT)
class HomescreenTests extends BaseTest {

    @Test
    @Issue("HSAP-168")
    @Story("Open the application with a new user")
    @Description("We need to verify that all page elements are present, " +
            "and the delivery place equals current location")
    @Severity(SeverityLevel.CRITICAL)
    void verifyThatAllHomeScreenElementsAreDisplayed(TestInfo testInfo) {
        //GIVEN, WHEN for this test case are defined in the BaseTest as BeforeAll
        //Then verify that all homescreen elements are showing up
        homeScreen.verifyThatAllHomeElementsDisplayed();
    }

    @ParameterizedTest
    @CsvSource({"503263813,395406"})
    @Issue("HSAP-169")
    @Story("Open the application with an already registered user without any saved place")
    @Description("Login with an existing customer who doesnt have a saved address, and " +
            "verify that all home screen elements are present")
    @Severity(SeverityLevel.CRITICAL)
    void verifyThatHomescreenElementsAreDisplayedForRegisteredUsers(String phoneNum, String verificationCode) {
        //When customer logs in
        homeScreen.clickMyOrdersButton();
        ordersScreen.clickVerifyButton();
        verifyAccountScreen.insertMobileNumber(phoneNum);
        verifyAccountScreen.clickNextButton();
        pinCodeVerificationScreen.insertVerificationCode(verificationCode);
        addReferalCodeScreen.clickCloseButton();

        //And navigates to homescreen
        ordersScreen.navigateToRestaurants();

        //Then verify that all homescreen elements are displayed
        homeScreen.verifyThatAllHomeElementsDisplayed();
    }
}
