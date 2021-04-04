package com.hs.mobile.steps.android;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.android.QuickMarketScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.QuickMarketScreenSteps;
import io.qameta.allure.Step;
import lombok.NonNull;
import org.assertj.core.api.SoftAssertions;

public class QuickMarketScreenStepsAndroid extends BaseSteps<QuickMarketScreenStepsAndroid>
    implements QuickMarketScreenSteps {

  @NonNull private final QuickMarketScreen quickMarketScreen;

  public QuickMarketScreenStepsAndroid(@NonNull TestSettings settings) {
    super(settings);
    quickMarketScreen = new QuickMarketScreen(settings);
  }

  @Override
  @Step("Assert that quick market cart is present in quick market screen")
  public void verifyQuickMarketCartIsPresent() {
    assertThat(quickMarketScreen.getLblCart().isDisplayed())
        .as("quick market cart label not displayed")
        .isTrue();
  }

  @Override
  @Step("verify Screen's elements are displaying")
  public void verifyScreenElements() {
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
        .as("Minimum fee is not displayed")
        .isTrue();
    softly
        .assertThat(quickMarketScreen.getTxtSearchHeader().isDisplayed())
        .as("Search header is not displayed")
        .isTrue();
    softly
        .assertThat(quickMarketScreen.getLblTopBanner().isDisplayed())
        .as("Dark store top banner is not displayed")
        .isTrue();
    softly
        .assertThat(quickMarketScreen.getLblCategoriesSection().isDisplayed())
        .as("Categories section is not displayed")
        .isTrue();
    softly
        .assertThat(quickMarketScreen.getBtnViewAllCategories().isDisplayed())
        .as("View all categories button is not displayed")
        .isTrue();
    softly
        .assertThat(quickMarketScreen.getBtnSwimlane().isDisplayed())
        .as("Dark store swim lane is not displayed")
        .isTrue();
    softly
        .assertThat(quickMarketScreen.getLblCart().isDisplayed())
        .as("Cart label is not displayed")
        .isTrue();
    softly.assertAll();
  }
}
