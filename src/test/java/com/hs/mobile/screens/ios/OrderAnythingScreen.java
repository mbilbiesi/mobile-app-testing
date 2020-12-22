package com.hs.mobile.screens.ios;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public class OrderAnythingScreen extends AbstractScreen<OrderAnythingScreen> {

  @iOSXCUITFindBy(accessibility = "Shop from")
  private MobileElement lblShopFrom;

  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Delivery Fees'`]")
  private MobileElement lblDeliveryFeesOA;

  public OrderAnythingScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
