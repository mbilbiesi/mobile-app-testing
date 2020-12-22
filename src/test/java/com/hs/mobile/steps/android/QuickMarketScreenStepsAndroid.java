package com.hs.mobile.steps.android;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.android.QuickMarketScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.QuickMarketScreenSteps;
import io.qameta.allure.Step;
import lombok.NonNull;

public class QuickMarketScreenStepsAndroid extends BaseSteps<QuickMarketScreenStepsAndroid>
    implements QuickMarketScreenSteps {

  @NonNull private final QuickMarketScreen quickMarketScreen;

  public QuickMarketScreenStepsAndroid(@NonNull TestSettings settings) {
    super(settings);
    quickMarketScreen = new QuickMarketScreen(settings);
  }

  @Override
  @Step("Assert that quick market car is present in quick market screen")
  public void verifyQuickMarketCarIsPresent() {
    assertThat(quickMarketScreen.getLblCart().isDisplayed())
        .as("quick market cart label not displayed")
        .isTrue();
  }
}
