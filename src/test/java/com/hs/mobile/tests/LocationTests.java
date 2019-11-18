package com.hs.mobile.tests;

import io.qameta.allure.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LocationTests extends BaseTest {

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
