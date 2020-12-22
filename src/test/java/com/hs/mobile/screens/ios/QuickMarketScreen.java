package com.hs.mobile.screens.ios;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class QuickMarketScreen extends AbstractScreen<QuickMarketScreen> {

  @iOSXCUITFindBy(accessibility = "icon_cart")
  private MobileElement lblCart;

  public QuickMarketScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
