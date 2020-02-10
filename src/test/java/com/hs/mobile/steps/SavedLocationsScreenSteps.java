package com.hs.mobile.steps;

import com.hs.mobile.screens.SavedLocationsScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SavedLocationsScreenSteps {
  private SavedLocationsScreen savedLocationsScreen;
  private AppiumDriver driver;

  public SavedLocationsScreenSteps(AppiumDriver driver) {
    this.driver = driver;
    savedLocationsScreen = new SavedLocationsScreen(driver);
  }

  @Step("Add new location")
  public void addNewLocation() {
    savedLocationsScreen.tap(savedLocationsScreen.getNewLocation());
  }

  @Step("Delete saved locations")
  public void deleteSavedLocations() {
    savedLocationsScreen
            .getSavedLocations()
            .forEach(
                    location -> {
                      savedLocationsScreen.tap(savedLocationsScreen.getMore());
                      savedLocationsScreen.tap(savedLocationsScreen.getDelete());
                    });
  }

  @Step("Edit location")
  public void editLocation() {
    savedLocationsScreen.tap(savedLocationsScreen.getMore());
    savedLocationsScreen.tap(savedLocationsScreen.getEdit());
  }

  void waitUntilNewLocationButtonDisplays() {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOf(savedLocationsScreen.getNewLocation()));
  }
}
