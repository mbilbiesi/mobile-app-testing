package com.hs.mobile.screens.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class PinCodeVerificationScreen extends AbstractScreen {

  // @iOSXCUITFindBy(id = "test") todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/state_description")
  private MobileElement eleCustomerPhoneNumber;

  @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField'") // todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/edt_verification_number")
  private MobileElement txtVerificationCode;

  // @iOSXCUITFindBy(id = "test") todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/resend_pin")
  private MobileElement lnkResendPin;

  // @iOSXCUITFindBy(id = "test") todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/resend_call_pin")
  private MobileElement lnkResendPinCall;

  // @iOSXCUITFindBy(id = "test") BUTTON DOESN'T EXIST IN IOS APP
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btn_login")
  private MobileElement btnVerifyNumber;

  public PinCodeVerificationScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
