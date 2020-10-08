package com.hs.mobile.screens.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public class AddLocationDescriptionScreen extends AbstractScreen<AddLocationDescriptionScreen> {

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/user_address_description")
  private MobileElement lblPlaceDescription;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/editDescription")
  private MobileElement txtEditDescription;

  // todo: ask developer to unique accessibility locator
  private MobileElement lblSaveLocationForLater;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/save_location_switch")
  private MobileElement switchSaveLocation;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/BtnAddAddress")
  private MobileElement btnDone;

  public AddLocationDescriptionScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
