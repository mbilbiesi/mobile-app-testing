package com.hs.mobile.screens;

import com.hs.mobile.core.settings.TestSettings;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class VerifyAccountScreen extends AbstractScreen {

  @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField'") // todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/phone_number")
  private MobileElement txtPhoneNumber;

  @iOSXCUITFindBy(accessibility = "next-button")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btn_login")
  private MobileElement btnNext;

  public VerifyAccountScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
