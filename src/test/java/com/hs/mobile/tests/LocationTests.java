package com.hs.mobile.tests;

import io.qameta.allure.*;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

public class LocationTests extends BaseTest {

    private static final String VALID_LOCATION = "Riyadh";
    private static SoftAssertions assertions = new SoftAssertions();

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
        assertions.assertThat(locationsScreen.isSubmitButtonEnabled())
                .as("Submit button should be enabled for valid landmarks.").isTrue();
        driver.navigate().back();
    }

    @Story("Location")
    @Description("Save without description")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("HSAP-172")
    @Test
    public void saveWithoutDescription() {
        deleteExistingLocations();
        saveALocationWithoutDescription();
        assertions.assertThat(savedLocationsScreen.getSavedLocations().size())
                .as("Description is not mandatory.").isEqualTo(1);
        driver.navigate().back();
    }

    @Story("Location")
    @Description("Use an out of range location")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("HSAP-174")
    @Test
    public void useAnOutOfRangeLocation() {
        deleteExistingLocations();
        searchForAnOutOfRangeLocation();
        assertions.assertThat(locationsScreen.isSubmitButtonEnabled())
                .as("Submit button should be disabled for out of range locations.").isFalse();
        driver.navigate().back();
    }

    @Story("Location")
    @Description("Edit description with different characters")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("HSAP-175")
    @Test
    public void editDescriptionWithDifferentCharacters() {
        deleteExistingLocations();
        saveALocationWithoutDescription();
        String description = "% 5";
        updateDescription(description);
        verifyUpdatedDescription(description);
    }

    @AfterAll
    static void assertAll() {
        assertions.assertAll();
    }

    private void verifyUpdatedDescription(String description) {
        savedLocationsScreen.editLocation();
        locationsScreen.submitAddress();
        assertions.assertThat(locationsScreen.getDescription())
                .as("Actual updated description does not match expected one.").isEqualTo(description);
        locationsScreen.submitAddress();
        driver.navigate().back();
        driver.navigate().back();
    }

    private void updateDescription(String description) {
        savedLocationsScreen.editLocation();
        locationsScreen.submitAddress();
        locationsScreen.clearDescription();
        locationsScreen.insertAddressDescription(description);
        locationsScreen.submitAddress();
    }

    private void saveALocationWithoutDescription() {
        homeScreen.findRestaurants();
        locationsScreen.searchForRestaurants();
        locationsScreen.insertLocation(VALID_LOCATION);
        locationsScreen.selectItemArea(0);
        locationsScreen.submitAddress();
        locationsScreen.clearDescription();
        locationsScreen.saveForLater();
        locationsScreen.submitAddress();
        restaurantsListScreen.waitUnitRestaurantsAreLoaded();
        driver.navigate().back();
        homeScreen.viewSavedLocations();
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
        assertions.assertThat(savedLocationsScreen.getSavedLocations().size())
                .as("Number of saved locations should be 4.").isEqualTo(4);
        driver.navigate().back();
    }

    private void addNewLocations() {
        homeScreen.findRestaurants();
        for (int i = 0; i < 4; i++) {
            if (i > 0) {
                homeScreen.viewSavedLocations();
                savedLocationsScreen.addNewLocation();
            }
            locationsScreen.searchForRestaurants();
            locationsScreen.insertLocation(VALID_LOCATION);
            locationsScreen.selectItemArea(0);
            locationsScreen.submitAddress();
            locationsScreen.saveForLater();
            locationsScreen.selectLocationType(i);
            locationsScreen.submitAddress();
            restaurantsListScreen.waitUnitRestaurantsAreLoaded();
            driver.navigate().back();
        }
    }

    private void deleteExistingLocations() {
        homeScreen.viewSavedLocations();
        savedLocationsScreen.deleteSavedLocations();
        driver.navigate().back();
    }
}
