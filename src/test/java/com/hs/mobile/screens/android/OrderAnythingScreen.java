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
public class OrderAnythingScreen extends AbstractScreen<OrderAnythingScreen> {

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/pickupLocationLabel")
  private MobileElement lblPickUpLocation;

  public OrderAnythingScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
