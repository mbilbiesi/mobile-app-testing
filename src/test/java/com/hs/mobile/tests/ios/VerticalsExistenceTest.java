package com.hs.mobile.tests.ios;

import com.hs.mobile.tests.base.BaseIosSteps;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;

public class VerticalsExistenceTest extends BaseIosSteps {

  @Test(description = "Verify all verticals are displayed")
  public void navigateToHomeScreen_VerifyLocationIsChosen() {
    // When
    landingScreenSteps.selectNewAddress();
    selectLocationScreenSteps.clickOnSearchIcon();
    selectLocationScreenSteps.sendCityViaIosKeyboard("Riyadh");
    selectLocationScreenSteps.enterSearchUsingKeyboard();
    selectLocationScreenSteps.clickOnCity();
    selectLocationScreenSteps.clickOnSelectBtn();
    selectLocationScreenSteps.clickOnDoneBtn();

    // Then
    verticalsScreenSteps.assertAllVerticals();
  }

  @Test(
      description = "Verify all verticals are displayed based on location",
      dependsOnMethods = {"navigateToHomeScreen_VerifyLocationIsChosen"})
  public void verifyVerticalsBasedOnLocations() {
    // When
    verticalsScreenSteps.clickOnArrow();
    verticalsScreenSteps.clickOnAdd();
    selectLocationScreenSteps.clickOnSearchIcon();
    selectLocationScreenSteps.sendCityViaIosKeyboard("Jeddah");
    selectLocationScreenSteps.enterSearchUsingKeyboard();

    MobileElement jeddah =
        driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Jeddah\"]");
    jeddah.click();

    selectLocationScreenSteps.clickOnSelectBtn();

    // when
    selectLocationScreenSteps.clickOnDoneBtn();

    // then
    verticalsScreenSteps.assertTwoVerticalsAreDisplayed();
  }

  // enabled = false,
  @Test(
      description = "Verify only All Stores Vertical is displayed",
      dependsOnMethods = {"verifyVerticalsBasedOnLocations"})
  public void verifyAllStoresVertical_isDisplayed() {
    // test case only homeRow_1 present (All-Stores Vertical)

    // given

    verticalsScreenSteps.clickOnArrow();

    verticalsScreenSteps.clickOnAdd();

    selectLocationScreenSteps.clickOnSearchIcon();

    selectLocationScreenSteps.sendCityViaIosKeyboard("Khobar");

    selectLocationScreenSteps.enterSearchUsingKeyboard();

    MobileElement khobar =
        driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Khobar\"]");
    khobar.click();

    selectLocationScreenSteps.clickOnSelectBtn();

    // when
    selectLocationScreenSteps.clickOnDoneBtn();

    // then
    verticalsScreenSteps.verifyAllStoresVertical();
  }

  @Test(
      description = "Verify cities with uncovered verticals",
      dependsOnMethods = {"verifyAllStoresVertical_isDisplayed"})
  public void verifyCityAreaIsNotCovered_isNotDisplayed() {

    // When

    verticalsScreenSteps.clickOnArrow();

    verticalsScreenSteps.clickOnAdd();

    selectLocationScreenSteps.clickOnSearchIcon();

    selectLocationScreenSteps.sendCityViaIosKeyboard("Alnamas");

    selectLocationScreenSteps.enterSearchUsingKeyboard();

    MobileElement btnNamasCity =
        driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Al Namas\"]");
    // when
    btnNamasCity.click();

    // then
    selectLocationScreenSteps.verifyNotCoveredArea();
  }
}
