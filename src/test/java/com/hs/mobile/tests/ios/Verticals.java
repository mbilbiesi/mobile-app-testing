package com.hs.mobile.tests.ios;


import com.google.inject.Inject;
import com.hs.mobile.steps.ios.LandingScreenSteps;
import com.hs.mobile.steps.ios.SelectLocationScreenSteps;
import com.hs.mobile.steps.ios.VerticalsScreenSteps;
import com.hs.mobile.tests.base.BaseStepsInitiator;
import io.appium.java_client.MobileElement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;

public class Verticals extends BaseStepsInitiator {

  @Inject
  private LandingScreenSteps landingScreenSteps;

  @Inject
  private SelectLocationScreenSteps selectLocationScreenSteps;

  @Inject
  private VerticalsScreenSteps verticalsScreenSteps;

  //@Inject
  //VerticalsScreen todo

  @Test(description = "Verify all verticals are displayed", priority = 0)
  public void navigateToHomeScreen_VerifyLocationIsChosen() throws InterruptedException {
    // Given
    try {
      driver.switchTo().alert().accept();
      //driver.switchTo().defaultContent();
    } catch (NoAlertPresentException e) {
      System.out.println(e.getMessage());
    }
    waiting();

    // When
    landingScreenSteps.selectNewAddress();

    waiting();
    selectLocationScreenSteps.clickOnSearchIcon();
    selectLocationScreenSteps.sendCityViaIosKeyboard();
    selectLocationScreenSteps.enterSearchUsingKeyboard();
    selectLocationScreenSteps.clickOnCity();
    selectLocationScreenSteps.clickOnSelectBtn();
    selectLocationScreenSteps.clickOnDoneBtn();

    // Then
    verticalsScreenSteps.assertAllVerticals();
  }

  //enabled = false,
  @Test(description = "Verify all verticals are displayed based on location", priority = 1)
  public void verifyVerticalsBasedOnLocations() {

    //given
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    verticalsScreenSteps.clickOnArrow();

    verticalsScreenSteps.clickOnAdd();

    selectLocationScreenSteps.clickOnSearchIcon();

    selectLocationScreenSteps.sendCityViaIosKeyboard2();

    selectLocationScreenSteps.enterSearchUsingKeyboard();

    MobileElement jeddah = driver
        .findElementByXPath("//XCUIElementTypeStaticText[@name=\"Jeddah\"]");
    jeddah.click();

    selectLocationScreenSteps.clickOnSelectBtn();

    //when
    selectLocationScreenSteps.clickOnDoneBtn();

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    waiting();

    //then
    verticalsScreenSteps.assertTwoVerticalsAreDisplayed();

  }

  //enabled = false,
  @Test(description = "Verify only All Stores Vertical is displayed", priority = 2)
  public void verifyAllStoresVertical_isDisplayed() {
    //test case only homeRow_1 present (All-Stores Vertical)

    //given
    waiting();

    verticalsScreenSteps.clickOnArrow();

    verticalsScreenSteps.clickOnAdd();

    selectLocationScreenSteps.clickOnSearchIcon();

    selectLocationScreenSteps.sendCityViaIosKeyboard3();

    selectLocationScreenSteps.enterSearchUsingKeyboard();

    MobileElement khobar = driver
        .findElementByXPath("//XCUIElementTypeStaticText[@name=\"Khobar\"]");
    khobar.click();

    selectLocationScreenSteps.clickOnSelectBtn();

    waiting();
    //when
    selectLocationScreenSteps.clickOnDoneBtn();

    //then
    verticalsScreenSteps.verifyAllStoresVertical();

  }

  @Test(description = "Verify cities with uncovered verticals", priority = 3)
  public void verifyCityAreaIsNotCovered_isNotDisplayed() {

    //given
    waiting();

    verticalsScreenSteps.clickOnArrow();

    verticalsScreenSteps.clickOnAdd();

    selectLocationScreenSteps.clickOnSearchIcon();

    selectLocationScreenSteps.sendCityViaIosKeyboard4();

    selectLocationScreenSteps.enterSearchUsingKeyboard();

    MobileElement btnNamasCity = driver
        .findElementByXPath("//XCUIElementTypeStaticText[@name=\"Al Namas\"]");
    //when
    btnNamasCity.click();

    waiting();

    //then
    selectLocationScreenSteps.verifyNotCoveredArea();

    waiting();
    waiting();

  }

  public void waiting() {
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
