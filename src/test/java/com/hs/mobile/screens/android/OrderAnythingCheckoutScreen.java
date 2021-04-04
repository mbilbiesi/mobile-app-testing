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
public class OrderAnythingCheckoutScreen extends AbstractScreen<OrderAnythingCheckoutScreen> {

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/order_number")
  private MobileElement lblOrderNumber;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/order_anything")
  private MobileElement lblPersonalShopper;

  public OrderAnythingCheckoutScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
