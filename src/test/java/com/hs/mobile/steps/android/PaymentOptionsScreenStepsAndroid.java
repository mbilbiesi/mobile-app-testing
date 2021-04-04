package com.hs.mobile.steps.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.android.PaymentOptionsScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.PaymentOptionsScreenSteps;
import io.qameta.allure.Step;
import lombok.NonNull;

public class PaymentOptionsScreenStepsAndroid extends BaseSteps<PaymentOptionsScreenStepsAndroid>
    implements PaymentOptionsScreenSteps {

  @NonNull private final PaymentOptionsScreen paymentOptionsScreen;

  public PaymentOptionsScreenStepsAndroid(@NonNull TestSettings settings) {
    super(settings);
    paymentOptionsScreen = new PaymentOptionsScreen(settings);
  }

  @Override
  public void clickOnCashOnDeliveryPayment() {}

  @Override
  public void clickOnMadaPaymentOption() {}

  @Override
  @Step("Click on add new debit or credit card")
  public void clickOnAddCC() {
    paymentOptionsScreen.getBtnAddNewCC().click();
  }
}
