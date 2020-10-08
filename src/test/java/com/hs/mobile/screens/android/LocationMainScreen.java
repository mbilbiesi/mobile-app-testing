package com.hs.mobile.screens.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.NonNull;

@SuppressWarnings("unused")
@Getter
public class LocationMainScreen extends AbstractScreen {

  // todo: ask developer to unique accessibility locator
  private AndroidElement imgLogo;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/ic_location")
  private AndroidElement imgPin;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delivery_label")
  private AndroidElement lblDeliverTo;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delivery_value")
  private AndroidElement txtDeliveryValue;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/ic_dropdown")
  private AndroidElement imgArrowDown;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/missing_location_image")
  private AndroidElement imgMissingLocation;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/explanation")
  private AndroidElement lblExplanation;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/give_permission_button")
  private AndroidElement btnGivePermission;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/enable_location")
  private AndroidElement btnEnableLocation;

  public LocationMainScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
