package com.hs.mobile.screens.ios;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class VerticalsScreen extends AbstractScreen {

  //_______________________
  //Start Address entry bar
  //_______________________
  @iOSXCUITFindBy(accessibility = "pin_icon")
  private MobileElement btnPinIcon;

  @iOSXCUITFindBy(accessibility = "delivery_to")
  private MobileElement btnDeliveryTo;


  @iOSXCUITFindBy(accessibility = "choose")
  private MobileElement btnChoose;

  @iOSXCUITFindBy(accessibility = "arrow_icon")
  private MobileElement btnArrow;

  @iOSXCUITFindBy(accessibility = "add_icon")
  private MobileElement btnAdd;
  //_______________________
  //End Address entry bar
  //_______________________

  @iOSXCUITFindBy(accessibility = "homeRow_0")
  private MobileElement lblAllStores;

  @iOSXCUITFindBy(accessibility = "homeRow_1")
  private MobileElement lblQuickMarket;

  @iOSXCUITFindBy(accessibility = "homeRow_2")
  private MobileElement lblOrderAnything;

  public VerticalsScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
