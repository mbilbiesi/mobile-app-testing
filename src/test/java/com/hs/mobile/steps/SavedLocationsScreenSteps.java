package com.hs.mobile.steps;

import com.hs.mobile.screens.SavedLocationsScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SavedLocationsScreenSteps extends BaseSteps {
  private SavedLocationsScreen savedLocationsScreen;

  public SavedLocationsScreenSteps(AppiumDriver driver) {
      super(driver);
    savedLocationsScreen = new SavedLocationsScreen(driver);
  }

  @Step("Add new location")
  public void addNewLocation() {
      tap(savedLocationsScreen.getNewLocation());
  }

  @Step("Delete saved locations")
  public void deleteSavedLocations() {
    savedLocationsScreen
            .getSavedLocations()
            .forEach(
                    location -> {
                        tap(savedLocationsScreen.getMore());
                        tap(savedLocationsScreen.getDelete());
                    });
  }

  @Step("Edit location")
  public void editLocation() {
      tap(savedLocationsScreen.getMore());
      tap(savedLocationsScreen.getEdit());
  }

  void waitUntilNewLocationButtonDisplays() {
    wait.until(ExpectedConditions.visibilityOf(savedLocationsScreen.getNewLocation()));
  }
}
