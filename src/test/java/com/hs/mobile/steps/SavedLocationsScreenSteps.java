package com.hs.mobile.steps;

import com.hs.mobile.screens.SavedLocationsScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SavedLocationsScreenSteps extends SavedLocationsScreen {

    public SavedLocationsScreenSteps(AppiumDriver driver) {
        super(driver);
    }

    @Step("Add new location")
    public void addNewLocation() {
        tap(getNewLocation());
    }

    @Step("Delete saved locations")
    public void deleteSavedLocations() {
        getSavedLocations()
                .forEach(
                        location -> {
                            tap(getMore());
                            tap(getDelete());
                        });
    }

    @Step("Edit location")
    public void editLocation() {
        tap(getMore());
        tap(getEdit());
    }

    void waitUntilNewLocationButtonDisplays() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(getNewLocation()));
    }
}
