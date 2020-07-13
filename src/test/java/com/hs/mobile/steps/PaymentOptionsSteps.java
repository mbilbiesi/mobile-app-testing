package com.hs.mobile.steps;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.PaymentOptionsScreen;
import lombok.NonNull;

public class PaymentOptionsSteps extends BaseSteps {

  @NonNull
  private final PaymentOptionsScreen paymentOptionsScreen;

  public PaymentOptionsSteps(@NonNull TestSettings settings) {
    super(settings);
    paymentOptionsScreen = new PaymentOptionsScreen(settings);
  }

  public void openWallet() {
    tap(paymentOptionsScreen.getBtnWallet());
  }
}
