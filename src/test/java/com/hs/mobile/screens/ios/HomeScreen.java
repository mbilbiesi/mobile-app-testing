package com.hs.mobile.screens.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import java.util.List;

public class HomeScreen {

  //DONE HOMEPAGE:
  @iOSXCUITFindBy(accessibility = "custom_button")
  private List<MobileElement> btnDifferentLocation;

  @iOSXCUITFindBy(accessibility = "delivery_to")
  private MobileElement lblDeliveryTo;

  @iOSXCUITFindBy(accessibility = "choose")
  private MobileElement lblChooseLocation;

  private MobileElement btnFirstVerticalTitle;
  private MobileElement lblFirstVerticalStatus;
  private MobileElement txtSecondVerticalTitle;
  private MobileElement lblSecondVerticalStatus;
  private MobileElement txtThirdVerticalTitle;
  private MobileElement lblThirdVerticalStatus;


  private MobileElement btnHomeNavBar; //todo: look at providing id
  private MobileElement btnOrderNavBar; //todo: look at providing id
  private MobileElement btnOffersButtonNavBar; //todo: look at providing id
  private MobileElement btnMoreMenuNavBar; //todo: look at providing id


}
