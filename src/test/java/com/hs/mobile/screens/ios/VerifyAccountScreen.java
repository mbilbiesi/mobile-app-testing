package com.hs.mobile.screens.ios;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class VerifyAccountScreen extends AbstractScreen {

  @iOSXCUITFindBy(accessibility = "phone_number")
  private MobileElement txtPhoneNumber;

  @iOSXCUITFindBy(accessibility = "next-button")
  private MobileElement btnNext;

  public VerifyAccountScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}