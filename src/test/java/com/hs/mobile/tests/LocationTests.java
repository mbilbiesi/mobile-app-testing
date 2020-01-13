package com.hs.mobile.tests;

import com.hs.mobile.core.listener.TestListener;
import com.hs.mobile.data.LocationType;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Feature("Location Smoke Tes")
@Story("Verify functionalities of add/removing/updating locations")
@Issue("HSAP-170")
@Listeners(TestListener.class)
public class LocationTests extends BaseTest {

  @BeforeMethod
  public void startApp() {
    homeScreenSteps.clickMyOrdersButton();
      myOrdersSteps.clickVerifyButton();
    verifyAccountScreenSteps.insertMobileNumber("503263813");
    verifyAccountScreenSteps.clickNextButton();
    pinCodeVerificationScreen.insertVerificationCode("395406");
    addReferalCodeScreen.clickCloseButton();
    homeScreenSteps.clickOnResturantIcon();

    deleteExistingLocations();
  }

  @Test(description = "Add locations for all available location types")
  void addLocationsForAllAvailableLocationTypes() {
    // When
    addAllTypesOfLocations();

    // Then
    verifyNewlyAddedLocations();
  }

  @Test(description = "Search by landmark")
  void searchByLandmark() {
    // When
    searchForALandmark();

    // Then
    Assertions.assertThat(locationsScreen.isSubmitButtonEnabled())
        .as("Submit button should be enabled for valid landmarks.")
        .isTrue();
  }

  @Test(description = "SSave without description")
  void saveWithoutDescription() {
    // When
    saveLocation(null);
    homeScreenSteps.viewSavedLocations();

    // Then
    Assertions.assertThat(savedLocationsScreenSteps.getSavedLocations().size())
        .as("Description is not mandatory.")
        .isEqualTo(1);
  }

  @Test(description = "Edit location")
  void editLocation() {
    // When
    saveLocation("test");
    homeScreenSteps.viewSavedLocations();
    savedLocationsScreenSteps.editLocation();

    // Then
    Assertions.assertThat(locationsScreen.isSubmitButtonEnabled())
        .as("User should be directed to the saved location.")
        .isTrue();
  }

  @Test(description = "Use an out of range location")
  void useAnOutOfRangeLocation() {
    // When
    searchForAnOutOfRangeLocation();

    // Then
    Assertions.assertThat(locationsScreen.isSubmitButtonEnabled())
        .as("Submit button should be disabled for out of range locations.")
        .isFalse();
  }

  @Test(description = "Edit description with different characters")
  void editDescriptionWithDifferentCharacters() {
    // When
    saveLocation(null);
    String description = "% 5";
    updateDescription(description);

    // Then
    verifyUpdatedDescription(description);
  }

  @Test(description = "Delete all locations")
  void deleteAllLocations() {
    // When
    saveLocation(null);
    deleteExistingLocations();
    homeScreenSteps.viewSavedLocations();

    // Then
    Assertions.assertThat(locationsScreen.isSearchButtonDisplayed())
        .as("User should be redirected to locations screen.")
        .isEqualTo(true);
  }

  @Step("Verify {description} updated description")
  public void verifyUpdatedDescription(String description) {
    savedLocationsScreenSteps.editLocation();
    locationsScreen.submitAddress();
    Assertions.assertThat(locationsScreen.getDescription())
        .as("Actual updated description does not match expected one.")
        .isEqualTo(description);
    locationsScreen.submitAddress();
    savedLocationsScreenSteps.waitUntilNewLocationButtonDisplays();
  }

  @Step("Update description to {description}")
  public void updateDescription(String description) {
    homeScreenSteps.viewSavedLocations();
    savedLocationsScreenSteps.editLocation();
    locationsScreen.submitAddress();
    locationsScreen.clearDescription();
    locationsScreen.insertAddressDescription(description);
    locationsScreen.submitAddress();
  }

  @Step("Save location")
  public void saveLocation(String description) {
    homeScreenSteps.findRestaurants();
    locationsScreen.searchForRestaurants();
    locationsScreen.insertLocation("Riyadh");
    locationsScreen.selectItemArea(0);
    locationsScreen.submitAddress();
    locationsScreen.clearDescription();
    if (description != null && !description.isBlank()) {
      locationsScreen.insertAddressDescription(description);
    }
    locationsScreen.saveForLater();
    locationsScreen.submitAddress();
    restaurantsListScreen.waitUntilRestaurantsAreLoaded();
    driver.navigate().back();
  }

  @Step("Search for a landmark")
  public void searchForALandmark() {
    homeScreenSteps.findRestaurants();
    locationsScreen.searchForRestaurants();
    locationsScreen.insertLocation("hayah mall");
    locationsScreen.selectItemArea(0);
  }

  @Step("Search for an out of range location")
  public void searchForAnOutOfRangeLocation() {
    homeScreenSteps.findRestaurants();
    locationsScreen.searchForRestaurants();
    locationsScreen.insertLocation("Amman");
    locationsScreen.selectItemArea(0);
  }

  @Step("Verify newly added locations")
  public void verifyNewlyAddedLocations() {
    homeScreenSteps.viewSavedLocations();
    Assertions.assertThat(savedLocationsScreenSteps.getSavedLocations().size())
        .as("Number of saved locations should be 4.")
        .isEqualTo(4);
  }

  @Step("Add all types of locations")
  public void addAllTypesOfLocations() {
    List<LocationType> allLocationTypes = Arrays.asList(LocationType.values());
    addNewLocations(allLocationTypes);
  }

  @Step("Delete existing locations")
  public void deleteExistingLocations() {
    homeScreenSteps.viewSavedLocations();
    try {
      locationsScreen.isSearchButtonDisplayed();
    } catch (Exception e) {
      savedLocationsScreenSteps.deleteSavedLocations();
      savedLocationsScreenSteps.waitUntilNewLocationButtonDisplays();
    } finally {
      driver.navigate().back();
    }
  }

  private void addNewLocations(List<LocationType> types) {
    homeScreenSteps.findRestaurants();
    for (int i = 0; i < types.size(); i++) {
      if (i > 0) {
        homeScreenSteps.viewSavedLocations();
        savedLocationsScreenSteps.addNewLocation();
      }
      locationsScreen.searchForRestaurants();
      locationsScreen.insertLocation("Riyadh");
      locationsScreen.selectItemArea(0);
      locationsScreen.submitAddress();
      locationsScreen.saveForLater();
      locationsScreen.selectLocationType(i);
      locationsScreen.submitAddress();
      restaurantsListScreen.waitUntilRestaurantsAreLoaded();
      driver.navigate().back();
    }
  }
}
