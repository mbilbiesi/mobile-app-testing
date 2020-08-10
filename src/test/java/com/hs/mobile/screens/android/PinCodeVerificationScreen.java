package com.hs.mobile.screens.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class PinCodeVerificationScreen extends AbstractScreen {

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/state_description")
  private MobileElement eleCustomerPhoneNumber;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/edt_verification_number")
  private MobileElement txtVerificationCode;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/resend_pin")
  private MobileElement lnkResendPin;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/resend_call_pin")
  private MobileElement lnkResendPinCall;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btn_login")
  private MobileElement btnVerifyNumber;

  public PinCodeVerificationScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
