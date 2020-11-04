package com.hs.mobile.steps.android;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.android.AllStoresScreen;
import com.hs.mobile.steps.AllStoresScreenSteps;
import com.hs.mobile.steps.BaseSteps;
import io.qameta.allure.Step;
import lombok.NonNull;

public class AllStoresScreenStepsAndroid extends BaseSteps<AllStoresScreenStepsAndroid>
    implements AllStoresScreenSteps {

  @NonNull private final AllStoresScreen allStoresScreen;

  public AllStoresScreenStepsAndroid(@NonNull TestSettings settings) {
    super(settings);
    allStoresScreen = new AllStoresScreen(settings);
  }

  @Override
  public void selectRestaurantByName(String name) {}

  @Override
  public void verifyLocationIsAppearedScreenHeader() {}

  @Override
  @Step("select first filter")
  public void clickOnFirstFilter() {
    allStoresScreen.getLstFilters().get(1).click();
  }

  @Override
  @Step("Verify filter is selected")
  public void assertFilterSelection() {
    assertThat(allStoresScreen.getLstFilters().size())
        .as("select filter is not working")
        .isEqualTo(1);
  }

  @Override
  @Step("deselect filter")
  public void deselectFilter() {
    allStoresScreen.getLstFilters().get(0).click();
  }

  @Override
  @Step("verify filter is deselected")
  public void assertFilterDeselected() {
    assertThat(allStoresScreen.getLstFilters().size())
        .as("deselect filter button is not working")
        .isGreaterThan(1);
  }
}
