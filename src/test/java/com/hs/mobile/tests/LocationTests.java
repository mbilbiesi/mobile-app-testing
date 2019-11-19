package com.hs.mobile.tests;

import io.qameta.allure.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LocationTests extends BaseTest {

    @BeforeEach
    public void startApp() {
        startAppiumServer();
    }

    @AfterEach
    public void closeApplication() {
        if (driver != null) {
            driver.closeApp();
        }
    }

    @Story("Location")
    @Description("Add locations for all available location types")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("HSAP-170")
    @Test
    public void addLocationsForAllAvailableLocationTypes() {
        deleteExistingLocations();
        addNewLocations();
        verifyNewlyAddedLocations();
    }

    @Story("Location")
    @Description("Search by landmark")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("HSAP-171")
    @Test
    public void searchByLandmark() {
        deleteExistingLocations();
        searchForALandmark();
        Assertions.assertThat(locationsScreen.isSubmitButtonEnabled())
                .as("Submit button should be enabled for valid landmarks.").isTrue();
    }

    @Story("Location")
    @Description("Save without description")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("HSAP-172")
    @Test
    public void saveWithoutDescription() {
        deleteExistingLocations();
        saveLocation(null);
        homeScreen.viewSavedLocations();
        Assertions.assertThat(savedLocationsScreen.getSavedLocations().size())
                .as("Description is not mandatory.").isEqualTo(1);
    }

    @Story("Location")
    @Description("Edit location")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("HSAP-173")
    @Test
    public void editLocation() {
        deleteExistingLocations();
        saveLocation("test");
        homeScreen.viewSavedLocations();
        savedLocationsScreen.editLocation();
        Assertions.assertThat(locationsScreen.isSubmitButtonEnabled())
                .as("User should be directed to the saved location.").isTrue();
    }

    @Story("Location")
    @Description("Use an out of range location")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("HSAP-174")
    @Test
    public void useAnOutOfRangeLocation() {
        deleteExistingLocations();
        searchForAnOutOfRangeLocation();
        Assertions.assertThat(locationsScreen.isSubmitButtonEnabled())
                .as("Submit button should be disabled for out of range locations.").isFalse();
    }

    @Story("Location")
    @Description("Edit description with different characters")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("HSAP-175")
    @Test
    public void editDescriptionWithDifferentCharacters() {
        deleteExistingLocations();
        saveLocation(null);
        String description = "% 5";
        updateDescription(description);
        verifyUpdatedDescription(description);
    }

    @Story("Location")
    @Description("Delete all locations")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("HSAP-176")
    @Test
    public void deleteAllLocations() {
        deleteExistingLocations();
        saveLocation(null);
        deleteExistingLocations();
        homeScreen.viewSavedLocations();
        Assertions.assertThat(locationsScreen.isSearchButtonDisplayed())
                .as("User should be redirected to locations screen.").isEqualTo(true);
    }

    private void verifyUpdatedDescription(String description) {
        savedLocationsScreen.editLocation();
        locationsScreen.submitAddress();
        Assertions.assertThat(locationsScreen.getDescription())
                .as("Actual updated description does not match expected one.").isEqualTo(description);
        locationsScreen.submitAddress();
        savedLocationsScreen.waitUntilNewLocationButtonDisplays();
    }

    private void updateDescription(String description) {
        homeScreen.viewSavedLocations();
        savedLocationsScreen.editLocation();
        locationsScreen.submitAddress();
        locationsScreen.clearDescription();
        locationsScreen.insertAddressDescription(description);
        locationsScreen.submitAddress();
    }

    private void saveLocation(String description) {
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

    private void searchForALandmark() {
        homeScreen.findRestaurants();
        locationsScreen.searchForRestaurants();
        locationsScreen.insertLocation("hayah mall");
        locationsScreen.selectItemArea(0);
    }

    private void searchForAnOutOfRangeLocation() {
        homeScreen.findRestaurants();
        locationsScreen.searchForRestaurants();
        locationsScreen.insertLocation("Amman");
        locationsScreen.selectItemArea(0);
    }

    private void verifyNewlyAddedLocations() {
        homeScreen.viewSavedLocations();
        Assertions.assertThat(savedLocationsScreen.getSavedLocations().size())
                .as("Number of saved locations should be 4.").isEqualTo(4);
    }

    private void addNewLocations() {
        homeScreen.findRestaurants();
        for (int i = 0; i < 4; i++) {
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

    private void deleteExistingLocations() {
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
}
