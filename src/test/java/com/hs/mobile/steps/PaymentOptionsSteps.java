package com.hs.mobile.steps;

import com.hs.mobile.screens.PaymentOptionsScreen;
import io.appium.java_client.AppiumDriver;

public class PaymentOptionsSteps extends BaseSteps {
  private PaymentOptionsScreen paymentOptionsScreen;

    public PaymentOptionsSteps(AppiumDriver driver, String language) {
    super(driver);
    paymentOptionsScreen = new PaymentOptionsScreen(driver);
  }

  public void openWallet() {
    tap(paymentOptionsScreen.getBtnWallet());
  }
}
