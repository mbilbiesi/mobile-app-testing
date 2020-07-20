package com.hs.mobile.steps;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.VerifyAccountScreen;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import lombok.NonNull;
import org.assertj.core.api.SoftAssertions;

public class VerifyAccountScreenSteps extends BaseSteps {

  @NonNull private final VerifyAccountScreen verifyAccountScreen;

  public VerifyAccountScreenSteps(@NonNull TestSettings settings) {
    super(settings);
    verifyAccountScreen = new VerifyAccountScreen(settings);
  }

  public boolean isTxtPhoneNumberDisplayed() {
    return verifyAccountScreen.getTxtPhoneNumber().isDisplayed();
  }

  public boolean isBtnNextDisplayed() {
    return verifyAccountScreen.getBtnNext().isDisplayed();
  }

  public MobileElement getPhoneNumberTextbox() {
    return verifyAccountScreen.getTxtPhoneNumber();
  }

  public MobileElement getNextButton() {
    return verifyAccountScreen.getBtnNext();
  }

  @Step("Make sure that all orders details are displayed if customer isn't logged in")
  public void verifyThatAllMyOrdersElementsIsDisplayed() {
    SoftAssertions soft = new SoftAssertions();
    soft.assertThat(isTxtPhoneNumberDisplayed())
        .as("Mobile number text box is not displayed.")
        .isTrue();
    soft.assertThat(isBtnNextDisplayed()).as("Next button is not displayed.").isTrue();
    soft.assertAll();
  }

  @Step("Insert mobile number")
  public void insertMobileNumber(String number) {
    // TODO: Add a step to validate whether the entered mobile number is correct or not
    getPhoneNumberTextbox().sendKeys(number);
  }

  @Step("Click the 'Next' button")
  public void clickNextButton() {
    touchAction.tap(tapOptions().withElement(element(getNextButton()))).perform();
  }
}
