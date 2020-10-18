package com.hs.mobile.steps.android;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.android.VerticalsScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.VerticalsScreenSteps;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lombok.NonNull;

public class VerticalsScreenStepsAndroid extends BaseSteps<VerticalsScreenStepsAndroid>
    implements VerticalsScreenSteps {

  @NonNull private final VerticalsScreen verticalsScreen;
  AppiumDriver<?> driver;

  public VerticalsScreenStepsAndroid(@NonNull TestSettings testSettings) {
    super(testSettings);
    verticalsScreen = new VerticalsScreen(testSettings);
    driver = testSettings.getDriver();
  }

  @Step("click on the address from the address bar")
  public void clickOnAddress() {
    tap(verticalsScreen.txtDeliveryValue());
  }

  @Step("Click on add new address from the verticals page")
  public void clickOnAddNewLocation() {
    tap(verticalsScreen.btnNewLocation());
  }

  @Override
  public boolean isAllStoresVerticalDisplayed() {
    return false;
  }

  @Step("verify all verticals are displayed")
  public void assertAllVerticals() {
    assertThat(verticalsScreen.verticals().size())
        .as("Expected to fetch all verticals for the provided address")
        .isEqualTo(3);
  }

  @Step("Verify two verticals are displayed and order-anything verticals is not present")
  public void assertTwoVerticalsAreDisplayed() {
    assertThat(verticalsScreen.verticals().size())
        .as("Expected 'All stores' & 'Quick Market' verticals for the provided address")
        .isEqualTo(2);
  }

  @Step("Verify `All stores' vertical is displayed")
  public void verifyAllStoresVertical() {
    assertThat(verticalsScreen.verticals().size())
        .as("Expected only 'All stores' vertical for the provided address")
        .isEqualTo(1);
  }

  @Override
  public void clickOnAllRestaurants() {}
}
