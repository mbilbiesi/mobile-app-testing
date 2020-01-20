package com.hs.mobile.tests;

import com.hs.mobile.core.listener.TestListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Feature("Location Smoke Tes")
@Story("Verify functionalities of add/removing/updating locations")
@Issue("HSAP-170")
@Listeners(TestListener.class)
public class LocationTests extends BaseTest {

    @BeforeMethod
    public void startApp() {
        homeScreenSteps.clickMyOrdersButton();
        myOrdersSteps.clickVerifyButton();
        verifyAccountScreenSteps.insertMobileNumber("503263813");
        verifyAccountScreenSteps.clickNextButton();
        pinCodeVerificationScreen.insertVerificationCode("395406");
        addReferalCodeScreen.clickCloseButton();
        homeScreenSteps.clickOnResturantIcon();

        locationScreenSteps.deleteExistingLocations();
    }

    @Test(description = "Add locations for all available location types")
    void addLocationsForAllAvailableLocationTypes() {
        // When
        locationScreenSteps.addAllTypesOfLocations();

        // Then
        locationScreenSteps.verifyNewlyAddedLocations();
    }

    @Test(description = "Search by landmark")
    void searchByLandmark() {
        // When
        locationScreenSteps.searchForALandmark();
        locationScreenSteps.waitUntilSubmitButtonIsEnabled();
        boolean isSubmitButtonEnabled = locationScreenSteps.isSubmitButtonEnabled();
        locationScreenSteps.navigateBack(1);

        // Then
        Assertions.assertThat(isSubmitButtonEnabled)
                .as("Submit button should be enabled for valid landmarks.")
                .isTrue();
    }

    @Test(description = "Save without description")
    void saveWithoutDescription() {
        // When
        locationScreenSteps.saveLocation(null);
        homeScreenSteps.viewSavedLocations();
        int savedLocationsCount = savedLocationsScreenSteps.getSavedLocations().size();
        locationScreenSteps.navigateBack(1);

        // Then
        Assertions.assertThat(savedLocationsCount)
                .as("Description is not mandatory.")
                .isEqualTo(1);
    }

    @Test(description = "Edit location")
    void editLocation() {
        // When
        locationScreenSteps.saveLocation("test");
        homeScreenSteps.viewSavedLocations();
        savedLocationsScreenSteps.editLocation();
        locationScreenSteps.waitUntilSubmitButtonIsEnabled();
        boolean isSubmitButtonEnabled = locationScreenSteps.isSubmitButtonEnabled();
        locationScreenSteps.navigateBack(2);

        // Then
        Assertions.assertThat(isSubmitButtonEnabled)
                .as("User should be directed to the saved location.")
                .isTrue();
    }

    @Test(description = "Use an out of range location")
    void useAnOutOfRangeLocation() {
        // When
        locationScreenSteps.searchForAnOutOfRangeLocation();

        // Then
        Assertions.assertThat(locationScreenSteps.isSubmitButtonEnabled())
                .as("Submit button should be disabled for out of range locations.")
                .isFalse();
    }

    @Test(description = "Edit description with different characters")
    void editDescriptionWithDifferentCharacters() {
        // When
        locationScreenSteps.saveLocation(null);
        String description = "% 5";
        locationScreenSteps.updateDescription(description);

        // Then
        locationScreenSteps.verifyUpdatedDescription(description);
    }

    @Test(description = "Delete all locations")
    void deleteAllLocations() {
        // When
        locationScreenSteps.saveLocation(null);
        locationScreenSteps.deleteExistingLocations();
        homeScreenSteps.viewSavedLocations();
        boolean isSearchButtonDisplayed = locationScreenSteps.isSearchButtonDisplayed();
        locationScreenSteps.navigateBack(1);

        // Then
        Assertions.assertThat(isSearchButtonDisplayed)
                .as("User should be redirected to locations screen.")
                .isEqualTo(true);
    }
}
