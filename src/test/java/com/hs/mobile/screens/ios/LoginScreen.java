package com.hs.mobile.screens.ios;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class LoginScreen extends AbstractScreen<LoginScreen> {

  @iOSXCUITFindBy(accessibility = "phone_number")
  private MobileElement txtPhoneNumber;

  @iOSXCUITFindBy(accessibility = "next_button")
  private MobileElement btnNext;

  @iOSXCUITFindBy(accessibility = "code_text")
  private MobileElement txtCode;

  public LoginScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
