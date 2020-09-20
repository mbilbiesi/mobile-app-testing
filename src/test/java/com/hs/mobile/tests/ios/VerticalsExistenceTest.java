package com.hs.mobile.tests.ios;

import com.hs.mobile.tests.base.BaseSteps;
import org.testng.annotations.Test;

public class VerticalsExistenceTest extends BaseSteps {

  @Test(description = "Verify all verticals are displayed")
  public void navigateToHomeScreen_VerifyLocationIsChosen() {
    // Given
    var cityToSearch = "Riyadh";

    // When
    landingScreenSteps.selectNewAddress();
    selectLocationScreenSteps.clickOnSearchIcon();
    selectLocationScreenSteps.sendCityViaIosKeyboard(cityToSearch);
    selectLocationScreenSteps.enterSearchUsingKeyboard();
    selectLocationScreenSteps.selectCity(cityToSearch);
    selectLocationScreenSteps.clickOnSelectAddressButton();
    selectLocationScreenSteps.clickOnDoneButton();

    // Then
    verticalsScreenSteps.assertAllVerticals();
  }

  @Test(
      description = "Verify all verticals are displayed based on location",
      dependsOnMethods = {"navigateToHomeScreen_VerifyLocationIsChosen"})
  public void verifyVerticalsBasedOnLocations() {
    // Given
    var cityToSearch = "Jeddah";

    // When
    verticalsScreenSteps.clickOnArrow();
    verticalsScreenSteps.clickOnAdd();
    selectLocationScreenSteps.clickOnSearchIcon();
    selectLocationScreenSteps.sendCityViaIosKeyboard(cityToSearch);
    selectLocationScreenSteps.enterSearchUsingKeyboard();
    selectLocationScreenSteps.selectCity(cityToSearch);
    selectLocationScreenSteps.clickOnSelectAddressButton();
    selectLocationScreenSteps.clickOnDoneButton();

    // then
    verticalsScreenSteps.assertTwoVerticalsAreDisplayed();
  }

  @Test(
      description = "Verify only All Stores Vertical is displayed",
      dependsOnMethods = {"verifyVerticalsBasedOnLocations"})
  public void verifyOnlyAllStoresVertical_isDisplayed() {
    // Given
    var cityToSearch = "Khobar";

    // When
    verticalsScreenSteps.clickOnArrow();
    verticalsScreenSteps.clickOnAdd();
    selectLocationScreenSteps.clickOnSearchIcon();
    selectLocationScreenSteps.sendCityViaIosKeyboard(cityToSearch);
    selectLocationScreenSteps.enterSearchUsingKeyboard();
    selectLocationScreenSteps.selectCity(cityToSearch);
    selectLocationScreenSteps.clickOnSelectAddressButton();
    selectLocationScreenSteps.clickOnDoneButton();

    // then
    verticalsScreenSteps.verifyAllStoresVertical();
  }

  @Test(
      description = "Verify cities with uncovered verticals",
      dependsOnMethods = {"verifyOnlyAllStoresVertical_isDisplayed"})
  public void verifyCityAreaIsNotCovered_isNotDisplayed() {
    // Given
    var cityToSearch = "Alnamas";

    // When
    verticalsScreenSteps.clickOnArrow();
    verticalsScreenSteps.clickOnAdd();
    selectLocationScreenSteps.clickOnSearchIcon();
    selectLocationScreenSteps.sendCityViaIosKeyboard(cityToSearch);
    selectLocationScreenSteps.enterSearchUsingKeyboard();
    selectLocationScreenSteps.selectCity(cityToSearch);

    // then
    selectLocationScreenSteps.verifyNotCoveredArea();
  }
}
