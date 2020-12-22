package com.hs.mobile.steps.android;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.android.MenuItemScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.RestaurantMenuScreenSteps;
import io.qameta.allure.Step;
import lombok.NonNull;

public class RestaurantMenuScreenStepsAndroid extends BaseSteps<RestaurantMenuScreenStepsAndroid>
    implements RestaurantMenuScreenSteps {

  @NonNull private final MenuItemScreen menuItemScreen;

  public RestaurantMenuScreenStepsAndroid(@NonNull TestSettings settings) {
    super(settings);
    menuItemScreen = new MenuItemScreen(settings);
  }

  @Override
  public void verifyRestaurantName(String restaurantName) {}

  @Override
  public void selectMenuItemByName(String menuItemName) {}

  @Override
  @Step("Verify close button is displayed in menu")
  public void verifyThatCloseButtonExist() {
    assertThat(menuItemScreen.getBtnClose().isDisplayed()).as("Menu is not displayed").isTrue();
  }
}
