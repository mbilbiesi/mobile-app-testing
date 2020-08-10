package com.hs.mobile.screens.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SelectLocationScreen {

  @iOSXCUITFindBy(accessibility = "back_button")
  private MobileElement btnClose;


  private MobileElement lblSelectLocation;

  @iOSXCUITFindBy(accessibility = "search_button")
  private MobileElement btnSearch;

  private MobileElement txtAddress;

  private MobileElement imgLocationMarker;

  private MobileElement imgCurrentLocation;

  @iOSXCUITFindBy(accessibility = "select_address_button")
  private MobileElement btnSelectAddress;


}
