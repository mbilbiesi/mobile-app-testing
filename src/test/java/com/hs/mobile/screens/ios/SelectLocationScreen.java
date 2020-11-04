package com.hs.mobile.screens.ios;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import lombok.NonNull;

@Getter
@SuppressWarnings("unused")
public class SelectLocationScreen extends AbstractScreen<SelectLocationScreen> {

  @iOSXCUITFindBy(accessibility = "back_button")
  private MobileElement btnClose;

  @iOSXCUITFindBy(accessibility = "Search")
  private MobileElement btnSearch;

  @iOSXCUITFindBy(accessibility = "searchBar")
  private MobileElement searchBar;

  @iOSXCUITFindBy(accessibility = "Search")
  private MobileElement keyboardInputSearch;

  @iOSXCUITFindBy(accessibility = "select_address_button")
  private MobileElement btnSelectAddress;

  @iOSXCUITFindBy(accessibility = "show_icon_switch")
  private MobileElement btnSwitchSaveForLater;

  @iOSXCUITFindBy(accessibility = "home_icon")
  private MobileElement btnHomeIcon;

  @iOSXCUITFindBy(accessibility = "pin img ic")
  private MobileElement iconMapPin;

  @iOSXCUITFindBy(accessibility = "save_button")
  private MobileElement btnDone;

  public SelectLocationScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
