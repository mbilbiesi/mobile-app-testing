package com.hs.mobile.screens.ios;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import lombok.NonNull;

@Getter
@SuppressWarnings("unused")
public class LandingScreen extends AbstractScreen<LandingScreen> {

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

  @iOSXCUITFindBy(accessibility = "More")
  private MobileElement btnMore;

  @iOSXCUITFindBy(accessibility = "more_action")
  private MobileElement btnMoreAction;

  @iOSXCUITFindBy(accessibility = "Edit Address, Home")
  private MobileElement btnEditAddress;

  @iOSXCUITFindBy(accessibility = "Delete Address, Home")
  private MobileElement btnDeleteAddress;

  @iOSXCUITFindBy(iOSNsPredicate = "label == 'Remove'")
  private MobileElement btnRemove;

  @iOSXCUITFindBy(accessibility = "address_label")
  private MobileElement addressLabel;

  @iOSXCUITFindBy(accessibility = "Orders")
  private MobileElement btnOrders;

  public LandingScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
