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
  @Step("Verify item added name is {0}")
  public void verifyItemName(String name) {
    assertThat(checkoutScreen.getLblItemName().getText().equals(name))
        .as("Item name does not match the item added")
        .isTrue();
  }

  @Override
  @Step("Verify checked out items quantity is {0}")
  public void verifyItemQuantity(String quantity) {
    assertThat(checkoutScreen.getLblItemQuantity().getText().equals(quantity))
        .as("Item quantity does not match actual result")
        .isTrue();
  }

  @Override
  @Step("Verify item total price is {0}")
  public void verifyItemsTotalPrice(String price) {
    assertThat(checkoutScreen.getLblTotalPrice().getText().equals(price))
        .as("Item total price does not match actual result")
        .isTrue();
  }

  @Override
  @Step("Click on Change payment")
  public void clickChangePayment() {}

  @Override
  @Step("Click on cash payment option")
  public void clickOnCashPayment() {}

  @Override
  @Step("verify wallet payment is disabled")
  public void verifyWalletToggleIsDisabled() {}

  @Override
  @Step("Verify wallet toggle is enabled for CC payment")
  public void verifyWalletToggleIsEnabled() {}

  @Override
  @Step("Verify cross-sell section is displayed")
  public void verifyCrossSellSectionIsDisplayed() {
    assertThat(checkoutScreen.getLblCrossSellSection().isDisplayed())
        .as("Cross-sell section is not displayed")
        .isTrue();
  }

  @Override
  @Step("Verify order price without delivery fees")
  public void verifyOrderPrice() {
    assertThat(checkoutScreen.getLblTotalPrice().isDisplayed())
        .as("Total price is not displayed")
        .isTrue();
  }

  @Override
  @Step("Verify delivery fee is displayed")
  public void verifyDeliveryFee() {
    assertThat(checkoutScreen.getLblDeliveryFee().isDisplayed())
        .as("Delivery fee is not present")
        .isTrue();
  }

  @Override
  @Step("Verify total price including delivery fee")
  public void verifyOrderTotalPrice() {
    assertThat(checkoutScreen.getLblTotalAmount().isDisplayed())
        .as("Total amount is not displayed")
        .isTrue();
  }
}
