package com.hs.mobile.tests;

import static org.assertj.core.api.Assumptions.assumeThat;

import com.hs.mobile.core.listener.TestListener;
import com.hs.mobile.tests.base.BaseStepsInitiator;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Feature("HomeScreen smoke test")
@Story("Verify HomeScreen")
@Issue("HSAP-354")
@Listeners(TestListener.class)
public class HomeScreenITs extends BaseStepsInitiator {

  @Test(description = "Accept location permission")
  void navigateToHomeScreen_acceptLocation_allHomeScreenElementsAreDisplayed() {
    // Given
    homeScreenSteps.verifyThatAllHomeElementsDisplayed();
    // Then
    homeScreenSteps.verifyLocationAcquiredCorrectly();
  }

  @Test(description = "Verify homeScreen elements based on location valid or invalid")
  public void navigateToHomeScreen_validAndInvalidLocation_allHomeScreenElementsAreDisplayed() {
    // Given
    homeScreenSteps.verifyThatAllHomeElementsDisplayed();
    // Then
    homeScreenSteps.verifyHomeScreenElementsBasedOnLocation(isLocationValid);
  }

  @Test(description = "Customer in an uncovered location clicks 'Select Location' button")
  public void clickSelectLocation_uncoveredLocation_customerRedirectedToMap() {
    assumeThat(isLocationValid).as("cannot proceed with valid location").isFalse();

    // When
    var userRedirectedToMap = homeScreenSteps.clickChangeLocationButton();

    // Then
    homeScreenSteps.verifyCustomerRedirectedToMap(userRedirectedToMap);
  }
}
