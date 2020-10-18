package com.hs.mobile.steps.ios;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.ios.CheckoutScreen;
import com.hs.mobile.screens.ios.MenuItemScreen;
import com.hs.mobile.screens.ios.OrderDetailsScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.CheckoutScreenSteps;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import lombok.NonNull;

public class CheckoutScreenStepsIOS extends BaseSteps<CheckoutScreenStepsIOS>
    implements CheckoutScreenSteps {

  @NonNull private final CheckoutScreen checkoutScreen;
  @NonNull private final OrderDetailsScreen orderDetailsScreen;
  @NonNull private final MenuItemScreen menuItemScreen;

  public CheckoutScreenStepsIOS(@NonNull TestSettings testSettings) {
    super(testSettings);
    checkoutScreen = new CheckoutScreen(testSettings);
    orderDetailsScreen = new OrderDetailsScreen(testSettings);
    menuItemScreen = new MenuItemScreen(testSettings);
  }

  @Override
  @Step("Skip note hint")
  public void skipNoteHint() {
    checkoutScreen.getTxtNoteHint().click();
  }

  @Override
  @Step("Enter phone number : {0}")
  public void enterPhoneNumber(String phoneNumber) {
    MobileElement phone = checkoutScreen.getTxtPhoneNumber();
    phone.sendKeys(phoneNumber);
  }

  @Override
  @Step("click on next")
  public void clickOnNext() {
    checkoutScreen.getBtnNext().click();
  }

  @Override
  @Step("enter OTP code : {0}")
  public void enterOtpCode(String otpCode) {
    checkoutScreen.getTxtCode().sendKeys(otpCode);
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
}
