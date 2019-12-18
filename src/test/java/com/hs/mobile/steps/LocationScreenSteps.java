package com.hs.mobile.steps;

import com.hs.mobile.data.LocationType;
import com.hs.mobile.screens.LocationsScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class LocationScreenSteps extends LocationsScreen {
    private HomeScreenSteps homeScreenSteps = new HomeScreenSteps(driver);
    private SavedLocationsScreenSteps savedLocationsScreenSteps = new SavedLocationsScreenSteps(driver);
    private RestaurantListScreenSteps restaurantListScreenSteps = new RestaurantListScreenSteps(driver);

    public LocationScreenSteps(AppiumDriver driver) {
        super(driver);
    }

    @Step("Verify {description} updated description")
    public void verifyUpdatedDescription(String description) {
        savedLocationsScreenSteps.editLocation();
        submitAddress();
        String desc = getDescription();
        submitAddress();
        savedLocationsScreenSteps.waitUntilNewLocationButtonDisplays();
        driver.navigate().back();

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
        driver.navigate().back();
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
        driver.navigate().back();
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
            searchForRestaurants();
            insertLocation("Riyadh");
            selectItemArea(0);
            submitAddress();
            saveForLater();
            selectLocationType(i);
            submitAddress();
            restaurantListScreenSteps.waitUntilRestaurantsAreLoaded();
            driver.navigate().back();
        }
    }
}
