package com.hs.mobile.steps.ios;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.ios.PaymentOptionsScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.PaymentOptionsScreenSteps;
import io.qameta.allure.Step;
import lombok.NonNull;

public class PaymentOptionsScreenStepsIOS extends BaseSteps<PaymentOptionsScreenStepsIOS>
    implements PaymentOptionsScreenSteps {

  @NonNull private final PaymentOptionsScreen paymentOptionsScreen;

  public PaymentOptionsScreenStepsIOS(@NonNull TestSettings settings) {
    super(settings);
    paymentOptionsScreen = new PaymentOptionsScreen(settings);
  }

  @Override
  @Step("Click on 'Cash on Delivery' payment option")
  public void clickOnCashOnDeliveryPayment() {
    paymentOptionsScreen.getBtnCashOnDelivery().click();
  }

  @Override
  @Step("Click on 'Mada Card' payment option")
  public void clickOnMadaPaymentOption() {
    paymentOptionsScreen.getMadaPaymentOption().click();
  }

  @Override
  @Step("Click on add new debit or credit card")
  public void clickOnAddCC() {}
}
