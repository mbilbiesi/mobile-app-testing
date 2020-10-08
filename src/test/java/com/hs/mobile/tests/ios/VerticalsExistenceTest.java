package com.hs.mobile.tests.ios;

import com.hs.mobile.tests.BaseSteps;
import org.testng.annotations.Test;

public class VerticalsExistenceTest extends BaseSteps {

  @Test(description = "Verify all verticals are displayed")
  public void verifyAllVerticalsAreDisplayed() {
    // Given
    var cityToSearch = "Riyadh";
    landingScreenSteps.handleLocationPopup();

    // When
    landingScreenSteps.selectNewAddress();
    selectLocationScreenSteps.clickOnSearchIcon();
    selectLocationScreenSteps.insertDesiredCity(cityToSearch);
    selectLocationScreenSteps.enterSearch();
    selectLocationScreenSteps.selectCity(cityToSearch);
    selectLocationScreenSteps.clickOnSelectAddressButton();
    selectLocationScreenSteps.clickOnDoneButton();

    // Then
    verticalsScreenSteps.assertAllVerticals();
  }

  @Test(
      description = "Verify specific verticals are displayed",
      dependsOnMethods = {"verifyAllVerticalsAreDisplayed"})
  public void verifySpecificVerticalsBasedOnLocations() {
    // Given
    var cityToSearch = "Jeddah";

    // When
    verticalsScreenSteps.clickOnAddress();
    verticalsScreenSteps.clickOnAddNewLocation();
    selectLocationScreenSteps.clickOnSearchIcon();
    selectLocationScreenSteps.insertDesiredCity(cityToSearch);
    selectLocationScreenSteps.enterSearch();
    selectLocationScreenSteps.selectCity(cityToSearch);
    selectLocationScreenSteps.clickOnSelectAddressButton();
    selectLocationScreenSteps.clickOnDoneButton();

    // then
    verticalsScreenSteps.assertTwoVerticalsAreDisplayed();
  }

  @Test(
      description = "Verify only 'All Stores' vertical is displayed",
      dependsOnMethods = {"verifySpecificVerticalsBasedOnLocations"})
  public void verifyOnlyAllStoresVerticalIsDisplayed() {
    // Given
    var cityToSearch = "Khobar";

    // When
    verticalsScreenSteps.clickOnAddress();
    verticalsScreenSteps.clickOnAddNewLocation();
    selectLocationScreenSteps.clickOnSearchIcon();
    selectLocationScreenSteps.insertDesiredCity(cityToSearch);
    selectLocationScreenSteps.enterSearch();
    selectLocationScreenSteps.selectCity(cityToSearch);
    selectLocationScreenSteps.clickOnSelectAddressButton();
    selectLocationScreenSteps.clickOnDoneButton();

    // then
    verticalsScreenSteps.verifyAllStoresVertical();
  }

  @Test(
      description = "Verify cities with uncovered verticals",
      dependsOnMethods = {"verifyOnlyAllStoresVerticalIsDisplayed"})
  public void verifyCityAreaIsNotCoveredBasedOnLocation() {
    // Given
    var cityToSearch = "Alnamas";

    // When
    verticalsScreenSteps.clickOnAddress();
    verticalsScreenSteps.clickOnAddNewLocation();
    selectLocationScreenSteps.clickOnSearchIcon();
    selectLocationScreenSteps.insertDesiredCity(cityToSearch);
    selectLocationScreenSteps.enterSearch();
    selectLocationScreenSteps.selectCity(cityToSearch);

    // then
    selectLocationScreenSteps.verifyNotCoveredArea();
  }
}
