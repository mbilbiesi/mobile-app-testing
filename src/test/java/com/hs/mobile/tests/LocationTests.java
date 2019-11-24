package com.hs.mobile.tests;

import com.hs.mobile.enumeration.LocationType;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Arrays;
import java.util.List;

@Feature("Location Smoke Tes")
@Story("Verify functionalities of add/removing/updating locations")
@Issue("HSAP-170")
@Execution(ExecutionMode.CONCURRENT)
public class LocationTests extends BaseTest {

    @BeforeEach
    public void startApp() {
        homeScreen.clickMyOrdersButton();
        ordersScreen.clickVerifyButton();
        verifyAccountScreen.insertMobileNumber("503263813");
        verifyAccountScreen.clickNextButton();
        pinCodeVerificationScreen.insertVerificationCode("395406");
        addReferalCodeScreen.clickCloseButton();
        homeScreen.clickOnResturantIcon();

        deleteExistingLocations();
    }

    @Test
    @DisplayName("Add locations for all available location types")
    void addLocationsForAllAvailableLocationTypes() {
        //When
        addAllTypesOfLocations();

        //Then
        verifyNewlyAddedLocations();
    }

    @Test
    @DisplayName("Search by landmark")
    void searchByLandmark() {
        //When
        searchForALandmark();

        //Then
        Assertions.assertThat(locationsScreen.isSubmitButtonEnabled())
                .as("Submit button should be enabled for valid landmarks.").isTrue();
    }

    @Test
    @DisplayName("Save without description")
    void saveWithoutDescription() {
        //When
        saveLocation(null);
        homeScreen.viewSavedLocations();

        //Then
        Assertions.assertThat(savedLocationsScreen.getSavedLocations().size())
                .as("Description is not mandatory.").isEqualTo(1);
    }

    @Test
    @DisplayName("Edit location")
    void editLocation() {
        //When
        saveLocation("test");
        homeScreen.viewSavedLocations();
        savedLocationsScreen.editLocation();

        //Then
        Assertions.assertThat(locationsScreen.isSubmitButtonEnabled())
                .as("User should be directed to the saved location.").isTrue();
    }

    @Test
    @DisplayName("Use an out of range location")
    void useAnOutOfRangeLocation() {
        //When
        searchForAnOutOfRangeLocation();

        //Then
        Assertions.assertThat(locationsScreen.isSubmitButtonEnabled())
                .as("Submit button should be disabled for out of range locations.").isFalse();
    }

    @Test
    @DisplayName("Edit description with different characters")
    void editDescriptionWithDifferentCharacters() {
        //When
        saveLocation(null);
        String description = "% 5";
        updateDescription(description);

        //Then
        verifyUpdatedDescription(description);
    }

    @Test
    @DisplayName("Delete all locations")
    void deleteAllLocations() {
        //When
        saveLocation(null);
        deleteExistingLocations();
        homeScreen.viewSavedLocations();

        //Then
        Assertions.assertThat(locationsScreen.isSearchButtonDisplayed())
                .as("User should be redirected to locations screen.").isEqualTo(true);
    }

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
