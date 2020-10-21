package com.hs.mobile.tests.ios;

import com.hs.mobile.tests.BaseSteps;
import com.hs.mobile.util.annotation.SearchAndDiscovery;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@SearchAndDiscovery
@Feature("Verticals")
@Story("Vertical existence based on selected location")
public class VerticalsExistenceTest extends BaseSteps {

  @Issue("HSAP-480")
  @Test(description = "Verify all verticals are displayed")
  public void verifyAllVerticalsAreDisplayed() {
    // Given
    var cityToSearch = "Riyadh";
    landingScreenSteps.handleLocationPopup();
    landingScreenSteps.handlePromotionPopup();

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
    verticalsScreenSteps.assertDistrictIsAppearedInSearchField();
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

    // Then
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

    // Then
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

    // Then
    selectLocationScreenSteps.verifyNotCoveredArea();
  }
}
