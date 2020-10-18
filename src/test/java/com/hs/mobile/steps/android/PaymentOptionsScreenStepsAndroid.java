package com.hs.mobile.steps.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.PaymentOptionsScreenSteps;
import lombok.NonNull;

public class PaymentOptionsScreenStepsAndroid extends BaseSteps<PaymentOptionsScreenStepsAndroid>
    implements PaymentOptionsScreenSteps {

  public PaymentOptionsScreenStepsAndroid(@NonNull TestSettings settings) {
    super(settings);
  }

  @Override
  public void clickOnCashOnDeliveryPayment() {}

  @Override
  public void clickOnMadaPaymentOption() {}
}
