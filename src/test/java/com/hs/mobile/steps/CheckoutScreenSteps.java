package com.hs.mobile.steps;

public interface CheckoutScreenSteps {

  void skipNoteHint();

  void enterPhoneNumber(String phoneNumber);

  void clickOnNext();

  void enterOtpCode(String otpCode);

  void enterMadaSecurityCode(String securityCode);

  void placeOrder();

  void typeVerificationCodeOnGatewaySimulator(String verificationMessage);

  void clickOnContinue();

  void changePaymentMethod();

  void verifyOrderIsSubmitted();
}
