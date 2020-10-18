package com.hs.mobile.steps.ios;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.exception.ExceptionSupplier;
import com.hs.mobile.screens.ios.RestaurantMenuScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.RestaurantMenuScreenSteps;
import io.qameta.allure.Step;
import lombok.NonNull;

public class RestaurantMenuScreenStepsIOS extends BaseSteps<RestaurantMenuScreenStepsIOS>
    implements RestaurantMenuScreenSteps {

  @NonNull private final RestaurantMenuScreen restaurantMenuScreen;

  public RestaurantMenuScreenStepsIOS(@NonNull TestSettings settings) {
    super(settings);
    restaurantMenuScreen = new RestaurantMenuScreen(settings);
  }

  @Override
  @Step("verify restaurant name")
  public void verifyRestaurantName(String restaurantName) {
    assertThat(restaurantMenuScreen.getRestaurantName().getText())
        .as("Wrong restaurant name displayed")
        .isEqualTo(restaurantName);
  }

  @Override
  @Step("Select '{0}' menu item")
  public void selectMenuItemByName(String menuItemName) {
    restaurantMenuScreen.getMenuItemNameList().stream()
        .filter(mobileElement -> mobileElement.getText().contains(menuItemName))
        .findFirst()
        .orElseThrow(ExceptionSupplier.testException("Could not find desired menu item"))
        .click();
  }
}
