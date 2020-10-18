package com.hs.mobile.steps.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.CheckoutScreenSteps;

public class CheckoutScreenStepsAndroid extends BaseSteps<CheckoutScreenStepsAndroid>
    implements CheckoutScreenSteps {

  public CheckoutScreenStepsAndroid(TestSettings testSettings) {
    super(testSettings);
  }

  @Override
  public void skipNoteHint() {}

  @Override
  public void enterPhoneNumber(String phoneNumber) {}

  @Override
  public void clickOnNext() {}

  @Override
  public void enterOtpCode(String otpCode) {}

  @Override
  public void enterMadaSecurityCode(String securityCode) {}

  @Override
  public void placeOrder() {}

  @Override
  public void typeVerificationCodeOnGatewaySimulator(String verificationMessage) {}

  @Override
  public void clickOnContinue() {}

  @Override
  public void changePaymentMethod() {}

  @Override
  public void verifyOrderIsSubmitted() {}
}
