package com.hs.mobile.steps.ios;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.ios.CheckoutScreen;
import com.hs.mobile.screens.ios.OrderDetailsScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.CheckoutScreenSteps;
import io.qameta.allure.Step;
import lombok.NonNull;

public class CheckoutScreenStepsIOS extends BaseSteps<CheckoutScreenStepsIOS>
    implements CheckoutScreenSteps {

  @NonNull private final CheckoutScreen checkoutScreen;
  @NonNull private final OrderDetailsScreen orderDetailsScreen;

  public CheckoutScreenStepsIOS(@NonNull TestSettings testSettings) {
    super(testSettings);
    checkoutScreen = new CheckoutScreen(testSettings);
    orderDetailsScreen = new OrderDetailsScreen(testSettings);
  }

  @Override
  @Step("Skip note hint")
  public void skipNoteHint() {
    checkoutScreen.getTxtNoteHint().click();
  }

  @Override
  @Step("Enter Mada credit card security code : {0}")
  public void enterMadaSecurityCode(String securityCode) {
    checkoutScreen.getTxtCvvCode().sendKeys(securityCode);
    checkoutScreen.getKeyboardInputDone().click();
    checkoutScreen.getBtnContinue().click();
  }

  @Override
  @Step("Click on place order")
  public void placeOrder() {
    checkoutScreen.getBtnPlaceOrder().click();
  }

  @Override
  @Step("enter check out via web credit card simulator")
  public void typeVerificationCodeOnGatewaySimulator(String verificationMessage) {
    checkoutScreen.getWebTxtCheckout().sendKeys(verificationMessage);
  }

  @Override
  @Step("Click on continue")
  public void clickOnContinue() {
    checkoutScreen.getWebBtnContinue().click();
  }

  @Override
  @Step("Click on change payment method")
  public void changePaymentMethod() {
    checkoutScreen.getBtnPaymentOption().click();
  }

  @Override
  @Step("Verify order is submitted successfully")
  public void verifyOrderIsSubmitted() {
    assertThat(orderDetailsScreen.getStatusSubTitleList().size())
        .as("Order is not submitted successfully")
        .isEqualTo(3);
  }

  @Override
  @Step("Click on done button")
  public void clickOnDone() {}

  @Override
  public void clickOnContinueViaSimulator() {}

  @Override
  @Step("Verify cancel button is displayed when payment is failed")
  public void verifyCancelOrderButton() {
    assertThat(checkoutScreen.getBtnCancelOrder().isDisplayed())
        .as("cancel order button is not displayed")
        .isTrue();
  }

  @Override
  @Step("Verify that change payment button is displayed when payment is failed")
  public void verifyChangePaymentButton() {
    assertThat(checkoutScreen.getBtnChangePaymentMethod().isDisplayed())
        .as("cancel order button is not displayed")
        .isTrue();
  }

  @Override
  public void clickOnContinueToFailedPayment() {}

  @Override
  @Step("Verify cross-sell section is displayed")
  public void verifyCrossSellSectionIsDisplayed() {
    assertThat(checkoutScreen.getLblCrossSellSection().isDisplayed())
        .as("Cross-sell section is not displayed")
        .isTrue();
  }
}
