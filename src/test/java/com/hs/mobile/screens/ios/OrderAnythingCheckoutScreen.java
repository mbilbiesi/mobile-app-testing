package com.hs.mobile.screens.ios;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class OrderAnythingCheckoutScreen extends AbstractScreen<OrderAnythingCheckoutScreen> {

  public OrderAnythingCheckoutScreen(@NonNull TestSettings settings) {
    super(settings);
  }

  @iOSXCUITFindBy(iOSNsPredicate = "label == 'Order Sent'")
  private MobileElement lblOrderSent;

  @iOSXCUITFindBy(iOSNsPredicate = "label == 'Personal shopper'")
  private MobileElement lblPersonalShopper;
}
