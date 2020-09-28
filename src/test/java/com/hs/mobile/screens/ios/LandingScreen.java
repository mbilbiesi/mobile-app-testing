package com.hs.mobile.screens.ios;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import lombok.NonNull;

@Getter
@SuppressWarnings("unused")
public class LandingScreen extends AbstractScreen {

  @iOSXCUITFindBy(accessibility = "pin_icon")
  private MobileElement btnPinIcon;

  @iOSXCUITFindBy(accessibility = "delivery_to")
  private MobileElement btnDeliveryTo;

  @iOSXCUITFindBy(accessibility = "choose")
  private MobileElement btnChoose;

  @iOSXCUITFindBy(accessibility = "arrow_icon")
  private MobileElement btnArrow;

  @iOSXCUITFindBy(accessibility = "header_logo")
  private MobileElement imgHeaderIcon;

  @iOSXCUITFindBy(accessibility = "custom_button")
  private MobileElement btnAllowAccess;

  @iOSXCUITFindBy(accessibility = "custom_button")
  private MobileElement btnManualLocation;

  public LandingScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}