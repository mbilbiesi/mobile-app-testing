package com.hs.mobile.screens.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public class SelectLocationScreen extends AbstractScreen<SelectLocationScreen> {

  @AndroidFindBy(accessibility = "Navigate up")
  private MobileElement btnNavigationUp;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/searchBarLocationName")
  private MobileElement searchBar;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/places_autocomplete_search_bar")
  private AndroidElement searchTextField;

  @AndroidFindBy(
      id = "com.hungerstation.android.web.debug:id/places_autocomplete_prediction_primary_text")
  private AndroidElement searchResult;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/marker_location")
  private MobileElement imgLocationMarker;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/my_current_location")
  private MobileElement imgCurrentLocation;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/placeName")
  private MobileElement txtPlaceName;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/address")
  private MobileElement txtAddress;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/BtnAddAddress")
  private MobileElement btnSelect;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/save_location_switch")
  private MobileElement btnSwitchSaveForLater;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/home_rb")
  private MobileElement btnHomeIcon;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/marker_location")
  private MobileElement iconMapPin;

  public SelectLocationScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
