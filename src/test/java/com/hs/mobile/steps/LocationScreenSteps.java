package com.hs.mobile.steps;

import com.hs.mobile.data.LocationType;
import com.hs.mobile.screens.LocationsScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;

import java.util.Arrays;
import java.util.List;

import static com.hs.mobile.data.ElementAttribute.ENABLED;
import static com.hs.mobile.data.ElementAttribute.TEXT;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class LocationScreenSteps extends LocationsScreen {
    private HomeScreenSteps homeScreenSteps;
    private SavedLocationsScreenSteps savedLocationsScreenSteps;
    private RestaurantListScreenSteps restaurantListScreenSteps;

    public LocationScreenSteps(AppiumDriver driver) {
        super(driver);
        homeScreenSteps = new HomeScreenSteps(driver);
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
        homeScreenSteps.findRestaurants();
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
        homeScreenSteps.findRestaurants();
        searchForRestaurants();
        insertLocation("hayah mall");
        selectItemArea(0);
    }

    @Step("Search for an out of range location")
    public void searchForAnOutOfRangeLocation() {
        homeScreenSteps.findRestaurants();
        searchForRestaurants();
        insertLocation("Amman");
        selectItemArea(0);
    }

    @Step("Verify newly added locations")
    public void verifyNewlyAddedLocations() {
        homeScreenSteps.viewSavedLocations();
        int locationsCount = savedLocationsScreenSteps.getSavedLocations().size();
        navigateBack(1);
        Assertions.assertThat(locationsCount)
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
        touchAction.tap(tapOptions().withElement(element(getSearchButton()))).perform();
    }

    @Step("insert {text} location")
    public void insertLocation(String text) {
        getSearchTextBox().sendKeys(text);
    }

    @Step("select {index} area")
    public void selectItemArea(int index) {
        touchAction.tap(tapOptions().withElement(element(getItemAreas().get(index)))).perform();
    }

    public void submitAddress() {
        touchAction.tap(tapOptions().withElement(element(getSelectAddressButton()))).perform();
    }

    @Step("Insert {description} address description")
    public void insertAddressDescription(String description) {
        getAddressDescriptionTextBox().sendKeys(description);
    }

    @Step("Toggle save for later button")
    public void saveForLater() {
        tap(getSaveForLaterToggleButton());
    }

    @Step("Select {index} location type")
    public void selectLocationType(int index) {
        tap(getLocationTypes().get(index));
    }

    @Step("Check if the submit button is enabled")
    public boolean isSubmitButtonEnabled() {
        return Boolean.parseBoolean(getElementAttributeValue(getSelectAddressButton(), ENABLED));
    }

    @Step("Clear description text box")
    public void clearDescription() {
        getAddressDescriptionTextBox().clear();
    }

    @Step("Get the current address description")
    public String getDescription() {
        return getElementAttributeValue(getAddressDescriptionTextBox(), TEXT);
    }

    @Step("Check if the search button is displayed")
    public boolean isSearchButtonDisplayed() {
        return getSearchButton().isDisplayed();
    }

    public void waitUntilSubmitButtonIsEnabled() {
        waitUntilAnElementIsUpdated(getSelectAddressButton(), ENABLED, String.valueOf(true));
    }

    private void addNewLocations(List<LocationType> types) {
        homeScreenSteps.findRestaurants();
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
