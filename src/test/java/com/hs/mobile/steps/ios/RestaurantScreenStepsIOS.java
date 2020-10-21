package com.hs.mobile.steps.ios;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.exception.ExceptionSupplier;
import com.hs.mobile.screens.ios.RestaurantScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.RestaurantScreenSteps;
import io.qameta.allure.Step;
import lombok.NonNull;

public class RestaurantScreenStepsIOS extends BaseSteps<RestaurantScreenStepsIOS>
    implements RestaurantScreenSteps {

  @NonNull private final RestaurantScreen restaurantScreen;

  public RestaurantScreenStepsIOS(@NonNull TestSettings testSettings) {
    super(testSettings);
    restaurantScreen = new RestaurantScreen(testSettings);
  }

  @Step("Select `{0}` restaurant")
  public void selectRestaurantByName(String name) {
    restaurantScreen.getRestaurantList().stream()
        .filter(mobileElement -> mobileElement.getText().contains(name))
        .findFirst()
        .orElseThrow(ExceptionSupplier.testException("Could not find desired restaurant"))
        .click();
  }

  @Override
  @Step("verify location is appeared in screen header")
  public void verifyLocationIsAppearedScreenHeader() {
    assertThat(restaurantScreen.getHeaderLocation().getText())
        .as("Wrong value in header screen")
        .isNotEmpty();
  }
}
