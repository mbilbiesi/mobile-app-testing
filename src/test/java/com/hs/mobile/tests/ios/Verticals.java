package com.hs.mobile.tests.ios;


import static org.assertj.core.api.Assertions.assertThat;

import com.google.inject.Inject;
import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.ios.LandingScreen;
import com.hs.mobile.screens.ios.SelectLocationScreen;
import com.hs.mobile.screens.ios.VerticalsScreen;
import com.hs.mobile.tests.base.BaseStepsInitiator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;
import java.util.concurrent.TimeUnit;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;

public class Verticals extends BaseStepsInitiator {

  @Inject
  LandingScreen landingScreen;
  @Inject
  SelectLocationScreen selectLocationScreen;
  @Inject
  VerticalsScreen verticalsScreen;



  //@Inject
  //VerticalsScreen todo

  @Test(description = "Verify all verticals are displayed", priority = 0)
  public void navigateToHomeScreen_VerifyLocationIsChosen() {
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    try {
      driver.switchTo().alert().accept();
    }catch (NoAlertPresentException e){
      System.out.println(e.getMessage());
    }


    //
    MobileElement choose = landingScreen.getBtnChoose();

    //MobileElement choose = landingScreen.getLblDeliveryTo();
    choose.click();


    MobileElement btnSearch = selectLocationScreen.getBtnSearch();
    btnSearch.click();

    MobileElement searchBar = landingScreen.getSearchBar();
    searchBar.sendKeys("Riyadh");

    MobileElement keyboardSearch = landingScreen.getKeyboardInputSearch();
    keyboardSearch.click();

    MobileElement city = driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Riyadh\"]");
    city.click();

    MobileElement btnSelectAddress = selectLocationScreen.getBtnSelectAddress();
    btnSelectAddress.click();

    MobileElement btnDone = selectLocationScreen.getBtnDone();
        //.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Done\"]");
    btnDone.click();

    SoftAssertions soft = new SoftAssertions();
    MobileElement lblAllStores = verticalsScreen.getLblAllStores();
    soft.assertThat(lblAllStores.isDisplayed())
        .as("'All stores' vertical is not displayed")
        .isTrue();

    MobileElement lblQuickMarket = verticalsScreen.getLblQuickMarket();
    soft.assertThat(lblQuickMarket.isDisplayed()).isTrue();

    MobileElement lblOrderAnything = verticalsScreen.getLblOrderAnything();
    soft.assertThat(lblOrderAnything.isDisplayed()).isTrue();


    System.out.println("Verticals are present");
    verifyVerticalsBasedOnLocations();
  }

  @Test(description = "Verify all verticals are displayed based on location", priority = 1)
  public void verifyVerticalsBasedOnLocations(){

    //test case only homeRow_1 present (All-Stores Vertical)
    MobileElement btnArrow = verticalsScreen.getBtnArrow();
    btnArrow.click();

    MobileElement btnAddLocation = verticalsScreen.getBtnAdd();
    btnAddLocation.click();

    MobileElement btnSearch_1 = selectLocationScreen.getBtnSearch();
    btnSearch_1.click();

    MobileElement searchBar = selectLocationScreen.getSearchBar();

    //Using iOS keyboard
    searchBar.sendKeys("Jeddah");

    //iOS Keyboard Input
    MobileElement keyboardSearch = driver.findElementById("Search");
    keyboardSearch.click();

    MobileElement jeddah = driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Jeddah\"]");
    jeddah.click();


    MobileElement select = selectLocationScreen.getBtnSelectAddress();
    select.click();


    MobileElement btnDone = selectLocationScreen.getBtnDone();
    btnDone.click();

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    MobileElement lblAllStores = verticalsScreen.getLblAllStores();

    SoftAssertions softCheck = new SoftAssertions();
    softCheck.assertThat(lblAllStores.isDisplayed())
        .as("'All stores' vertical is not displayed")
        .isTrue();

    softCheck.assertThat(lblAllStores.isDisplayed())
        .as("Quick Market vertical is not displayed")
        .isTrue();


  }
}
