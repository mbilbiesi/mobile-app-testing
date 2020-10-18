package com.hs.mobile.steps.ios;

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

  @Step("Verify rating icons are displayed")
  public void verifyRatingIcons() {
    restaurantScreen.getLblRating().isDisplayed();
    restaurantScreen.getImgRatingIcon().isDisplayed();
  }
}
