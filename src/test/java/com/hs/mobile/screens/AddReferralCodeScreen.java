package com.hs.mobile.screens;

import com.hs.mobile.core.annotation.AssertElementVisibility;
import com.hs.mobile.core.settings.TestSettings;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class AddReferralCodeScreen extends AbstractScreen {

  @AndroidFindBy(className = "android.widget.ImageButton")
  @AssertElementVisibility
  private MobileElement btnClose;

  @AndroidFindBy(className = "android.widget.ImageView")
  @AssertElementVisibility
  private MobileElement imgReferralCode;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/txt_code_label")
  @AssertElementVisibility
  private MobileElement lblReferralCode;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/edt_referral")
  @AssertElementVisibility
  private MobileElement txtReferralCode;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btn_verify")
  @AssertElementVisibility
  private MobileElement btnVerifyReferralCode;

  public AddReferralCodeScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
