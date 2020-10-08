package com.hs.mobile.steps.legacy;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.data.LocationType;
import com.hs.mobile.data.locations.LocationsProvider;
import com.hs.mobile.screens.android.LandingScreen;
import com.hs.mobile.screens.android.LocationMainScreen;
import com.hs.mobile.steps.BaseSteps;
import io.qameta.allure.Step;
import java.util.Arrays;
import java.util.List;
import lombok.NonNull;
import org.assertj.core.api.Assertions;

public class LocationScreenSteps extends BaseSteps {

  @NonNull private final LocationMainScreen locationMainScreen;
  @NonNull private final HomeScreenSteps homeScreenSteps;
  @NonNull private final LandingScreen landingScreen;
  @NonNull private final LocationsProvider locationsProvider;

  public LocationScreenSteps(@NonNull TestSettings settings) {
    super(settings);
    locationMainScreen = new LocationMainScreen(settings);
    landingScreen = new LandingScreen(settings);
    homeScreenSteps = new HomeScreenSteps(settings);
    locationsProvider = new LocationsProvider(settings);
  }

  @Step("Verify {description} updated description")
  public void verifyUpdatedDescription(String description) {
    tap(landingScreen.getLstHomeScreenAddresses());
    homeScreenSteps.editLocation();
    submitAddress();
    String desc = getDescription();
    submitAddress();

    Assertions.assertThat(desc)
        .as("Actual updated description does not match expected one.")
        .isEqualTo(description);
  }

  @Step("Update description to {description}")
  public void updateDescription(String description) {
    homeScreenSteps.viewSavedLocations();
    homeScreenSteps.editLocation();
    submitAddress();
    clearDescription();
    insertAddressDescription(description);
    submitAddress();
    homeScreenSteps.waitUntilRestaurantsAnGroceryWidgetsLoaded();
  }

  @Step("Save location")
  public void saveLocation(String description) {
    homeScreenSteps.clickSelectLocationManually();
    searchForRestaurants();
    insertLocation("Riyadh");
    selectItemArea(0);
    submitAddress();
    clearDescription();
    if (description != null && !description.isBlank()) {
      insertAddressDescription(description);
    }
    saveForLater();
    submitAddress();
    homeScreenSteps.waitUntilRestaurantsAnGroceryWidgetsLoaded();
  }

  @Step("Search for a landmark")
  public void searchForALandmark() {
    homeScreenSteps.clickSelectLocationManually();
    searchForRestaurants();
    insertLocation("hayah mall");
    selectItemArea(0);

    waitUntilSubmitButtonIsEnabled();
  }

  @Step("Search for an out of range location")
  public void searchForAnOutOfRangeLocation() {
    homeScreenSteps.clickSelectLocationManually();
    searchForRestaurants();
    insertLocation("Amman");
    selectItemArea(0);
  }

  @Step("Verify newly added locations")
  public void verifyNewlyAddedLocations() {
    List<LocationType> allLocationTypes = Arrays.asList(LocationType.values());
    homeScreenSteps.viewSavedLocations();
    int locationsCount = landingScreen.getSavedLocations().size();
    navigateBack(1);
    Assertions.assertThat(locationsCount)
        .as("Number of saved locations should be 4.")
        .isEqualTo(allLocationTypes.size());
  }

  @Step("Verify location can be saved without adding a description")
  public void verifyLocationCanBeSavedWithoutDescription() {
    int savedLocationsCount = landingScreen.getSavedLocations().size();
    navigateBack(1);

    Assertions.assertThat(savedLocationsCount).as("Description is not mandatory.").isEqualTo(1);
  }

  @Step("Verify that a location can be edited successfully")
  public void verifyLocationUpdatedSuccessfully() {
    waitUntilSubmitButtonIsEnabled();
    boolean isSubmitButtonEnabled = isSubmitButtonEnabled();
    navigateBack(1);

    Assertions.assertThat(isSubmitButtonEnabled)
        .as("User should be directed to the saved location.")
        .isTrue();
  }

  @Step("Verify that user cannot use out of range locations")
  public void verifyOutOfRangeLocations() {
    Assertions.assertThat(isSubmitButtonEnabled())
        .as("Submit button should be disabled for out of range locations.")
        .isFalse();
  }

  @Step("Verify that all locations are deleted")
  public void verifyAllLocationsDeleted() {
    boolean isSearchButtonDisplayed = isSearchButtonDisplayed();
    navigateBack(1);

    Assertions.assertThat(isSearchButtonDisplayed)
        .as("User should be redirected to locations screen.")
        .isEqualTo(true);
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
      isSearchButtonDisplayed();
    } catch (Exception e) {
      homeScreenSteps.deleteSavedLocations();
    } finally {
      navigateBack(1);
    }
  }

  @Step("search for restaurants")
  public void searchForRestaurants() {
    // touchAction.tap(tapOptions().withElement(element(locationMainScreen.getSearchButton()))).perform();
  }

  @Step("insert {text} location")
  public void insertLocation(String text) {
    // locationMainScreen.getSearchTextBox().sendKeys(text);
  }

  @Step("insert default location")
  public void insertDefaultLocation() {
    // locationMainScreen.getSearchTextBox().sendKeys(locationsProvider.getLocationValue("area"));
  }

  @Step("select {index} area")
  public void selectItemArea(int index) {
    //    touchAction
    //        .tap(tapOptions().withElement(element(locationMainScreen.getItemAreas().get(index))))
    //        .perform();
  }

  public void submitAddress() {
    //    touchAction
    //        .tap(tapOptions().withElement(element(locationMainScreen.getSelectAddressButton())))
    //        .perform();
  }

  @Step("Insert {description} address description")
  public void insertAddressDescription(String description) {
    // locationMainScreen.getAddressDescriptionTextBox().sendKeys(description);
  }

  @Step("Toggle save for later button")
  public void saveForLater() {
    // tap(locationMainScreen.getSaveForLaterToggleButton());
  }

  @Step("Select {index} location type")
  public void selectLocationType(int index) {
    // tap(locationMainScreen.getLocationTypes().get(index));
  }

  @Step("Check if the submit button is enabled")
  public boolean isSubmitButtonEnabled() {
    return false;
    //    return Boolean.parseBoolean(
    //        getElementAttributeValue(locationMainScreen.getSelectAddressButton(), ENABLED));
  }

  @Step("Clear description text box")
  public void clearDescription() {
    // locationMainScreen.getAddressDescriptionTextBox().clear();
  }

  @Step("Get the current address description")
  public String getDescription() {
    return "";
    // return getElementAttributeValue(locationMainScreen.getAddressDescriptionTextBox(), TEXT);
  }

  @Step("Check if the search button is displayed")
  public boolean isSearchButtonDisplayed() {
    return false;
    // return locationMainScreen.getSearchButton().isDisplayed();
  }

  @Step("Verify that address can be submitted upon selecting a location by it's landmark")
  public void verifySubmitButtonAfterSelectingValidLandmark() {
    boolean isSubmitButtonEnabled = isSubmitButtonEnabled();
    navigateBack(1);

    Assertions.assertThat(isSubmitButtonEnabled)
        .as("Submit button should be enabled for valid landmarks.")
        .isTrue();
  }

  public void waitUntilSubmitButtonIsEnabled() {
    //    waitUntilAnElementIsUpdated(
    //        locationMainScreen.getSelectAddressButton(), ENABLED, String.valueOf(true));
  }

  private void addNewLocations(List<LocationType> types) {
    homeScreenSteps.clickSelectLocationManually();
    for (int i = 0; i < types.size(); i++) {
      if (i > 0) {
        homeScreenSteps.viewSavedLocations();
        homeScreenSteps.clickAddNewLocation();
      }
      searchForRestaurants();
      insertLocation("Riyadh");
      selectItemArea(0);
      submitAddress();
      saveForLater();
      selectLocationType(i);
      submitAddress();
      homeScreenSteps.waitUntilRestaurantsAnGroceryWidgetsLoaded();
    }
  }
}
