package com.hs.mobile.tests;

import com.hs.mobile.core.listener.TestListener;
import com.hs.mobile.tests.base.BaseSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Feature("Profile Smoke Test")
@Story("Verify elements, updates, and field boundaries of the profile screen")
@Issue("HSAP-181")
@Listeners(TestListener.class)
public class ProfileITs extends BaseSteps {

  boolean hasFirstTestExecuted = false;

  @BeforeMethod
  public void goToProfile() {
    // When
    if (!hasFirstTestExecuted) {
      homeScreenSteps.clickMyOrdersButton();
      myOrdersSteps.clickVerifyButton();
      verifyAccountScreenSteps.insertMobileNumber(testUser.getMobileNumber());
      verifyAccountScreenSteps.clickNextButton();
      pinCodeVerificationSteps.insertVerificationCode(testUser.getVerificationCode());

      hasFirstTestExecuted = true;
    }

    homeScreenSteps.clickOnMore().goToProfile();
  }

  @Test(description = "Check user profile screen elements")
  public void navigateToProfileScreen_elementsAreProperlyDisplayed() {
    // Then
    profileScreenSteps.verifyProfileScreen();
  }

  @Test(description = "Perform and verify valid updates")
  public void navigateToProfileScreen_updatesAreCorrectlyPerformed() {
    // Then
    profileScreenSteps.verifyProfileUpdates();
  }

  @Test(description = "Check user profile field boundaries")
  public void navigateToProfileScreen_fieldsHaveProperBoundaries() {
    // Then
    profileScreenSteps.verifyFieldBoundaries();
  }
}
