package com.hs.mobile.tests;

import com.hs.mobile.core.listener.TestListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Feature("Location Smoke Tes")
@Story("Verify functionalities of add/removing/updating locations")
@Issue("HSAP-170")
@Listeners(TestListener.class)
public class LocationTests extends BaseTest {

  boolean hasFirstTestExecuted = false;

  @BeforeMethod
  public void startApp() {
    if (!hasFirstTestExecuted) {
      homeScreenSteps.clickMyOrdersButton();
      myOrdersSteps.clickVerifyButton();
      verifyAccountScreenSteps.insertMobileNumber("503263813");
      verifyAccountScreenSteps.clickNextButton();
      pinCodeVerificationScreen.insertVerificationCode("395406");

      hasFirstTestExecuted = true;
    }

    homeScreenSteps.clickOnResturantIcon();
    locationScreenSteps.deleteExistingLocations();
  }

  @Test(description = "Add locations for all available location types")
  void addLocationsForAllAvailableLocationTypes() {
    // When
    locationScreenSteps.addAllTypesOfLocations();

    // Then
    locationScreenSteps.verifyNewlyAddedLocations();
  }

  @Test(description = "Search by landmark")
  void searchByLandmark() {
    // When
    locationScreenSteps.searchForALandmark();

    // Then
    locationScreenSteps.verifySubmitButtonAfterSelectingValidLandmark();
  }

  @Test(description = "Save without description")
  void saveWithoutDescription() {
    // When
    locationScreenSteps.saveLocation(null);
    homeScreenSteps.viewSavedLocations();

    // Then
    locationScreenSteps.verifyLocationCanBeSavedWithoutDescription();
  }

  @Test(description = "Edit location")
  void editLocation() {
    // When
    locationScreenSteps.saveLocation("test");
    homeScreenSteps.viewSavedLocations();
    savedLocationsScreenSteps.editLocation();

    // Then
    locationScreenSteps.verifyLocationUpdatedSuccessfully();
  }

  @Test(description = "Use an out of range location")
  void useAnOutOfRangeLocation() {
    // When
    locationScreenSteps.searchForAnOutOfRangeLocation();

    // Then
    locationScreenSteps.verifyOutOfRangeLocations();
  }

  @Test(description = "Edit description with different characters")
  void editDescriptionWithDifferentCharacters() {
    // When
    locationScreenSteps.saveLocation(null);
    String description = "% 5";
    locationScreenSteps.updateDescription(description);

    // Then
    locationScreenSteps.verifyUpdatedDescription(description);
  }

  @Test(description = "Delete all locations")
  void deleteAllLocations() {
    // When
    locationScreenSteps.saveLocation(null);
    locationScreenSteps.deleteExistingLocations();
    homeScreenSteps.viewSavedLocations();

    // Then
    locationScreenSteps.verifyAllLocationsDeleted();
  }
}
