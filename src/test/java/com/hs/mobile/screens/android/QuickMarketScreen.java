package com.hs.mobile.screens.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class QuickMarketScreen extends AbstractScreen<QuickMarketScreen> {

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btnCart")
  private AndroidElement lblCart;

  public QuickMarketScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
