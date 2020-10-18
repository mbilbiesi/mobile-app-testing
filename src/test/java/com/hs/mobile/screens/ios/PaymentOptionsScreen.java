package com.hs.mobile.screens.ios;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class PaymentOptionsScreen extends AbstractScreen<PaymentOptionsScreen> {

  @iOSXCUITFindBy(iOSNsPredicate = "label == 'Mada Card'")
  private MobileElement madaPaymentOption;

  @iOSXCUITFindBy(accessibility = "option_cash")
  private MobileElement btnCashOnDelivery;

  public PaymentOptionsScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
