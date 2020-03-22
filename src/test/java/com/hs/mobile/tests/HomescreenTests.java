package com.hs.mobile.tests;

import com.hs.mobile.core.listener.TestListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Feature("Homescreen smoke test")
@Story("Verify Homescreen")
@Issue("HSAP-354")
@Listeners(TestListener.class)
public class HomescreenTests extends BaseTest {

  @BeforeClass
  @Parameters({"platform"})
  public void skipApplePay(String platformInfo) {
    String[] platform = platformInfo.split(" ");

    if (platform[0].equalsIgnoreCase("ios")) {
      applePaySteps.skipApplePay();
    }
  }

  @Test(description = "Accept location permission")
  void navigateToHomeScreen_acceptLocation_allHomeScreenElementsAreDisplayed() {
    // Given
    homeScreenSteps.verifyThatAllHomeElementsDisplayed();
    //Then
    homeScreenSteps.verifyLocationAcquiredCorrectly();
  }

  @Test(description = "Verify homescreen elements based on location (Covered, or Un covered)")
  @Parameters({"locationCovered"})
  public void navigateToHomeScreen_coveredAndUnCoveredLocation_allHomeScreenElementsAreDisplayed(
          boolean locationCovered) {
    // Given
    homeScreenSteps.verifyThatAllHomeElementsDisplayed();
    //Then
    homeScreenSteps.verifyHomescreenElementsBasedOnLocation(locationCovered);
  }

  @Test(description = "Customer in an uncovered location clicks 'Select Location' button")
  @Parameters({"locationCovered"})
  public void clickSelectLocation_uncoveredLocation_customerRedirectedToMap(boolean locationCovered) {
    /*
    This test case will ONLY run in case the location isn't covered by hungerstation
     */
    if (locationCovered) {
      boolean userRedirectedToMap;

      //When
      userRedirectedToMap = homeScreenSteps.clickChangeLocationButton();

      //Then

    }
  }
}
