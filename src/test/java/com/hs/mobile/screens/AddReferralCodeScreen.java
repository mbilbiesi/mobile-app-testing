package com.hs.mobile.screens;

import com.hs.mobile.core.annotation.AssertElementVisibility;
import com.hs.mobile.core.settings.TestSettings;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class AddReferralCodeScreen extends AbstractScreen {

  @iOSXCUITFindBy(accessibility = "Skip") // todo:ChangeArabicId
  @AndroidFindBy(className = "android.widget.ImageButton")
  @AssertElementVisibility
  private MobileElement btnClose;

  @iOSXCUITFindBy(className = "") // todo:id
  @AndroidFindBy(className = "android.widget.ImageView")
  @AssertElementVisibility
  private MobileElement imgReferralCode;

  @iOSXCUITFindBy(accessibility = "Please enter you referral code") // todo:ChangeArabicId
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/txt_code_label")
  @AssertElementVisibility
  private MobileElement lblReferralCode;

  @iOSXCUITFindBy(id = "") // todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/edt_referral")
  @AssertElementVisibility
  private MobileElement txtReferralCode;

  @iOSXCUITFindBy(id = "") // todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btn_verify")
  @AssertElementVisibility
  private MobileElement btnVerifyReferralCode;

  public AddReferralCodeScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
