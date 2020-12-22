package com.hs.mobile.steps;

public interface CheckoutScreenSteps {

  void skipNoteHint();

  void enterMadaSecurityCode(String securityCode);

  void placeOrder();

  void typeVerificationCodeOnGatewaySimulator(String verificationMessage);

  void clickOnContinue();

  void changePaymentMethod();

  void verifyOrderIsSubmitted();

  void clickOnDone();

  void clickOnContinueViaSimulator();
}
