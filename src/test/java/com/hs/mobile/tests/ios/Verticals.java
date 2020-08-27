package com.hs.mobile.tests.ios;


import static org.assertj.core.api.Assertions.assertThat;

import com.google.inject.Inject;
import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.ios.LandingScreen;
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

  @Test
  public void navigateToHomeScreen_VerifyLocationIsChosen() {
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    try {
      driver.switchTo().alert().accept();
    }catch (NoAlertPresentException e){
      System.out.println(e.getMessage());
    }


    //
    //MobileElement choose = driver.findElementById("delivery_to");

    MobileElement choose = landingScreen.getLblDeliveryTo();
    choose.click();

    //MobileElement choose = driver.findElement()

    MobileElement btnSearch = driver.findElementById("search_button");
    btnSearch.click();

    MobileElement searchBar = driver.findElementById("searchBar");
    searchBar.sendKeys("Riyadh");
    MobileElement keyboardSearch = driver.findElementById("Search");
    keyboardSearch.click();

    MobileElement city = driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Riyadh\"]");
    city.click();

    MobileElement btnSelectAddress = driver.findElementById("select_address_button");
    btnSelectAddress.click();

    MobileElement btnDone = driver
        .findElementByXPath("//XCUIElementTypeStaticText[@name=\"Done\"]");
    btnDone.click();

    SoftAssertions soft = new SoftAssertions();
    MobileElement lblAllStores = driver.findElementById("homeRow_0");
    soft.assertThat(lblAllStores.isDisplayed())
        .as("'All stores' vertical is not displayed")
        .isFalse();

    MobileElement lblQuickMarket = driver.findElementById("homeRow_1");
    soft.assertThat(lblAllStores.isDisplayed()).isTrue();

    MobileElement lblOrderAnything = driver.findElementById("homeRow_2");
    soft.assertThat(lblAllStores.isDisplayed()).isTrue();
    soft.assertAll();

    System.out.println("Verticals are present");
  }


}
