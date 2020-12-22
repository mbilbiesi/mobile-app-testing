package com.hs.mobile.screens.ios;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.NonNull;

public class OrdersScreen extends AbstractScreen<OrdersScreen> {

  @iOSXCUITFindBy(accessibility = "custom_button")
  private MobileElement btnLogin;

  public OrdersScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
