package com.hs.mobile.steps;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.SavedLocationsScreen;
import io.qameta.allure.Step;
import lombok.NonNull;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SavedLocationsScreenSteps extends BaseSteps {

  @NonNull
  private final SavedLocationsScreen savedLocationsScreen;

  public SavedLocationsScreenSteps(@NonNull TestSettings settings) {
    super(settings);
    savedLocationsScreen = new SavedLocationsScreen(settings);
  }

  @Step("Add new location")
  public void addNewLocation() {
    tap(savedLocationsScreen.getBtnAddNewLocation());
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
    wait.until(ExpectedConditions.visibilityOf(savedLocationsScreen.getBtnAddNewLocation()));
  }
}
