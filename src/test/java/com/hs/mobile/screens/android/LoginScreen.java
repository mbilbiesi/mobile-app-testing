package com.hs.mobile.screens.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class LoginScreen extends AbstractScreen<LoginScreen> {

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/phone_number")
  private MobileElement txtPhoneNumber;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btn_login")
  private MobileElement btnNext;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/edt_verification_number")
  private MobileElement txtCode;

  public LoginScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
