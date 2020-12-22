package com.hs.mobile.steps.ios;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.ios.QuickMarketScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.QuickMarketScreenSteps;
import io.qameta.allure.Step;
import lombok.NonNull;

public class QuickMarketScreenStepsIOS extends BaseSteps<QuickMarketScreenStepsIOS>
    implements QuickMarketScreenSteps {

  @NonNull private final QuickMarketScreen quickMarketScreen;

  public QuickMarketScreenStepsIOS(@NonNull TestSettings settings) {
    super(settings);
    quickMarketScreen = new QuickMarketScreen(settings);
  }

  @Override
  @Step("Assert that quick market car is present in quick market screen")
  public void verifyQuickMarketCarIsPresent() {
    assertThat(quickMarketScreen.getLblCart().isDisplayed())
        .as("quick market cart label not displayed")
        .isFalse();
  }
}
