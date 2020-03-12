package com.hs.mobile.steps;

import com.hs.mobile.data.LocationType;
import com.hs.mobile.screens.LocationsScreen;
import com.hs.mobile.screens.SavedLocationsScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;

import java.util.Arrays;
import java.util.List;

import static com.hs.mobile.data.ElementAttribute.ENABLED;
import static com.hs.mobile.data.ElementAttribute.TEXT;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class LocationScreenSteps extends BaseSteps {
  private LocationsScreen locationsScreen;
  private HomeScreenSteps homeScreenSteps;
  private SavedLocationsScreen savedLocationsScreen;
  private SavedLocationsScreenSteps savedLocationsScreenSteps;
  private RestaurantListScreenSteps restaurantListScreenSteps;

  public LocationScreenSteps(AppiumDriver driver) {
    super(driver);
    locationsScreen = new LocationsScreen(driver);
    homeScreenSteps = new HomeScreenSteps(driver);
    savedLocationsScreen = new SavedLocationsScreen(driver);
    savedLocationsScreenSteps = new SavedLocationsScreenSteps(driver);
    restaurantListScreenSteps = new RestaurantListScreenSteps(driver);
  }

  @Step("Verify {description} updated description")
  public void verifyUpdatedDescription(String description) {
    savedLocationsScreenSteps.editLocation();
    submitAddress();
    String desc = getDescription();
    submitAddress();
    savedLocationsScreenSteps.waitUntilNewLocationButtonDisplays();
    navigateBack(1);

    Assertions.assertThat(desc)
        .as("Actual updated description does not match expected one.")
        .isEqualTo(description);
  }

  @Step("Update description to {description}")
  public void updateDescription(String description) {
    homeScreenSteps.viewSavedLocations();
    savedLocationsScreenSteps.editLocation();
    submitAddress();
    clearDescription();
    insertAddressDescription(description);
    submitAddress();
  }

  @Step("Save location")
  public void saveLocation(String description) {
    homeScreenSteps.clickFindRestaurantsButton();
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
    restaurantListScreenSteps.waitUntilRestaurantsAreLoaded();
    navigateBack(1);
  }

  @Step("Search for a landmark")
  public void searchForALandmark() {
    homeScreenSteps.clickFindRestaurantsButton();
    searchForRestaurants();
    insertLocation("hayah mall");
    selectItemArea(0);

    waitUntilSubmitButtonIsEnabled();
  }

  @Step("Search for an out of range location")
  public void searchForAnOutOfRangeLocation() {
    homeScreenSteps.clickFindRestaurantsButton();
    searchForRestaurants();
    insertLocation("Amman");
    selectItemArea(0);
  }

  @Step("Verify newly added locations")
  public void verifyNewlyAddedLocations() {
    List<LocationType> allLocationTypes = Arrays.asList(LocationType.values());
    homeScreenSteps.viewSavedLocations();
    int locationsCount = savedLocationsScreen.getSavedLocations().size();
    navigateBack(1);
    Assertions.assertThat(locationsCount)
        .as("Number of saved locations should be 4.")
        .isEqualTo(allLocationTypes.size());
  }

  @Step("Verify location can be saved without adding a description")
  public void verifyLocationCanBeSavedWithoutDescription() {
    int savedLocationsCount = savedLocationsScreen.getSavedLocations().size();
    navigateBack(1);

    Assertions.assertThat(savedLocationsCount).as("Description is not mandatory.").isEqualTo(1);
  }

  @Step("Verify that a location can be edited successfully")
  public void verifyLocationUpdatedSuccessfully() {
    waitUntilSubmitButtonIsEnabled();
    boolean isSubmitButtonEnabled = isSubmitButtonEnabled();
    navigateBack(2);

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
      savedLocationsScreenSteps.deleteSavedLocations();
      savedLocationsScreenSteps.waitUntilNewLocationButtonDisplays();
    } finally {
      navigateBack(1);
    }
  }

  @Step("search for restaurants")
  public void searchForRestaurants() {
    touchAction.tap(tapOptions().withElement(element(locationsScreen.getSearchButton()))).perform();
  }

  @Step("insert {text} location")
  public void insertLocation(String text) {
    locationsScreen.getSearchTextBox().sendKeys(text);
  }

  @Step("select {index} area")
  public void selectItemArea(int index) {
    touchAction
        .tap(tapOptions().withElement(element(locationsScreen.getItemAreas().get(index))))
        .perform();
  }

  public void submitAddress() {
    touchAction
        .tap(tapOptions().withElement(element(locationsScreen.getSelectAddressButton())))
        .perform();
  }

  @Step("Insert {description} address description")
  public void insertAddressDescription(String description) {
    locationsScreen.getAddressDescriptionTextBox().sendKeys(description);
  }

  @Step("Toggle save for later button")
  public void saveForLater() {
    tap(locationsScreen.getSaveForLaterToggleButton());
  }

  @Step("Select {index} location type")
  public void selectLocationType(int index) {
    tap(locationsScreen.getLocationTypes().get(index));
  }

  @Step("Check if the submit button is enabled")
  public boolean isSubmitButtonEnabled() {
    return Boolean.parseBoolean(
        getElementAttributeValue(locationsScreen.getSelectAddressButton(), ENABLED));
  }

  @Step("Clear description text box")
  public void clearDescription() {
    locationsScreen.getAddressDescriptionTextBox().clear();
  }

  @Step("Get the current address description")
  public String getDescription() {
    return getElementAttributeValue(locationsScreen.getAddressDescriptionTextBox(), TEXT);
  }

  @Step("Check if the search button is displayed")
  public boolean isSearchButtonDisplayed() {
    return locationsScreen.getSearchButton().isDisplayed();
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
    waitUntilAnElementIsUpdated(
        locationsScreen.getSelectAddressButton(), ENABLED, String.valueOf(true));
  }

  private void addNewLocations(List<LocationType> types) {
    homeScreenSteps.clickFindRestaurantsButton();
    for (int i = 0; i < types.size(); i++) {
      if (i > 0) {
        homeScreenSteps.viewSavedLocations();
        savedLocationsScreenSteps.addNewLocation();
      }
      searchForRestaurants();
      insertLocation("Riyadh");
      selectItemArea(0);
      submitAddress();
      saveForLater();
      selectLocationType(i);
      submitAddress();
      restaurantListScreenSteps.waitUntilRestaurantsAreLoaded();
      navigateBack(1);
    }
  }
}
