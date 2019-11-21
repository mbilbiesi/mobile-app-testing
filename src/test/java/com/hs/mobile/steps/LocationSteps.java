package com.hs.mobile.steps;

import com.hs.mobile.enumeration.LocationType;
import com.hs.mobile.tests.BaseTest;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class LocationSteps extends BaseTest {
    @Step("Verify {description} updated description")
    public void verifyUpdatedDescription(String description) {
        savedLocationsScreen.editLocation();
        locationsScreen.submitAddress();
        Assertions.assertThat(locationsScreen.getDescription())
                .as("Actual updated description does not match expected one.").isEqualTo(description);
        locationsScreen.submitAddress();
        savedLocationsScreen.waitUntilNewLocationButtonDisplays();
    }

    @Step("Update description to {description}")
    public void updateDescription(String description) {
        homeScreen.viewSavedLocations();
        savedLocationsScreen.editLocation();
        locationsScreen.submitAddress();
        locationsScreen.clearDescription();
        locationsScreen.insertAddressDescription(description);
        locationsScreen.submitAddress();
    }

    @Step("Save location")
    public void saveLocation(String description) {
        homeScreen.findRestaurants();
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
        homeScreen.findRestaurants();
        locationsScreen.searchForRestaurants();
        locationsScreen.insertLocation("hayah mall");
        locationsScreen.selectItemArea(0);
    }

    @Step("Search for an out of range location")
    public void searchForAnOutOfRangeLocation() {
        homeScreen.findRestaurants();
        locationsScreen.searchForRestaurants();
        locationsScreen.insertLocation("Amman");
        locationsScreen.selectItemArea(0);
    }

    @Step("Verify newly added locations")
    public void verifyNewlyAddedLocations() {
        homeScreen.viewSavedLocations();
        Assertions.assertThat(savedLocationsScreen.getSavedLocations().size())
                .as("Number of saved locations should be 4.").isEqualTo(4);
    }

    @Step("Add all types of locations")
    public void addAllTypesOfLocations() {
        List<LocationType> allLocationTypes = Arrays.asList(LocationType.values());
        addNewLocations(allLocationTypes);
    }


    @Step("Delete existing locations")
    public void deleteExistingLocations() {
        homeScreen.viewSavedLocations();
        try {
            locationsScreen.isSearchButtonDisplayed();
        } catch (Exception e) {
            savedLocationsScreen.deleteSavedLocations();
            savedLocationsScreen.waitUntilNewLocationButtonDisplays();
        } finally {
            driver.navigate().back();
        }
    }

    private void addNewLocations(List<LocationType> types) {
        homeScreen.findRestaurants();
        for (int i = 0; i < types.size(); i++) {
            if (i > 0) {
                homeScreen.viewSavedLocations();
                savedLocationsScreen.addNewLocation();
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
