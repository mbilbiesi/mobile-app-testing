package com.hs.mobile.steps.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.android.LoginScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.LoginScreenSteps;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import lombok.NonNull;

public class LoginScreenStepsAndroid extends BaseSteps<LoginScreenStepsAndroid>
    implements LoginScreenSteps {

  @NonNull private final LoginScreen loginScreen;

  public LoginScreenStepsAndroid(@NonNull TestSettings settings) {
    super(settings);
    loginScreen = new LoginScreen(settings);
  }

  @Override
  @Step("Enter phone number : {0}")
  public void enterPhoneNumber(String phoneNumber) {
    MobileElement phone = loginScreen.getTxtPhoneNumber();
    phone.sendKeys(phoneNumber);
  }

  @Override
  @Step("click on next")
  public void clickOnNext() {
    loginScreen.getBtnNext().click();
  }

  @Override
  @Step("enter OTP code : {0}")
  public void enterOtpCode(String otpCode) {
    loginScreen.getTxtCode().sendKeys(otpCode);
  }
}