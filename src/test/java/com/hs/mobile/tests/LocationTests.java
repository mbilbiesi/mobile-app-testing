package com.hs.mobile.tests;

import com.hs.mobile.steps.LocationSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LocationTests extends BaseTest {

    LocationSteps steps = new LocationSteps();

    @BeforeEach
    public void startApp() {
        startAppiumServer();
        //Given
        steps.deleteExistingLocations();
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
        //When
        steps.addAllTypesOfLocations();
        //Then
        steps.verifyNewlyAddedLocations();
    }

    @Story("Location")
    @Description("Search by landmark")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("HSAP-171")
    @Test
    public void searchByLandmark() {
        //When
        steps.searchForALandmark();
        //Then
        Assertions.assertThat(locationsScreen.isSubmitButtonEnabled())
                .as("Submit button should be enabled for valid landmarks.").isTrue();
    }

    @Story("Location")
    @Description("Save without description")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("HSAP-172")
    @Test
    public void saveWithoutDescription() {
        //When
        steps.saveLocation(null);
        homeScreen.viewSavedLocations();
        //Then
        Assertions.assertThat(savedLocationsScreen.getSavedLocations().size())
                .as("Description is not mandatory.").isEqualTo(1);
    }

    @Story("Location")
    @Description("Edit location")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("HSAP-173")
    @Test
    public void editLocation() {
        //When
        steps.saveLocation("test");
        homeScreen.viewSavedLocations();
        savedLocationsScreen.editLocation();
        //Then
        Assertions.assertThat(locationsScreen.isSubmitButtonEnabled())
                .as("User should be directed to the saved location.").isTrue();
    }

    @Story("Location")
    @Description("Use an out of range location")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("HSAP-174")
    @Test
    public void useAnOutOfRangeLocation() {
        //When
        steps.searchForAnOutOfRangeLocation();
        //Then
        Assertions.assertThat(locationsScreen.isSubmitButtonEnabled())
                .as("Submit button should be disabled for out of range locations.").isFalse();
    }

    @Story("Location")
    @Description("Edit description with different characters")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("HSAP-175")
    @Test
    public void editDescriptionWithDifferentCharacters() {
        //When
        steps.saveLocation(null);
        String description = "% 5";
        steps.updateDescription(description);
        //Then
        steps.verifyUpdatedDescription(description);
    }

    @Story("Location")
    @Description("Delete all locations")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("HSAP-176")
    @Test
    public void deleteAllLocations() {
        //When
        steps.saveLocation(null);
        steps.deleteExistingLocations();
        homeScreen.viewSavedLocations();
        //Then
        Assertions.assertThat(locationsScreen.isSearchButtonDisplayed())
                .as("User should be redirected to locations screen.").isEqualTo(true);
    }
}
