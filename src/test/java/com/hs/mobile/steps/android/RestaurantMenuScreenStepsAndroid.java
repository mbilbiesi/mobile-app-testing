package com.hs.mobile.steps.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.RestaurantMenuScreenSteps;
import lombok.NonNull;

public class RestaurantMenuScreenStepsAndroid extends BaseSteps<RestaurantMenuScreenStepsAndroid>
    implements RestaurantMenuScreenSteps {

  public RestaurantMenuScreenStepsAndroid(@NonNull TestSettings settings) {
    super(settings);
  }

  @Override
  public void verifyRestaurantName(String restaurantName) {}

  @Override
  public void selectMenuItemByName(String menuItemName) {}
}
