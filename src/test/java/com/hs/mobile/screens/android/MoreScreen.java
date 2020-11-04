package com.hs.mobile.screens.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class MoreScreen extends AbstractScreen<MoreScreen> {

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/slide_login")
  private MobileElement btnLogin;

  @iOSXCUITFindBy(accessibility = "Home")
  private MobileElement btnHome;

  public MoreScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
