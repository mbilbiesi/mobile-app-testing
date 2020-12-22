package com.hs.mobile.steps.android;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.android.CheckoutScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.CheckoutScreenSteps;
import io.qameta.allure.Step;
import lombok.NonNull;

public class CheckoutScreenStepsAndroid extends BaseSteps<CheckoutScreenStepsAndroid>
    implements CheckoutScreenSteps {

  @NonNull private final CheckoutScreen checkoutScreen;

  public CheckoutScreenStepsAndroid(TestSettings settings) {
    super(settings);
    checkoutScreen = new CheckoutScreen(settings);
  }

  @Override
  public void skipNoteHint() {}

  @Override
  @Step("Enter credit card cvv code")
  public void enterMadaSecurityCode(String securityCode) {
    checkoutScreen.getTxtCvvCode().sendKeys(securityCode);
  }

  @Override
  @Step("Click on place order")
  public void placeOrder() {
    checkoutScreen.getBtnPlaceOrder().click();
  }

  @Override
  @Step("Click on continue")
  public void clickOnContinue() {
    checkoutScreen.getBtnContinue().click();
  }

  @Override
  public void changePaymentMethod() {}

  @Override
  @Step("Verify order is submitted after checking out")
  public void verifyOrderIsSubmitted() {
    assertThat(checkoutScreen.getLblOrderNumber().isDisplayed())
        .as("order is not completed")
        .isTrue();
  }

  @Override
  @Step("Click on done after adding a credit card")
  public void clickOnDone() {
    checkoutScreen.getBtnDone().click();
  }

  @Override
  @Step("Type `{0}` message via CC simulator")
  public void typeVerificationCodeOnGatewaySimulator(String verificationMessage) {
    checkoutScreen.getTxtCheckoutViaSimulator().sendKeys(verificationMessage);
  }

  @Step("Click on continue via simulator")
  public void clickOnContinueViaSimulator() {
    checkoutScreen.getBtnContinueViaSimulator().click();
  }

  @Override
  public void verifyCancelOrderButton() {}

  @Override
  @Step("Verify that change payment button is displayed when payment is failed")
  public void verifyChangePaymentButton() {
    assertThat(checkoutScreen.getBtnChangePayment().isDisplayed())
        .as("cancel order button is not displayed")
        .isTrue();
  }

  @Override
  @Step("Click on continue to failed payment screen")
  public void clickOnContinueToFailedPayment() {
    // valid for Android only
    checkoutScreen.getBtnContinueToFailedPaymentScreen().click();
  }

  @Override
  @Step("Verify cross-sell section is displayed")
  public void verifyCrossSellSectionIsDisplayed() {
    assertThat(checkoutScreen.getLblCrossSellSection().isDisplayed())
        .as("cross sell suggested items are not displayed")
        .isTrue();
  }
}
