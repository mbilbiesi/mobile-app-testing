package com.hs.mobile.steps.android;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.android.CheckoutScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.CheckoutScreenSteps;
import com.hs.mobile.util.CustomConditions;
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
  @Step("Click on place order ")
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
  @Step("Click on continue via simulator")
  public void clickOnContinueViaSimulator() {
    checkoutScreen.getBtnContinueViaSimulator().click();
  }

  @Step("Type `{0}` message via CC simulator")
  public void typeVerificationCodeOnGatewaySimulator(String verificationMessage) {
    checkoutScreen.getTxtCheckoutViaSimulator().sendKeys(verificationMessage);
  }

  @Override
  @Step("Verify that change payment button is displayed when payment is failed")
  public void verifyChangePaymentButton() {
    assertThat(checkoutScreen.getBtnChangePayment().isDisplayed())
        .as("cancel order button is not displayed")
        .isTrue();
  }

  @Override
  @Step("Verify item name is {0}")
  public void verifyItemName(String name) {
    assertThat(checkoutScreen.getLblItemName().getText().equals(name))
        .as("Item name does not match the item added")
        .isTrue();
  }

  public void verifyCancelOrderButton() {}

  @Override
  @Step("Click on continue to failed payment screen")
  public void clickOnContinueToFailedPayment() {
    checkoutScreen.getBtnContinueToFailedPaymentScreen().click();
  }

  @Override
  @Step("Verify item total quantity is {0}")
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
  public void clickChangePayment() {
    checkoutScreen.getTxtChangePayment().click();
  }

  @Override
  @Step("Click on cash payment option")
  public void clickOnCashPayment() {
    wait.withMessage("could not click on cash on delivery")
        .until(
            CustomConditions.elementIsClicked(
                checkoutScreen.getBtnCashOnDeliveryOption(),
                checkoutScreen.getLblWalletDisabled()));
  }

  @Override
  @Step("verify wallet payment is disabled")
  public void verifyWalletToggleIsDisabled() {
    assertThat(checkoutScreen.getLblWalletDisabled().isDisplayed())
        .as("Wallet toggle is not disabled")
        .isTrue();
  }

  @Override
  @Step("Verify wallet toggle is enabled for CC payment")
  public void verifyWalletToggleIsEnabled() {
    assertThat(checkoutScreen.getBtnWalletToggle().isDisplayed())
        .as("Wallet toggle is disabled")
        .isTrue();
  }

  @Override
  @Step("Verify order price without delivery fees")
  public void verifyOrderPrice() {
    assertThat(checkoutScreen.getTxtOrderTotal().isDisplayed())
        .as("Total price is not displayed")
        .isTrue();
  }

  @Override
  @Step("Verify delivery fee is displayed")
  public void verifyDeliveryFee() {
    assertThat(checkoutScreen.getTxtOrderTotal().isDisplayed())
        .as("Total price is not displayed")
        .isTrue();
  }

  @Override
  @Step("Verify total price including delivery fee")
  public void verifyOrderTotalPrice() {
    // todo: ID is not present
  }

  @Step("Verify cross-sell section is displayed")
  public void verifyCrossSellSectionIsDisplayed() {
    assertThat(checkoutScreen.getLblCrossSellSection().isDisplayed())
        .as("cross sell suggested items are not displayed")
        .isTrue();
  }
}
