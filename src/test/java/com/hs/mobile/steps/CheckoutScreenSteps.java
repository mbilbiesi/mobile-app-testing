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

  void verifyCancelOrderButton();

  void verifyChangePaymentButton();

  void clickOnContinueToFailedPayment();

  void verifyCrossSellSectionIsDisplayed();

  void verifyItemName(String name);

  void verifyItemQuantity(String quantity);

  void verifyItemsTotalPrice(String price);
}
