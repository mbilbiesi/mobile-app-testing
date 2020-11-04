package com.hs.mobile.screens.ios;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class MoreScreen extends AbstractScreen<MoreScreen> {

  @iOSXCUITFindBy(accessibility = "cell_0")
  private MobileElement btnReferralCode;

  @iOSXCUITFindBy(accessibility = "cell_2")
  private MobileElement btnLogin;

  @iOSXCUITFindBy(accessibility = "cell_3")
  private MobileElement btnPaymentOptions;

  @iOSXCUITFindBy(accessibility = "cell_4")
  private MobileElement btnInvoices;

  @iOSXCUITFindBy(accessibility = "cell_5")
  private MobileElement btnSupport;

  @iOSXCUITFindBy(accessibility = "cell_7")
  private MobileElement btnSettings;

  @iOSXCUITFindBy(accessibility = "Home")
  private MobileElement btnHome;

  public MoreScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
