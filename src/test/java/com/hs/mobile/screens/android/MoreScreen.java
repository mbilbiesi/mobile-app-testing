package com.hs.mobile.screens.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class MoreScreen extends AbstractScreen<MoreScreen> {

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/slide_login")
  private MobileElement btnSlideLogin;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/slide_payment_options")
  private MobileElement btnSlidePaymentOptions;

  public MoreScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
