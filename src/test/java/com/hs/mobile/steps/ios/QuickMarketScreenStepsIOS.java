package com.hs.mobile.steps.ios;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.ios.QuickMarketScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.QuickMarketScreenSteps;
import io.qameta.allure.Step;
import lombok.NonNull;
import org.assertj.core.api.SoftAssertions;

public class QuickMarketScreenStepsIOS extends BaseSteps<QuickMarketScreenStepsIOS>
    implements QuickMarketScreenSteps {

  @NonNull private final QuickMarketScreen quickMarketScreen;

  public QuickMarketScreenStepsIOS(@NonNull TestSettings settings) {
    super(settings);
    quickMarketScreen = new QuickMarketScreen(settings);
  }

  @Override
  @Step("Assert that quick market car is present in quick market screen")
  public void verifyQuickMarketCartIsPresent() {
    assertThat(quickMarketScreen.getLblCart().isDisplayed())
        .as("quick market cart label not displayed")
        .isFalse();
  }

  @Override
  @Step("verify Screen's elements are displaying")
  public void verifyScreenElements() {
    // todo: missing two elements (top banner, and swimlane)
    SoftAssertions softly = new SoftAssertions();
    softly
        .assertThat(quickMarketScreen.getBtnBack().isDisplayed())
        .as("Back button is not displayed")
        .isTrue();
    softly
        .assertThat(quickMarketScreen.getLblDeliveryFee().isDisplayed())
        .as("Delivery fee is not displayed")
        .isTrue();
    softly
        .assertThat(quickMarketScreen.getLblMinDeliveryFee().isDisplayed())
        .as("Minimum delivery fee is not displayed")
        .isTrue();
    softly
        .assertThat(quickMarketScreen.getLblSearchIcon().isDisplayed())
        .as("Search header is not displayed")
        .isTrue();
    softly
        .assertThat(quickMarketScreen.getLblCategoriesSection().isDisplayed())
        .as("Categories section is not displayed")
        .isTrue();
    softly.assertAll();
  }
}
